package nestedClasses_01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//** References: Alternate email pattern, from reference: ** "How to validate email address with regular expression", https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression

//** Reference: main source of code: Peter van der Linden (exact page URL currently unknown): 

/** Class to validate an e-mail adress
 * @author Francisco Gómez Aparicio 99GU4668, code from Peter van der Linden
 * @since 17-abr-2009, 12:48:59
* Logo from:http://groups.google.es/group/comp.lang.java.help/browse_thread/thread/730f1807cc2ab2e3
 *         _____________________________________________________ 
  ________|                                                     |________ 
  \       |   Java Programmers FAQ        http://www.afu.com    |       / 
   \      |      Copyright (c) 1997-98 Peter van der Linden     |      / 
   /      |_____________________________________________________|      \ 
  /___________)                                              (__________\
 * 
 */
public class EmailValidator {
	//	metodo para validar correo electronico
	public boolean validate(String strCorreo) {
		if (!isEmail(strCorreo)) return false;
		return true;
	}
	
    public boolean isEmail(String strEmail) {
        Pattern pattern = null;
        Matcher matcher = null;        
//        pattern = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        //ZZZZZ Alternate email pattern, from reference: ** "How to validate email address with regular expression", https://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/ 
        pattern =Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        		);
        
        
        matcher = pattern.matcher(strEmail);
        if (matcher.find()) {
            ////System.out.println("[" + matcher.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
} // End of class

