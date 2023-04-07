package pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'MD Khan')]")
    WebElement homeBtn;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homeTestValidation() {
        Boolean flag = homeBtn.isDisplayed();
        return flag;

    }
}