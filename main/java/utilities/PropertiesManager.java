package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static Properties frameworkConfig;

    public PropertiesManager() {

    }

    public static void initializeProperties() {

        FileInputStream readConfigFile = null;

        try {
            readConfigFile = new FileInputStream("src/main/resources/Configurations.properties");

            frameworkConfig = new Properties();
            frameworkConfig.load(readConfigFile);

        } catch (FileNotFoundException e) {
            System.out.println("Property File isn't found");
        } catch (IOException e) {
            System.out.println("File isn't readable or corrupted");
        }


    }
}
