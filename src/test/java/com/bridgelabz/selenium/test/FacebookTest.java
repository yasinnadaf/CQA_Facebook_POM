package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import dataprovider.DataProviderLogic;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Dashboard;
import pages.FileUpload;
import pages.LoginPage;

import java.io.IOException;
import java.util.logging.Logger;

public class FacebookTest extends BaseClass {
    LoginPage loginPage;
    Dashboard dashboard;
    FileUpload fileUpload;
    public static Logger log = Logger.getLogger(FacebookTest.class.getName());

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser){
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        fileUpload = new FileUpload(driver);
    }

    @Test(priority = 0)
    public void validateUrlNavigation(){
//        log.error("validation error");
       String currentUrl =  driver.getCurrentUrl();
        Assert.assertEquals("https://www.facebook.com/", currentUrl);
    }

    @Test(priority = 1, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    //@Parameters({"userName","password"})
    public void loginToFacebook(String userName, String password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToFacebook(userName, password);
        Assert.assertEquals("Facebook",loginPageTitle);
        log.info("login to fb success");
    }

    @Test(priority = 2, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void fileUploadFb(String userName, String password) throws InterruptedException, IOException {
        String loginPageTitle = loginPage.loginToFacebook(userName, password);
        fileUpload.uploadFileToFb();
        log.info("file upload success");
    }

    @Test(priority = 3, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    //@Parameters({"userName","password"})
    public void dashboardValidation_Success(String userName, String password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToFacebook(userName,password);
        Assert.assertEquals("Facebook",loginPageTitle);
        Boolean flag = dashboard.homeTestValidation();
        Assert.assertEquals(true,flag);
        log.info("dashboardValidation success");
    }

    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}

