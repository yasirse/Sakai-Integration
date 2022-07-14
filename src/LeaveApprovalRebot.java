import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.URL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.safety.Whitelist;

 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sun.net.www.protocol.http.HttpURLConnection;





import com.google.code.com.sun.mail.imap.IMAPFolder;
import com.google.code.com.sun.mail.imap.IMAPMessage;
import com.google.code.com.sun.mail.imap.IMAPSSLStore;
import com.google.code.javax.mail.BodyPart;
import com.google.code.javax.mail.Flags;
import com.google.code.javax.mail.Flags.Flag;
import com.google.code.javax.mail.Folder;
import com.google.code.javax.mail.Message;
import com.google.code.javax.mail.Message.RecipientType;
import com.google.code.javax.mail.FetchProfile;
import com.google.code.javax.mail.MessagingException;
import com.google.code.javax.mail.Multipart;
import com.google.code.javax.mail.NoSuchProviderException;
import com.google.code.javax.mail.Session;
import com.google.code.javax.mail.Store;
import com.google.code.javax.mail.URLName;
import com.google.code.javax.mail.internet.MimeMultipart;
import com.google.code.javax.mail.search.ComparisonTerm;
import com.google.code.javax.mail.search.FlagTerm;
import com.google.code.javax.mail.search.GmailRawSearchTerm;
import com.google.code.javax.mail.search.GmailThreadIDTerm;
import com.google.code.javax.mail.search.MessageIDTerm;
import com.google.code.javax.mail.search.ReceivedDateTerm;
import com.google.code.javax.mail.search.SearchTerm;
import com.google.code.javax.mail.search.SubjectTerm;

public class LeaveApprovalRebot {
	
	 	static SendEmail  bn=null;
	    static HashMap<String,String> map, map1 ;
	    static HashMap<String,String[]> AcademicsCollection;
	    static HashMap<String,String[]> aCode;
	    static HashMap<String, Date> map7;
	    static HashMap<String, String> map8;
	    
	   
	    static Helper encrypter =null;
	    static String uid="cTZK/KL6WSrNNHttFL4Q1yR25tOPX05A";
		static String pw="19xr7IPJ3vATBc684v/wZA==";
		static Session session =null;
		static int old_message_count=-1;
		static int ternimate_time=0;
		private static final long KEEP_ALIVE_FREQ = 1000*15*1; // 30 seconds
		static Folder approvedEmails =null;
		static Folder RA =null;
		static IMAPSSLStore store =null;
		static ServerSocket socket = null;
		static int logout_counter=0;	 
		static oracle orcl =null;
		static FetchProfile fp =null;
	 
	
	public static void main(String args[]) {
		
	/*
	//	 String te="On Feb 18, 2016 10:12 AM, \"HUMAN RESOURCES\" <";
		 String te="On Tue, Feb 16, 2016 at 3:51 PM, HUMAN RESOURCES <";
		 
		 int sss1=te.length();
		 sss1=sss1-5;
		 
		 String result1=te.toLowerCase().substring(te.length()-50, te.length()-45);
		 System.out.println(result1);
		*/
		
		try {
		      socket = new ServerSocket(34557);
		      System.out.println("Starting Leave Approval Server for HoD ... ");
		     
		    String sss="";
		    	sss.replace("","");
		    }
		    catch (IOException ex) 
		    {
		      System.out.println(" Leave Approval Server is already running, exiting in 5 seconds ...");
		      try{ Thread.sleep(5000); } 
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
					    	 
			        		try {
								//Thread.sleep(1000001);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					                
			           
			                IMAPFolder f = (IMAPFolder)approvedEmails;
			                startListening(f);
			           
			                try {
			                           
			                        try {
			                            store.close();}
			                            catch (Exception e) {


			                            }
			                            
			                  //  }
			                  //  optionReader.close();
			                } catch (Exception e) {
			                	   System.out.println("((((((((((((((");
			                    System.out.println(e);
			                }
			               
			                try {
			                store.close();}
			                catch (Exception e) {


			                }
			                //////////////////////////
			                
			                if(map.size()>0)
			                System.out.println("---------Un Answerd Emails------------");
			             //   sendApprovalsToUnAnswered(map,1);
			                
			                
			                
			        } catch (NoSuchProviderException e) {
			        	System.out.println("********************");
			            System.out.println(e.toString());
			            e.printStackTrace();
			            System.exit(1);
			        } catch (MessagingException e) {
			        	System.out.println("*################*");
			            System.out.println(e.toString());
			            System.exit(2);
			        }

			    }
	
	private static IMAPSSLStore ConnectToGmail() throws MessagingException {
		
		if(store!=null)
		if(store.isConnected())
		{ System.out.println("Trying to logout, and exit");
			store.close();
			//System.out.println("Logout success, wait for 1 minute/s");
			
			try {
				System.exit(0);
			
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		
		if(approvedEmails!=null)
		if(approvedEmails.isOpen())
		{
			approvedEmails.close(true);
		}
		
		Properties props = System.getProperties();
		props.setProperty("mail.imap.starttls.enable", "true");
		props.setProperty("mail.imap.ssl.enable", "true");
		props.setProperty("mail.store.protocol", "imaps");

		 session = Session.getDefaultInstance(props, null);
      
		URLName urlName = new URLName("imap.gmail.com");
		 store = new IMAPSSLStore(session, urlName);
		 store.connect("imap.gmail.com", uid, pw);
		 System.out.println("Login success");
		 
		   fp = new FetchProfile();
		    fp.add(FetchProfile.Item.ENVELOPE);
		    fp.add(IMAPFolder.FetchProfileItem.X_GM_THRID);
		
		approvedEmails = store.getFolder("LR");
		approvedEmails.open(Folder.READ_WRITE);
		
		RA = store.getFolder("RA");
		RA.open(Folder.READ_ONLY);
		
		
		  // System.out.println("All folders opened");
		return store;
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
	        	
	        	
	        	//System.out.println("thread interrupt  " + logout_counter);
	        	
	        	if(imapFolder.isOpen())
	            imapFolder.idle();
	        } catch (MessagingException e) {
	        	
	        	try {
	        	//System.out.println("JB? **** Messaging exception during IDLE --- "+ e.getMessage());
	        	//System.out.println("Re opening ");
	        	 
	        	System.exit(1);
	            
	        	}catch(Exception ex){}
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
	              //  System.out.println(ternimate_time  +" Leave Approval Server is waiting for an email from HoD  ... " );
	               
	             
	                if(ternimate_time==17)
	                	  System.out.println( ""); 
	                
	                if(ternimate_time>16)
	                 	  System.out.print( "\""); 
	                 else
	                	System.out.print(".");
	                
	               
	                if(print>2)
	                {
	                	print=0;
	                	
		                ternimate_time++;
		              
		               
		                
		                if(ternimate_time>23)
		                {
		                	try {
		                		orcl.DisConnect();
								store.close();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
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
	                		 	System.out.println( "Email received from HR");
	                  	
	        				
	                	try{
	           			 ReplyToEmail();
	           			}catch(Exception ex)
	           			{
	           				System.out.println("JKK: Some problem while reading unread messages");
	           				System.exit(1);
	           			}
	                	  old_message_count=current_count;
	              
	                   
	                      
	                      map.clear(); 
	                      map1.clear();
	                	
	                }
	                
	                Thread.sleep(KEEP_ALIVE_FREQ);
	                
	            } catch (InterruptedException e) {
	                // Ignore, just aborting the thread...
	            } catch (Exception e) {
	            	
	                // Shouldn't really happen...
	            	System.out.println("JB: Unexpected exception while keeping alive the IDLE connection "+ e.getMessage());
	            	System.out.println("Re opening connection ");
	            	try {
	            		if(orcl!=null)
	            			orcl.DisConnect();
	            		
	            		System.exit(1);
	            	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
	            }
	        }
	    }
	}

	
	 
	static int old_ra_count=-1;
	private static boolean ReplyToEmail()   {
		///////////////////////////////////////////////////////////////delete
		try {
		
			
		FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		 Message msg1[]= approvedEmails.search(ft);
		 Message RA_all[]= RA.getMessages();
		
		 /*
		 if(   old_ra_count!=RA_all.length )
		 {
			 System.out.println("Sorting for performance");
			 RA_all = RA.getMessages();
			 old_ra_count= RA_all.length;
			 
			 // Sort on the date
			    java.util.Arrays.sort(RA_all, new Comparator() {
			            public int compare(Object o1, Object o2) 
			            {
			                Message m1 = (Message)o1;
			                Message m2 = (Message)o2;
			                
								try {
									return (m2.getSentDate().compareTo(m1.getSentDate()));
								} catch (MessagingException e) {
									// TODO Auto-generated catch block
									 
								}
							return 0;
			            } 
			    });
			 
			    
			    
		 }*/
		 
		 
		 //System.out.println(RA_all[0].getSubject());
		 
		 
		 System.out.println(".Leave approval server is waiting for an email from HoD only... " + msg1.length);
			
			
		 if(msg1.length>0)
			 System.out.println("-Email received from other employee, HoD expected... " + msg1.length + " - ");
		 else
			 return false;
		 
			
			 
		
			
			 
		int email_counter=0;
		 List list= new ArrayList();
		 
		
		 
		 for(Message message:msg1) 
		 {
			 
			 /////////////////////////////////////////
			 
			 String result = null;
	         if (message.isMimeType("text/plain") )
	         {
	        	  try {
	        		  	result= message.getContent().toString();
	        	  } catch (IOException e) {}
	         }
	         else //if (m.isMimeType("multipart/*")) 
	         {
	        	 MimeMultipart mimeMultipart = null;
	        	 
	        	 Object content=null;
				try {
					content = message.getContent();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
	        	 if (content!=null && content instanceof String)  
	        	 {  
	        		// System.out.println("\nString>>>>>>>>: ");
	        	     result = (String)content;  
	        	     //result =  Jsoup.parse(result).text();
	        	     
	        	     Document doc =  Jsoup.parse(result);
	        	     result=getText(doc);
	        	     
	        	     result=result.toLowerCase();
	        			char[] c_arr = result.toCharArray();
	        			for(int i=0;i<c_arr.length;i++)
	        			{
	        				char character =	c_arr[i];
	        				int ascii = (int) character;
	        				if((ascii>47 && ascii<58) 
	        						|| (ascii>96 && ascii<123) 
	        						|| (ascii>64 && ascii<91)
	        						|| (ascii==64) 
	        						|| (ascii==62) 
	        						|| (ascii==60) 
	        						|| (ascii==32)
	        						|| (ascii==35) 
	        						|| (ascii==10) 
	        						|| (ascii==9) 
	        						|| (ascii==46) 	
	        						|| (ascii==47) 
	        						|| (ascii==92) 
	        						|| (ascii==45) 
	        						|| (ascii==58) 
	        						)
	        				{
	        					
	        				}
	        				else
	        				{
	        					//System.out.println(c_arr[i] + " " + ascii);
	        					
	        					if(ascii==160)
	        						c_arr[i]=' ';
	        					else
	        						c_arr[i]='*';
	        				}
	        				
	        			}
	        			
	        			
	        			
	        			result = String.valueOf(c_arr);
	        			result=result.replace("*", "");
	        			result=result.replace("?", "");
	        			result=result.replace("&lrm;", "");
	        			result=result.replace("&#8206;", "");
	        			
	        			
	        	     if(result!=null)
	        	     {
	        	    	 result=result.replace("#", "\n");
	        	    	 result=result.replace("<", "\n<#<");
	        	    	 result=result.replace(">", ">#>\n");
	        	    	 result=result.trim();
	        	   
	        	     }
	        	  //   System.out.println("\n" +result);
	        	     
	        	    
	        	 
	        	    
	        	 }  
	        	 else if (content!=null && content instanceof MimeMultipart)  
	        	 {  
	        		 System.out.println("\nMimeMultipart>>>>>>>>: ");
	        		 mimeMultipart = (MimeMultipart)content;  
	        	    
	        	 } 
	        	 else if (content!=null && content instanceof Multipart)  
	        	 {  
	        		 System.out.println("\nMultipart>>>>>>>>: ");
	        		 mimeMultipart = (MimeMultipart)content;  
	        	    
	        	 } 
	        	 
	        	 if(mimeMultipart==null)
	        	 {
	        		 try {
						mimeMultipart =(MimeMultipart)message.getContent();
						// System.out.println("\nGooooooooooooooooooooooD>>>>>>>>: ");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						 
					}
	        	 }
	        
	         
	             int count = 0; 
	             
	             if(mimeMultipart!=null)
	             {
	            	 count=mimeMultipart.getCount();
	            	 if(count>0)
	            		 result="";
	            	 
	            	 if(count>0)
	            	 {
	            		 //System.out.println("Total body parts " + count);
	            	 }
	             }
	             
	             for (int i = 0; i < count; i ++)
	             {
	                 BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	                 System.out.println("bodyPart Content Type: " +bodyPart.getContentType()); 
	                 if (bodyPart.isMimeType("text/plain"))
	                 {
	                     try {
							result = result + "\n" + bodyPart.getContent();
						} catch (IOException e) {}
						
	                     break;  //without break same text appears twice in my tests
	                 } 
	                 else if (bodyPart.isMimeType("text/html"))
	                 {
	                	 try {
	                		 	String html = (String) bodyPart.getContent();
	                		 	 result = result + "\n" + Jsoup.parse(html).text();
	                		 	  
	                		 	
	                	 	} catch (IOException e) {}
	                     	break;
	                 }
	             }
	           
	         }//if plain else 
	         //
	        
	         
	         System.out.println("Here 1");
		if(result!=null && result.toLowerCase().contains("from: human resources"))///for mukhtar ullah khan PDA
			{
			result=result.toLowerCase();
			
			// System.out.println("Here 1, entered");
					 
						 result=result.substring(0, result.indexOf("from: human resources") );
						 
						 if(result.length()>1)
							 result=result.substring(0, result.length()-1 );
						 
						 if(result.length()>100)
							 result=result.substring(0, 100 ) + " ... ";
					
					
				
					
				 }
				 else
			 if(result!=null && result.contains("noreply.hrisb@nu.edu.pk")) //for common PC  
			 {
				 //System.out.println("Here 1, entered1");
				 String result1=null;
				 result=result.substring(0, result.indexOf("noreply.hrisb@nu.edu.pk") );
				 
				 if(result.length()>50)
					 result1=result.toLowerCase().substring(result.length()-50, result.length()-45);
		
				 
				 if(result.length()>45)
						 result=result.substring(0, result.length()-45 );
				 
				 
				 if(result.length()>6)
				 {
					// String result1=result.toLowerCase().substring(result.length()-6,6);
					 	 
					 if(result1.contains("n mo")
						|| result1.contains("n tu")	 
					 || result1.contains("n we")
					 || result1.contains("n th")
					 || result1.contains("n fr")
					 || result1.contains("n sa")
					 || result1.contains("n su")
					 )
					 {
//						 String te="On Feb 18, 2016 10:12 AM, \"HUMAN RESOURCES\" <";
	             	//	 String te="On Tue, Feb 16, 2016 at 3:51 PM, HUMAN RESOURCES <";
							//	 System.out.println(te.length());
						 result=result.substring(0, result.length()-6 );
						 
						
					 }
						 
				 }
				
				
			 }
			 else
				 if(result!=null && result.contains("cc: hr.isbcamp@nu.edu.pk")) //for adnan shafaqat PDA
				 {
					// System.out.println("Here 1, entered2");
					 if(result.toLowerCase().contains("blackberry"))
					 {
						 result=result.substring(0, result.indexOf("blackberry") );
					 
					 if(result.length()>14)
						 result=result.substring(0, result.length()-14 );
					 }
					 else
					 {
						 result=result.substring(0, result.indexOf("cc: hr.isbcamp@nu.edu.pk") );
						 if(result.length()>100)
							 result=result.substring(0, 100 ) + " ... ";
					 }
					
				
					
				 }
		
		 //System.out.println("Here 2");
		
		 if(result!=null && result.toLowerCase().contains("-----ori"))
			 result=result.substring(0, result.toLowerCase().indexOf("-----ori") );
		 
	
			 
			 if(result!=null && result.length()>273)
					 result=result.substring(0,270) + "...";
			 
			 if(result!=null && result.contains("warm regards"))
				 result=result.substring(0, result.indexOf("warm regards")-1 );
				 
			 if(result!=null && result.contains("\'"));
			 result=result.replace("\'", " ");
			 
			 if(result!=null && result.contains("\""));
			 result=result.replace("\"", " ");
			 
			 if(result!=null && result.contains("'"));
			 result=result.replace("'", " ");
			 
			 if(result!=null && result.contains("\\"));
			 result=result.replace("\\", " ");
			 
			 if(result!=null );
			 	result=result.trim();
			
			 System.out.println(">>>>>>"+result +"<<<<<<");
			 
			 
	         
			 /////////////////////////////////////////
			
			 boolean reject=false;
			 IMAPMessage lastMsg = (IMAPMessage) message;
			 String org_subj=null;
			 String current_email_subject= lastMsg.getSubject();
			 String current_email_subject1= lastMsg.getSubject();
			
			 if(current_email_subject!=null && current_email_subject.toLowerCase().contains("reject"))
			 {
				
				 if( current_email_subject.toLowerCase().contains("rejected"))
				 {
					 current_email_subject=current_email_subject.replace("rejected", " rejected");
					 current_email_subject=current_email_subject.replace(" rejected", "");
					 current_email_subject=current_email_subject.replace("rejected", "");
				 }
				 else
				 {
					 current_email_subject=current_email_subject.replace("reject", " reject");
					 current_email_subject=current_email_subject.replace(" reject", "");
					 current_email_subject=current_email_subject.replace("reject", "");
				 }
				 
				 current_email_subject=current_email_subject.replace("  ", " ");
				 current_email_subject=current_email_subject.replace("  ", " ");
				 current_email_subject=current_email_subject.replace("  ", " ");
				 current_email_subject=current_email_subject.trim();
				 
				 current_email_subject=current_email_subject + " " + "reject";
				 current_email_subject=current_email_subject.replace("  ", " ");
				 
				 reject=true;
			 }
			 
			 String true_message_id=message.getHeader("message-id")[0].toString();
	       	 true_message_id=true_message_id.substring(1,true_message_id.length()-1);
        	
			 
			 String msgid=null;
		     try{
		    	  String Received = lastMsg.getHeader("In-Reply-To")[0].toString().trim();;
		    	  msgid = Received;
		      	  if(list.contains(Received))
		    		  continue;
		 	    	 
		    	  
		      }catch(Exception ex){}
		      
		      
		      
		      
		      if(msgid==null || msgid.length()<5)
		      {
		    		System.out.println("Reference not found for the subject: "+current_email_subject );
		    		//MarkReadApprovals(true_message_id);
		    		
		    		String raw_received =null;
		  	      
		  	      try{
		  	    	  raw_received = lastMsg.getHeader("Received")[1].toString();
		  	      }catch(Exception ex){}
		  	    //  System.out.println( "  " +raw_received);
		         	  boolean satus = isValidHost(raw_received);
		         	  if(satus==false  )
		         	  {
		         		  System.out.println("!!!!!! unable to identify the HOST for: "+lastMsg.getFrom()[0] );
		         		continue;
		         	  }
		         	  else
		         	  {
		         		 String reply_to_org= lastMsg.getFrom()[0]+"";
		         		 if(reply_to_org.contains("jehan.badshah"))
		         		 {
		         			 org_subj=current_email_subject.replace("reject", "").trim();
		         		 }	
		         	  }
		         	  
			    	//  continue;
		    	  
		      }
		      
		     // System.out.println("Search started\n");
		      
		      /*
		      SearchTerm term = new SearchTerm() {
		    	    public boolean match(Message message) {
		    	        try {
		    	        	
		    	        	String temp_msgdd = message.getHeader("Message-ID")[0].toString().trim();
					         temp_msgdd=temp_msgdd.substring(1,temp_msgdd.length()-1);
					         
					         if(  msgid.contains(temp_msgdd)){
		    	                return true;
		    	            }
		    	        } catch (MessagingException ex) {
		    	       
		    	        }
		    	        return false;
		    	    }
		    	};
		    	*/
		      /*
		      if(org_subj==null)
		      for(Message message1:RA_all) 
				 {
					
					 IMAPMessage lastMsg1 = (IMAPMessage) message1;
			       	 String temp_msgdd = lastMsg1.getHeader("Message-ID")[0].toString().trim();
			         temp_msgdd=temp_msgdd.substring(1,temp_msgdd.length()-1);
			       	 
			         if(  msgid.contains(temp_msgdd))
			       	 {
			       		org_subj = lastMsg1.getSubject();
			       		
			       		System.out.println(org_subj );
			       		break;
			       	 }
				      	  
				  }
		      
		     // System.out.println("Search end "+org_subj +"\n"); 
		      if(org_subj==null)
		      {
		    	 
		    	    String body="HR Alert email was not found of subject: "+current_email_subject ;
        			System.out.println(body );
		   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", lastMsg.getSubject(),  body,  true_message_id);

		   			
		    	    MarkReadApprovals(true_message_id);
		    	  continue;
		      }
		      else
		    	   System.out.println(">>>  "+org_subj );
		           
		      
		      if(!current_email_subject.contains(org_subj))
		      {
		 
		    	    String body="Email subject is tempared "+current_email_subject;
        			System.out.println(body );
		   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", lastMsg.getSubject(),  body,  true_message_id);

		    	    MarkReadApprovals(true_message_id);
		    	  continue;
		      }
		   
		      
		      */
		      
	         try{
		    	  String Received = lastMsg.getHeader("Received")[0].toString().trim();;
		    	  if(list.contains(Received) )
		    		  continue;
		    	  
		      }catch(Exception ex){}
		      
		      try{
		    	  String Received = lastMsg.getHeader("Message-ID")[0].toString().trim();;
		    	  if(list.contains(Received))
		    		  continue;
		    	  
		    	 
		    	  
		      }catch(Exception ex){}
		      
		      try{
		    	  String Received = lastMsg.getHeader("References")[0].toString();
		    	  
		    	  //System.out.println("REF: "+Received);
		    	  if(list.contains(Received))
		    		  continue;
		    	  
		    	  if(Received.contains("\n"))
			       {
			    	   String [] sp =Received.split("\n");
			    	   if(list.contains(Received))
			    		   
			    		if(list.contains(sp[0].trim()))
			    			continue;
			    	   
			    	   	if(list.contains(sp[1].trim()))
			    	   		continue;
			  
			       }
		    	 
		    	  
		      }catch(Exception ex){}
			 
		      
		    
			 approvedEmails.fetch(new Message[]{lastMsg}, fp);
	         long threadId = lastMsg.getGoogleMessageThreadId();
	         
	       
	         
	        // System.out.println(threadId);
	         
	         GmailThreadIDTerm term = new GmailThreadIDTerm(threadId + "");
	         Message[] thread = approvedEmails.search(term);
	         approvedEmails.fetch(thread, fp);
	         
	         
	         
	         int cnt=0;
	        
	      
	         if(thread.length>0)
	         { 
	        	 
	        	   Message m= thread[thread.length-1];
	        	   System.out.println("Last Email Received on Date: "+m.getReceivedDate());
	        	   
			       cnt++;
			        
			        if(cnt>1)
			        	continue;
			        
			      
			        String subject_test= m.getSubject();
			        
			  
			        boolean recommendation=false;
			        boolean approval=false;
				      
			        if(subject_test==null)
			        	return false;
			        		
			         	subject_test=subject_test.toLowerCase().trim();
			        	subject_test=subject_test.replace(")".toLowerCase(),"");
						
			        
			        
			        if(subject_test.contains("HR Alert – Pending Leave Recommendation (".toLowerCase()))
			        {
			        	recommendation=true;
			        	subject_test=subject_test.replace("HR Alert – Pending Leave Recommendation (".toLowerCase(),"");
			        }
			        else
			        	if(subject_test.contains("HR Alert – Pending Leave Approval (".toLowerCase()))
				        {
			        		approval=true;
				        	subject_test=subject_test.replace("HR Alert – Pending Leave Approval (".toLowerCase(),"");
				        }
			        	else
			        	{
			        		System.out.println("\n<<<<<< problem in subject: Entered for another checking >>>>>>>>>>> " );
			        		
			        		String sub1 = subject_test;
			        		if(subject_test.toLowerCase().contains("pending leave"))
			        		{
			        			String raw_subb_slice=subject_test.substring(subject_test.indexOf("pending leave"), subject_test.length());
			        			String new_subb="hr alert – "+ raw_subb_slice;
			        			subject_test=new_subb;
			        		}

			        		 if(subject_test.contains("HR Alert – Pending Leave Recommendation (".toLowerCase()))
						        {
						        	recommendation=true;
						        	subject_test=subject_test.replace("HR Alert – Pending Leave Recommendation (".toLowerCase(),"");
						        }
						        else
						        	if(subject_test.contains("HR Alert – Pending Leave Approval (".toLowerCase()))
							        {
						        		approval=true;
							        	subject_test=subject_test.replace("HR Alert – Pending Leave Approval (".toLowerCase(),"");
							        }
			        		 
			        		 		System.out.println("recommendation: "+recommendation +", approval: "+approval);
						        	 
					        		 if(!recommendation && !approval )
					        		 {
					        	 	    String body="Email subject has some problem, therefore it will not be replied <br>" +subject_test +"<br>"+sub1 ;
					        			System.out.println(body );
							   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
					
								       	MarkReadApprovals(true_message_id);
					        		  return false;
						        	}
					        		 else
					        		 {
					        			 System.out.println("<<< Subject correctly identified, procceding further >>>");
					        		 }
			        	}
			        
			        String raw_app_id=null;
			        if(subject_test.contains("la"))
			  		 {
			  			 String [] fff =subject_test.split(" ");
			  			 for(int i=0;i<fff.length; i++ )
			  			 {
			  				 if(fff[i].contains("la"))
			  					raw_app_id=fff[i];
			  			 }
			  			 
			  		 }
			      
			        
			        if(!subject_test.contains("la") || raw_app_id==null)
			        {
			        	  
		        	 	    String body="Email is not related to approvals or recommendation, subject is not enough" ;
		        			System.out.println(body );
				   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
		
		        	 	   
		        	 	   MarkReadApprovals(true_message_id);
		        		return false;
			        }
			        
			        raw_app_id=raw_app_id.replace("la", "");
			        raw_app_id=raw_app_id.replace("i", "");
			        raw_app_id=raw_app_id.trim();
			        
			        int valid_app_id=-1;
			        try{
			        	valid_app_id = Integer.parseInt(raw_app_id);
			        }catch(Exception ex){}
			        
			        if(valid_app_id<=0)
			        {
			        	
			        	  String body=valid_app_id+" Application ID is not valid " ;
		        			System.out.println(body );
				   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
	
					       	MarkReadApprovals(true_message_id);
		        		continue;
			        }
			        
			        valid_app_id=valid_app_id-7; //actual ID
			        if(valid_app_id<=0)
			        {
			        	
		        	 	   
		        	 	   
		        	 	    String body=valid_app_id+" 1Application ID is not valid " ;
		        			System.out.println(body );
				   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
	
				   			
					       	MarkReadApprovals(true_message_id);
					       	continue;
			        }
			        
			      
			        
			    
							
							
		        	 
		        	
		        	 
		        	 try {
				        	
		        	  	  
			        	  	 
			    		 
			    			  String reply_to_org= lastMsg.getFrom()[0]+"";
			        		  String reply_to=reply_to_org;
			   		 
			        		  if(reply_to_org!=null && (reply_to_org.contains(">") || reply_to_org.contains("<")))
			        		  {
			 		  		 try{
			 		  			 int f2 = reply_to_org.indexOf('<');
			 		  			 int l2 = reply_to_org.indexOf('>');
			 		  			 
			 		  			 if(f2>=0 && f2>0)
			 		  					 reply_to  = reply_to_org.substring(f2, l2);
			 		  			 
			 		  				 reply_to=reply_to.replace("<", "");
			 		  				 reply_to=reply_to.replace(">", "");
			 		  			  
			 		  			 
			 		  		 }catch(Exception ex){}
			        		  }
			        		  
			        		  
			        		 if(reply_to==null || !reply_to.contains("@"))
			        			reply_to = reply_to_org;
			        			
			   		 if(reply_to!=null)
			   			 reply_to=reply_to.trim().toLowerCase();
			   		 
			   		 if(reply_to.contains(" "))
			   		 {
			   			 String [] fff =reply_to.split(" ");
			   			 for(int i=0;i<fff.length; i++ )
			   			 {
			   				 if(fff[i].contains("@"))
			   					reply_to=fff[i];
			   			 }
			   			 
			   		 }
			   		 
			    			 
			   	  if(!recommendation && !approval)
			   		{
			        		   
			        	    String body="Nothing to recommend or approve " + m.getSubject() + ", please contact HR" ;
		        			System.out.println(body );
				   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
	
				   			
					       	MarkReadApprovals(true_message_id);
					       
					       	continue;
			   		}
			        
			        if(recommendation || approval)
			        {
			        	    System.out.println(reply_to +", Rec:" +recommendation +", Apr:" +approval +", App#:" +valid_app_id );
			        	    
			        	   
			        }
			            	
				  		 /*
		            		  String request_subject = lastMsg.getSubject();
				       		  String origional_subject = request_subject;
				       		   
				       		   request_subject=request_subject.replace("Re:", "");
				       		  request_subject=request_subject.replace("Fwd:", "");
				       		  request_subject ="Re: " +request_subject.trim();
				       		   
		            		 String hr_email=uid;
					        String hr_password=pw;
					      
					         
			       		    SendEmail bn= new SendEmail(hr_email,hr_password,"slateisb@nu.edu.pk", "slateisb@nu.edu.pk",request_subject,body,true_message_id);
			       		 if( bn.Send(reply_to))
			    			{
			    				 //System.out.println("Itimation for department-wise report to "+reply_to);
			    			 }
			    			*/	 
			    	
			   		
			   	    if(orcl==null || !orcl.isValidConnection())  
						orcl = new oracle();
			        
						if( !orcl.isValidConnection())
						{
							
							 try {
								  orcl.Connect(); 
							} catch (Exception e) 
							{
								
							}
						}
							
							if( !orcl.isValidConnection())
							{
								
								 System.out.println("DB Connection is closed,trying to open new connection, 2 ");
								
								 try {
									 Thread.sleep(10000);
									 orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							
							if( !orcl.isValidConnection())
							{
								 System.out.println("DB Connection is closed,trying to open new connection, 3 ");
								
								 try {
									 Thread.sleep(30000);
									  orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							
							if( !orcl.isValidConnection())
							{
								 System.out.println("DB Connection is closed,trying to open new connection, 4 ");
								 
								 try {
									 Thread.sleep(60000);
									  orcl.Connect(); 
								} catch (Exception e) 
								{
									
								}
							}	
							if( orcl.isValidConnection())
							{
								 System.out.println("Oracle connection is already opened");
							}
							
							boolean is_recommend=false; 
			    			boolean is_approve=false; 
				       		 String dQuery="";
			        		 
				        		
		        	   dQuery=" select id,prop1,prop2 from ileave_application "+
									" where ( "+
									" prop1 like (select user_id from istaff where trim(lower(email)) like '"+reply_to+"') "+
									" )  and id=" +valid_app_id ;
		        		 
		        	    String rec_user_id="";
		        		ResultSet rs=  orcl.select(dQuery);
		    			while(rs.next())
		    			{
		    				try{
				   				rec_user_id = rs.getString("prop1").trim(); 
				   				}catch(Exception ex){}
		    				is_recommend=true;
		    			}
		    			try{
		    				rs.close();
		    			}catch(Exception ex){}
		    			
		    			
		    			dQuery=" select id,prop1,prop2 from ileave_application "+
							" where ( "+
							" prop2 like (select user_id from istaff where trim(lower(email)) like '"+reply_to+"') "+
							" )  and id=" +valid_app_id ;
       		 
       		 
		    			
		    			String apr_user_id="";
			       		rs=  orcl.select(dQuery);
			   			while(rs.next())
			   			{
			   				is_approve=true;
			   		 		 
			   				
			   				try{
			   				apr_user_id = rs.getString("prop2").trim(); 
			   				}catch(Exception ex){}
			   				
			   			}
   			
			   			try{
			   				rs.close();
			        	 }catch(Exception ex){}		
						         
			        	 
			        	
			        	 
			        	 if(!is_recommend && !is_approve && !reply_to.contains("hr.isbcamp@nu.edu.pk"))
			        	 {
			        		    
			        			String body=reply_to+"  cannot recommend or approve the leave application # LA" +(valid_app_id+7)+"i" ;
			        			System.out.println(body );
					   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
					   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
					   			
					       		MarkReadApprovals(true_message_id);
					       		
					       		orcl.DisConnect();
					       		continue;
			        	 }
			        	 if(recommendation && reply_to.contains("hr.isbcamp@nu.edu.pk"))
			        	 {
			        		 rec_user_id="hr.isbcamp@nu.edu.pk";    
			        		 is_recommend=true;
			          	 }
			        	 if(approval && reply_to.contains("hr.isbcamp@nu.edu.pk"))
			        	 {
			        		 apr_user_id="hr.isbcamp@nu.edu.pk";    
			        		 is_approve=true;
			           	 }
			        	 
			        	 int count_process=0;
			        	 if(reject==false)
			        	 {
			        		 count_process=0;
			    			 if(recommendation && is_recommend==true  )
						   		{
			    				
					   			 	//valid_app_id
							   		//reply_to
			    				 System.out.println("Start recommendation by Line Manager#1");
							   			 
							   		String rec="	update ileave_application "+
							   		"		set APPROVED_FROM_DATE=REQUEST_FROM_DATE, "+
							   		"		APPROVED_TO_DATE=REQUEST_TO_DATE, "+
							   		"		APPROVED_COMMENTS='Recommended via email: "+result+"', "+
							   		"		APPROVED_BY='"+rec_user_id+"', "+
							   		"		APPROVED_STATUS='Accept', "+
							   		"		DATE_APPROVED=sysdate "+
							   		"		where id="+valid_app_id +
							   		"		and APPROVED_STATUS is null";
							   		int count1=orcl.DeleteUpdate(rec);
									if(count1!=0)
									{	
										System.out.println(count1+" leave application recommended ");
										
								   		String rec1="		update ileave_application_detail "+
								   		"		set approve_status=1 "+
								   		"		where ileave_application_id="+valid_app_id;
								   		
							   			count1=orcl.DeleteUpdate(rec1);
										if(count1!=0)
										{
											 count_process++;
											System.out.println(count1+" days recommended successfully");
										}
										else
										{
											System.out.println(count1+" >>>>>>>>>> problem >>>>leave recommended but days are not updated");
											String body="LA"+(valid_app_id+7)+"i" + " leave rec rejected but balance is not updated ";
									   		 
								   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
										}
							   		
									}
									
									if(is_approve==true && count_process>0  ) //when line manager1 and line manager2 will same
									{
								  		 System.out.println("Line manager# 1 and 2 is same there approving by same email");
								   			
								   			 rec="	update ileave_application "+
									   		"		set ISSUED_FROM_DATE=APPROVED_FROM_DATE, "+
									   		"		ISSUED_TO_DATE=APPROVED_TO_DATE, "+
									   		"		ISSUED_COMMENTS='Approved via email: "+result+"', "+
									   		"		ISSUED_BY='"+apr_user_id+"', "+
									   		"		ISSUED_STATUS='Accept', "+
									   		"		DATE_ISSUED=sysdate "+
									   		"		where id="+valid_app_id+
									   		"		and ISSUED_STATUS is null "+
									   		"		and APPROVED_STATUS like 'Accept'";
								   			
								   			count1=orcl.DeleteUpdate(rec);
											if(count1!=0)
											{	
												System.out.println(count1+" leave application approved ");
												
										   		String rec1="		update ileave_application_detail "+
										   		"		set issue_status=1 "+
										   		"		where ileave_application_id="+valid_app_id +
										   		"		and approve_status=1 ";
										   		 count1=orcl.DeleteUpdate(rec1);
												if(count1!=0)
												{
													count_process=100;
													System.out.println(count1+" days approved successfully");
												}
												else
												{
													System.out.println(count1+" >>>>>>>>>> problem >>>>leave approved but balance is not updated");
													String body="LA"+(valid_app_id+7)+"i" + " leave apprval rejected but balance is not updated ";
										   		 
										   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
												}
											}
									}//end if: same manager
					   			
						   	}
			    			 
			    			 
					   		if(approval && is_approve==true  )
					   		{
					   		 
					   			 //valid_app_id
					   			 //reply_to
					   		 System.out.println("Start approvals by Line Manager#2");
					   			
					   			String rec="	update ileave_application "+
						   		"		set ISSUED_FROM_DATE=APPROVED_FROM_DATE, "+
						   		"		ISSUED_TO_DATE=APPROVED_TO_DATE, "+
						   		"		ISSUED_COMMENTS='Approved via email: "+result+"', "+
						   		"		ISSUED_BY='"+apr_user_id+"', "+
						   		"		ISSUED_STATUS='Accept', "+
						   		"		DATE_ISSUED=sysdate "+
						   		"		where id="+valid_app_id+
						   		"		and ISSUED_STATUS is null "+
						   		"		and APPROVED_STATUS like 'Accept'";
					   			
					   			int count1=orcl.DeleteUpdate(rec);
								if(count1!=0)
								{	
									System.out.println(count1+" leave application approved ");
									
							   		String rec1="		update ileave_application_detail "+
							   		"		set issue_status=1 "+
							   		"		where ileave_application_id="+valid_app_id +
							   		"		and approve_status=1 ";
							   		 count1=orcl.DeleteUpdate(rec1);
									if(count1!=0)
									{
										 count_process++;
										System.out.println(count1+" days approved successfully");
									}
									else
									{
										System.out.println(count1+" >>>>>>>>>> problem >>>>leave approved but balance is not updated");
										String body="LA"+(valid_app_id+7)+"i" + " leave apprval rejected but balance is not updated ";
							   		 
							   			SendEmailToEmployee( "jehan.badshah@nu.edu.pk", m.getSubject(),  body,  true_message_id);
									}
								}
					   			
					   		}
					   		
			   				
							if(count_process==0)
					   		{
								
								//System.out.println("here7");
					   			String body="LA"+(valid_app_id+7)+"i" + " may be already reviewed ";
					   			if(recommendation)
					   			{
					   				//System.out.println("here71");
					   				String approved_comments =null;
					   				String approved_by=null;
					   				String date_approved=null;
					   				String approved=null;
					   				ResultSet rsf=  null;
					   				try{
					   				String qrf="select  approved_status, issued_status, approved_comments, issued_comments, approved_by, issued_by, date_approved, date_issued from ileave_application where id="+ valid_app_id;
					   			//	System.out.println(qrf); 
					   				rsf=  orcl.select(qrf);
					    			while(rsf.next())
					    			{
					    				//System.out.println("entered71");
					    				try{
					    					approved_comments = rsf.getString("approved_comments").trim(); 
							   				}catch(Exception ex){}
							   				
							   			try{
							   				approved_by = rsf.getString("approved_by").trim(); 
								   			}catch(Exception ex){}
								   		
								   		try{
								   			date_approved = rsf.getDate("date_approved").toLocaleString(); 
									   		}catch(Exception ex){}
									   		
									   	try{
									   		approved = rsf.getTimestamp("approved_status").toLocaleString(); 
										   	}catch(Exception ex){}
					    			
					    			}
					   				}catch(Exception ex){}
					    			try{
					    				rsf.close();
					    				orcl.srs.close();
					    			}catch(Exception ex){}
					    			
					    			if(approved_comments!=null || approved_by !=null ||  date_approved!=null || approved!=null)
					    			{
					    				if(approved.toLowerCase().contains("accept"))
					    					approved="Recommended";
					    				else if(approved.toLowerCase().contains("rej"))
					    					approved="Rejected";
					    				
					    				body=body+"<br><br>";
					    				body=body+"Status: <b>" + approved + "</b><br>";
					    				body=body+"Reviewer: <b>" + approved_by + "</b><br>";
					    				body=body+"Date: <b>" + date_approved + "</b><br>";
					    				body=body+"Comments: <b>" + approved_comments + "</b><br><br>";
					    			}
					    			
					    			
					   			}
					   			if(approval)
					   			{
					   			//	System.out.println("here72");
					   				String issued_comments=null;
					   				String issued_by=null;
					   				String date_issued=null;
					   				String issued=null;
					   				
					   				ResultSet rsf=  null;
					   				
					   				try{
					   				String qrf="select  approved_status, issued_status, approved_comments, issued_comments, approved_by, issued_by, date_approved, date_issued from ileave_application where id="+ valid_app_id;
					   				 rsf=  orcl.select(qrf);
					    			while(rsf.next())
					    			{
					    				//System.out.println("entered72");
					    				try{
					    					issued_comments = rsf.getString("issued_comments").trim(); 
							   				}catch(Exception ex){}
							   				
							   				//System.out.println("issued_comments: " +issued_comments);
							   				
							   			try{
							   				issued_by = rsf.getString("issued_by").trim(); 
								   			}catch(Exception ex){}
								   			//System.out.println("issued_by: " +issued_by);
								   			
								   		try{
								   			date_issued = rsf.getTimestamp("date_issued").toLocaleString(); 
									   		}catch(Exception ex){}
									   		//System.out.println("date_issued: " +date_issued);
									   		
									   	try{
									   		issued = rsf.getString("issued_status"); 
										   	}catch(Exception ex){}
											//System.out.println("issued: " +issued);
										   	
					    			}
					    			}catch(Exception ex){}
					    			
					    			//System.out.println("out72: outwhile" );
					    			
					    			try{
					    				rsf.close();
					    				orcl.srs.close();
					    			}catch(Exception ex){}
					    			
					    		//	System.out.println("out72: srs" );
					    			
					    			if(issued_comments!=null || issued_by !=null || date_issued!=null || issued!=null)
					    			{
					    				//System.out.println("ifstatus72: "+issued );
					    				
					    				if(issued.toLowerCase().contains("accept"))
					    					issued="Approved";
					    				else if(issued.toLowerCase().contains("rej"))
					    					issued="Rejected";
					    				
					    				//System.out.println("ifstatus72: "+issued );
					    				
					    				body=body+"<br><br>";
					    				body=body+"Status: <b>" + issued + "</b><br>";
					    				body=body+"Reviewer: <b>" + issued_by + "</b><br>";
					    				body=body+"Date: <b>" + date_issued + "</b><br>";
					    				body=body+"Comments: <b>" + issued_comments + "</b><br><br>";
					    			}
					   				
					   			}
					   			
					   			
					   			System.out.println(body);
					   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
					   		}
					   		else
					   			if(count_process==2)
					   		{
					   			String body="LA"+(valid_app_id+7)+"i" + " has been approved with comments:  <i>\"" +result +"\" <i>";
					   			System.out.println(body);
					   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
					   		}
					   			else
						   			if(count_process==1 && recommendation)
						   		{
						   			String body="LA"+(valid_app_id+7)+"i" + " has been recommended with comments:  <i>\"" +result +"\" <i>";
						   			System.out.println(body);
						   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
						   		}
						   			else
							   			if(count_process==1 && approval)
							   		{
							   			String body="LA"+(valid_app_id+7)+"i" + " has been approved with comments:  <i>\"" +result +"\" <i>";
							   			System.out.println(body);
							   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
							   		}
							   			else
								   			if(count_process>99)
								   		{
								   				String body="Dear Sir<br> As you are Line Manager#1 and 2 of the employee.<br>Therefore, "+
								   			     "LA"+(valid_app_id+7)+"i" + " has been <b>recommended</b> and <b>approved</b> with comments:  <i>\"" +result +"\" <i>";
								   			System.out.println(body);
								   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
								   		}
					   		
					   		
			        	 }
				   		 
			        	 else 
			        	 
			        	 if(reject==true)
			        	 {
			        		 count_process=0;
							 if(recommendation && is_recommend==true)
						   		{
					   			 	//valid_app_id
							   		//reply_to
							   		 System.out.println("Start Rejection by Line Manager#1");
							   			 
							   		String rec="	update ileave_application "+
							   		"		set "+
							   		
							   		"		APPROVED_COMMENTS='Rejected via email: "+result+"', "+
							   		"		APPROVED_BY='"+rec_user_id+"', "+
							   		"		APPROVED_STATUS='Reject', "+
							   		"		DATE_APPROVED=sysdate "+
							   		"		where id="+valid_app_id +
							   		"		and APPROVED_STATUS is null";
							   		int count1=orcl.DeleteUpdate(rec);
									if(count1!=0)
									{	
										count_process++;
										System.out.println(count1+" leave recommendation rejected successfully");
										/*
								   		String rec1="		update ileave_application_detail "+
								   		"		set approve_status=0 "+
								   		"		where ileave_application_id="+valid_app_id;
								   		
							   			count1=orcl.DeleteUpdate(rec1);
										if(count1!=0)
										{
											System.out.println(count1+" rejected by line manager1   ");
										}
							   		*/
									}
									 
										
					   			
						   	}
							 
							 
					   		if(approval && is_approve==true  )
					   		{
					   			 //valid_app_id
					   			 //reply_to
					   			System.out.println("Start Rejection by Line Manager#2");
					   			
					   			String rec="	update ileave_application "+
						   		"		set "+
						   		
						   		"		ISSUED_COMMENTS='Rejected via email: "+result+"', "+
						   		"		ISSUED_BY='"+apr_user_id+"', "+
						   		"		ISSUED_STATUS='Reject', "+
						   		"		DATE_ISSUED=sysdate "+
						   		"		where id="+valid_app_id+
						   		"		and ISSUED_STATUS is null "+
						   		"		and APPROVED_STATUS like 'Accept'";
					   			
					   			int count1=orcl.DeleteUpdate(rec);
								if(count1!=0)
								{	
									count_process++;
									System.out.println(count1+" Approval rejected successfully ");
									
									/*
							   		String rec1="		update ileave_application_detail "+
							   		"		set issue_status=0 "+
							   		"		where ileave_application_id="+valid_app_id +
							   		"		and approve_status=1 ";
							   		 count1=orcl.DeleteUpdate(rec1);
									if(count1!=0)
									{
										System.out.println(count1+" rejected by line manager2 ");
									}
									*/
								}
						   		
					   			
					   		}
					   		
							if(count_process==0)
					   		{
					   			String body="LA"+(valid_app_id+7)+"i" + " may be already reviewed ";
					   			
					   			if(recommendation)
					   			{
					   				String approved_comments =null;
					   				String approved_by=null;
					   				String date_approved=null;
					   				String approved=null;
					   				ResultSet rsf=  null;
					   				try{
					   				String qrf="select  approved_status, issued_status, approved_comments, issued_comments, approved_by, issued_by, date_approved, date_issued from ileave_application where id="+ valid_app_id;
					   				 rsf=  orcl.select(qrf);
					    			while(rsf.next())
					    			{
					    				try{
					    					approved_comments = rsf.getString("approved_comments").trim(); 
							   				}catch(Exception ex){}
							   				
							   			try{
							   				approved_by = rsf.getString("approved_by").trim(); 
								   			}catch(Exception ex){}
								   		
								   		try{
								   			date_approved = rsf.getTimestamp("date_approved").toLocaleString(); 
									   		}catch(Exception ex){}
									   		
									   	try{
									   		approved = rsf.getString("approved_status"); 
										   	}catch(Exception ex){}
					    			
					    			}
					   				}catch(Exception ex){}
					    			try{
					    				rsf.close();
					    				orcl.srs.close();
					    			}catch(Exception ex){}
					    			
					    			if(approved_comments!=null || approved_by !=null ||  date_approved!=null || approved!=null)
					    			{
					    				if(approved.toLowerCase().contains("accept"))
					    					approved="Recommended";
					    				else if(approved.toLowerCase().contains("rej"))
					    					approved="Rejected";
					    				
					    				body=body+"<br><br>";
					    				body=body+"Status: <b>" + approved + "</b><br>";
					    				body=body+"Reviewer: <b>" + approved_by + "</b><br>";
					    				body=body+"Date: <b>" + date_approved + "</b><br>";
					    				body=body+"Comments: <b>" + approved_comments + "</b><br><br>";
					    			}
					    			
					    			
					   			}
					   			if(approval)
					   			{
					   				
					   				String issued_comments=null;
					   				String issued_by=null;
					   				String date_issued=null;
					   				String issued=null;
					   				
					   				ResultSet rsf=  null;
					   				
					   				try{
					   				String qrf="select  approved_status, issued_status, approved_comments, issued_comments, approved_by, issued_by, date_approved, date_issued from ileave_application where id="+ valid_app_id;
					   				 rsf=  orcl.select(qrf);
					    			while(rsf.next())
					    			{
					    				try{
					    					issued_comments = rsf.getString("issued_comments").trim(); 
							   				}catch(Exception ex){}
							   				
							   			try{
							   				issued_by = rsf.getString("issued_by").trim(); 
								   			}catch(Exception ex){}
								   		
								   		try{
								   			date_issued = rsf.getTimestamp("date_issued").toLocaleString(); 
									   		}catch(Exception ex){}
									   		
									   	try{
									   		issued = rsf.getString("issued_status"); 
										   	}catch(Exception ex){}
					    			}
					    			}catch(Exception ex){}
					    			
					    			try{
					    				rsf.close();
					    				orcl.srs.close();
					    			}catch(Exception ex){}
					    			
					    			if(issued_comments!=null || issued_by !=null || date_issued!=null || issued!=null)
					    			{
					    				if(issued.toLowerCase().contains("accept"))
					    					issued="Approved";
					    				else if(issued.toLowerCase().contains("rej"))
					    					issued="Rejected";
					    				
					    				body=body+"<br><br>  ";
					    				body=body+"Status: <b>" + issued + "</b><br>";
					    				body=body+"Reviewer: <b>" + issued_by + "</b><br>";
					    				body=body+"Date: <b>" + date_issued + "</b><br>";
					    				body=body+"Comments: <b>" + issued_comments + "</b><br><br>";
					    			}
					   				
					   			}
					   			
					   			
					   			System.out.println(body);
					   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
					   		}
					   		else
					   			if(count_process==2)
					   		{
					   			String body="LA"+(valid_app_id+7)+"i" + " has been rejected  with comments:  <i>\"" +result +"\" <i>";
					   			System.out.println(body);
					   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
					   		}
					   			else
						   			if(count_process==1 && recommendation)
						   		{
						   			String body="LA"+(valid_app_id+7)+"i" + " has been rejected before recommendation with comments:  <i>\"" +result +"\" <i>";
						   			System.out.println(body);
						   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
						   		}
						   			else
							   			if(count_process==1 && approval)
							   		{
							   			String body="LA"+(valid_app_id+7)+"i" + " has been rejected after recommendation with comments:  <i>\"" +result +"\" <i>";
							   			System.out.println(body);
							   			SendEmailToEmployee( reply_to, m.getSubject(),  body,  true_message_id);
							   		}
							
			        	 }
				   		 
				   
				   		
					    
			        	 System.out.println("Finished reviewing by "+reply_to);
			 			    	
			       		MarkReadApprovals(true_message_id);
			       		orcl.DisConnect();
		        	
			       		 
		        	 }catch(Exception ex) {}
			        
	         }//thread
	        
		 } //message
		}catch(Exception ex) {}
		return false;  	 
		        	
		}
		 
	private static String SendEmailToEmployee(String reply_to,String request_subject, String body, String true_message_id) 
	{
		
 
		  String origional_subject = request_subject;
		   
		  request_subject=request_subject.replace("Re:", "");
		  request_subject=request_subject.replace("Fwd:", "");
		  request_subject ="Re: " +request_subject.trim();
		   
	 String hr_email=uid;
     String hr_password=pw;
 
    
	    SendEmail bn= new SendEmail(hr_email,hr_password,null, null,request_subject,body,true_message_id);
		if( bn.Send(reply_to))
		{
			 System.out.println("Email sent to "+reply_to);
		 }
	
	 return null;
	 
	}
	
	private static Flags MarkReadEmail(List list, Message message,
			IMAPMessage lastMsg) throws MessagingException {
		try{
			  String Received = lastMsg.getHeader("In-Reply-To")[0].toString().trim();
		   	  list.add(Received);
		    }catch(Exception ex){}
		  
		 try{
			  String Received = lastMsg.getHeader("Received")[0].toString().trim();
		  	  list.add(Received);
		   }catch(Exception ex){}
		  
		  try{
			  String Received = lastMsg.getHeader("Message-ID")[0].toString().trim();
		 	  list.add(Received);
		   }catch(Exception ex){}
		   
		   try{
		       String Received = lastMsg.getHeader("References")[0].toString().trim();
		       list.add(Received);
		       
		       if(Received.contains("\n"))
		       {
		    	   String [] sp =Received.split("\n");
		    	   list.add(sp[0].trim());
		    	   list.add(sp[1].trim());
		    	   
		    	  // System.out.println("Ref1: "+sp[0].trim());
		    	   //System.out.println("Ref2: "+sp[1].trim());
		       }
		    	  
		      }catch(Exception ex){}
		  
		//////////////////////
		//Start attendance here
		
		         message.setFlag(Flag.SEEN, true);
				 Flags processedFlag = new Flags("processed");
				 message.setFlags(processedFlag, true);
				 
				 lastMsg.setFlag(Flag.SEEN, true);
				 lastMsg.setFlags(processedFlag, true);
				 
				  System.out.println("Processed:- " + message.getSubject() + " and " +
				      lastMsg.getSubject());
		return processedFlag;
		
		
	}
	
	private static String FormatDate(SimpleDateFormat format, String raw_text) 
	{
		 		 
	            
		String t1=null;
		
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MM-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd/MM/yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd/MM/yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd-MM-yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd-MMM-yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd-MMM-yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd/MMM/yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("dd/MMM/yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		///////////////////////////////
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM-dd-yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM-dd-yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		///////////////////////////////
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM/dd-yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM/dd-yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		///////////////////////////////
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM/dd/yy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		
		if(t1==null)
		{
			try 
			{
				Date inputDate = (new SimpleDateFormat("MMM/dd/yyyy")).parse(raw_text.toString());
			    t1 = format.format(inputDate);
				
			} catch (Exception e) {	}
		}
		return t1;
	}
	
	private static String FormatDateTime(SimpleDateFormat format, String raw_text) 
	{
		 		 
	            
		String t1=null;
		
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MMM-yy h:mm a")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
		
		
		
		return t1;
	}
	
	
	public static boolean isValidHost(String raw_received)
	{
		
		String IP = ExtractHeaderIP(raw_received);
		//System.out.println("IP: "+ IP);
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
				//System.out.println( "Valid Host");	
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
	  
    static String getText(Element parentElement) {
		     String working = "";
		     for (Node child : parentElement.childNodes()) {
		          if (child instanceof TextNode) 
		          {
		        	  
		              working += (((TextNode) child).text()).trim();
		          }
		          if (child instanceof Element) {
		              Element childElement = (Element)child;
		              // do more of these for p or other tags you want a new line for
		              if (childElement.tag().getName().equalsIgnoreCase("br")) {
		                   working += "\n";
		              }  
		              
		              working += getText(childElement);
		          }
		     }

		     return working;
		 }

	private static void MarkRead(String rep_message_id)
			throws MessagingException {
		
		SearchTerm searchTerm = new MessageIDTerm(rep_message_id);
		  Message[] messages = approvedEmails.search(searchTerm);
		  for(int k=0;k<messages.length;k++)
		  {
			 messages[k].setFlag(Flag.SEEN, true);
			 Flags processedFlag = new Flags("processed");
			 messages[k].setFlags(processedFlag, true);
		  }
		  
         	  searchTerm = new MessageIDTerm("<"+rep_message_id+">");
      		  messages = approvedEmails.search(searchTerm);
      		  for(int k=0;k<messages.length;k++)
      		  {
      			 Flags processedFlag = new Flags("processed");
    			 messages[k].setFlags(processedFlag, true);
    			 messages[k].setFlag(Flag.SEEN, true);
    			  
      		  }
	}
	
	private static void MarkReadApprovals(String rep_message_id)
	throws MessagingException {

		  SearchTerm searchTerm = new MessageIDTerm(rep_message_id);
		  Message[] messages = approvedEmails.search(searchTerm);
		  for(int k=0;k<messages.length;k++)
		  {
			 messages[k].setFlag(Flag.SEEN, true);
			 Flags processedFlag = new Flags("processed");
			 messages[k].setFlags(processedFlag, true);
		  }
  
 	  searchTerm = new MessageIDTerm("<"+rep_message_id+">");
		  messages = approvedEmails.search(searchTerm);
		  for(int k=0;k<messages.length;k++)
		  {
			 Flags processedFlag = new Flags("processed");
		 messages[k].setFlags(processedFlag, true);
		 messages[k].setFlag(Flag.SEEN, true);
		  
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
	
	
	
	
	
	
	
	public class CheckDate  {
	    public void myCheckDate(Date givenDate) {
	        SearchTerm st = new ReceivedDateTerm(ComparisonTerm.EQ,givenDate);

	        try {
				Message[] messages = approvedEmails.search(st);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    // in main method

	   
	}
}


