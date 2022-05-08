package com.automationlab.main.SetUP;

import com.automationlab.main.Utilities.LoadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Operations {
    WebDriver driver;
    WebElement element=null;
    @Autowired
    public LoadProperties loadProperties;
    public void SetupDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            this.driver =new ChromeDriver();
            this.driver.manage().window().maximize();
        } else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver =new FirefoxDriver();
            this.driver.manage().window().maximize();
        } else if(browserName.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            this.driver =new SafariDriver();
            this.driver.manage().window().maximize();
        } else if(browserName.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            this.driver =new OperaDriver();
            this.driver.manage().window().maximize();
        } else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            this.driver =new EdgeDriver();
            this.driver.manage().window().maximize();
        }else {
            System.out.println("Invalid browser name, Please check your browser name provided!!");
        }
    }
    public WebElement getElement(String elementKey){
        if(elementKey.endsWith("_XPATH")){
            this.element=driver.findElement(By.xpath(loadProperties.getProps().getProperty(elementKey)));
        }else if(elementKey.endsWith("_NAME")){
            this.element=driver.findElement(By.name(loadProperties.getProps().getProperty(elementKey)));
        }else if(elementKey.endsWith("_CSSSELECTOR")){
            this.element=driver.findElement(By.cssSelector(loadProperties.getProps().getProperty(elementKey)));
        } else if (elementKey.endsWith("_ID")) {
            this.element=driver.findElement(By.id(loadProperties.getProps().getProperty(elementKey)));
        } else if (elementKey.endsWith("_LINKTEXT")) {
            this.element=driver.findElement(By.linkText(loadProperties.getProps().getProperty(elementKey)));
        } else if (elementKey.endsWith("_PARTIALLINKTEXT")) {
            this.element=driver.findElement(By.partialLinkText(loadProperties.getProps().getProperty(elementKey)));
        }else {
            System.out.println("Invalid Locator details!!");
        }
        return element;
    }
    public void getURL(String urlKey){
        driver.get(loadProperties.getProps().getProperty(urlKey));
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void tearDown(){
        driver.close();
    }
}
