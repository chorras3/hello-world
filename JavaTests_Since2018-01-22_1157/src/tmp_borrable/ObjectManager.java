
////package core.common;
package tmp_borrable;

import java.lang.reflect.Field;

/**
 * La clase ObjectManager. 
 * @author fgaparicio
 *
 */
public class ObjectManager {
	
	/**
	 * Metodo objectToString. 
	 * Recibe un objeto cualquiera y retorna String con valores de todos 
	 * sus atributos. 
	 * 
	 * @param theObject la clase recibida
	 * @return se retorna el tipo String con valores de atributos. 
	 *
	 * @Author Connectis
	 */
	public String objectToString(Object theObject) {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(theObject.getClass().getName());
		result.append(" Object {");
		result.append(newLine);

		// determine fields declared in this class only (no fields of
		// superclass)
		// Field[] fields = theObject.getClass().getDeclaredFields();
		java.lang.reflect.Field[] fields = theObject.getClass()
				.getDeclaredFields();

		// print field names paired with their values
		for (java.lang.reflect.Field fieldAux : fields) {
			result.append("  ");
			fieldAux.setAccessible(true);
			try {
				result.append(fieldAux.getName());
				result.append(": ");
				// requires access to private field:
				result.append(fieldAux.get(theObject));
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
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
//		Object valueAsString = null;
		String valueAsString = null;
		final boolean TRUE_boolean=true;
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
		
/*		
// Test map. References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs		
		java.util.Map<String, String> map = new java.util.HashMap<String, String>();
	    String test = "pet:cat::car:honda::location:Japan::food:sushi";

	    // split on ':' and on '::'
	    String[] partsTest = test.split("::?");

	    for (int i = 0; i < partsTest.length; i += 2) {
	        map.put(partsTest[i], partsTest[i + 1]);
	    }

	    for (String s : map.keySet()) {
	        System.out.println(s + " is " + map.get(s));
	    }
    
*/	    
	
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
//		java.util.Map valuesToForceMap=null;
		if (options!=""){
			// Escape a textual comma (this is, the characters: /, ):
			valuesToForce = options;
			if (valuesToForce.toString().indexOf("/,")!=-1){
				valuesToForce=valuesToForce.replace(COMMA_ESCAPPED, COMMA_CODIFIED);  //FAILS
			}
			
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
			    System.out.println("option:valuesToForce. There are the following values to force:");
			    for (Object fieldAux : valuesToForceMap.keySet()) {    // Print map
			        System.out.println("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
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
//				// But if options parameter specifies an override value for this field...
//				if ( fieldValueArr!=null && fieldValueArr.toString().indexOf(fieldNameStr)>0 ){
//					fieldValue=fieldNameStr+" "+DEFAULT_String_VALUE;
//				}
				// If options parameter specifies to forcean override value for this field...
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (fieldAux.getType().getName().equals("java.lang.Long")){
//				fieldValue=DEFAULT_Long_VALUE;
				if (valuesToForceMap.get(fieldNameAux)==null ){
					valueAsString=new Long(DEFAULT_Long_VALUE).toString();
//				// But if options parameter specifies an override value for this field...
//				if ( fieldValueArr!=null && fieldValueArr.toString().indexOf(fieldNameStr)>0 ){
//					fieldValue=fieldNameStr+" "+DEFAULT_String_VALUE;
//				}
				// If options parameter specifies to forcean override value for this field...
				} else {
					// new Default value: 
					valueAsString=valuesToForceMap.get(fieldNameAux);  
				}
				// WRITE
				// (remember: when writting, we need: 'fieldAux.setAccessible(true)' as done above)
				//=====
	            try {
//		            Long l = new Long(valueAsString);
//	            	Long l = Long.parseLong((String) valueAsString);
	            	Long l = Long.parseLong(valueAsString.toString());
	            	fieldAux.set(object, l);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
			} else {
				valueAsString=null;
			}

// TRY02 Write                      
//			// Write value 
//          //=====
//            // Set: "We want to access private fields":
//            fieldAux.setAccessible(true);
//            try {
////            	Long l = new Long(valueAsString);
//            	Long l = Long.valueOf((String) valueAsString);
//            	fieldAux.set(object, l);
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
            
		} // end: "for each field..."
		
		
		System.out.println("object"+object);
		
		return object;
	}
	
	
}
