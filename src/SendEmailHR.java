

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailHR {
 
	private String  d_email = "noreply.hrisb@nu.edu.pk",
    d_password = "cgh8*&(*gasd%",
    d_host = "smtp.gmail.com",
    d_port  = "465",
    m_to = "jehanbadshah@hotmail.com",
    m_cc1 = null,
    m_cc2 = null,
    m_cc3 = null,
    m_subject = "Slate Server Information",
    m_text = "Hello this is a test Message",
    name="Jehan",
	password="Badshah";

	boolean Email()
	{
		Properties props = new Properties();
	
		/*
		
		
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.debug","true");
		*/
 
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
			
		props.setProperty("mail.smtp.**ssl.enable", "true");
		props.setProperty("mail.smtp.**ssl.required", "true");
		
		props.put("mail.smtp.debug", "true");
		
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		
		 System.getSecurityManager();
		
		try
		{
		    Authenticator auth = new SMTPAuthenticator();
		    Session session = Session.getInstance(props, auth);
		    //session.setDebug(true);
		
		    MimeMessage msg = new MimeMessage(session);
		    //msg.setText(m_text);
		    msg.setSubject(m_subject);
		    msg.setFrom(new InternetAddress(d_email, "No-reply HR ISB "));
		    msg.setContent(m_text, "text/html; charset=utf-8");
		    
		    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to, this.name));
		    
		    if(m_cc1!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(m_cc1));
		    if(m_cc2!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(m_cc2));
		    if(m_cc3!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(m_cc3));
		    
		  Transport.send(msg);
		    	System.out.println("Email has been sent to " + m_to);
		    	return true;
		}
		catch (Exception mex)
		{
		   // mex.printStackTrace();
			System.out.println("Exception: Could not sent, \nMessage: " + mex.getMessage());
		    return false;
		} 
	}

	public boolean SendEmail(String mail_to, String Name, String cc1, String cc2, String cc3, String subject, String body)
	{
		this.m_cc1 =cc1;
		this.m_cc2 =cc2;
		this.m_cc3 =cc3;
		this.m_to=mail_to;
		this.name=Name;
	 
		this.m_subject=subject;
		this.m_text=body;
			
		return Email();
	}	
	
	
 
	
	
	
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{
		public PasswordAuthentication getPasswordAuthentication()
		{
		    return new PasswordAuthentication(d_email, d_password);
		}
	}
	
	

	
}