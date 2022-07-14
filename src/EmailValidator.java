import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator {
    
    public static boolean isValid(String email_address) {
        try {
           
            String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            boolean b = email_address.matches(emailregex);
            return b;
          
        }
        catch (Exception e) {
        }
        
        return false;
    }
}