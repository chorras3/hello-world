package nestedClasses_01;

import java.util.Calendar;
import java.util.GregorianCalendar;

/** Class to validate a GregorianCalendar value
 * @author Francisco Gómez Aparicio 99GU4668
 * @since 17-abr-2009, 12:48:59
 */
public class CalendarValidator {
	
	
	public boolean validate(Calendar calendar) {
		GregorianCalendar gregorianCalendar = (GregorianCalendar)calendar;
		return this.validate(gregorianCalendar);
	}
	

	public boolean validate(GregorianCalendar gregorianCalendar) {
		
		boolean resultado = false;
		// Si se usó calendar.lenient(true) no puede considerarse un valor válido ya que 
		// pudo introducirse cualquier cosa Ej. MONTH=14. 
		// TODO Fran <<<<<<<<<<<<<Si envío por WS un Calendar mejor 
		// comentar las siguientes dos líneas: No compruebo isLenient porque se altera el valor durante la comunicación (y queda siempre a true). 
		if (gregorianCalendar.isLenient())
			return resultado;    
		
		gregorianCalendar.getTime();
		try {
			gregorianCalendar.setLenient(false);
			// If bad date this raises Exception:
			gregorianCalendar.getTime();
			resultado = true;
			
		} catch (NumberFormatException e) {
			resultado = false;
		}
		return resultado;
	}

} // End of CalendarValidator class
