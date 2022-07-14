import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.URL;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.DateTime;

 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sun.net.www.protocol.http.HttpURLConnection;





import com.google.code.com.sun.mail.imap.IMAPFolder;
import com.google.code.com.sun.mail.imap.IMAPMessage;
import com.google.code.com.sun.mail.imap.IMAPSSLStore;
import com.google.code.javax.mail.Flags;
import com.google.code.javax.mail.Flags.Flag;
import com.google.code.javax.mail.Folder;
import com.google.code.javax.mail.Message;
import com.google.code.javax.mail.Message.RecipientType;
import com.google.code.javax.mail.FetchProfile;
import com.google.code.javax.mail.MessagingException;
import com.google.code.javax.mail.NoSuchProviderException;
import com.google.code.javax.mail.Session;
import com.google.code.javax.mail.Store;
import com.google.code.javax.mail.URLName;
import com.google.code.javax.mail.search.ComparisonTerm;
import com.google.code.javax.mail.search.FlagTerm;
import com.google.code.javax.mail.search.GmailRawSearchTerm;
import com.google.code.javax.mail.search.GmailThreadIDTerm;
import com.google.code.javax.mail.search.MessageIDTerm;
import com.google.code.javax.mail.search.ReceivedDateTerm;
import com.google.code.javax.mail.search.SearchTerm;
import com.google.code.javax.mail.search.SubjectTerm;

public class StudentPassword {
	
	 	static SendEmail  bn=null;
	    static HashMap<String,String> map, map1 ;
	    static HashMap<String,String[]> AcademicsCollection;
	    static HashMap<String,String[]> aCode;
	    static HashMap<String, Date> map7;
	    static HashMap<String, String> map8;
	    
	    static Folder inbox =null;
	    static Helper encrypter =null;
	    static String uid="UhAhWBK4sZpp4hG9xnN2gfGcUFv0hZiH";
		static String pw="0TXEl9c0oJiIv7brv8lwyw==";
		static Session session =null;
		static int old_message_count=-1;
		static int ternimate_time=0;
		private static final long KEEP_ALIVE_FREQ = 1000*15*1; // 30 seconds
		 static Folder approvedEmails =null;
		 static IMAPSSLStore store =null;
		 static ServerSocket socket = null;
	static int logout_counter=0;	 
	public static void main(String args[]) {
		
		   //SakaiServices sv= new SakaiServices("admin",encrypter.decrypt("GDJNpFzdY1o="));
		    try {
		      socket = new ServerSocket(34566);
		      System.out.println("Starting student password reseting server... ");
		     
		    
		    }
		    catch (IOException ex) 
		    {
		      System.out.println("Password reseting server is already running, exiting ...");
		      try{ Thread.sleep(1000); } 
		      catch(Exception e){ }
		      
		      System.exit(1);
		    }
		  
		
		 map7 = new HashMap<String,Date>();
			    	 map = new HashMap<String,String>();
			    	 map1 = new HashMap<String,String>();
			    	 aCode = new HashMap<String,String[]>();
			    	 AcademicsCollection= new HashMap<String,String[]>();
			    	 map8 = new HashMap<String,String>();
			    	 
			    	 encrypter= new Helper("");
			    	 uid=encrypter.decrypt(uid);
			    	 pw=encrypter.decrypt(pw);
			    	 
			    	// SendEmail  bn= new SendEmail(uid,pw,"jehan.badshah@nu.edu.pk","test1","Dear1 Student! <br><br> Please reset your password, <br><br>User_ID: "+"ssss"+"   <br>Password: "+"kk" + "<br><br>URL: http://slate.nu.edu.pk <br><br> SLATE Automated Password Recovery System","ss");
		          //    bn.Send("jehan.badshah@nu.edu.pk");
		              
			    	 Date date= new Date();
			    	 String message_code1=encrypter.encrypt("I9$am%6Je0han"+"jehan.badshah@nu.edu.pk"+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime() - 1 * 24 * 3600 * 1000 )))+"password i070844");
			    	 String message_code=encrypter.encrypt("I9$am%6Je0han"+"jehan.badshah@nu.edu.pk"+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime())))+"password i070844");
			    	 
			    	 message_code="GRuj9v4d5RTugZzDAumop0hEnhZXCRz8fW/RP0+cG+/o9cATGYR+zRjQNKD0DnBnB2IoDd2nTldgrratlal12345nratlal12345u2ztCk+p9mFEtFH9gXEM1uiex7y56bjKm7aENZSQ1Q==";
				        
			     message_code= message_code.replace( "rratlal12345","\r");
			     message_code= message_code.replace( "nratlal12345","\n");
			   	 
			        
			        try {

			        		IMAPSSLStore store = ConnectToGmail();
					    	 
			        	     
			                IMAPFolder f = (IMAPFolder)inbox;
			                startListening(f);
			   	  	                
			                
			        } catch (Exception e)
			        {
			        	
			            System.exit(1);
			        }
			    }
	 static FetchProfile fp =null;
	private static IMAPSSLStore ConnectToGmail() throws MessagingException {
		
		if(store!=null)
		if(store.isConnected())
		{ System.out.println("Trying to logout, and exit");
			store.close();
			//System.out.println("Logout success, wait for 1 minute/s");
			
			try {
				System.exit(0);
				//Thread.sleep(1000*60*1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(inbox!=null)
		if(inbox.isOpen())
		{
			inbox.close(true);
		}
		
		Properties props = System.getProperties();
		props.setProperty("mail.imap.starttls.enable", "true");
		props.setProperty("mail.imap.ssl.enable", "true");
		props.setProperty("mail.store.protocol", "imaps");

		 session = Session.getDefaultInstance(props, null);
            // Store store = session.getStore("imaps");
            // store.connect("imap.gmail.com", uid, pw);
		URLName urlName = new URLName("imap.gmail.com");
		 store = new IMAPSSLStore(session, urlName);
		 store.connect("imap.gmail.com", uid, pw);
		 System.out.println("Login success");
		 
		   fp = new FetchProfile();
		    fp.add(FetchProfile.Item.ENVELOPE);
		    fp.add(IMAPFolder.FetchProfileItem.X_GM_THRID);
		
		// IMAP host for yahoo.
		//store.connect("imap.mail.yahoo.com", "", "");

            // System.out.println("Service being stared, please don't close it");

		 inbox = store.getFolder("*");
		 inbox.open(Folder.READ_WRITE); 
		 
		 
		
         
         
		Folder aCollection = store.getFolder("ACADEMICS");
		aCollection.open(Folder.READ_ONLY);
		
		approvedEmails = store.getFolder("APPROVAL");
		approvedEmails.open(Folder.READ_ONLY);
		
		
		
//////////////////////////////////////////////////////
		 Message msg[] = aCollection.getMessages();
		    //System.out.println("MAILS: "+msg.length); 
		    int i=0;
		    for(Message message:msg) {
		    	
		    	String subject=message.getSubject().toString();
		    	if(subject.length()<5)
		    	{
		    		System.out.println("Invalid Subject "+subject);
		    		continue;
		    	}
		    	
		    	String [] array = subject.split(" ");
		    	if(array.length>=4)
		    	{
		    		String campus = array[0];
		    		String email_id = array[1];
		    		String dept = array[2];
		    		String code = array[3].trim();
		    		
		    		if(!code.equals("xiantiaTz&6@$#k1->/;l+====wwrowerwijksdnf834l;.mjrr-4olkjh"))
		    		{
		    			System.out.println("Invalid Code");
		    			continue;
		    		}
		    		
		    		String [] info={campus,dept,code };
		    		AcademicsCollection.put(email_id,info );
		    		
		    	}
		    	
		 
		        	//System.out.println(++i +" " +message.getReplyTo()[0].toString());
		        }
		    
		 //   System.out.println("All folders opened");
		return store;
	}


	private static boolean ReplyToEmail() throws MessagingException {
		///////////////////////////////////////////////////////////////delete
		 FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		 Message msg1[] = inbox.search(ft);  
		 System.out.println(".Password reseting  server is waiting for an email... " + msg1.length);
			
		
		 if(msg1.length<1)
		 {
			 /*
			 System.out.println("Need to re-login ");
			 ConnectToGmail();
			 ReplyToEmail();
			 */
			return false;
		 }
		 System.out.println("Email received: " + msg1.length);
		 
		 for(Message message:msg1) 
		 {
		    	
			 IMAPMessage lastMsg = (IMAPMessage) message;
			 inbox.fetch(new Message[]{lastMsg}, fp);
	         long threadId = lastMsg.getGoogleMessageThreadId();
	         
	       
	         
	        // System.out.println(threadId);
	         
	         GmailThreadIDTerm term = new GmailThreadIDTerm(threadId + "");
	         Message[] thread = inbox.search(term);
	         inbox.fetch(thread, fp);
	         
	         int cnt=0;
	         Date date=null;
	         for(Message m: thread)
	         { 
	        	 cnt++;
	        Date dat=	m.getReceivedDate();
	       // System.out.println((new SimpleDateFormat("yyyy/MMM/dd ")).format(dat));
	        date=dat;
	     
	         }
	         
	         if(cnt<=1)
		       {
		      
		        		 map7.put(threadId+"",date);
		         }
	         
	       //  System.out.println(map7.size());
		 }
		 
		 Set<String> keys=map7.keySet();
		 
		 if(keys.size()>=15)
		 {
			 System.out.println("### New password requests are greater than 10, next check = " +map7.size());
			// return false;
		 }
		
		 if(keys.size()==0)
		 {
			 Date dat11 = null;
			 return false;
			// map7.put("adasdasdasdasd",dat11);
			
		 }
		 
		 System.out.println("Total emails to be replied  = " +keys.size());
		 
		 int todays_count=0;
		 String oldDate=null;
		 boolean progress=true;
		 for(String m: keys)
         { 
			 Date dat=map7.get(m);
			 String currentDate=(new SimpleDateFormat("yyyy/MMM/dd ")).format(dat);
			 if(oldDate!=currentDate)
			 {
				 oldDate= currentDate;
				 todays_count=1;
			 }
			 else
				 todays_count++;
			 
			if(todays_count>=10)
			{
				System.out.println("Requests for changing password received on  "+oldDate+" is greater than 10, total requests="+todays_count);
				 progress=false;
			}
         }
		 
		 if( progress==false)
		  return false;
		 int t_count=0;
		 
		 Object [] msgs1= keys.toArray();
		 
		 for(int i=0;i<msgs1.length; i++)
         { 
			 
			    String m = msgs1[i].toString();
			    
	         GmailThreadIDTerm term = new GmailThreadIDTerm(m + "");
	         Message[] thread = inbox.search(term);
	         inbox.fetch(thread, fp);
	         
	        
	         
	      if(thread.length==1)
	    	  for(int j=0;j<thread.length; j++)
	         { 
	    		   Message m1= thread[j];
	        	   String raw_user_id=m1.getFrom()[0].toString();
	       		   String target_email =  ExtractEmail(raw_user_id);
	       		   System.out.println("____________________________________________________________________ ");
	       		   System.out.println(++t_count+ " ::: "+m1.getReceivedDate()+ " ### Email Subject: " + m1.getSubject() +", Email Address: "+target_email ); 
	        	  
	       		   if(m1.getHeader("References")!=null)
	        	  {
	        		  System.out.println("### Please reply manually to email " +target_email);
	        		  continue;
	        	  }
	       		   
	        	  ////////////////////////////////////////////////
	        	  String message_id=m1.getHeader("message-id")[0].toString();
	        	  
	        	  String rep_subject = "Re:";
	        	  if(m1.getSubject()!=null)
	        	    rep_subject = "Re: "+ m1.getSubject();
	        	  
	        	  try {
					int received_from_count = m1.getHeader("Received").length;
					int xreceived_from_count = m1.getHeader("X-Received").length;
					int Delivered_to_count = m1.getHeader("Delivered-To").length;
					int X_BeenThere_count = m1.getHeader("X-BeenThere").length;
					if (received_from_count != 10
							&& xreceived_from_count != 6
							&& Delivered_to_count != 2
							&& X_BeenThere_count == 1
							&& !m1.getHeader("X-BeenThere")[0]
									.equals("slate@nu.edu.pk")) {
						System.out.println("This email will not be replied "
								+ received_from_count + " -- " + target_email);
						
						  System.out.println("### Please reply manually to email " +target_email);
						  
						continue;
					}
				} catch (Exception e) {
					 System.out.println(" Information is not enough for " +target_email+ ", either not student or SPAM, this email should be manually replied ");
					continue;
				}
				
				
				String raw_received = m1.getHeader("Received")[1].toString();
	        	  boolean satus = isValidHost(raw_received);
	        	  if(satus==false)
	        	  {
	        		  System.out.println("SPAM Email: HOST could not well identified " +target_email);
	        		  continue;
	        	  }
       		   //////////////////////////////
       		   //
       		  
       		   raw_user_id=target_email;
      
                  if(raw_user_id.contains("@lhr.nu.edu.pk"))
               	   raw_user_id=raw_user_id.replace("@lhr.nu.edu.pk", "");
                  
                  else if(raw_user_id.contains("@nu.edu.pk"))
               	   raw_user_id=raw_user_id.replace("@nu.edu.pk", "");
                  else
                  {
                  	System.out.println("Public email "+target_email);
                  	continue;
                  }
                  
               	 String sss=  sendCredentialsToStudent(raw_user_id,  rep_subject,   target_email,  message_id,  m1,  target_email,"-1");
                 if(sss!=null && sss.contains("_already_replied"))
                	 continue;
                 
               	 try{
               	   SendToAcademicManagers( target_email,   rep_subject,   target_email,    message_id,   m1,    target_email); 
                   }catch(Exception ex){
                	   
                	  // ConnectToGmail() ;
                   }
	        	  ///////////////////////////////////////////
	         }
         }
		////////////////////////////////////////////////////////////////delete
		 
		 return false;
	}
		 
	
	public static void SendToAcademicManagers(String target_email,String   rep_subject, String  approved_by_email, String   message_id,  Message msg, String   decrypted_code)
	{
		
	       String  request_subject = rep_subject;
		   String raw_user_id=target_email;
		   
		   
           if(raw_user_id.contains("@lhr.nu.edu.pk"))
        	   raw_user_id=raw_user_id.replace("@lhr.nu.edu.pk", "");
           
           else if(raw_user_id.contains("@nu.edu.pk"))
        	   raw_user_id=raw_user_id.replace("@nu.edu.pk", "");
           else
           {
           	System.out.println("Public email "+target_email);
           	return;
           }
           
       /////////////////////////////////////////////
          
           String [] academic_info= AcademicsCollection.get(raw_user_id);
           
           
           String mcampus="";
           // System.out.println(academic_info.length+ " " + raw_user_id );
          if(academic_info!=null)
             if(academic_info.length>=3)
            {
             	
             	String campus = academic_info[0].trim().toUpperCase();
             	System.out.println("Academic Statff "+campus+ " " + raw_user_id );
             	/*String dept_id = academic_info[1].trim().toLowerCase();
             	if(!user_id.equals(raw_user_id))
             	{
             		System.out.println("500: Academics users did not match " +user_id +"!=" + raw_user_id );
             		continue;
             	}
             	*/
             	
             	String cc_email="";
                 String email_subscript="@nu.edu.pk";
                 if(campus.equals("LHR"))
                 {
                	 mcampus="l";
                 	cc_email="slatelhr@nu.edu.pk";
                 	email_subscript="@lhr.nu.edu.pk";
                 }
                 else if(campus.equals("ISB"))
                 	{
                	 mcampus="i";
                 	cc_email="slateisb@nu.edu.pk";
                 	}
                 else if(campus.equals("FSD"))
                	{
                	 mcampus="f";
                 	cc_email="slatefsd@nu.edu.pk";
                	}
                 else if(campus.equals("KHI"))
                	{
                	 mcampus="k";
                 	cc_email="slatekhi@nu.edu.pk";
                	}
                 else if(campus.equals("PWR"))
                	{
                	 mcampus="p";
                 	cc_email="slatepwr@nu.edu.pk";
                	}
                 else if(campus.equals("*"))
                	{
               
                 	cc_email="slateisb@nu.edu.pk";
                	}
             	//////////////////////////////////////////////
                 
                 
             	
              	//  String request_subject=map.get(target_email);
         
              	  request_subject=request_subject.replace(",", " ");
              	  request_subject=request_subject.trim().toLowerCase();
              	 
              	 
              	  
              	 int reset_count=0;
              	 int failuer_count=0;
              	 String account_list="";
              	 String failed_list="";
              	  boolean password_present=false;
              	  
              	  String rep_subject1111=request_subject.toLowerCase().replace("subject:", "");
              	rep_subject1111=request_subject.toLowerCase().replace("re:", "");
              	  
              	 // System.out.println(rep_subject1111 + " >>>>test");
              	  if(rep_subject1111!=null && rep_subject1111.contains(":"))
              		  password_present=true;
              	  else
              		 if(rep_subject!=null && rep_subject.contains(";"))
              		 {
              			rep_subject1111=rep_subject1111.replace(";", ":");
                   		password_present=true;
              		 }
              	  
              	String [] arraySubject=null;
              	if(request_subject!=null)
              	{
        			 String new_sub=request_subject.replace("-", "");
        			   arraySubject=new_sub.split(" ");
        			   
        			   
              	}
              	  
              	 
              	 if(arraySubject!=null && arraySubject.length>1)
              	  {
              		   account_list="<table border=1>";
                  	   failed_list="<table border=1>";
                  	
                  	   
              		  for(int j=1;j<arraySubject.length; j++)
              		  {
              		   String password="";
              		   
              		  
              	 
             		   String mPassword="-1";
             		   raw_user_id=arraySubject[j];
             		   
             		  
                      
             		   
             		  System.out.println(">>>>>>>>>>>>>>>>>> Processing " + raw_user_id);
             		  
             		   raw_user_id=raw_user_id.toLowerCase().trim();
             		   
             		   if(raw_user_id.contains(":"))
             		   {
             			 raw_user_id=raw_user_id.replace(" ", "");
             			 String [] arraySubject1=raw_user_id.split(":");
             			 if(arraySubject1.length>1)
             			 {
             				 raw_user_id=arraySubject1[0];
             				 raw_user_id=raw_user_id.trim();
             				 mPassword= arraySubject1[1];
             				 mPassword=mPassword.trim();
             			 }
             		   }
              			 
              		 
              		  try {
  						if(raw_user_id.length()==6 && Integer.parseInt(raw_user_id)>0)
  						   {
  							raw_user_id =mcampus+raw_user_id;
  						   }
              		  }catch(Exception ex)
              		  {}
              		   
              		   String student_prefix=raw_user_id.toLowerCase().substring(0,1);
              		   String campus_prefix =campus.toLowerCase().substring(0,1);
              		 
              		   try {
						if(Integer.parseInt(student_prefix)>=0)
						   {
							 if(raw_user_id.contains("i"))
							 {
								 raw_user_id =raw_user_id.replace("i", "");
								 student_prefix="i";
							 }
							else
							if(raw_user_id.contains("p"))
							{
								 raw_user_id =raw_user_id.replace("p", "");
								 student_prefix="p";
							 }
							else if(raw_user_id.contains("k"))
							{
								 raw_user_id =raw_user_id.replace("k", "");
								 student_prefix="k";
							 }
							else if(raw_user_id.contains("l"))
							{
								 raw_user_id =raw_user_id.replace("l", "");
								 student_prefix="l";
							 }
							else if(raw_user_id.contains("f"))
							{
								 raw_user_id =raw_user_id.replace("f", "");
								 student_prefix="f";
							 }
							 raw_user_id= student_prefix+ raw_user_id;
							 
							 System.out.println("YYCXXXX format, new student_prefix =>" +student_prefix +", = " + raw_user_id);
						   }
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block


					}
              		   
              		
              		 if(raw_user_id.contains("-") || raw_user_id.contains("_") )
              		 if(raw_user_id.toLowerCase().contains(campus_prefix.toLowerCase()))
              		{
              			student_prefix=raw_user_id.toLowerCase().substring(0,1);
              			raw_user_id =raw_user_id.replace(campus_prefix, "");
              			raw_user_id =raw_user_id.replace("_", "");
              			raw_user_id =raw_user_id.replace("-", "");
              			raw_user_id=campus_prefix.toLowerCase()+raw_user_id;
              			
              			 //System.out.println(raw_user_id);
              		}
              		   if(student_prefix.equals(campus_prefix) || campus_prefix.equals("*"))
              		   {
              			 if(password_present)
	              			 {
	              				String rep_subject1="Your account password ";
	              				password=sendCredentialsToStudent(raw_user_id,  rep_subject1,   approved_by_email,  message_id,  msg,  decrypted_code,mPassword);
	                          
	              			 }
	              			 else
	              			 	{
	              				 	password=sendCredentialsToStudent(raw_user_id,  rep_subject,   approved_by_email,  message_id,  msg,  decrypted_code,mPassword);
	              			 	}
              		   }
                         else
              		   {
              			   System.out.println(raw_user_id + " - " +campus_prefix);
              			   System.out.println(target_email + " can only change student password of "+campus+" campus ");
              		   }
              		   
              		   if(password.length()>1 && !password.contains("already_replied"))
              		   {
              			   reset_count++;
              			   account_list+="<tr>";
              			   account_list+="<td>"+reset_count+"</td><td>"+raw_user_id+"</td>"+"<td>"+password+"</td>";
              			   account_list+="</tr>";
              			  
              			  
              		   }
              		   else
              		   {
              			   try{
              				   
              				 String tt=raw_user_id.toLowerCase().substring(0,1);
              				 String numeric_id=raw_user_id.replace(tt, "").trim();
              				 
              				 if(Integer.parseInt(numeric_id)>0)
              				 {       
              					 
              					 if(password!=null && password.contains("_already_replied"))
              					 {}
              					 else
              					 {
		              			  failuer_count++;
		              			  failed_list+="<tr>";
		              			  failed_list+="<td>"+failuer_count+"</td><td>"+raw_user_id+"</td>"+"<td>"+password+"</td>";
		              			  failed_list+="</tr>";
              					 }
              				 }
              			  
              			   }catch(Exception ex){}
              		   }
              		   
              		  
              		  }
              		  
              		 account_list+="</table>";
                  	 failed_list+="</table>";
              	  } ////if subject length >1
              	 
              	 String fail_msg="";
              	 if(failuer_count>0)
              		fail_msg =" <br><br>Password of following account/s is not changed, <br> please check that following rollno is correct, if yes than send new email after 2 hour "+ failed_list +"<br><br>";
              		
                 bn= new SendEmail(uid,pw,cc_email,rep_subject,"Password reset for the following accounts <br>"+account_list + " <br><br> Above mentioned students are informed individually via email "+fail_msg+" <br><br> This email sent to you by SLATE Autmated Password Recovery System "  ,message_id);
                 
              if( reset_count>0 )
              {
       		   if(bn.Send(target_email) == true)
       		   {
       			  String rep_message_id = map1.get(target_email);
       			 
       			  try {
					MarkRead(rep_message_id);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
         		  
               	   System.out.println("List of login credentials has been sent to Academic staff " + target_email);
               	   //System.out.println("Credential sent to " + user_id);
       		   }
       		   else
       		   {
       			   System.out.println("Problem while sending credential to " + target_email);
       		   }
       		   
              }
              else
              {
            	  System.out.println("Please have a look into this email, and reply manual to academic manager, failure message sending process initiated ");
            	  if(failuer_count >0)
            	  {
            		  
            	  }
            	  /*
            	  if(failuer_count >0)
            	  {
            		  
            		  bn= new SendEmail(uid,pw,cc_email,rep_subject,fail_msg  ,message_id);
                      
            		  //if(bn.Send(target_email) == true)
            		  if(true)
              		   {
              			  String rep_message_id = map1.get(target_email);
              			 
              			  try {
       					MarkRead(rep_message_id);
       				} catch (MessagingException e) {
       					// TODO Auto-generated catch block
       					//e.printStackTrace();
       				}
                		  
                      	   System.out.println(" Academic staff " + target_email +" informed about failure");
                      	   //System.out.println("Credential sent to " + user_id);
              		   }
              		   else
              		   {
              			   System.out.println("Problem while sending failure email to " + target_email);
              		   }
            		  
            	  }
            	  
            	  */
              }
          	 
            }
           

       
       
       //////////////////////////////////////////////
	}
	
	public static boolean isValidHost(String raw_received)
	{
		
		String IP = ExtractHeaderIP(raw_received);
		System.out.println("IP: "+ IP);
	if(IP==null)	
		return false;
		
		String host = ExtractHeaderHost(raw_received);
		System.out.println("Email host: "+ host);
		if(host==null)	
			return false;

		
		/*
		String host2 = GetOnlineHttpHost(IP);
		System.out.println("Verified host: "+ host2);	
		if(host2==null)	
			return false;

		
		if(host2!=null)
		if(host.equals(host2))
		{*/
			if(host.contains("google.com")){
				System.out.println( "Valid Host");	
				return true;
			}
			else
			{
				System.out.println( "Invalid Host");
				return false;
			}
			/*
		}
		else
		{
			System.out.println( "Invalid Host: Information did not extract at right way");
			return false;
		}
		else
			System.out.println( "Invalid Host: Information did not extract at right way");
		
		return false;*/
	}
	
	private static String ExtractHeaderHost(String raw_host) {
		int index1= raw_host.indexOf("(");
		int index2= raw_host.indexOf("[");
		String str1=null;
		

 try {
	str1 = raw_host.substring(index1 + 1, index2).trim();
} catch (Exception e) {
	return null;
	// TODO: handle exception
}
		str1=str1.trim();
		return str1;
	}

	private static String ExtractHeaderIP(String raw_received) {
		int index1= raw_received.indexOf("])");
		String str1= null;
		
		 try {
			str1 = raw_received.substring(index1 - 20, index1);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		index1= str1.indexOf("[");
		
		String IP= str1.substring(index1+1, str1.length() );
		IP=IP.trim();
		
	return IP;
		
	}
	
	private static String GetOnlineHttpHost(String IP) {
		String URL ="http://stuff.mit.edu/cgi/machine?hostname="+IP;
		String html=getHTML(URL);
		
		if(html==null)
			return null;
		
		int indexH2=html.indexOf("<h2>Hostinfo")+13;
		String host1 =html.substring(indexH2,indexH2+50);
		int indexH21=host1.indexOf("</h2>");
		
		String host2 =null;
		
		 try {
			host2 = host1.substring(0, indexH21);
			host2=host2.trim();
		} catch (Exception e) {
			
			return null;
			// TODO: handle exception
		}

		
		return host2;
	}
	
	  public static String getHTML(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(urlToRead);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (IOException e) {
	    	  
	    	  System.out.println("Exception: " + e.getMessage());
	        // e.printStackTrace();
	      } catch (Exception e) {
	    	  System.out.println("Exception: " + e.getMessage());
	        // e.printStackTrace();
	      }
	      return result;
	   }
	  
	  
	static void CollectUnAnswerdMails(Folder inbox){     
	
        try {
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message msg[] = inbox.search(ft);
            //System.out.println("MAILS: "+msg.length); 
            int i=0;
            for(Message message:msg) {
                try {++i;
                	//System.out.println(++i +" " +message.getReplyTo()[0].toString());
                    //System.out.println("DATE: "+message.getSentDate().toString());
                    //System.out.println("FROM: "+message.getFrom()[0].toString() + "-> "+message.getRecipients(RecipientType.TO)[0].toString());           
                    try{
                    //System.out.println("SUBJECT: "+message.getSubject().toString() +"----"+message.getHeader("message-id")[0].toString());
                    
                    String recep=message.getRecipients(RecipientType.TO)[0].toString();
                    String sender=message.getFrom()[0].toString();
                    
                    String subSubject="NULL_CHARACTERS";
                    try{
                    	subSubject= message.getSubject().toString().substring(0, 6).toLowerCase().trim();
                    }catch (Exception e) {
                    	//continue;
                    }
                    	
                    	
                     recep  = ExtractEmail(recep);
                     sender = ExtractEmail(sender);
                      //  System.out.println("SUBJECT: "+message.getSubject().toString() +" ==> "+recep);
                   //  msg[i-1].setFlag(Flags.Flag.SEEN, true);
                     //System.out.println(" check for key "+recep +" "+sender);
                       if( map.containsKey(recep))
                    {
                    	  System.out.println("need to delete from map "+recep);
                    	if(subSubject.toLowerCase().contains("re:") && message.getHeader("References")!=null)
                    	{
                    	   	map.remove(recep);
                    	   	map1.remove(recep);
                    	   	System.out.println(recep + " already replied");
                    	    System.out.println("-------------------------------------------");
                    	}
                    	 
                    }
                    
                
                    else if ( //!subSubject.contains("re: ")  && 		 !subSubject.contains("fwd: ")  &&           		
                    		  message.getHeader("References")==null
                    		&&  message.getHeader("message-id")[0].toString().contains("@mail.gmail.com")
                    		)
                    
                    {
                    	subSubject="NULL_CHARACTERS";
                        try{
                        	subSubject= message.getSubject().toString();
                        }catch (Exception e) {
                        	//continue;
                        }
                        
                    	//if(!sender.contains("slate"))
                    		 map.put(sender,  subSubject);
                    		 
                    		 String true_message_id=message.getHeader("message-id")[0].toString();
                    		 true_message_id=true_message_id.substring(1,true_message_id.length()-1);
                    		 map1.put(sender,  true_message_id);
                    		 System.out.println("-------------------------------------------");
                    		 System.out.println(" Checking "+sender );
                    		
                    }
                    } catch (Exception e) {
                    	 System.out.println("showUnreadMails: Exception : "+e.getMessage());
                    	
                    }
                 //   System.out.println("CONTENT: "+message.getContent().toString());
                 //   System.out.println("-------------------------------------------");
                } catch (Exception e) {
                    System.out.println("Exception : No Information");
                }
            }
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    }
	 
	public static void sendApprovalsToUnAnswered(HashMap mp, int flag) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            String key=pairs.getKey().toString();
           
            String em = ExtractEmail(key);
            
            String email=em;
            
            if(em.contains("@lhr.nu.edu.pk"))
            	em=em.replace("@lhr.nu.edu.pk", "");
            
            else if(em.contains("@nu.edu.pk"))
            	em=em.replace("@nu.edu.pk", "");
            else
            {
            	System.out.println("Public email "+email);
            	continue;
            }
            
        
           
            int id=0;
            try{
            	id=Integer.parseInt(em.substring(1,7));
            	
            }catch(Exception ex){}
                
            String type="Not student";
            if(id>0)
            	type="Student";
            
            String cm=em.substring(0,1);
            String campus=null;
            String from_email="";
            if(cm.equals("l"))
            {
            	campus="Lahore";
            	from_email="slatelhr@nu.edu.pk";
            }
            else if(cm.equals("i"))
            	{
            	campus="Islamabad";
          	from_email="slateisb@nu.edu.pk";
            	}
            else if(cm.equals("f"))
           	{
           	campus="FSD";
         	from_email="slatefsd@nu.edu.pk";
           	}
            else if(cm.equals("k"))
           	{
           	campus="KHI";
         	from_email="slatekhi@nu.edu.pk";
           	}
            else if(cm.equals("p"))
           	{
           	campus="PWR";
         	from_email="slatepwr@nu.edu.pk";
           	}
          
            System.out.println("\nEmail: "+pairs.getKey() +", User_ID: "+em +", Campus: " +campus+", Type: "+type);
           
            if(flag==2)
            {
            	//System.out.println("");
            	ExtractInfoAndSendApprovalCode(email);
            }
            // it.remove(); // avoids a ConcurrentModificationException
        }
    }
  
	
	static boolean checkReplied(String target_email)
	{
		try{
		  Flags processedFlag = new Flags("processed");
		   Message[] processess_messages = inbox.search(new FlagTerm(processedFlag, true));
		   String messsage_id=map1.get(target_email);
		   ////////////////////
		   boolean processed=false;
		      SearchTerm searchTerm = new MessageIDTerm(messsage_id);
			  Message[] messages = inbox.search(searchTerm);
			  for(int k=0;k<processess_messages.length;k++)
			  {
				  for(int l=0;l<messages.length;l++)
   			  {
   				 if(processess_messages[k].getHeader("message-id")[0].toString().equals(messages[k].getHeader("message-id")[0].toString()))
   				 {
   					 processed=true; 
   				 }
   			  } 
			  }
			  
			  searchTerm = new MessageIDTerm("<"+messsage_id+">");
			  messages = inbox.search(searchTerm);
			  for(int k=0;k<processess_messages.length;k++)
			  {
				  for(int l=0;l<messages.length;l++)
   			  {
   				 if(processess_messages[k].getHeader("message-id")[0].toString().equals(messages[k].getHeader("message-id")[0].toString()))
   				 {
   					 processed=true; 
   				 }
   			  } 
			  }
			  
		   if(processed)
		   {
			  	System.out.println("Already replied to "+target_email);
			  	return processed;
		   }
		}catch(Exception ex)
		{}
		
		return false;
	}
	static void NotUsedSendCredentialsToApprovedMail(Folder inbox){     
		
        try {
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message msg[] = inbox.search(ft);
            //System.out.println("MAILS: "+msg.length); 
            for(int i=0;i<msg.length;i++) {
            	Message message=msg[i];
                try {
                	//System.out.println(++i +" " +message.getReplyTo()[0].toString());
                    //System.out.println("DATE: "+message.getSentDate().toString());
                    //System.out.println("FROM: "+message.getFrom()[0].toString() + "-> "+message.getRecipients(RecipientType.TO)[0].toString());           
                    try{
                    //System.out.println("SUBJECT: "+message.getSubject().toString() +"----"+message.getHeader("message-id")[0].toString());
                    
                    String recep=message.getRecipients(RecipientType.TO)[0].toString();
                    String approved_by_email=message.getFrom()[0].toString();
                    String subSubject="";
                    
                    try{
                   subSubject=message.getSubject().toString();
                    }
                    catch(Exception ex){}
                    
                   // if(subSubject.length()>5)
                    //	subSubject.substring(0, 6).toLowerCase().trim();
                    
                     recep  = ExtractEmail(recep);
                     approved_by_email = ExtractEmail(approved_by_email);
                   if(subSubject.contains("Re: Need approval for reseting password of your SLATE account. CODE[["))
                   {
                	   String code=subSubject.toString().replace("Re: Need approval for reseting password of your SLATE account. CODE[[","");
                	  
                	   code= code.replace("rratlal12345","\r");
                	   code= code.replace("nratlal12345","\n");
              	    
              	  
              	     
                	   String decrypted_code=encrypter.decrypt(code);
                	   //System.out.println(decrypted_code +" &&&&&&&&& "+code);
                	   String target_email=decrypted_code.substring(13,decrypted_code.indexOf("<>")).trim().toLowerCase();
                	   //System.out.println(target_email +" ------------------- ");
                	   
                	   
                	  // I9$am%6Je0hanjehan.badshah@nu.edu.pk<>*h5/2014/Feb/23  
                	   
                	   if( map.containsKey(target_email))
                       {
                		   boolean status =checkReplied(target_email);
                		   if(status==true)
                		  continue;
                		   
                		  String  nullSubject="NULL_CHARACTERS";
                		  String rep_subject="";
                		 
                		  if(map.get(target_email).toUpperCase().trim().equals(nullSubject))
                			  rep_subject="Re: ";
                		  else
                			  rep_subject="Re: "+map.get(target_email);
                		   
                		  String message_id=map1.get(target_email);
                		 
                		   
                		   //////////////////////////////
                		   
                		   String raw_user_id=target_email;
                           
                           if(raw_user_id.contains("@lhr.nu.edu.pk"))
                        	   raw_user_id=raw_user_id.replace("@lhr.nu.edu.pk", "");
                           
                           else if(raw_user_id.contains("@nu.edu.pk"))
                        	   raw_user_id=raw_user_id.replace("@nu.edu.pk", "");
                           else
                           {
                           	System.out.println("Public email "+target_email);
                           	continue;
                           }
                           
                       /////////////////////////////////////////////
                          
                           String [] academic_info= AcademicsCollection.get(raw_user_id);
                           
                           // System.out.println(academic_info.length+ " " + raw_user_id );
                            if(academic_info==null)
                            {
                         	   sendCredentialsToStudent(raw_user_id,  rep_subject,   approved_by_email,  message_id,  msg[i],  decrypted_code,"-1");
                                
                            }
                            else
                            
                             if(academic_info.length>=3)
                            {
                             	
                             	String campus = academic_info[0].trim().toUpperCase();
                             	System.out.println("Academic Statff "+campus+ " " + raw_user_id );
                             	/*String dept_id = academic_info[1].trim().toLowerCase();
                             	if(!user_id.equals(raw_user_id))
                             	{
                             		System.out.println("500: Academics users did not match " +user_id +"!=" + raw_user_id );
                             		continue;
                             	}
                             	*/
                             	
                             	String cc_email="";
                                 String email_subscript="@nu.edu.pk";
                                 if(campus.equals("LHR"))
                                 {
                                 	
                                 	cc_email="slatelhr@nu.edu.pk";
                                 	email_subscript="@lhr.nu.edu.pk";
                                 }
                                 else if(campus.equals("ISB"))
                                 	{
                                
                                 	cc_email="slateisb@nu.edu.pk";
                                 	}
                                 else if(campus.equals("FSD"))
                                	{
                               
                                 	cc_email="slatefsd@nu.edu.pk";
                                	}
                                 else if(campus.equals("KHI"))
                                	{
                                
                                 	cc_email="slatekhi@nu.edu.pk";
                                	}
                                 else if(campus.equals("PWR"))
                                	{
                               
                                 	cc_email="slatepwr@nu.edu.pk";
                                	}
                                 else if(campus.equals("*"))
                                	{
                               
                                 	cc_email="slateisb@nu.edu.pk";
                                	}
                             	//////////////////////////////////////////////
                             	
 	                         	  String request_subject=map.get(target_email);
 	                         	  request_subject=request_subject.replace(",", " ");
 	                         	  request_subject=request_subject.trim().toLowerCase();
 	                         	 
 	                         	  String [] arraySubject=request_subject.split(" ");
 	                         	  
 	                         	 int reset_count=0;
 	                         	 int failuer_count=0;
 	                         	 String account_list="";
 	                         	 String failed_list="";
 	                         	
 	                         	  int count=0;
 	                         	 if(arraySubject.length>1)
 	                         	  {
 	                         		   account_list="<table border=1>";
 	                             	   failed_list="<table border=1>";
 	                             	
 	                         		  for(int j=1;j<arraySubject.length; j++)
 	                         		  {
 	                         		   String password="";
 	                         		   String mPassword="-1";
 	                         		   raw_user_id=arraySubject[j];
 	                         		   if(raw_user_id.contains(":"))
 	                         		   {
 	                         			 raw_user_id=raw_user_id.trim();
 	                         			 raw_user_id=raw_user_id.replace(" ", "");
 	                         			 String [] arraySubject1=raw_user_id.split(":");
 	                         			 
 	                         			 if(arraySubject1.length>1)
 	                         			 {
 	                         				 raw_user_id=arraySubject1[0];
 	                         				 mPassword= arraySubject1[1];
 	                         				 mPassword=mPassword.trim();
 	                         			 }
 	                         		   }
 	                         		   
 	                         		   raw_user_id=raw_user_id.toLowerCase().trim();
 	                         		   
 	                         		   String student_prefix=raw_user_id.toLowerCase().substring(0,1);
 	                         		   String campus_prefix =campus.toLowerCase().substring(0,1);
 	                         		   
 	                         		   if(student_prefix.equals(campus_prefix) || campus_prefix.equals("*"))
 	                                  		    password=sendCredentialsToStudent(raw_user_id,  rep_subject,   approved_by_email,  message_id,  msg[i],  decrypted_code,mPassword);
 	                         		   else
 	                         		   {
 	                         			   System.out.println(target_email + " can only change student password of "+campus+" campus ");
 	                         		   }
 	                         		   
 	                         		   if(password.length()>1)
 	                         		   {
 	                         			  count++;
 	                         			   account_list+="<tr>";
 	                         			   account_list+="<td>"+reset_count+"</td><td>"+raw_user_id+"</td>"+"<td>"+password+"</td>";
 	                         			   account_list+="</tr>";
 	                         			  
 	                         			   reset_count++;
 	                         		   }
 	                         		   else
 	                         		   {
 	                         			  failuer_count++;
 	                         			  failed_list+="<tr>";
 	                         			  failed_list+="<td>"+failuer_count+"</td><td>"+raw_user_id+"</td>"+"<td>"+password+"</td>";
 	                         			  failed_list+="</tr>";
 	                         		   }
 	                         		   
 	                         		  
 	                         		  }
 	                         		  
 	                         		 account_list+="</table>";
 	                             	 failed_list+="</table>";
 	                         	  }
 	                         	 
 	                            bn= new SendEmail(uid,pw,cc_email,rep_subject,"Password reset <br>"+account_list + "<br> <br> Reset Failed for following accounts<br> "+failed_list ,message_id);
 	                            
 	                  		   if(bn.Send(target_email) == true)
 	                  		   {
 	                  			  String rep_message_id = map1.get(target_email);
 	                  			 
 	                  			  MarkRead(rep_message_id);
 	                    		  
 	                          	   System.out.println("List of login credentials has been sent to Academic staff " + target_email);
 	                          	   //System.out.println("Credential sent to " + user_id);
 	                  		   }
 	                  		   else
 	                  		   {
 	                  			   System.out.println("Problem while sending credential to " + target_email);
 	                  		   }
 	                  		   
                   		   
                          	 
                            }
                             else
                             {
                                 sendCredentialsToStudent(raw_user_id,  rep_subject,   approved_by_email,  message_id,  msg[i],  decrypted_code,"-1");
                                 
                             }
    
                       
                       
                       //////////////////////////////////////////////
                           
                       }
                	   
                	   
                	// 
                    		
                    }
                    } catch (Exception e) {
                    	try{
                    	 System.out.println("showApprovedMailsAndSendPassword: Exception : "+e.getMessage());
                    	 e.printStackTrace();
                    	}catch(Exception ex){}
                    	
                    }
                 //   System.out.println("CONTENT: "+message.getContent().toString());
                 //   System.out.println("-------------------------------------------");
                } catch (Exception e) {
                    System.out.println("Exception : No Information");
                }
            }
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    }

	private static String sendCredentialsToStudent(String user_id, String rep_sub, String approval_email, String rep_message_id, Message msg, String decrypted_code, String mpass)
	{
		String password="";
        int id=0;
        String type="-1";
        String cm="";
        String campus=null;
        
        try{
        	id=Integer.parseInt(user_id.substring(1,7));
        	
        }catch(Exception ex){}
            
        
        if(id>0)
        	type="Student";
        
         cm=user_id.substring(0,1);
        
        
        cm=cm.toLowerCase();
        
        String from_email="";
        String email_subscript="@nu.edu.pk";
        if(cm.equals("l"))
        {
        	campus="Lahore";
        	from_email="slatelhr@nu.edu.pk";
        	email_subscript="@lhr.nu.edu.pk";
        }
        else if(cm.equals("i"))
        	{
        	campus="Islamabad";
      	from_email="slateisb@nu.edu.pk";
        	}
        else if(cm.equals("f"))
       	{
       	campus="FSD";
     	from_email="slatefsd@nu.edu.pk";
       	}
        else if(cm.equals("k"))
       	{
       	campus="KHI";
     	from_email="slatekhi@nu.edu.pk";
       	}
        else if(cm.equals("p"))
       	{
       	campus="PWR";
     	from_email="slatepwr@nu.edu.pk";
       	}
        
      if(type.equals("Student"))  
      { 
    	  
    	  if(map8.get(user_id)!=null)
    		{
     	
  		
  			System.out.println("Already replied, please restart this server");
  			
  			/*try {
				ConnectToGmail();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
  			return "_already_replied";
  		}
    	  System.out.println("User_ID and Password is being sent to " + user_id+ ", Subject: " +rep_sub +", Email: "+user_id+email_subscript);   
		  
          password=encrypter.encrypt(decrypted_code).substring(3,6);
         
         CheckSum pass=new CheckSum();
 		
  		password=pass.checksum(user_id+password+"1je*").toLowerCase();
  		password=password.substring(4,9);
  		
         SakaiServices sv= new SakaiServices("admin",encrypter.decrypt("GDJNpFzdY1o="));
         
         if(!mpass.contains("-1") && mpass.length()>2)
        	 password =mpass;
         
 		 boolean status=sv.changeUserPassword(user_id, password);
 		 sv.LogOut();
 		   ////////////////////////////////
 		// System.out.println(encrypter.decrypt(encrypter.encrypt(bod+"jjj")));
           if(status==true)
           {
        	   map8.put(user_id, user_id+email_subscript);
         	   System.out.println(user_id+"'s "+"password has been changed by confirmation of "+approval_email);
     		   bn= new SendEmail(uid,pw,from_email,rep_sub,"Dear Student! <br><br> Please reset your password, <br><br>User_ID: "+user_id+"   <br>Password: "+password + "<br><br>URL: http://slate.nu.edu.pk <br><br> SLATE Automated Password Recovery System",rep_message_id);
               boolean status1= bn.Send(user_id+email_subscript);
     		   if(status1 == true)
     		   {
     			//  ternimate_time=ternimate_time+1;
             	   try {
             		  MarkRead(rep_message_id);
       				  msg.setFlag(Flag.SEEN, true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
             	   System.out.println("Login credentials has been sent to " + user_id+email_subscript);
             	   //System.out.println("Credential sent to " + user_id);
     		   }
     		   else
     		   {
     			   System.out.println("Problem while sending credential to " + user_id);
     			  map8.put(user_id, user_id+email_subscript);
     		   }
 		   
           }
           else
           {
         	  System.out.println("Problem in reseting password of " + user_id); 	
         	// map8.put(user_id, user_id+email_subscript);
         	  password="";
           }
      }
      else
      {
     	 System.out.println("For time being this service is enabled for students only, " +user_id+email_subscript + " is not formatted student account");
      }
		
      return password;
	}

	private static void MarkRead(String rep_message_id)
			throws MessagingException {
		
		SearchTerm searchTerm = new MessageIDTerm(rep_message_id);
		  Message[] messages = inbox.search(searchTerm);
		  for(int k=0;k<messages.length;k++)
		  {
			 messages[k].setFlag(Flag.SEEN, true);
			 Flags processedFlag = new Flags("processed");
			 messages[k].setFlags(processedFlag, true);
		  }
		  
         	  searchTerm = new MessageIDTerm("<"+rep_message_id+">");
      		  messages = inbox.search(searchTerm);
      		  for(int k=0;k<messages.length;k++)
      		  {
      			 Flags processedFlag = new Flags("processed");
    			 messages[k].setFlags(processedFlag, true);
    			 messages[k].setFlag(Flag.SEEN, true);
      		  }
	}
	
	private static void ExtractInfoAndSendApprovalCode(String sendTo) {
		Date date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MMM/dd ");
		//get current date time with Date()
		
		
		
	//	(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime() - 1 * 24 * 3600 * 1000 )));
	    
		//////////////////
		String em=sendTo;
        
        if(em.contains("@lhr.nu.edu.pk"))
        	em=em.replace("@lhr.nu.edu.pk", "");
        
        else if(em.contains("@nu.edu.pk"))
        	em=em.replace("@nu.edu.pk", "");
        else
        {
        	System.out.println("Public email "+sendTo);
        	return;
        }
        
    String User_ID= em.toLowerCase().trim();
       
        int id=0;
        try{
        	id=Integer.parseInt(em.substring(1,7));
        	
        }catch(Exception ex){}
            
        String type="-1";
        if(id>0)
        	type="Student";
        
        String cm=em.substring(0,1);
        String campus=null;
        
        cm=cm.toLowerCase();
        
        String from_email="slateisb@nu.edu.pk";
        if(cm.equals("l"))
        {
        	campus="Lahore";
        	from_email="slatelhr@nu.edu.pk";
        }
        else if(cm.equals("i"))
        	{
        	campus="Islamabad";
      	from_email="slateisb@nu.edu.pk";
        	}
        else if(cm.equals("f"))
       	{
       	campus="FSD";
     	from_email="slatefsd@nu.edu.pk";
       	}
        else if(cm.equals("k"))
       	{
       	campus="KHI";
     	from_email="slatekhi@nu.edu.pk";
       	}
        else if(cm.equals("p"))
       	{
       	campus="PWR";
     	from_email="slatepwr@nu.edu.pk";
       	}
        
      if(type.equals("Student"))  
      {
    	//dateFormat = new SimpleDateFormat("yyyy/MMM/dd HH");
    	String message_code =encrypter.encrypt("I9$am%6Je0han"+sendTo+"<>*h5/"+dateFormat.format(date));
    	String message_code1=encrypter.encrypt("I9$am%6Je0han"+sendTo+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime() - 1 * 24 * 3600 * 1000 ))));
            // System.out.println(encrypter.decrypt(raw_message_id));
		String sub= "Need approval for reseting password of your SLATE account. CODE[["+message_code;
		String sub1="Need approval for reseting password of your SLATE account. CODE[["+message_code1;
		
		String bod="<span style='color:blue; font-size: 12pt'>You have requested for reseting <b>password of SLATE account </b></span>, <br><br> If you did not request then ignore this email,<br><br>If you really want to reset SLATE account password then please confirm by replying to this email without typing any word, or reply with any text e.g., 123 etc <br> <br> SLATE Automatic Password Recovery System";
        ///////////
	
	    CheckAndSendCode(sendTo, sub, sub1, bod, from_email);
       
	}
      else if(AcademicsCollection.get(User_ID)!=null)
      {
    	 String request_subject=map.get(sendTo);
    	 
    	 String [] academic_info=AcademicsCollection.get(User_ID);
    	  
    	 String campus1 = academic_info[0].trim().toUpperCase();
    	 
    	 System.out.println(" Academic user "+User_ID+", campus= " +campus1 );
    	 
    	
     	/* String dept_id = academic_info[1].trim().toLowerCase();
     	if(!user_id.equals(User_ID))
     	{
     		System.out.println("861: Academics users did not match " +user_id +"!=" + User_ID );
     		return;
     	}
     	*/
     	
     	String cc_email="";
         String email_subscript="@nu.edu.pk";
         if(campus1.equals("LHR"))
         {
         	
         	cc_email="slatelhr@nu.edu.pk";
         	email_subscript="@lhr.nu.edu.pk";
         }
         else if(campus1.equals("ISB"))
         	{
        
         	cc_email="slateisb@nu.edu.pk";
         	}
         else if(campus1.equals("FSD"))
        	{
       
         	cc_email="slatefsd@nu.edu.pk";
        	}
         else if(campus1.equals("KHI"))
        	{
        
         	cc_email="slatekhi@nu.edu.pk";
        	}
         else if(campus1.equals("PWR"))
        	{
       
         	cc_email="slatepwr@nu.edu.pk";
        	}
         
         else if(campus1.equals("*"))
     	{
    
      	cc_email="slateisb@nu.edu.pk";
     	}
         
         
    	String message_code=encrypter.encrypt("I9$am%6Je0han"+sendTo+"<>*h5/"+dateFormat.format(date)+request_subject);
      	String message_code1=encrypter.encrypt("I9$am%6Je0han"+sendTo+"<>*h5/"+(new SimpleDateFormat("yyyy/MMM/dd ")).format((new Date(date.getTime() - 1 * 24 * 3600 * 1000 )))+request_subject);
       
      	 message_code= message_code.replace("\r", "rratlal12345");
	     message_code= message_code.replace("\n", "nratlal12345");
	    
	     message_code1= message_code1.replace("\r", "rratlal12345");
	     message_code1= message_code1.replace("\n", "nratlal12345");
	    
      //	System.out.println(message_code+ " <decripted> "+ encrypter.decrypt(message_code));
          
          
  		String sub="Need approval for reseting password of your SLATE account. CODE[["+message_code;
  		String sub1="Need approval for reseting password of your SLATE account. CODE[["+message_code1;
  		
  		String bod="<span style='color:blue; font-size: 12pt'>You have requested for reseting <b>password of SLATE account </b></span>, <br><br> If you did not request then ignore this email,<br><br>If you really want to reset SLATE account password then please confirm by replying to this email without typing any word, or reply with any text e.g., 123 etc <br> <br> SLATE Automatic Password Recovery System";
          ///////////
  	    //System.out.println("Target " +sendTo +", from/cc"+  from_email);
  	    CheckAndSendCode(sendTo, sub, sub1, bod, cc_email);
    	  
      }
      else
      {
    	  System.out.println(sendTo + " is not authorized to change password, therefore we cancelled sending of approval code");    	  
      }
	}

	private static void CheckAndSendCode(String sendTo, String todays_subject,
			String previous_day_subject, String message_body, String cc_email) {
		
		 String [] code = new String[2];
		 code[0] = todays_subject.trim().toLowerCase();
		 code[1] = previous_day_subject.trim().toLowerCase();
		 
		 String [] currentSentCode= aCode.get(sendTo);
		 String code1 = currentSentCode[0].trim().toLowerCase();
		 String code2 = currentSentCode[1].trim().toLowerCase();
		 
		 if(code[0].equals(code1) || code[0].equals(code2)||code[1].equals(code1) || code[1].equals(code2))
		 {
			 System.out.println("Approval code is already sent to "+sendTo);
		 }
		 else
		//check! if approval code already did not receive , avoid duplicate 
		
		
		 //todays_subject=todays_subject.trim();
		 //previous_day_subject=previous_day_subject.trim();
		
		// System.out.println(todays_subject);
		// System.out.println(previous_day_subject);
		 
		
		if(totalExists(inbox,todays_subject)>0)
	      {
	     	 System.out.println("Today approval code is already sent to "+sendTo);
	      }
	      else if(totalExists(inbox,previous_day_subject)>0)
	      {
	      	 System.out.println("Previous day we have sent approval code to "+sendTo + ", new code will be issued/sent by tomorrow");
	      }
	      else if(totalExists(inbox,"Re: "+todays_subject)>0)
	      {
	      	 System.out.println("Today approval received from "+sendTo + ", only need to reset password");
	      }
	      else if(totalExists(inbox,"Re: "+previous_day_subject)>0)
	      {
	    		 System.out.println("Previous day approval received from "+sendTo + ", only need to reset password");      
	      }
	       else
	     
	       {
	        	 System.out.println("Code is being sent to "+sendTo);
				 bn= new SendEmail(uid,pw,cc_email,todays_subject,message_body,null);
				 if(bn.Send(sendTo))
				 {
					 System.out.println("Approval code sent to "+sendTo);
					 
				
					 
					 aCode.put(sendTo, code);
					 
					 try{
						approvedEmails = store.getFolder("APPROVAL");
						approvedEmails.open(Folder.READ_ONLY);
					 }catch(Exception ex){}
				 }
				 else
				 {
					 System.out.println("Problem while sending approval code to "+sendTo);
				 }
				 
	        }
	}
	
	private static String ExtractEmail(String key) {
		int a=key.indexOf("<");
		int b=key.indexOf(">");
		String em="";
		
		if(b>0)
		em=key.substring(a+1,b);
		else
			em=key;
		
		return em.trim().toLowerCase();
	}

	static int totalExists(Folder inbox, String sub){     
		
		if(!inbox.isOpen())
		{
			
			System.out.println("Connected closed, we are opening connection NU Mail");
			try {
				ConnectToGmail();
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//sub="Need approval for reseting password of your SLATE account. CODE[[GRuj9v4d5RTV1cWVMHOoJUITDLjYjzGaR3NYALgQTFGWLmBPkFGDCtcuDaXaj9TIOyc/7MXP/x4=";
	//	SearchTerm sTerm = new SubjectTerm(sub); //this fails
        //FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		  SubjectTerm rawTerm =new SubjectTerm(sub);
		  GmailRawSearchTerm rawTerm1 =new GmailRawSearchTerm("subject:"+sub);
    
        try {
			int count= approvedEmails.search(rawTerm).length;
			//System.out.println("SubjectText: " +count);
			
			int count1= approvedEmails.search(rawTerm1).length;
			//System.out.println("GmailRawSearchTerm: " +count1);	
			
			if(count>0 || count1>0)
						return 1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return 0;
    
}
	
	
	
	
	public static void startListening(IMAPFolder imapFolder) {
	    // We need to create a new thread to keep alive the connection
	    Thread t = new Thread(
	        new KeepAliveRunnable(imapFolder), "IdleConnectionKeepAlive"
	    );

	    t.start();

	    while (!Thread.interrupted()) {
	    	//System.out.println("Starting IDLE");
	        try {
	        	logout_counter++;
	        	
	        	if(imapFolder.isOpen())
	            imapFolder.idle();
	        } catch (Exception e)
	        {
	        	System.exit(1);
	        }
	    }

	    // Shutdown keep alive thread
	    if (t.isAlive()) {
	        t.interrupt();
	    }
	}
	private static class KeepAliveRunnable implements Runnable {

	 

	    private IMAPFolder folder;

	    public KeepAliveRunnable(IMAPFolder folder) {
	        this.folder = folder;
	    }

	    int threadcounter=0;
	    int print=0;
	    public void run() {
	        while (!Thread.interrupted()) {
	            try {
	               

	                // Perform a NOOP just to keep alive the connection
	                threadcounter++;
	                
	                if(threadcounter>360)
	                {
	                	System.out.print("*");
	                	threadcounter=0;
	                }
	          
	                
	                int current_count = folder.getMessageCount(); 
	               // System.out.println(ternimate_time + " - " + (((print+1) * KEEP_ALIVE_FREQ))/1000  + "\t\t current:" +current_count + "\t old:" +old_message_count + " (Email server for changing Password of Students)");
	               // System.out.println( " (Server is waiting for an email to reset the password of students only)");
	               
	               
	                
	                
	                if(print>2)
	                {
	                	print=0;
	                	
		                ternimate_time++;
		                
		                if(ternimate_time<17)
		                	System.out.print(".");
		                
		                if(ternimate_time==17)
		                	  System.out.println( ""); 
		                
		                if(ternimate_time>16)
		                 	  System.out.print( "\""); 
		                 
		                
		                if(ternimate_time>23)
		                {
		                	try {
								store.close();
							} catch (Exception e) 
							{
								
							}
							 
						          try{ 
						        	  if (socket != null)
						        	  socket.close(); 
						        	  } catch(Exception e){}
						          
		                	System.exit(0);
		                }
		                
		                
	                }
	                else
	                {
	                	print++;
	                }
	                
	                if(current_count != old_message_count)
	                {
	                  	 System.out.println("\n\n\n****************** "+(new Date())+" ******************");
	                  	 
	                	 if(old_message_count!=-1)
	                		 System.out.println( "Email Received");
	                	  
	                		
	                	  ReplyToEmail();
	                	  old_message_count=current_count;
	         
	                      System.out.println();
	                   
	                      
	                      map.clear(); 
	                      map1.clear();
	                	
	                } 
	                
	                Thread.sleep(KEEP_ALIVE_FREQ);
	                
	            }  catch (Exception e) {
	                // Shouldn't really happen...
	            	System.out.println("JB: Unexpected exception while keeping alive the IDLE connection"+ e.getMessage());
	            	System.out.println("Re opening connection ");
	            System.exit(1);
	            }
	        }
	    }
	}
	
	
	
	
	
	public class CheckDate  {
	    public void myCheckDate(Date givenDate) {
	        SearchTerm st = new ReceivedDateTerm(ComparisonTerm.EQ,givenDate);

	        try {
				Message[] messages = inbox.search(st);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    // in main method

	   
	}
}


