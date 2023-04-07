package pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FileUpload extends BaseClass {
    @FindBy(name = "//span[contains(text(),'Photo/video')]")
    WebElement clickOntoPic;

    @FindBy (name = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement clickToSelect;


    public  FileUpload(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadFileToFb() throws IOException {
        clickOntoPic.click();
        clickToSelect.click();
        Runtime.getRuntime().exec("C:\\Users\\Yasin Nadaf\\Documents\\FbPicUpload.exe");
    }
}
