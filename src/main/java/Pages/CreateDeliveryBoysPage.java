package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDeliveryBoysPage extends BasePage {
    @FindBy(id="delivery_boy_name")
    private WebElement deliveryBoyNameLocator;

    @FindBy(id="phone_number")
    private WebElement phoneNumberLocator;

    @FindBy(id="email")
    private WebElement emailLocator;

    @FindBy(id="password")
    private WebElement passwordLocator;



    public CreateDeliveryBoysPage(WebDriver driver) {
        super(driver);
    }

    public void addNewDeliveryBoy(String deliveryBoyName, String phoneNumber, String email, String password){

        deliveryBoyNameLocator.sendKeys(deliveryBoyName);
        phoneNumberLocator.sendKeys(phoneNumber);
        emailLocator.sendKeys(email);
        passwordLocator.sendKeys(password);


    }
}
