package com.automationlab.main.Utilities;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Component
public class LoadProperties {
    public Properties getProps(){
        Properties properties=new Properties();
        try {
            FileReader fileLocator=new FileReader(System.getProperty("user.dir")+"/src/test" +
                    "/resources/PropertiesFile/locators.properties");
            FileReader fileURL=new FileReader(System.getProperty("user.dir")+"/src/test/resources" +
                    "/PropertiesFile/pages.properties");
            properties.load(fileLocator);
            properties.load(fileURL);
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(System.getProperty("user.dir"));
            System.out.println("File not exits");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
