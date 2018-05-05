package cemadoare.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyPropertyManager {

    private static String rootPath;
    private static Properties applicationProperties;

    static {
        rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        applicationProperties = new Properties();
        try {
            applicationProperties.load(new FileInputStream(rootPath + "application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return applicationProperties.getProperty(propertyName,"");
    }
}
