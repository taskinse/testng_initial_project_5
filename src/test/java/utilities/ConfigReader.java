package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    // properties makes you read config.properties extended file
    // call a static block- executes before everything else
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            // should be the same name as the properties exact
            properties.load(fileInputStream);
            fileInputStream.close(); //get all the information in config/ properties into code store as key values
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
