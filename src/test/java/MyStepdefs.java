import Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {

    WebDriver driver;
    HomePage homePage;
    CustomerPage customerPage;
    CreateCustomerPage createCustomerPage;
    CreateDeliveryBoysPage createDeliveryBoysPage;
    DeliveryBoyPage deliveryBoyPage;

    @Before
    public void start(){
        driver = TestRunner.driver;
        homePage = new HomePage(driver);
        customerPage = new CustomerPage(driver);
        createCustomerPage = new CreateCustomerPage(driver);
        createDeliveryBoysPage = new CreateDeliveryBoysPage(driver);
        deliveryBoyPage = new DeliveryBoyPage(driver);

    }

    @Given("Admin user is in login page")
    public void adminUserIsInLoginPage() {
        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed());

        }

    @When("Admin user logs in with valid details")
    public void adminUserLogsInWithValidDetails() {
       homePage.adminLogin();
    }

    @Then("Admin user should see the dashboard")
    public void adminUserShouldSeeTheDashboard() {
        Assert.assertTrue(driver.findElement(By.className("sidebar-toggle")).isDisplayed());
    }


    @And("Admin is in create customer page")
    public void adminIsInCreateCustomerPage() {
        homePage.adminLogin();
        customerPage.navigateToCustomerPage();
    }

    @When("Admin enters valid data in fields {string},{string},{string},{string},{string}")
    public void adminEntersValidDataInFields(String customerName, String phoneNumber, String email, String password, String bloodGroup) {
        customerPage.createNewRecord();
        createCustomerPage.addNewCustomer(customerName,phoneNumber,email,password,bloodGroup);
    }

    @And("Submit to create customer")
    public void submitToCreateCustomer() {
    createCustomerPage.submit();

    }

    @Then("New customer should be created")
    public void newCustomerShouldBeCreated() {
        Assert.assertTrue(driver.findElement(By.className("column-customer_name")).isDisplayed());
    }

    @Then("User should logout")
    public void userShouldLogout() {
        driver.navigate().to("http://karehealth.menpaniproducts.com/admin/auth/logout");
    }


    @And("Admin is in create delivery boys page")
    public void adminIsInCreateDeliveryBoysPage() {
        deliveryBoyPage.navigateToDeliveryBoyPage();

    }

    @When("Admin enters valid data in fields {string},{string},{string},{string}")
    public void adminEntersValidDataInFields(String deliveryBoyName, String phoneNumber, String email, String password) {
        createDeliveryBoysPage.addNewDeliveryBoy(deliveryBoyName,phoneNumber,email,password);
    }

    @And("Submit to create delivery boys")
    public void submitToCreateDeliveryBoys() {
    deliveryBoyPage.submit();
    }

    @Then("New delivery boys should be created")
    public void newDeliveryBoysShouldBeCreated() {
        Assert.assertTrue(driver.findElement(By.className("column-delivery_boy_name")).isDisplayed());
    }

    @When("Admin enters invalid phone number in fields {string},{string},{string},{string}")
    public void adminEntersInvalidPhoneNumberInFields(String deliveryBoyName, String phoneNumber, String email, String password) {
        createDeliveryBoysPage.addNewDeliveryBoy(deliveryBoyName,phoneNumber,email,password);
    }

    @Then("User should be asked to enter valid phone number")
    public void userShouldBeAskedToEnterValidPhoneNumber() {
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()=' The Phone number must be between 9 and 20 digits.']")).isDisplayed());

    }
}
