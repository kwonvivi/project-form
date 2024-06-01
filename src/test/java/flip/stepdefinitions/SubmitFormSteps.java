package flip.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import flip.pageobjects.Helper;
import flip.pageobjects.SubmitFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;


public class SubmitFormSteps extends Helper {
    public static final Dotenv dotenv = Dotenv.load();

    public static WebDriver webDriver;
    @Before
    public void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @Given("user is on page user information")
    public void homePage() {
        webDriver.get(dotenv.get("BASE_URL"));
    }

    @When("user fill form with valid data")
    public void inputForm() throws InterruptedException {
        webDriver.findElement(By.xpath(SubmitFormPage.choose_title)).click();
        webDriver.findElement(By.name("Mrs.")).click();
        webDriver.findElement(By.xpath(SubmitFormPage.first_name_field)).sendKeys(dotenv.get("FIRST_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.middle_name_field)).sendKeys(dotenv.get("MIDDLE_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.last_name_field)).sendKeys(dotenv.get("LAST_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.email_field)).sendKeys(randomEmail("gmail"));
        webDriver.findElement(By.xpath(SubmitFormPage.phone_number_field)).sendKeys(dotenv.get("PHONE_NUMBER_FIELD"));
        webDriver.findElement(By.xpath(SubmitFormPage.dob_field)).sendKeys("01012001");
        webDriver.findElement(By.xpath(SubmitFormPage.gender_field)).click();
        webDriver.findElement(By.xpath(SubmitFormPage.province_field)).click();
        webDriver.findElement(By.name("DKI Jakarta")).click();
        webDriver.findElement(By.xpath(SubmitFormPage.city_field)).click();
        wait(3);
        webDriver.findElement(By.name("Jakarta Barat")).click();
    }

    @When("user fill form with invalid data")
    public void errorSubmitForm() {
        webDriver.findElement(By.xpath(SubmitFormPage.first_name_field)).sendKeys(dotenv.get("FULL_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.submit_button)).click();
    }

    @When("user click submit")
    public void submitForm() {
        webDriver.findElement(By.xpath(SubmitFormPage.submit_button)).click();
    }

    @Then("the form has successfully submitted")
    public void validateSuccessfullySubmit() {
        webDriver.findElement(By.xpath(SubmitFormPage.success_message)).isDisplayed();
        webDriver.findElement(By.xpath(SubmitFormPage.close_button)).click();
    }

    @Then("the error message will has displayed")
    public void validateErrorMessage() {
        webDriver.findElement(By.xpath(SubmitFormPage.error_message)).isDisplayed();
    }

    @After
    public void shutDown() {
        webDriver.close();
    }
}
