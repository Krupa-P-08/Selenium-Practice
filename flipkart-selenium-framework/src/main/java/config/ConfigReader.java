package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static Properties getProperties() {

        try {

            prop = new Properties();

            FileInputStream file =
                    new FileInputStream("config.properties");

            prop.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }
}
