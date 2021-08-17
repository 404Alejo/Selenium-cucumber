package util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public String getProperty(String filename, String property) {
        String value = null;
        try {

            Properties prop = new Properties();
            prop.load(new FileReader(filename));
            value = prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
