package com.vodafone.base;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties properties;

    public static Actions actions;

    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public Base() {
        properties =new Properties();
        try {
            FileInputStream fis = new FileInputStream("F:\\Task\\src\\main\\java\\com\\vodafone\\properities\\config.properities");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lunchBrowser(){

        if (properties.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (properties.getProperty("browser").equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else if (properties.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        js = (JavascriptExecutor)driver;

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
}
