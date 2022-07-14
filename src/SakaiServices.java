

import java.rmi.RemoteException;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;



public class SakaiServices {
	private String loginSession = null; 
	private String serviceBaseURL = "http://172.16.100.146:8080/sakai-axis/";
	private String adminLoginID ="admin"; 
	private String adminLoginPW ="yk#$%_";

	public SakaiServices() {
		
		// cm = new org.sakaiproject.coursemanagement.api.CourseManagementAdministration();
			
		this.AdminLogin(); 
	}
	
	public SakaiServices(String uid, String pw) {
		//	adminLoginID =uid;
		//	adminLoginPW =pw;
		// cm = new org.sakaiproject.coursemanagement.api.CourseManagementAdministration();
			
		this.AdminLogin(); 
	}
	
public boolean isLogin() {
		
		if(this.loginSession==null){
			return false;}
		return true;
	}
	public String AdminLogin (String username, String password) { 
		this.adminLoginID = username; 
		this.adminLoginPW = password; 
		return AdminLogin(); 
	}
	
	public String AdminLogin() {
		Service service = new Service(); 
		String id = (String) this.adminLoginID; 
		String pw = (String) this.adminLoginPW; 
		System.out.println("\nIniting Web Service call ..... " );
		Call nc; 
		try {
			nc = (Call) service.createCall();
			String service_end_point = this.serviceBaseURL + "SakaiLogin.jws"; 
			nc.setTargetEndpointAddress(service_end_point);
			
			nc.removeAllParameters();
			nc.setOperationName("login");
			nc.addParameter("id",XMLType.XSD_STRING, ParameterMode.IN);
			nc.addParameter("pw",XMLType.XSD_STRING, ParameterMode.IN);
			nc.setReturnType(XMLType.XSD_STRING);
			this.loginSession = (String) nc.invoke(new Object [] { id, pw });
		//	System.out.print(" Login Session Created\n\t " );
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			this.loginSession = null; 
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			this.loginSession = null; 
			e.printStackTrace();
		}
			
		return this.loginSession; 
	}
	

	public String LogOut() {
		
		if(this.loginSession==null || this.isLogin()==false)
		{
			//System.out.println("\nUser is not login");
			return null;
		}
		
			Service service = new Service(); 
			//System.out.print("\nIniting Web Service call ..... ");
		Call nc; 
		try {
			nc = (Call) service.createCall();
			String service_end_point = this.serviceBaseURL + "SakaiLogin.jws"; 
			nc.setTargetEndpointAddress(service_end_point);
			
			nc.removeAllParameters();
			nc.setOperationName("logout");
			nc.addParameter("sakai_session",XMLType.XSD_STRING, ParameterMode.IN);
			nc.setReturnType(XMLType.XSD_BOOLEAN);
			//System.out.println(nc.invoke(new Object [] { this.loginSession }));
			//String status = (String) nc.invoke(new Object [] { this.loginSession });
			
			Object message=nc.invoke(new Object [] { this.loginSession });
			
			if(message.toString().equals("true"))
			{
			System.out.println(adminLoginID+ " user logout from SLATE");
			this.loginSession=null;
			}
			else
			{
				System.out.println("**************** User could not logout");
			}
			
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			this.loginSession = null; 
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			this.loginSession = null; 
			e.printStackTrace();
		}
			
		return this.loginSession; 
	}
	
	
	

	public boolean changeUserPassword(String ID,String passwords) {
		
		if(this.loginSession == null) {
			System.out.println(this.adminLoginID + " is not logged in to avail fecility for changing password of "+ ID); 
			return false; 
		}
		try {	
		//	System.out.println(ID+" Wait! password is being changed ....");
			Service service = new Service();
			String sakai_session = this.loginSession;
			String eid = ID;
			String password = passwords;
			
			Call nc = (Call) service.createCall();
			
			String service_end_point = this.serviceBaseURL + "SakaiScript.jws"; 
			nc.setTargetEndpointAddress(service_end_point);
			
			nc.removeAllParameters();
			nc.setOperationName("changeUserPassword");
			nc.addParameter("sakai_session",XMLType.XSD_STRING, ParameterMode.IN);
			nc.addParameter("eid",XMLType.XSD_STRING, ParameterMode.IN);
			nc.addParameter("password",XMLType.XSD_STRING, ParameterMode.IN);
			
			nc.setReturnType(XMLType.XSD_STRING);
	
			String results = (String) nc.invoke(new Object [] { sakai_session, eid, password });
			if((results.equals("success") == false)  )
				return false;
			//System.out.println(ID+"'s "+"Password has been changed");
			LogOut();
			return true;
		
		} catch (Exception e ) {
			LogOut();
			//e.printStackTrace();
			return false;
		}
	}
	
	
}
