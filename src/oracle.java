import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.io.*;
public class oracle  {
	private Connection conn;
	private String Dept="CS";
	public Statement srs = null; 
	public oracle()
	{
		//this.Connect();
	}
	 
	

	public Connection getConnection() 	
	{ 			
		return conn; 
		}
	
	public boolean isValidConnection()
	{
		try{
			if(conn!=null && !conn.isClosed())
			{
				 
				return true;
			}
			}catch(Exception ex){}
			
			return false;
	}
	
	public Connection Connect() {
		
		try{
		if(conn!=null && !conn.isClosed())
		{
			System.out.println("Returned valid connection");
			return conn;
		}
		}catch(Exception ex){}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String username = JShared.slateUser; 
			String password = JShared.slatePass;
			String connectionString = "jdbc:oracle:thin:@"+JShared.slateDatabaseIP+":1521:"+JShared.slateDatabaseSID; 
			conn=DriverManager.getConnection(connectionString, username, password);
			return conn; 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	public void DisConnect() 
	{
		System.out.println("Attempt to close oracle connection");
		
		try{
			if(conn!=null && conn.isClosed()==false)
			{
					conn.close();
					System.out.println("Oracle connection closed");
			}
		}
		catch(SQLException e)
		{
			 
		}
		
		
	}
	public ResultSet select(String query)
	{
		ResultSet resultReturned = null; 
		try {
			this.srs= this.conn.createStatement();
			resultReturned = srs.executeQuery(query); 
			return resultReturned; 
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" "+e.getErrorCode()); 
			//e.printStackTrace(); 
			return null;
		}
	}
	
	public int DeleteUpdate(String query)
	{
		int resultReturned = -1; 
		try {
			this.srs= this.conn.createStatement();
			resultReturned = srs.executeUpdate(query); 
			return resultReturned; 
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" "+e.getErrorCode()); 
			//e.printStackTrace(); 
			return -2;
		}
	}
	
	
}