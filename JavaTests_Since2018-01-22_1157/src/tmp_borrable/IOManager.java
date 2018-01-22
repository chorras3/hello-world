////package core.common;
package tmp_borrable;


/* ==================================================
 * Clase recuperada desde otro proyecto, DropFiles, ruta concreta:  
 * F:\User\workspace_eclipse\Juno_usb_F\2014-05-11_0000_DropFiles\src\common\IOManager.java
 * 
 * Tras copia Verbatim inicial (ver original en esta misma ruta: 
 * "IOManager_ORIG_Dont_Modify.java"), el 17-02-2017 10:42, a partir 
 * de dicha fecha se habr� ido modificando su codigo. 
 * 
 * 
 * ==================================================
 */


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
//&&&&&&&&&&&&&&&&&&&&&
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

////import tools.validator.EmailValidator;



/** Class to manage input/output, conversions, and other stuff.  
 * @author Francisco G�mez Aparicio 99GU4668
 * @since 17-abr-2009, 12:48:59
 * Last updated: 19-oct-2009 17:36
 */
public class IOManager {
	
	// This ArrayList must be declared out of the recursive methods (because of recursive calling nature)
	public static ArrayList lisGenericRecursive = new ArrayList();
	
	private String editorPath = null;
	
	static final String SEMICOLON = ";";
	static final String NEW_LINE = "\n";
	static final String N_ERRORES_MAS = "(##### errores m�s)";
	
	
	
	
	/*
	 * TODO
	 * Empty method!!
	 */
	public String getFormattedDate(String strDate, String strFormat)
	throws IOException
	{
		String strDateFormatted = "";
				
		if (!strFormat.equals("dd-mm-yyyy_hh;mi")){
			// <<<<<<<<<<<<<<<<<<<<g
		} else {
			throw new IOException("User IOException: Format do not recognized");
		}
		
//		String strInverseDate = getPassedDateInverseFormat(); 
//		return strInverseDate;
		
		return strDateFormatted;
	}
	


		

		
		
		
		
		
		// TODO Fran: INICIO m�todos que he heredado de la GISS y que conviene quitar: <<<<<<<<<<<<<<<<<<<<<<<<<<<
		public static String truncate(String str, int endIndex)
		{
			return ((str.length() > endIndex) ? str.substring(0, endIndex): str);
		}
		
		// TODO Fran: FIN m�todos que he heredado y que conviene quitar: <<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		
		
		

		
		
	    protected static GregorianCalendar millisecondsToCalendar(long lngDateInMilliseconds){
	    	Date d = new Date(lngDateInMilliseconds);

	    	GregorianCalendar c = new GregorianCalendar();
	    	c.setTime(d);

	    	return c;
	    }
		
	    public static String convertMilliseconds2InverseDate (long lngDAteInMilliseconds){ 

	    	GregorianCalendar gregorianCalendar = millisecondsToCalendar(lngDAteInMilliseconds);
	    	   	
	    	int day = gregorianCalendar.get(Calendar.DATE);
	    	int month = 1+ gregorianCalendar.get(Calendar.MONTH);       //Add 1 because months are managed as array (0 to 11)
	    	int annio = gregorianCalendar.get(Calendar.YEAR);
	    	int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);
	    	int minute = gregorianCalendar.get(Calendar.MINUTE);
	    	int second = gregorianCalendar.get(Calendar.SECOND);
	  
	    	String strInverseDate = new Integer(annio).toString();
	    	
	    	
	        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("00");
	    	
	    	strInverseDate = strInverseDate+"-"+decimalFormat.format(month);
	    	strInverseDate = strInverseDate+"-"+decimalFormat.format(day);
	    	strInverseDate = strInverseDate+"_"+decimalFormat.format(hour);
	    	strInverseDate = strInverseDate+""+decimalFormat.format(minute);
	    	
	    	return strInverseDate;
	    }

		
	    

		/**
		 * Metodo objectFill. Receibes a bean and fills its values automatically, or with customization. 
		 * </br>References: ** "Using reflection to set an object property", https://stackoverflow.com/questions/14374878/using-reflection-to-set-an-object-property  
		 * @param object the intantiated class to fill with data (any Java class with attributes having getter/setter)
		 * @param options Optional options (Can be empty, ""). 
		 * </br>-Example 1: to force value 1 to a Field called 'id' (this is, ".setId(1)"), use option: "&lt;FIELD_VALUE&gt;id:1&lt;/FIELD_VALUE&gt;"
		 * </br>-Example 2: Dynamic way when int counter = counter++; The option would be-> int counter=1; counter++; "&lt;FIELD_VALUE&gt;id:"+counter+"&lt;/FIELD_VALUE&gt;"
		 * </br>-Example 3: Using escape for values containing commas: "&lt;FIELD_VALUE&gt;email:themail@mailing.com,address:street Big 2/, this is a test using commas /, comas&lt;/FIELD_VALUE&gt;" 
		 * @return the object returned, willed with values already.
		 *  
		 *
		 * @Author Connectis
		 */	    
		public <T> T objectFill(T object, String options){
//			core.common.ObjectManager objectManager = new core.common.ObjectManager();
//			T o = objectManager.objectFill(object, "");
//			return o;

	/**/			
//			Object valueAsString = null;
			String valueAsString = null;
			final boolean TRUE_boolean=true;
			final boolean FALSE_boolean=false;
			final String TAG_FIELD_VALUE_INIT ="<FIELD_VALUE>";
			final String TAG_FIELD_VALUE_END ="</FIELD_VALUE>";
			// Parameter 'object' could include this simbol, which means that 
			// within a value there is literally a real comma (not a code separator): \,
			final String COMMA_ESCAPPED ="/,";
			final String COMMA_CODIFIED ="$$COMMA$$";
			final String COMMA_REAL=",";
			
			final String DEFAULT_String_VALUE="1";
			final Long DEFAULT_Long_VALUE=new Long(1);
			final long DEFAULT_long_VALUE=1;
			final Boolean DEFAULT_Boolean_VALUE=true;
			final boolean DEFAULT_boolean_VALUE=true;
			
			boolean logPrintableActive=FALSE_boolean;  
			List logMessages = new ArrayList<String>(); 
			
			
	//// Test map. References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs		
//			java.util.Map<String, String> map = new java.util.HashMap<String, String>();
//		    String test = "pet:cat::car:honda::location:Japan::food:sushi";
	//
//		    // split on ':' and on '::'
//		    String[] partsTest = test.split("::?");
	//
//		    for (int i = 0; i < partsTest.length; i += 2) {
//		        map.put(partsTest[i], partsTest[i + 1]);
//		    }
	//
//		    for (String s : map.keySet()) {
//		        System.out.println(s + " is " + map.get(s));
//		    }
	    
		    
		
			// Option parameter received: save it into valuesToForceMap.
			// ====================
			// Obtains valuesToForceMap. Contains the values that must be forced later. 
			// -If there exist options (param "options") get the fieldValueMap (map having pairs: field and default value for it, as desired)
			// -If options parameter not empty: Replace options (force alternative default values):		
			// -References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs
			// 		
			String valuesToForce=null;
			java.util.Map<String, String> valuesToForceMap = new java.util.HashMap<String, String>();
			String fieldValueAsString =null;
//			java.util.Map valuesToForceMap=null;
			if (options!=""){
				// Escape a textual comma (this is, the characters: /, ):
				valuesToForce = options;
				if (valuesToForce.toString().indexOf("/,")!=-1){
					valuesToForce=valuesToForce.replace(COMMA_ESCAPPED, COMMA_CODIFIED);  //FAILS
				}
				// Remove newLine characters
				valuesToForce = valuesToForce.trim().replaceAll("\n ", "");			
				if (options.toString().indexOf(TAG_FIELD_VALUE_INIT) != -1){
					fieldValueAsString = valuesToForce.substring(TAG_FIELD_VALUE_INIT.length(), valuesToForce.length()-TAG_FIELD_VALUE_END.length());
					String[] fieldValueArray = fieldValueAsString.split(TAG_FIELD_VALUE_INIT+"?");
					// Split if exist any delimiter: symbols ',' or ':'
					String[] parts = fieldValueAsString.split("(,)|(:)");  // Split if exist delimiter ',' or ':'
					// Every correlated pair of parts will go to a map
					for (int i = 0; i < parts.length; i += 2) {   
				    	String elementKey=parts[i];
				    	String elementValue=parts[i + 1];
				    	// UNDO codification of an escaped comma symbol (The text: "/," was replaced by text $$COMMA$$ or similar, so we revert it back):
						if (elementKey.indexOf(COMMA_CODIFIED)!=-1){
							elementKey=elementKey.replace(COMMA_CODIFIED, COMMA_REAL);
						}
						if (elementValue.indexOf(COMMA_CODIFIED)!=-1){
							elementValue=elementValue.replace(COMMA_CODIFIED, COMMA_REAL);
						}
				    	valuesToForceMap.put(elementKey, elementValue);
				    }
					
				    // Log
					logMessages.add("option:valuesToForce. There are the following values to force:");
					
				    for (Object fieldAux : valuesToForceMap.keySet()) {    // Print map
//				        System.out.println("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
				    	logMessages.add("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
				    }

				}
			}

			// Object received: Set values
			// ====================
			// Set fields to its force value, if proceed (if options says it so)
		    Class<?> clazz = object.getClass();
			Field[] classFieldsArray = object.getClass().getDeclaredFields();
			
			for (int i = 0; i < classFieldsArray.length; i++) {
				
				// Read field
	            //=====
				Field fieldAux = classFieldsArray[i];
				String fieldNameAux = fieldAux.getName();
	            // When setting values into the object, we declare: "We want to access private fields":
	            fieldAux.setAccessible(true);
				
				// Set value
				// References: ** "", https://stackoverflow.com/questions/14374878/using-reflection-to-set-an-object-property
	            //=====			
				if (fieldAux.getType().getName().equals("java.lang.String")){
					// READ
					if (valuesToForceMap.get(fieldNameAux)==null ){
						valueAsString=fieldNameAux+" "+DEFAULT_String_VALUE;
					// If options parameter specifies to force an override value for this field...
					} else {
						// new Default value: 
						valueAsString=valuesToForceMap.get(fieldNameAux);  
					}
					
					// WRITE 
					// (remember: when writting, we need: 'fieldAux.setAccessible(true)' as done above)
					//=====
		            try {
		            	fieldAux.set(object, valueAsString);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					
				} else if (fieldAux.getType().getName().equals("java.lang.Long")){
					if (valuesToForceMap.get(fieldNameAux)==null ){
						valueAsString=new Long(DEFAULT_Long_VALUE).toString();
					// If options parameter specifies to force an override value for this field...
					} else {
						// new Default value: 
						valueAsString=valuesToForceMap.get(fieldNameAux);  
					}
					
					// WRITE
					// (remember: when writting, we need: 'fieldAux.setAccessible(true)' as done above)
					//=====
		            try {
		            	Long l = Long.parseLong(valueAsString.toString());
		            	fieldAux.set(object, l);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
									
				} else {
					valueAsString=null;
				}
	            
			} // end: "for each field..."
						
			// Show logged messaged
			if (logPrintableActive){
				System.out.println("logPrintableActive=\n"+logMessages);
			}
			
			return object;
		
		}
		
		
		
		
	    
//	    public <T> T objectFill_test(T object, String options){
//	    	System.out.println("objectFill_test(T object, String options)");
//	    	
////	    	System.out.println("options="+options);
////	    	
//////	    	return new String("");  //zzzzz
////	    	return object;
//	    	
////			core.common.ObjectManager objectManager = new core.common.ObjectManager();
////			T o = objectManager.objectFill(object, "");
////			return o;
//
//	/**/			
////			Object valueAsString = null;
//			String valueAsString = null;
//			final boolean TRUE_boolean=true;
//			final String TAG_FIELD_VALUE_INIT ="<FIELD_VALUE>";
//			final String TAG_FIELD_VALUE_END ="</FIELD_VALUE>";
//			// Parameter 'object' could include this simbol, which means that 
//			// within a value there is literally a real comma (not a code separator): \,
//			final String COMMA_ESCAPPED ="/,";
//			final String COMMA_CODIFIED ="$$COMMA$$";
//			final String COMMA_REAL=",";
//			
//			final String DEFAULT_String_VALUE="1";
//			final Long DEFAULT_Long_VALUE=new Long(1);
//			final long DEFAULT_long_VALUE=1;
//			final Boolean DEFAULT_Boolean_VALUE=true;
//			final boolean DEFAULT_boolean_VALUE=true;	    	
//	    	
//			
//	//// Test map. References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs		
////			java.util.Map<String, String> map = new java.util.HashMap<String, String>();
////		    String test = "pet:cat::car:honda::location:Japan::food:sushi";
//	//
////		    // split on ':' and on '::'
////		    String[] partsTest = test.split("::?");
//	//
////		    for (int i = 0; i < partsTest.length; i += 2) {
////		        map.put(partsTest[i], partsTest[i + 1]);
////		    }
//	//
////		    for (String s : map.keySet()) {
////		        System.out.println(s + " is " + map.get(s));
////		    }
//	    			
//			
//			
//			// Option parameter received: save it into valuesToForceMap.
//			// ====================
//			// Obtains valuesToForceMap. Contains the values that must be forced later. 
//			// -If there exist options (param "options") get the fieldValueMap (map having pairs: field and default value for it, as desired)
//			// -If options parameter not empty: Replace options (force alternative default values):		
//			// -References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs
//			// 		
//			String valuesToForce=null;
//			java.util.Map<String, String> valuesToForceMap = new java.util.HashMap<String, String>();
//			String fieldValueAsString =null;
////			java.util.Map valuesToForceMap=null;
//			if (options!=""){
//				// Escape a textual comma (this is, the characters: /, ):
//				valuesToForce = options;
//				if (valuesToForce.toString().indexOf("/,")!=-1){
//					valuesToForce=valuesToForce.replace(COMMA_ESCAPPED, COMMA_CODIFIED);  //FAILS
//				}
//				// Remove newLine characters
//				valuesToForce = valuesToForce.trim().replaceAll("\n ", "");			
//				if (options.toString().indexOf(TAG_FIELD_VALUE_INIT) != -1){
//					fieldValueAsString = valuesToForce.substring(TAG_FIELD_VALUE_INIT.length(), valuesToForce.length()-TAG_FIELD_VALUE_END.length());
//					String[] fieldValueArray = fieldValueAsString.split(TAG_FIELD_VALUE_INIT+"?");
//					// Split if exist any delimiter: symbols ',' or ':'
//					String[] parts = fieldValueAsString.split("(,)|(:)");  // Split if exist delimiter ',' or ':'
//					// Every correlated pair of parts will go to a map
//					for (int i = 0; i < parts.length; i += 2) {   
//				    	String elementKey=parts[i];
//				    	String elementValue=parts[i + 1];
//				    	// UNDO codification of an escaped comma symbol (The text: "/," was replaced by text $$COMMA$$ or similar, so we revert it back):
//						if (elementKey.indexOf(COMMA_CODIFIED)!=-1){
//							elementKey=elementKey.replace(COMMA_CODIFIED, COMMA_REAL);
//						}
//						if (elementValue.indexOf(COMMA_CODIFIED)!=-1){
//							elementValue=elementValue.replace(COMMA_CODIFIED, COMMA_REAL);
//						}
//				    	valuesToForceMap.put(elementKey, elementValue);
//				    }
//				    // Log
//				    System.out.println("option:valuesToForce. There are the following values to force:");
//				    for (Object fieldAux : valuesToForceMap.keySet()) {    // Print map
//				        System.out.println("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
//				    }
//
//				}
//			}			
//			
//			
//			// Object received: Set values
//			// ====================
//			// Set fields to its force value, if proceed (if options says it so)
//		    Class<?> clazz = object.getClass();
//			Field[] classFieldsArray = object.getClass().getDeclaredFields();
//			
//
//			for (int i = 0; i < classFieldsArray.length; i++) {
//				// Read field
//	            //=====
//				Field fieldAux = classFieldsArray[i];
//				String fieldNameAux = fieldAux.getName();
//	            // When setting values into the object, we declare: "We want to access private fields":
//	            fieldAux.setAccessible(true);
//				
//				// Set value
//				// References: ** "", https://stackoverflow.com/questions/14374878/using-reflection-to-set-an-object-property
//	            //=====			
//				if (fieldAux.getType().getName().equals("java.lang.String")){
//					// READ
//					if (valuesToForceMap.get(fieldNameAux)==null ){
//						valueAsString=fieldNameAux+" "+DEFAULT_String_VALUE;
////					// But if options parameter specifies an override value for this field...
////					if ( fieldValueArr!=null && fieldValueArr.toString().indexOf(fieldNameStr)>0 ){
////						fieldValue=fieldNameStr+" "+DEFAULT_String_VALUE;
////					}
//					// If options parameter specifies to forcean override value for this field...
//					} else {
//						// new Default value: 
//						valueAsString=valuesToForceMap.get(fieldNameAux);  
//					}
//					// WRITE 
//					// (remember: when writting, we need: 'fieldAux.setAccessible(true)' as done above)
//					//=====
//		            try {
//		            	fieldAux.set(object, valueAsString);
//					} catch (IllegalArgumentException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				} else if (fieldAux.getType().getName().equals("java.lang.Long")){
////					fieldValue=DEFAULT_Long_VALUE;
//					if (valuesToForceMap.get(fieldNameAux)==null ){
//						valueAsString=new Long(DEFAULT_Long_VALUE).toString();
////					// But if options parameter specifies an override value for this field...
////					if ( fieldValueArr!=null && fieldValueArr.toString().indexOf(fieldNameStr)>0 ){
////						fieldValue=fieldNameStr+" "+DEFAULT_String_VALUE;
////					}
//					// If options parameter specifies to forcean override value for this field...
//					} else {
//						// new Default value: 
//						valueAsString=valuesToForceMap.get(fieldNameAux);  
//					}
//					// WRITE
//					// (remember: when writting, we need: 'fieldAux.setAccessible(true)' as done above)
//					//=====
//		            try {
////			            Long l = new Long(valueAsString);
////		            	Long l = Long.parseLong((String) valueAsString);
//		            	Long l = Long.parseLong(valueAsString.toString());
//		            	fieldAux.set(object, l);
//					} catch (IllegalArgumentException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//									
//				} else {
//					valueAsString=null;
//				}
//
//	// TRY02 Write                      
////				// Write value 
////	          //=====
////	            // Set: "We want to access private fields":
////	            fieldAux.setAccessible(true);
////	            try {
//////	            	Long l = new Long(valueAsString);
////	            	Long l = Long.valueOf((String) valueAsString);
////	            	fieldAux.set(object, l);
////				} catch (IllegalArgumentException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				} catch (IllegalAccessException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
//	            
//			} // end: "for each field..."			
//			
//
//			
//			
//			//zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
//			
//			System.out.println("object"+object);
//			
//			return object;
//		
//	    }
	    		
		
	    
		
		public static class FileTool {
	        public static boolean validateFile(String strFile) {
	        	java.io.File filAux = new java.io.File(strFile);
	        	boolean blnResult = false;
	        	if (filAux.exists())
	        		blnResult=true;
	        	return blnResult;
	        }
	    }
	    
	    
	}  // End of class 
	








//	/**
//	 *  -This class repeats sequential replacements on text contents. Receives an 
//	 *  Arraylist as argument containing all replacements (match and 
//	 *  replacement). So, it is an ArrayList of ArrayList (bidimensional: each 
//	 *  element has a two Strings ArrayList), the Search string and the 
//	 *  replacement string.  
//	 * @param pstrTextOriginal
//	 * @param lisReplacementPair
//	 * @return
//	 */
//	public String applyReplaceList(String pstrTextOriginal, ArrayList lisReplacementPair){
//		String strResult = pstrTextOriginal;
//		
//		Iterator itReplacementPair = lisReplacementPair.iterator();
//		while (itReplacementPair .hasNext()) {
//			ArrayList arlisFilaCurrent = (ArrayList) itReplacementPair.next();
//			String strSearchCurrent = (String) arlisFilaCurrent.get(0);
//			String strTextReplaciationCurrent = (String) arlisFilaCurrent.get(1);
//			
//			System.out.println("strSearchCurrent="+strSearchCurrent);
//			
//			strResult = pstrTextOriginal.replace(strSearchCurrent, strTextReplaciationCurrent);
//		}
//		
//		return strResult;
//	}


	
	
	
	
	
	
	
//}  //End of IOManager class



	
//	public static String conexionPreparedToString(ConexionPrepared conn, String strSql){
//		String strSqlValuated = strSql;
//		String strValue = "";
//		int posValue = 0;
//
//		while (posValue <= conn.getTotalValues()-1){
//			// Get value
//			if (conn.getType(posValue) == 1) {  // If String, put quotes around 
//				strValue = "'" + conn.getValue(posValue) + "'";
//			} else {  // Unknown type, use the same format than String by default 
//				strValue = "'" + conn.getValue(posValue) + "'";
//				System.out.println("strValue=" + strValue);
//			}
//			// Obtener poner valor en la sql
//			strSqlValuated = strSqlValuated.replaceFirst("\\?", strValue);
//			posValue++;
//		}
//		return strSqlValuated;
//		
////		Object o = conn.getClass().getComponentType();
////		String elString = conn.toString();
////		int j = conn.total;
////		Field largoFields = conn.getClass().getFields()[0];
////		System.out.println("elString=" + elString);
//		////ConexionPrepared c = conn;		
//		
//	}
	
	
//	/** ATENCI�N, ACTUALMENTE NO FUNCIONA. 
//	 * Recibe un texto con etiquetas HTML y las elimina y retorna un texto plano. 
//	 * -References: 
//	 *   http://www.masterdlabs.es/2009/expresiones-regulares-en-java/
//	 *   http://es.wikipedia.org/wiki/Expresi%C3%B3n_regular
//	 *   http://en.wikipedia.org/wiki/Regular_expression
//	 * 
//	 * @param html
//	 * @return
//	 */
//	// <<<<<<<<<<< NO FUNCIONA
//	private static String htmlToPlainText(String html) {
//		html = html.replaceAll(";", "\n"); //salto de l�nea
//		html = html.replaceAll("", "\n"); //salto de l�nea
//		Pattern pattern = Pattern.compile("&lt;(.*?)&gt;");
//		Matcher matcher = pattern.matcher(html);
//		String plainText = matcher.replaceAll("");
//		return plainText;
//	}
