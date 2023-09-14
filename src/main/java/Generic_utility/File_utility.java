package Generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_utility {
	public String getUrlNBrowKey(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Facegenie.properties");
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}
