import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//PROJ JavaTests_Since2018-01-22_1157

//import tmp_borrable.Contact;
//import tmp_borrable.IOManager;

public class Main_001 {

	public enum UserStatus {
	    PENDING,
	    ACTIVE,
	    INACTIVE,
	    DELETED;
	}
	
	
	// enum showing Mobile prices
	enum Mobile {
	   Samsung(400), Nokia(250),Motorola(325);
	  
	   int price;
	   Mobile(int p) {
	      price = p;
	   }
	   int showPrice() {
	      return price;
	   } 
	}
	
	
/*	
	// enum showing Mobile prices
	enum Aplicacion_OLD {
//	   Samsung(400), Nokia(250),Motorola(325);
		DOCEL("d"), PORTAFIRMAS("p");
	  
//	   int price;
//	   Mobile2(int p) {
//	      price = p;
//	   }
	   String codeString;
	   Aplicacion_OLD(String code) {
		   codeString = code;
	   }
	   
//	   int showPrice() {
//	      return price;
//	   } 
	}
*/	
	
	// App list (E.g. D is code for DOCEL application, P is for PORTAFIRMAS application)
	enum AplicacionEnum {
		DOCEL("D"), PORTAFIRMAS("P");
	  
	   String codeString;
	   AplicacionEnum(String code) {
		   codeString = code;
	   }
	}	
	
	
	
	public static void main(String args[]){

		msgConsole("main(...)", "");
		
		Main_001 application = new Main_001();
		
		

		application.runTest07();  // Fill Car class a

//		application.runTest06();  // objectFill
//		application.runTest05();  // source Bean


		
//		application.runTest04();
		
//		application.runTest03();
		
//		application.runTest02();
//		application.runTest01();

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
	
	
	

	

	
	
	public void runTest01(){
		msgConsole("runTest01()", "");
  
		// Create an enum
		AplicacionEnum unaAplicacion = AplicacionEnum.DOCEL;  // Alternative way-> unaAplicacion = AplicacionEnum.valueOf( "DOCEL" ); 
		System.out.println( "unaAplicacion="+unaAplicacion.toString() );
		System.out.println( "codigo="+unaAplicacion.codeString );
      
		// List elements
		AplicacionEnum[] enumArray = AplicacionEnum.values();
		for (int i = 0; i < enumArray.length; i++) {
			String actualValorDesc = enumArray[i].toString();  // code
			String actualValorCode = enumArray[i].codeString;  // description
			System.out.println( "actualValorDesc="+actualValorDesc+", actualValorCode="+actualValorCode );
		} 
	      		
	}
	
	
	
	
	/**
	 *  TESTING EXCEPTION HANDLING
	 */
	public void runTest02(){
		
		msgConsole("runTest02()", "");
		
		String o="";
		final String OPTION = "";
		
		try {
			o = methodThatCanFail(OPTION);
		} catch (Exception e) {
			msgConsole("Error catched", "");
			e.printStackTrace();
		}
		
		try {
			o = methodThatCanFail("IOException");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		msgConsole("o="+o, "");
		
		
	}
	
	
	
	
	//_defaultFilling
	private void runTest03(){
		
		System.out.println("test01a_defaultFilling() pending To do. Not available yet");  //TODO. Do not force values (default automatic values will be used)
		
		
		
		Contact contact = new Contact();
		// Log
		String strOut = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact EMPTY: contact="+strOut);
		
		
		// Option 1 (deprecated)
		// Rellenar con valores autom�ticos por defecto (no customizamos para forzar valores), para ello el segundo argumento es un String vac�o, "":
		//// ESTO QUÉ ES IOManager ioManager = new IOManager();
		
		
		//TODO: semilla
//		
//		// Option 2 (recommended): partiendo de seed, "semilla"
//		Seed.IOManager.beanFill(contact, "");		// TODO: usar NO-est�tico, instancia ioManager en min�scula
//		Seed seed = new Seed();
//		seed.ioManager.objectFill(contact, "");
		
		// Log: objeto resultante
		String strOut_end_IOMANAGER = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact filled: contact="+strOut_end_IOMANAGER);

		
	}
	
	
	private void runTest04(){
		System.out.println("test02a_forceFilling()"); 
		
		Contact contact = new Contact();
		// Log
		String strOut = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact EMPTY: contact="+strOut);
		
		// Use options: force value to fill some fields: address, prueba: 
		Long idCounter = new Long(1);
		// We wish to customize this field value: id=2
		idCounter++;
		
		
//		//LLAMADA normal función dentro de ésta clase
//		objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		String strOut_end = SIMULATOR_objectToString(contact);
//		System.out.println("class contact filled: contact="+strOut_end);
//		/**/
				

//		//LLAMADA a [Proyecto JCODER] IOManager.java
//		IOManager ioManager = new IOManager();
////		ioManager.objectFill_test(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		ioManager.objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		String strOut_end_IOMANAGER = SIMULATOR_LIBRARY_objectToString(contact);
//		System.out.println("class contact filled: contact="+strOut_end_IOMANAGER);
		
		// Llamada a seed: 
		//// ESTO QUÉ ES core.common.Seed seed = new Seed();
		idCounter++;
		//// ESTO QUÉ ES seed.getIoManager().objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email3@coldmail.com,address:street Fish 3/ address using a /, comma value in this address info</FIELD_VALUE>");
		objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email3@coldmail.com,address:street Fish 3/ address using a /, comma value in this address info</FIELD_VALUE>");
		String strOut_end_IOMANAGER2 = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact filled: contact="+strOut_end_IOMANAGER2);



		
		
/*		
	    // Crear 2 elementos con direccion Madrid		
		System.out.println("FILLING AT LOOP ============");
		java.util.List direccionesMadList = new java.util.ArrayList();
		for (int i = 1; i <= 2; i++) {
			objectFill(contact, "<FIELD_VALUE>id:"+i+"</FIELD_VALUE>");
			// Log
			String strOut = objectToString(contact);
			System.out.println("class contact filled: contact="+strOut);
		}
		
		
*/		


		
		
		// TODO: 
		//*Use of loops and .add to configure lists
		//*Consider adding list on every element of the main list, since this will be the real scenario. E.g. aCustomerBean.add(aCustomerAdressList). 
		//*Remember to give example of adding a list to another to extend it: aCustomerAdressList1.add(aCustomerAdressList2)
		


	}
	
	private void runTest05(){
		String sourceCode = getCodeBean("id=String,brand=String,year=int,color=String,price=int,soldState=boolean");
		
		// Choose a class name: 
		sourceCode = sourceCode.replace("/@A_CLASS_NAME@/", "Car");
		
		System.out.println("bean sourceCode=\n"+sourceCode);
	}
	
	private void runTest06(){
		System.out.println("test02a_forceFilling()"); 
		
		Contact contact = new Contact();
		// Log
		String strOut = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact EMPTY: contact="+strOut);
		
		// Use options: force value to fill some fields: address, prueba: 
		Long idCounter = new Long(1);
		// We wish to customize this field, value: id=2
		idCounter++;
		
		
//		//LLAMADA normal función dentro de ésta clase
//		objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		String strOut_end = SIMULATOR_objectToString(contact);
//		System.out.println("class contact filled: contact="+strOut_end);
//		/**/
				

//		//LLAMADA a [Proyecto JCODER] IOManager.java
//		IOManager ioManager = new IOManager();
////		ioManager.objectFill_test(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		ioManager.objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email2@coldmail.com,address:street Fish 2/ address using a /, comma value in this address info</FIELD_VALUE>");
//		String strOut_end_IOMANAGER = SIMULATOR_LIBRARY_objectToString(contact);
//		System.out.println("class contact filled: contact="+strOut_end_IOMANAGER);
		
		// Llamada a seed: 
		//// ESTO QUÉ ES core.common.Seed seed = new Seed();
		idCounter++;
		//// ESTO QUÉ ES seed.getIoManager().objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email3@coldmail.com,address:street Fish 3/ address using a /, comma value in this address info</FIELD_VALUE>");
		objectFill(contact, "<FIELD_VALUE>id:"+idCounter+",email:email3@coldmail.com,address:street Fish 3/ address using a /, comma value in this address info</FIELD_VALUE>");
		String strOut_end_IOMANAGER2 = SIMULATOR_LIBRARY_objectToString(contact);
		System.out.println("class contact filled: contact="+strOut_end_IOMANAGER2);


	    // Crear 2 elementos forzando a que el ID sea respectivamente: 1, 2		
		System.out.println("FILLING AT LOOP ============");
		java.util.List direccionesMadList = new java.util.ArrayList();
		for (int i = 1; i <= 2; i++) {
			objectFill(contact, "<FIELD_VALUE>id:"+i+"</FIELD_VALUE>");
			// Log
			String strOutTwo = SIMULATOR_LIBRARY_objectToString(contact);
			System.out.println("class contact filled: contact="+strOutTwo);
		}
		
		
		// TODO: 
		//*Use of loops and .add to configure lists
		//*Consider adding list on every element of the main list, since this will be the real scenario. E.g. aCustomerBean.add(aCustomerAdressList). 
		//*Remember to give example of adding a list to another to extend it: aCustomerAdressList1.add(aCustomerAdressList2)
		


	}
	
	
	// Fill Car.java, etc
	private void runTest07(){
		System.out.println("runTest07()");
		
		// List, addings
		List carsList = new ArrayList();
		
		
		exampleClasses.primefacesShowcase.Car aCar = new exampleClasses.primefacesShowcase.Car();
		// Log
		String messageEmpty = SIMULATOR_LIBRARY_objectToString(aCar);
		System.out.println("class car EMPTY: aCar="+messageEmpty);
		
		// Use options: force value to force fill some fields as "id": 
		Long idCounter = new Long(0);
		// We wish to customize this field, value: id=2 zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
		idCounter++;
		
		exampleClasses.primefacesShowcase.Car carNew= new exampleClasses.primefacesShowcase.Car();
//		objectFill(carNew, "<FIELD_VALUE>id:"+idCounter+",");
//		objectFill(carNew, "");
		objectFill(carNew, "<FIELD_VALUE>id:"+idCounter);
		
		carsList.add(carNew);
		
		
		idCounter++;
		carNew= new exampleClasses.primefacesShowcase.Car();
		objectFill(carNew, "<FIELD_VALUE>id:"+idCounter);
		
		carsList.add(carNew);
		
		final int NUMERO_COCHES_TOTAL = 100;
		for (int i = 3; i < NUMERO_COCHES_TOTAL+1; i++) {
			carNew= new exampleClasses.primefacesShowcase.Car();
			objectFill(carNew, "<FIELD_VALUE>id:"+i);
			exampleClasses.primefacesShowcase.Car item = carNew;
			carsList.add(carNew);		
		}
		

		
		System.out.println("Here anchor. Lista rellena. Mostramos lista:");
		
		String filaStr=null;
		for (Iterator iterator = carsList.iterator(); iterator.hasNext();) {
			exampleClasses.primefacesShowcase.Car fila = (exampleClasses.primefacesShowcase.Car) iterator.next();
			filaStr = SIMULATOR_LIBRARY_objectToString(fila);
			System.out.println("\nfilaStr="+filaStr);
		}
		
		
		idCounter++;
		objectFill(aCar, "<FIELD_VALUE>id:"+idCounter+",");
		
		
		
	}

	
	
	/** Send parameter distinct to "" to force Exception
	 * @param option
	 * @return
	 * @throws Exception
	 */
	public String methodThatCanFail(String option) throws Exception{
		String result = "ok";
		if (option.equals("")){
			result="ok";
		}else if (option.equals("IOException")){
			IOException ex  = new IOException(option);
			throw ex;			
		}else if (option.equals("IndexOutOfBoundsException")){
			IndexOutOfBoundsException ex  = new IndexOutOfBoundsException(option);
			throw ex;
		} else {
			Exception ex  = new Exception("Option unknown, can not be managed");
			throw ex;
		}
		return result;
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
//		core.common.ObjectManager objectManager = new core.common.ObjectManager();
//		T o = objectManager.objectFill(object, "");
//		return o;

/**/			
//		Object valueAsString = null;
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
		java.util.List logMessages = new java.util.ArrayList<String>(); 
		
		
//// Test map. References: ** "Split string into key-value pairs", https://stackoverflow.com/questions/31153753/split-string-into-key-value-pairs		
//		java.util.Map<String, String> map = new java.util.HashMap<String, String>();
//	    String test = "pet:cat::car:honda::location:Japan::food:sushi";
//
//	    // split on ':' and on '::'
//	    String[] partsTest = test.split("::?");
//
//	    for (int i = 0; i < partsTest.length; i += 2) {
//	        map.put(partsTest[i], partsTest[i + 1]);
//	    }
//
//	    for (String s : map.keySet()) {
//	        System.out.println(s + " is " + map.get(s));
//	    }
    
	    
	
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
			// Remove newLine characters
			valuesToForce = valuesToForce.trim().replaceAll("\n ", "");			
			if (options.toString().indexOf(TAG_FIELD_VALUE_INIT) != -1){
				////fieldValueAsString = valuesToForce.substring(TAG_FIELD_VALUE_INIT.length(), valuesToForce.length()-TAG_FIELD_VALUE_END.length());
				fieldValueAsString = valuesToForce.replaceFirst(TAG_FIELD_VALUE_INIT, "");
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
//			        System.out.println("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
			    	logMessages.add("Field "+ fieldAux + "=" + valuesToForceMap.get(fieldAux));
			    }

			}
		}

		// Object received: Set values
		// ====================
		// Set fields to its force value, if proceed (if options says it so)
	    Class<?> clazz = object.getClass();
	    java.lang.reflect.Field[] classFieldsArray = object.getClass().getDeclaredFields();
		
		for (int i = 0; i < classFieldsArray.length; i++) {
			
			// Read field
            //=====
			java.lang.reflect.Field fieldAux = classFieldsArray[i];
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
	public String SIMULATOR_LIBRARY_objectToString(Object theObject) {
		
//		core.common.ObjectManager objectManager = new core.common.ObjectManager();
//		String o = objectManager.objectToString(theObject);
//		return o;
		
		StringBuilder result = new StringBuilder();
		final String NEW_LINE = System.getProperty("line.separator");

		result.append(theObject.getClass().getName());
		result.append(" Object {");
		result.append(NEW_LINE);

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
			result.append(NEW_LINE);
		}
		result.append("}");

		return result.toString();

	}

	
	/**
	 * Test get bean source
	 */
	public String getCodeBean(String options){
		final String NEW_LINE = "\n";
		StringBuffer result = new StringBuffer();
		
		final String CLASS_TEMPLATE = 	"public class /@A_CLASS_NAME@/{"+NEW_LINE
				  						+ "/@BEAN_VARIABLE_DECLARATIONS@/"+NEW_LINE
				  						+ "/@BEAN_GETTERS_AND_SETTERS@/"+NEW_LINE
				  						+"}"+NEW_LINE;
		
		String classSourceCode = CLASS_TEMPLATE;
		
		List<String> variablesAndTypeList = textCommasToList(options);
		
		////String beanVariablesDeclaration = generateBeanVariableDeclaration(variablesAndTypeArray);
		List aBeanVariablesDeclarationList = generateBeanVariableDeclaration(variablesAndTypeList);
//		String beanVariablesDeclarationString =  formatListAsSourceCode(aBeanVariablesDeclarationList);// beanVariablesDeclarationList.formatSourcecodetoString();
		
		
		List<String> aGetterSetterList = generateGetterSetter(variablesAndTypeList);
		
		classSourceCode = classSourceCode.replace("/@BEAN_VARIABLE_DECLARATIONS@/", formatListAsSourceCode(aBeanVariablesDeclarationList))
				.replace("/@BEAN_GETTERS_AND_SETTERS@/", formatListAsSourceCode(aGetterSetterList));
		
		
		result.append(classSourceCode);
		
		return result.toString();
	}
	
	
	// Receives, for example:
	// "id=long,brand=String,year=int"
	public List<String> generateBeanVariableDeclaration(List<String> variablesWithTypeList){
		final String JAVA_SENTENCE_DELIMITER = ";";
		final int VARIABLE_NAME_COLUMN=0;
		final int VARIABLE_TYPE_COLUMN=1;
//		StringBuffer result = new StringBuffer("");
		ArrayList<String> resultList = new ArrayList<String>();
	
		for (Iterator iterator = variablesWithTypeList.iterator(); iterator.hasNext();) {
			String part = (String) iterator.next();
			String[] currentVarAndTypeArr = part.split("=");
			resultList.add("private " + currentVarAndTypeArr[VARIABLE_TYPE_COLUMN] +" "+ currentVarAndTypeArr[VARIABLE_NAME_COLUMN] + JAVA_SENTENCE_DELIMITER);
		}
		
		return resultList;
	}
	
	public List<String> generateGetterSetter(List<String> variablesAndTypeList){
	
//		StringBuffer result = new StringBuffer();
		
/*		
		String getterSetterTemplate = "public class /@className@/{"+NEW_LINE
				  + "/@classBody@/"+NEW_LINE
				  +"}"+NEW_LINE;
*/
		
		
//		/**
//		 * @return the name class field to get.
//		 */
//		public String getName() {
//			return name;
//		}
//		/**
//		 * @param name the name class field to set. 
//		 */
//		public void setName(String name) {
//			this.name = name;
//		}
		
		final String NEW_LINE = "\n";
		final int VARIABLE_NAME_COLUMN = 0;
		final int VARIABLE_TYPE_COLUMN = 1;
		List<String> resultList = new ArrayList<String>();
		
		final String GET_TEMPLATE = 	NEW_LINE+"/**"+
								NEW_LINE+"@return the field to get."+
								NEW_LINE+"*/"+ 
								NEW_LINE+"public /@FIELD_TYPE@/ get/@FIELD_NAME@/() {"+
								NEW_LINE+"  return /@FIELD_NAME@/;"+
								NEW_LINE+"}";
		
		final String SET_TEMPLATE = 	NEW_LINE+"/**"+
								NEW_LINE+"@param the field to set."+
								NEW_LINE+"*/"+ 
								NEW_LINE+"public void set/@FIELD_NAME@/(/@FIELD_TYPE@/ /@FIELD_NAME@/) {"+
								NEW_LINE+"  this./@FIELD_NAME@/ = /@FIELD_NAME@/;"+
								NEW_LINE+"}";
		
		String variableInfo = null;
		String[] variablePartsArr = null;
		String aGet = null;
		String aSet = null;
		for (Iterator iterator = variablesAndTypeList.iterator(); iterator.hasNext();) {
			variableInfo = (String) iterator.next();
			variablePartsArr = variableInfo.split("=");
			String varName = variablePartsArr[VARIABLE_NAME_COLUMN];
			String varType = variablePartsArr[VARIABLE_TYPE_COLUMN];
			//
			aGet = GET_TEMPLATE;
			aGet = aGet.replaceFirst("/@FIELD_NAME@/", textUppercaseFirstLetter(varName));
			aGet = aGet.replaceAll("/@FIELD_NAME@/", varName);
			aGet = aGet.replaceAll("/@FIELD_TYPE@/", varType);
			//
			aSet = SET_TEMPLATE;
			aSet = aSet.replaceFirst("/@FIELD_NAME@/", textUppercaseFirstLetter(varName));
			aSet = aSet.replaceAll("/@FIELD_NAME@/", varName);
			aSet = aSet.replaceAll("/@FIELD_TYPE@/", varType);
			//
			resultList.add(aGet);
			resultList.add(aSet);
		}
		
		return resultList;
	}
	
	
//	public String[] commasToArray(String stringWithCommas){		
//		String[] partsArray = stringWithCommas.split("(,)|(;)");  // Split if exist delimiter ',' or ':'
//		return partsArray;
//	}
	
	public List<String> textCommasToList(String stringWithCommas){
		List<String> variableAndTypeList = new ArrayList();
		
		String[] variableAndTypeArray = stringWithCommas.split("(,)|(;)");  // Split if exist delimiter ',' or ':'
		
		for (int i = 0; i < variableAndTypeArray.length; i++) {
			String aRow = variableAndTypeArray[i];
//			String[] aRowArr = aRow.split("=");
//			String aRowArrName = aRowArr[0];
//			String aRowArrType = aRowArr[1];
			//
			variableAndTypeList.add(aRow);
		}
		
		return variableAndTypeList;
		
	}
	
	// Using modification on @APACHE WordUtils. Reference: ** "", https://commons.apache.org/proper/commons-lang/apidocs/src-html/org/apache/commons/lang3/text/WordUtils.html
	public String textUppercaseFirstLetter(String text){
		String result =  capitalizeFully(text, new char[]{' '});
		return result;		
	}
	
	
	/**
	* <p>Converts all the delimiter separated words in a String into capitalized words,
	* that is each word is made up of a titlecase character and then a series of
	* lowercase characters. </p>
	*
	* <p>The delimiters represent a set of characters understood to separate words.
	* The first string character and the first non-delimiter character after a
	* delimiter will be capitalized. </p>
	*
	* <p>A <code>null</code> input String returns <code>null</code>.
	* Capitalization uses the Unicode title case, normally equivalent to
	* upper case.</p>
	*
	* <pre>
	* WordUtils.capitalizeFully(null, *)            = null
	* WordUtils.capitalizeFully("", *)              = ""
	* WordUtils.capitalizeFully(*, null)            = *
	* WordUtils.capitalizeFully(*, new char[0])     = *
	* WordUtils.capitalizeFully("i aM.fine", {'.'}) = "I am.Fine"
	* </pre>
	*
	* @param str  the String to capitalize, may be null
	* @param delimiters  set of characters to determine capitalization, null means whitespace
	* @return capitalized String, <code>null</code> if null String input
	* @since 2.1
	*/
	public static String capitalizeFully(String str, final char... delimiters) {
		final int delimLen = delimiters == null ? -1 : delimiters.length;
//		if (StringUtils.isEmpty(str) || delimLen == 0) {
		if ((str==null || str=="") || delimLen == 0) {
			return str;
		}
		str = str.toLowerCase();
		return capitalize(str, delimiters);
	}
	
	
	
	// Modification on @APACHE WordUtils. Reference: ** "", https://commons.apache.org/proper/commons-lang/apidocs/src-html/org/apache/commons/lang3/text/WordUtils.html
    /**
* <p>Capitalizes all the delimiter separated words in a String.
* Only the first character of each word is changed. To convert the
* rest of each word to lowercase at the same time,
* use {@link #capitalizeFully(String, char[])}.</p>
*
* <p>The delimiters represent a set of characters understood to separate words.
* The first string character and the first non-delimiter character after a
* delimiter will be capitalized. </p>
*
* <p>A <code>null</code> input String returns <code>null</code>.
* Capitalization uses the Unicode title case, normally equivalent to
* upper case.</p>
*
* <pre>
* WordUtils.capitalize(null, *)            = null
* WordUtils.capitalize("", *)              = ""
* WordUtils.capitalize(*, new char[0])     = *
* WordUtils.capitalize("i am fine", null)  = "I Am Fine"
* WordUtils.capitalize("i aM.fine", {'.'}) = "I aM.Fine"
* </pre>
*
* @param str  the String to capitalize, may be null
* @param delimiters  set of characters to determine capitalization, null means whitespace
* @return capitalized String, <code>null</code> if null String input
* @see #uncapitalize(String)
* @see #capitalizeFully(String)
* @since 2.1
*/
	public static String capitalize(final String str, final char... delimiters) {
		final int delimLen = delimiters == null ? -1 : delimiters.length;
//		if (StringUtils.isEmpty(str) || delimLen == 0) {
		if ((str==null || str=="") || delimLen == 0) {
			return str;
		}
		final char[] buffer = str.toCharArray();
		boolean capitalizeNext = true;
		for (int i = 0; i < buffer.length; i++) {
			final char ch = buffer[i];
			if (isDelimiter(ch, delimiters)) {
				capitalizeNext = true;
			} else if (capitalizeNext) {
				buffer[i] = Character.toTitleCase(ch);
				capitalizeNext = false;
			}
		}
		return new String(buffer);
	}
	
	
	// Modification on @APACHE WordUtils. Reference: ** "", https://commons.apache.org/proper/commons-lang/apidocs/src-html/org/apache/commons/lang3/text/WordUtils.html
	// -----------------------------------------------------------------------
	/**
	 * Is the character a delimiter.
	 *
	 * @param ch
	 *            the character to check
	 * @param delimiters
	 *            the delimiters
	 * @return true if it is a delimiter
	 */
	private static boolean isDelimiter(final char ch, final char[] delimiters) {
		if (delimiters == null) {
			return Character.isWhitespace(ch);
		}
		for (final char delimiter : delimiters) {
			if (ch == delimiter) {
				return true;
			}
		}
		return false;
	}
	
	
//	public String formatSourceCodeToString (String[] anArrayOfString){
//		
//		//TODO ARRAY<STRING>_TO_STRING
//		
//		////// Generate all String at one time, with "[" "]" removed:
//		////String result = "java.util.Arrays.toString(codeArray)="+java.util.Arrays.toString(anArrayOfString).replace("[","").replace("]","");
//
//		
///*		
//		//Generate all String at one time, with "[" "]" removed:
//		String result = "java.util.Arrays.toString(codeArray)="+java.util.Arrays.toString(anArrayOfString).replace("[","").replace("]","");
//		
//		System.out.println( "result="+result );  // Hide: "[" "]"
//		
//		return result;
//*/
//		
//		//Generate all String at one time, with "[" "]" removed:
//		
//		
//		////String result = arrayToString(anArrayOfString);
//		
//		////System.out.println( "result="+result );  // Hide: "[" "]"
//		
//		////return result;
//		return null;
//	}
	
	
	
	
	
	public String formatListAsSourceCode (List<String> aListOfString){
		final String NEW_LINE = "\n";
	
		StringBuffer result= new StringBuffer();
		
		//TODO: Add further formatting (e.g. tabulation, insert blank lines between paragraphs getter/setters) (nothing done yet but adding NEW_LINE)
		
		// Format each line of code
		for (Iterator iterator = aListOfString.iterator(); iterator.hasNext();) {
			String aLine = (String) iterator.next();
			aLine=aLine+NEW_LINE;
			result.append(aLine);
		}
			
		return result.toString();
	}

	
//	public String arrayToString(String[] anArrayOfString){
//		String result = "java.util.Arrays.toString(codeArray)="+java.util.Arrays.toString(anArrayOfString).replace("[","").replace("]","");
//		
//		System.out.println( "result="+result );  // Hide: "[" "]"
//		
//		return result;
//	}
	
	
	
	public String listToString(List<String> aListOfString){

		StringBuffer resultBuffer = new StringBuffer();
		for (Iterator iterator = aListOfString.iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			resultBuffer.append(type);

		}
		
		
		return resultBuffer.toString();
	}
	

	
}
