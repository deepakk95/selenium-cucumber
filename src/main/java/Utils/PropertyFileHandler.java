package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileHandler {

    static Properties prop = new Properties();

    public static String getdataFromConfigurationFile(String propertyName){
        try(InputStream input = new FileInputStream("src/main/resources/config.properties")){
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
