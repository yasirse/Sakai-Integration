
import java.util.Calendar;
import java.util.zip.CheckedInputStream;
import java.util.zip.Adler32;
import java.io.*;

public class CheckSum {
	private long magicValue=25497;
	private long timeStamp;
	public String checksum(String userID){	    
	try{ 
	      String password = userID;
	      long value;
	      byte buffer[] = password.getBytes();
	      ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
	      CheckedInputStream cis = new CheckedInputStream(bais, new Adler32());
	      byte readBuffer[] = new byte[5000];
	      cis.read(readBuffer);
	      Calendar cal = Calendar.getInstance();
		  timeStamp=cal.getTimeInMillis();
	      value = cis.getChecksum().getValue()+magicValue+timeStamp;
	      password= String.valueOf(value);
	      return password;
	    }
	    catch(Exception e){
	    	System.out.println("Exception has been caught" + e);
	    	return "-1";
	    }
	  }
}
