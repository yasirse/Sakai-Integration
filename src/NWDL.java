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

public class NWDL {
	
	  
		static oracle orcl =null;
		 SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
	
	
	public static void main(String args[]) {
		
		//String subject_test="atlc cs lin 20/AUG/16 29/9/2016";
		String subject_test="NWDL 12/01/2016";
		if(subject_test.toLowerCase().contains("nwdl"))
		{
			String table_data="";
			 String db_connection_problem="";
			
			NWDL obj =new NWDL();
		
			String [] ret =obj.ULBE(subject_test);	
			
			if(ret[0]!=null && ret[0].equals("10"))
			{
				System.out.println("All processed successfully" );
				
				
				if(ret[2]!=null  )
				{
					table_data=ret[2];
				}
				 
				//mark read
			}
			else if(ret[0]!=null && ret[0].equals("1"))
			{
				System.out.println("Date format issue" );
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

	     String [] ULBE(String subject_test) 
	{
	 int count_records=-1;
	    	 String date_from=null;
		String [] ret = new String [6];
	////////////////////////////////////////////////////		
		 
		 subject_test=subject_test.replace("*", " ");
		 subject_test=subject_test.trim().toLowerCase();	
			 
		 
        	String [] tokens=null;
			if(subject_test.contains(" "))
				tokens= subject_test.split(" ");
			else
				tokens= subject_test.split("*");
			 System.out.println("Email subject is processing...\n Subject: "+ subject_test);
			for(int i=0;i<tokens.length;i++)
			{
				
					tokens[i]=tokens[i].toLowerCase().trim();
				    System.out.println("Token# "+ (i+1) +" = "+tokens[i]);
			}
				
	/////////////////////////////////////////
			if(tokens[0].equals("nwdl"))
			{
/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
				  date_from=tokens[1];
				date_from=FormatDate(date_from);
			
				if(		   date_from.length()!=9	)
				{
				 
					 System.out.println("From date is invalid");
					 
					 
					    ret[0]="1";
						ret[1]=" From datre: "+tokens[1]+" is invalid " ;
					    return ret;
				}
				else
					System.out.println(date_from + "  is correctly reconized");
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
			 
		
		
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

	
	
	 
 
		
	String get_balance_query=	 "select  cc.title department, aa.user_id, bb.title,bb.emp2, concat(concat('LA',aa.id+7),'I') id,concat(concat('LA',id1+7),'I') id1,    aa.id id2 ,id1  id3,  request_from_date, request_to_date, (days-nwd) is_true, (days-1) days,  approved_status,  issued_status,  approved_status1, issued_status1 "+
"  , (select issue_status from ileave_application_detail where user_id=aa.user_id and idate=aa.request_from_date and issue_status=1) from_availed "+
"  , (select issue_status from ileave_application_detail where user_id=aa.user_id and idate=aa.request_to_date and issue_status=1) to_availed "+
"  , (select count(*) from ileave_application_detail kk where user_id=aa.user_id and idate between (aa.request_to_date-1) and  (aa.request_from_date+1) and issue_status=1 and ileave_application_id=( select id from ileave_application bb where  bb.id =kk.ileave_application_id and bb.approved_status='Accept' and bb.issued_status='Accept' ) ) fixed_count "+

"  from( "+
"  select user_id, id,id1,  request_from_date, request_to_date, extract( day from (request_to_date-request_from_date)) days  "+
"  , (select count(*) from iattendance where ostatus  not like 'OWD' and idate between request_from_date and  request_to_date and user_id=aa.user_id) nwd,  approved_status, issued_status,  approved_status1, issued_status1 "+
"  from "+
"  ( "+
"  select count(*), id, user_id,  "+
"      coalesce(  "+
"           lag( request_from_date , 1, Null ) over (order by user_id,request_from_date) , "+
"          request_from_date) "+
"      as request_from_date, request_from_date as request_to_date  ,  "+
"      coalesce(  "+
"            lag( id , 1, Null ) over (order by user_id,id) , "+
"          id) "+
"          as id1,  "+
"      coalesce(  "+
"            lag( approved_status , 1, Null ) over (order by approved_status) , "+
"          approved_status) as approved_status1 "+
"          ,  "+
"      coalesce(  "+
"            lag( issued_status , 1, Null ) over (order by issued_status) , "+
"         issued_status) as issued_status1 "+
        
"       ,ileave_application.approved_status, ileave_application.issued_status "+
    
"    from ileave_application    "+
"     group by id, user_id,request_from_date , request_to_date,   ileave_application.approved_status, ileave_application.issued_status  "+
"    order by request_from_date desc "+
"    ) aa "+
"    where extract( day from (request_to_date-request_from_date))<10 "+
"  ) aa, istaff bb, idepartment cc "+
"  where aa.user_id=bb.user_id "+
"  and bb.dept_id=cc.department_code "+
"  and cc.campus_code='ISB' "+
"  and (days-nwd)=1 "+
"  and days>1 "+
" and bb.CURRENT_STATUS=1 " +
"  and (request_from_date > to_date('"+date_from+"','DD-MON-YY')  "+
"  or request_from_date = to_date('"+date_from+"','DD-MON-YY')) "+
"  order by cc.title, aa.user_id, request_from_date desc  ";
	
	try{
	 	 ResultSet rsConfirm=  orcl.select(get_balance_query);
				
	 	String old_dept="";
	 	String table="From Date: "+ date_from  +" till current date<br> <table>";
		while(rsConfirm.next())
		{
			 
			
			String from_availed=rsConfirm.getString("from_availed")+"";
			String to_availed=rsConfirm.getString("to_availed")+"";
			
			if(!from_availed.equals("1") || !to_availed.equals("1"))
			{
				System.out.println("Skipped cancel leave");
				continue;
			}
			
			
			String days=rsConfirm.getString("days");
			String fixed_count=rsConfirm.getString("fixed_count");
		
			
			String department=rsConfirm.getString("department");
			String name=rsConfirm.getString("title");
			String emp2=rsConfirm.getString("emp2")+"";
			String user_id=rsConfirm.getString("user_id");
			String id=rsConfirm.getString("id");
			String id1=rsConfirm.getString("id1");
			String request_from_date=rsConfirm.getString("request_from_date").replace("00:00:00", "");
			String request_to_date=rsConfirm.getString("request_to_date").replace("00:00:00", "");
			
			//balance_id=rsConfirm.getInt("id");
			//previous_balance=rsConfirm.getInt("balance");
			//utlized=rsConfirm.getInt("utlized");
			
			request_to_date=FormatDate(request_to_date);
			request_from_date=FormatDate(request_from_date);
			
			if(fixed_count.equals(days))
			{
				System.out.println("Fixed Leave, Skipping following record");
			    System.out.println(user_id + "  " + request_from_date + "  " + request_to_date + ",  days=" + days+ ",  fixed=" +fixed_count );

				continue;
			}
			
			if(!old_dept.toLowerCase().trim().equals(department.toLowerCase().trim()))
			{
				 table +=" </table>";
				old_dept=department;
				table +="<br><br>"+department+"<br><table border='1'>";
				table +="<tr><td>Employee</td><td>EMP#</td><td>LA#1</td><td>LA#2</td><td>LA#1 Date</td><td>LA#2 Date</td><td>Count days</td></tt>";
				
			}
			
			table +="<tr><td>"+name+"</td><td>"+emp2+"</td><td>"+id+"</td><td>"+id1+"</td><td>"+request_from_date+"</td><td>"+request_to_date+"</td><td>"+days+"</td></tt>";
			count_records++;
			//System.out.println(user_id + "  " + id + "  " + request_from_date+ "  " + id1+ "  " + request_to_date + "  " + days );
		}
		
		 table +=" </table>";
		 if(count_records>=0)
			{
			 ret[0]="10";
			 ret[1]="Processed " ;
			 ret[2]=table ;
			 return ret;
			}
		 
		// System.out.println(table);
	 
	}catch(Exception ex){ ex.printStackTrace();}
	
 
	
	 
	 orcl.DisConnect();
		  
	

	
 
	
			}//if nwdl
 
			 
			 ret[0]="11";
			 ret[1]="some problem " ;
			 
			 return ret;
			 
	}



///////////////////////////////////////////
	/////////////////////////////////////// Utility functions
	//////////////////////////////
private static String FormatDate(String raw_text) 
{
	 		 
	 SimpleDateFormat format  = new SimpleDateFormat("dd-MMM-yy");
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