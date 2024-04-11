package g52445.stib.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigManager {
    private static final String FILE = "./config/config.properties";
    private final Properties prop;
    private final String url;


    private ConfigManager() {
        prop = new Properties();
        URL urlToUpdate = getClass().getClassLoader().getResource(FILE);

        Path dest = null;
        try {
            dest = Paths.get(urlToUpdate.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        url = dest.toAbsolutePath().toString();
    }
    public void load() throws IOException {
        try (InputStream input = new FileInputStream(url)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new IOException("Chargement configuration impossible ", ex);
        }
    }
    public String getProperties(String name){
        return prop.getProperty(name);
    }

    public static ConfigManager getInstance(){
        return ConfigManagerHolder.INSTANCE;
    }


    /*Initialization-on-demand holder idiom
    The key idea behind this idiom is to use a nested static class (often called the holder class)
    to hold the singleton instance. The static class is only loaded and initialized by the Java Virtual
    Machine (JVM) when it is first accessed. This ensures that the singleton instance is created lazily
    and on-demand.
     */
    private static class ConfigManagerHolder{
        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}
