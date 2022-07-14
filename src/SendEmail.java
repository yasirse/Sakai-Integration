

import javax.mail.*;
import javax.mail.internet.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SendEmail {

	private String  d_email = "asdasdasd", //"noasdb@nu.edu.pk",
    d_password = "asdasda",//"Slatasdasdst",
    d_host = "smtp.gmail.com",
    d_port  = "465",
    m_to = "jehan.badshah@nu.edu.pk",
    m_subject = "Slate Server Information",
    m_text = "Hello this is a test Message",
    name="Jehan",
    CC=null,
    CC1=null,
    CC2=null,
    ref_message_id=null,
    //message_id=(new Date()).getDate()+" "+(new Date()).getHours()+(new Date()).getMinutes()+(new Date()).getSeconds(),
	password="Badshah";

	
	public  SendEmail()
	{
	
	}
	
	public  SendEmail(String idd, String pw, String cc,String sub, String body, String header_ref_msg_id )
	{
		d_email=idd;
		d_password=pw;
		m_subject=sub;
		m_text=body;
		
		if(cc!=null)
			CC=cc;
		
		 
		
		if(header_ref_msg_id!=null)
			ref_message_id=header_ref_msg_id;
	}
	
	public  SendEmail(String idd, String pw, String cc, String cc1,String sub, String body, String header_ref_msg_id )
	{
		d_email=idd;
		d_password=pw;
		m_subject=sub;
		m_text=body;
		
		
			CC=cc;
		
		 
			CC1=cc1; 
		
		if(header_ref_msg_id!=null)
			ref_message_id=header_ref_msg_id;
	}
	
	public  SendEmail(String idd, String pw, String cc, String cc1, String cc2,String sub, String body, String header_ref_msg_id )
	{
		d_email=idd;
		d_password=pw;
		m_subject=sub;
		m_text=body;
		
		
			CC=cc;
		
		 
			CC1=cc1; 
			
			CC2=cc2; 
		
		if(header_ref_msg_id!=null)
			ref_message_id=header_ref_msg_id;
	}
	
	private boolean Email()
	{
		Properties props = new Properties();
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
	
		//In-Reply-To: <21356612.0.1393149389262.JavaMail.jehan@lion-PC>
		//References: <21356612.0.1393149389262.JavaMail.jehan@lion-PC>	
		 System.getSecurityManager();
		  MimeMessage msg =null;
		try
		{
		    Authenticator auth = new SMTPAuthenticator();
		    Session session = Session.getInstance(props, auth);
		    //session.setDebug(true);
		
		      msg = new MimeMessage(session);
		    msg.setContent(m_text, "text/html");
		  
		    msg.setSubject(m_subject);
		    msg.setFrom(new InternetAddress(CC, "no-reply HR/ISB"));
		   
		   
		    if(ref_message_id!=null)
		    {
		    	  msg.setHeader("In-Reply-To", ref_message_id);
		    	  msg.setHeader("References", ref_message_id);
		    }
		    
		  //  msg.setHeader("Received", "Jehan Badshah");
		 //   msg.setHeader("Received", "Jehan Badshah1");
		    msg.setHeader("SLATE-Reply", "asdasdem1");
		    msg.setHeader("SLATE-Reply", "Rasdystem2");
		    msg.setHeader("SLATE-Reply", "Rsdf");
		    msg.setHeader("SLATE-Reply", "Replied by SLATE automatic password recovery system");
		  
		    
		    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
		    
		    if(CC!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(CC));
		   
		    if(CC1!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(CC1));
		    
		    if(CC2!=null)
		    	msg.addRecipient(Message.RecipientType.CC, new InternetAddress(CC2));
		  
		    
		    	Transport.send(msg);
		   
		    	//System.out.println("Login credentials has been sent to " + m_to);
		    	return true;
		}
		catch (Exception mex)
		{
		   // mex.printStackTrace();
			System.out.println("Exception: Could not sent, \nMessage: " + mex.getMessage() +", to: "+ m_to+", cc: "+ CC);
		   
			try{
				Thread.sleep(10000);
				Transport.send(msg);
			}catch (Exception mex1)	
			{
				
				try
				{
					Thread.sleep(40000);
					Transport.send(msg);
				}catch (Exception mex2)
				{
					
				}
			}
			
			return false;
		} 
	}

	public boolean Send(String mail_to)
	{
		m_to=mail_to;
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