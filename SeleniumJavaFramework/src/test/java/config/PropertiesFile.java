package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	static String ProjPath = System.getProperty("user.dir");
	static String result="";

	public static void main(String[] args) {
      getProperties(result);
     // setProperties();
      
	}
	
	public static String getProperties(String property){
		
		try{
		InputStream input = new FileInputStream(ProjPath+"/src/test/java/config/config.properties");
		prop.load(input);
		result = prop.getProperty(property);
		
		 
		}
		catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return result;
	}
	
	
	public static void setProperties(){
		try {
			OutputStream output = new FileOutputStream(ProjPath+"/src/test/java/config/config.properties");
			prop.setProperty("result","pass");
			prop.store(output,null);

		} catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}

}
