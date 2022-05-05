package Pages;

import org.openqa.selenium.WebDriver;

public class DeliveryBoyPage extends BasePage{

    public String deliveryBoysURL = "http://karehealth.menpaniproducts.com/admin/delivery_boys";
    public DeliveryBoyPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToDeliveryBoyPage(){
        driver.get(deliveryBoysURL);
    }
}

