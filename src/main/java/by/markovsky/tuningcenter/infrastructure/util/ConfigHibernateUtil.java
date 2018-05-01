package by.markovsky.tuningcenter.infrastructure.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigHibernateUtil {

    private static final String PROPERTIES_PATH = "hibernate.properties";
    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(ConfigHibernateUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    private ConfigHibernateUtil() {

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static Properties getProperties() {
        return properties;
    }

}
