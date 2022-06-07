package kompas.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import kompas.pageobjects.Helper;
import kompas.pageobjects.SubmitFormPage;
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
    @Given("user is on home page")
    public void homePage() {
        webDriver.get(dotenv.get("BASE_URL"));
    }

    @When("user fill form with valid data")
    public void submitForm() {
        webDriver.findElement(By.xpath(SubmitFormPage.name_field)).sendKeys(dotenv.get("FULL_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.email_field)).sendKeys(randomEmail("gmail"));
        webDriver.findElement(By.xpath(SubmitFormPage.submit_button)).click();
    }

    @When("user fill form with invalid data")
    public void errorSubmitForm() {
        webDriver.findElement(By.xpath(SubmitFormPage.name_field)).sendKeys(dotenv.get("FULL_NAME"));
        webDriver.findElement(By.xpath(SubmitFormPage.submit_button)).click();
    }

    @Then("the form has successfully submitted")
    public void validateSuccessfullySubmit() {
        webDriver.findElement(By.xpath(SubmitFormPage.success_message)).isDisplayed();
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
