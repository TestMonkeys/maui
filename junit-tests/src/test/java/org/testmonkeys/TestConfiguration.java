package org.testmonkeys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

import static java.io.File.separator;

@Configuration
public class TestConfiguration {

    //TODO remove this ugly stuff until the defect on video library is fixed
    @Bean
    public Properties loadVideoProperties() throws IOException {
        ClassPathResource resource = new ClassPathResource("video.properties");
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        for (Object key : properties.keySet()) {
            System.setProperty((String) key, properties.getProperty((String) key));
        }
        System.setProperty("video.folder", System.getProperty("user.dir") + separator + "target" + separator + "video");
        return properties;
    }
}
