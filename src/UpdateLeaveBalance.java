import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.URL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

 
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

public class UpdateLeaveBalance {
	
	  
		static oracle orcl =null;
		 SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
	
	
	public static void main(String args[]) {
		
		//String subject_test="atlc cs lin 20/AUG/16 29/9/2016";
		String subject_test="";//ULBE CL 2016 14 jehan.badshah@nu.edu.pk";
		if(subject_test.toLowerCase().contains("ulbe"))
		{
			String log_problem="";
			String leave_not_added_problem="";
			String db_connection_problem="";
			
			UpdateLeaveBalance obj =new UpdateLeaveBalance();
		
			String [] ret =obj.ULBE(subject_test,"jehan.badshah@nu.edu.pk");	
			
			if(ret[0]!=null && ret[0].equals("10"))
			{
				System.out.println("All processed successfully" );
				
				
				if(ret[2]!=null && ret[2].equals("12"))
				{
					  log_problem=ret[3];
				}
				if(ret[4]!=null && ret[4].equals("11"))
				{
					  leave_not_added_problem=ret[5];
				}
				//mark read
			}
			else if(ret[0]!=null && ret[0].equals("50"))
			{
				db_connection_problem=ret[1];
				//do not process email/keep unread
			}
			else
			{
				String problem_text=ret[1];
				//mark read
			}
		}
		else
		if(subject_test.toLowerCase().contains("atlc"))
		{
			String log_problem="";
			String leave_not_added_problem="";
			String db_connection_problem="";
			
			AbsentToLeaveConversion obj =new AbsentToLeaveConversion();
		
			String [] ret =obj.ATLC(subject_test);	
			
			if(ret[0]!=null && ret[0].equals("10"))
			{
				System.out.println("All processed successfully" );
				
				
				if(ret[2]!=null && ret[2].equals("11"))
				{
					  log_problem=ret[3];
				}
			 
				//mark read
			}
			else if(ret[0]!=null && ret[0].equals("50"))
			{
				db_connection_problem=ret[1];
				//do not process email/keep unread
			}
			else
			{
				String problem_text=ret[1];
				//mark read
			}
		}
		
		 
		 
	 
			    }

	     String [] ULBE(String subject_test, String sender_email) 
	{
		 String leave_code="";
		 boolean leave_type=false;
		 
		 String leave_year="";
		 boolean leave_year_no=false;
		 
		 String email_address="";
		 boolean email=false;
		 
		String [] ret = new String [6];
	////////////////////////////////////////////////////		
		 
		 subject_test=subject_test.replace("*", " ");
		 subject_test=subject_test.trim().toLowerCase();	
			 
		 
        	String [] tokens=null;
			if(subject_test.contains(" "))
				tokens= subject_test.split(" ");
			else
				tokens= subject_test.split("*");
			
			for(int i=0;i<tokens.length;i++)
			{
				
				tokens[i]=tokens[i].toLowerCase().trim();
				 System.out.println(i+" "+tokens[i]);
			}
				
	/////////////////////////////////////////
			if(tokens[0].equals("ulbe"))
			{
/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
					 
				if(		   tokens[1].equals("cl") 
						|| tokens[1].equals("el") 
						|| tokens[1].equals("al") 
						|| tokens[1].equals("ol")
						|| tokens[1].equals("np")
				)
				{
					 leave_type=true;
					 leave_code = tokens[1];
				}
				else
				{
					 System.out.println("Leave code is invalid");
					 
					 
					    ret[0]="1";
						ret[1]=" Leave code: "+tokens[1]+" is invalid " ;
					    return ret;
				}
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
				if(		   tokens[2].equals("2013") 
						|| tokens[2].equals("2014") 
						|| tokens[2].equals("2015") 
						|| tokens[2].equals("2016")
						|| tokens[2].equals("2017")
				)
				{
					leave_year_no=true;
					leave_year = tokens[2];
				}
				else
				{
					 System.out.println("Leave year is invalid");
					 
					 
					    ret[0]="2";
						ret[1]=" Specified leave year: "+tokens[2]+" is invalid " ;
					    return ret;
				}
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
				try{
				int count_leave=Integer.parseInt( tokens[3]);
				}catch(Exception ex){
					 ret[0]="3";
					 ret[1]=" Specified leave count: '"+tokens[3]+"' is not a number " ;
					  return ret;
					
				}
				
				int count_leave=Integer.parseInt( tokens[3]);
				if(	tokens[1].equals("cl") && (count_leave>15 || count_leave<0)	)
				{
						 ret[0]="4";
						 ret[1]=" Specified casual leave count: "+tokens[3]+" is exeeding the limit i.e., 30 " ;
						 return ret;
					}
				else
					if(	tokens[1].equals("el") && (count_leave>30 || count_leave<0) 	)
					{
							 ret[0]="4";
							 ret[1]=" Specified casual leave count: "+tokens[3]+" is exeeding the limit i.e., 30 " ;
							 return ret;
						}
			 			
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
				if(tokens[4].contains("@") )
				{
					email=true;
					email_address = tokens[4];
				}
				else
				{
					 System.out.println("Employee email address is invalid");
					 
					    ret[0]="2";
						ret[1]=" Specified  email address: "+tokens[4]+" is invalid " ;
					    return ret;
				}		
		
		
			//////////////////////open DB connection///////////////////////////////////////
				
				if(orcl==null)  
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
					
					
					if( !orcl.isValidConnection())
					{
						System.out.println("Unable to open connection to oracle");
						 
						 ret[0]="50";
						 ret[1]=" Unable to open connection to oracle database " ;
						 return ret;
					}
					
					
					 
				/////////////////////////////////////////////////////////////

	
	
	if(email ==true && leave_type==true &&  leave_year_no==true )
	{
		email=false;
		System.out.println("Checking employee using email address '"+email_address + "'  "   );
		try{
		 	 ResultSet resd=  orcl.select("select user_id from istaff where  campus_id like 'ISB'  and trim(lower(email)) like '"+email_address+"'");
							    			 
			while(resd.next())
			{
				email=true;
				String user_id=	resd.getString("user_id");
				email_address = "  and user_id like '"+user_id+"' ";
				System.out.println("Email found using specified address ");
			}
		 
		}catch(Exception ex){ ex.printStackTrace();}
	}
	
	
	if(!email)
	{
		System.out.println("Employee with the specified email address ("+email_address+") is not found ");
		orcl.DisConnect();
		ret[0]="5";
		ret[1]="Employee with specified email address ("+email_address+") is not found " ;
		return ret;
	}
	
	boolean proceed=false;
	int balance_id=-1;
	int previous_balance=-1;
	int utlized=-1;
	 int count_balances=0;
	if(email)
	{
		
	String get_balance_query=	" select id, ifrom, ito, iannual_leave_id, user_id,balance,     "+
	"  (to_number((select count(*) from ileave_application_detail    "+
	"   where iannual_leave_balance_id=iannual_leave_balance.id and issue_status=1))) utlized      "+
	" from iannual_leave_balance      "+
	" 	where  iannual_leave_id =    "+
	" 	(select id from iannual_leave where lower(leave_code) like '"+leave_code+"')    "+
	email_address +
	" 	and to_char(ifrom, 'YYYY') like '"+leave_year+"'    ";
	//System.out.println(get_balance_query);
	
	try{
	 	 ResultSet rsConfirm=  orcl.select(get_balance_query);
				
	 	
		while(rsConfirm.next())
		{
			count_balances++;
			proceed=true;
			
			if(count_balances>1)
				proceed=false;
			
			balance_id=rsConfirm.getInt("id");
			previous_balance=rsConfirm.getInt("balance");
			utlized=rsConfirm.getInt("utlized");
			
			System.out.println("Previous balance checked ");
		}
	 
	}catch(Exception ex){ ex.printStackTrace();}
	
	if(count_balances>1)
	{
		System.out.println("Some technical problem, more than one balances found ");
		orcl.DisConnect();
		ret[0]="6";
		ret[1]="Some technical problem, more than one balances found  " ;
		return ret;
		
	}
	
	if(!proceed)
	{
		System.out.println("Some technical problem, no balance found ");
		orcl.DisConnect();
		ret[0]="7";
		ret[1]="Some technical problem, no balance found  " ;
		return ret;
		
	}
	
	if(balance_id<10 || previous_balance<0 || utlized<0)
	{
		System.out.println("Some technical problem, balance id or balance is smaller than 0 ");
		orcl.DisConnect();
		ret[0]="8";
		ret[1]="Some technical problem, balance id or balance is smaller than 0   " ;
		return ret;
		
	}
		
	if( count_leave<utlized)
	{
		System.out.println(utlized + " is already utilized, new balance should not be smaller than  "+ utlized);
		orcl.DisConnect();
		ret[0]="9";
		ret[1]="Balance:"+ utlized + " has already utilized, new balance should not be smaller than  "+ utlized  ;
		return ret;
		
	}
	
	if( count_leave==previous_balance)
	{
		System.out.println( "No change in the balance ");
		/*orcl.DisConnect();
		ret[0]="9";
		ret[1]="No change in the balance"  ;
		return ret;
		*/
	}
	int count1=-1;
	
	try{
	String update_balance=" update iannual_leave_balance " +
						  " set balance= " +count_leave +
						  " where id="+balance_id;
	
	//System.out.println( update_balance);
			  count1=orcl.DeleteUpdate(update_balance);
	}catch (Exception ex){}
			

	
			if(count1==1  )
			{
				System.out.println( "Leave balance updated to "+count_leave );
				
				ret[0]="10";
				ret[1]="Leave balance updated to "+count_leave  ;
				
				/////////////////////////////////
				
				
				int   count3=-1;
				try{
				String query_log1="Insert into iannual_leave_balance_log (ID,IANNUAL_LEAVE_BALANCE_ID,CAMPUS_CODE,USER_ID,NOTE,DATE_CREATED,IP_ADDRESS,NOTIFIED) "+
				" values (IANNUAL_LEAVE_BALANCE_LOG_SEQ.nextval,"+balance_id+",'ISB','"+sender_email+"','"+count_leave+",   Reference: "+subject_test.replace("ulbe", "")+"',sysdate,'email',-1)";
				 
				  count3=orcl.DeleteUpdate(query_log1);
			    
				  
				  //System.out.println( query_log);
				}catch (Exception ex)
				{
					System.out.println( "Exception #########");
					ex.printStackTrace();
					}
				
				if(count3!=1  )
				{
					ret[2]="11";
					ret[3]="Log of leave balance is not added "  ;
					System.out.println(ret[3]);
				}
				
				orcl.DisConnect();
				return ret;
				
			}
			else
			if(count1>1  )
			{
				System.out.println( "Problem, more than once leave balances are updated i.e., "+count1 );
				orcl.DisConnect();
				ret[0]="9";
				ret[1]= "Problem, more than once leave balances are updated i.e., "+count1  ;
				return ret;
				
			}
			else
			{
				System.out.println( "Some error while updating balance   " );
				orcl.DisConnect();
				ret[0]="9";
				ret[1]="Some error while updating balance   "  ;
				return ret;
			}
			
		 
			 
	}
	
	
	/*
	
					
					
			
		if(!leave_assigned)
		{
			System.out.println(" Unable to assign leave to "+user_id+" of date "+idate);
			ret[4]="11";
			ret[5] +="Unable to assign leave to "+user_id+" of date "+idate +"<br>" ;
		}
	
	 */
 
	
	
	///remove later
	orcl.DisConnect();
	
			}
 
			 ret[0]="10";
			 ret[1]="Processed " ;
			 return ret;
	}



///////////////////////////////////////////
	/////////////////////////////////////// Utility functions
	//////////////////////////////
private static String FormatDate(SimpleDateFormat format, String raw_text) 
{
	 		 
            
	String t1=null;
	
	try 
	{
		Date inputDate = (new SimpleDateFormat("yyyy-MM-dd")).parse(raw_text.toString());
	    t1 = format.format(inputDate);
		
	} catch (Exception e) {	}
	
	if(t1==null)
	{
		try 
		{
			Date inputDate = (new SimpleDateFormat("dd-MM-yyyy")).parse(raw_text.toString());
		    t1 = format.format(inputDate);
			
		} catch (Exception e) {	}
	}
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
			Date inputDate = (new SimpleDateFormat("MMM dd, yyyy")).parse(raw_text.toString());
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
	
	if(t1!=null )
		t1=t1.toUpperCase().trim();
	
	return t1;
}



}