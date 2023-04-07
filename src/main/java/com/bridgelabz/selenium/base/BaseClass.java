package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.logging.Logger;

public class BaseClass {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());

    public void initialization(String browser){  //browserName
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            log.info("chrome browser started successfully");
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

    }

    public void tearDown(){
        driver.close();
    }
}
