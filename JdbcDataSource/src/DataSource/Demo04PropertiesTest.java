package DataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Demo04PropertiesTest {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Demo04PropertiesTest.class.getClassLoader();
        URL resource = classLoader.getResource("druid.properties");
        String path = resource.getPath();
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        properties.list(System.out);
    }
}
