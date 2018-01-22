package nestedClasses_01;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main_Nested_001 {

	public static void main(String args[]){

		msgConsole("main(...)", "");
		
		Main_Nested_001 application = new Main_Nested_001();
		application.runTest01();

		System.exit(0);
	}
	
	
	
	
	
	
	/**
	 * Metodo msgConsole.
	 * Writes message on console. 
	 * -The second parameter ('options') is not available yet, just set empty "" value always.
	 *  
	 * @param message Text to be printed on console
	 * @param options Not available yet. Put "" empty value always. 
	 *
	 * @author Connectis
	 */
	public static void msgConsole(String message, String options){
		//TO DO: options parameter still not available, symply put "" value

		if (options !=null){
			
			if (options.equals("error")){
				System.err.println(message);	
			} else {
				try {
					System.out.write(  (message+" \n").getBytes()  );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
			
		} 
	}
	
	
	
	
	public void runTest01(){
		msgConsole("runTest01()", "");
  
//		CalendarValidator calendarValidator = new CalendarValidator();
		
//		Calendar cal = new GregorianCalendar();
//		cal.set(field, value);
//		
//		calendarValidator.validate(new GregorianCalendar);
		
		EmailValidator emailValidator = new EmailValidator();
		
		boolean emailOk = emailValidator.validate("email_Ok@mail.es");
		
		if (!emailOk){
			msgConsole("Error. The mail is not well formed", "");
		} else {
			msgConsole("The mail is ok", "");
		}
		
	      		
	}
	
	
	
	
	
	
}
