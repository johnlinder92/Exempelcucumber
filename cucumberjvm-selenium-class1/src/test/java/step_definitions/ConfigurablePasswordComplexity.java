package step_definitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


import java.util.concurrent.TimeUnit;



public class ConfigurablePasswordComplexity {
    public WebDriver driver;
    public ConfigurablePasswordComplexity()
    {
        driver = Hooks.driver;
    }


    @Given("^I am logged in as a company admin$")
    public void iAmLoggedInAsACompanyAdmin() {
        driver.get("https://testsitename.atronic.se/account/login?ReturnUrl=%2F");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();
    }

    @And("^I have selected high complexity in the dropdown$")
    public void iHaveSelectedHighComplexityInTheDropdown() {
        driver.get("https://testsitename.atronic.se/Company/Edit/1");


        driver.findElement(By.id("ComplexityList")).click();
        {
            WebElement dropdown = driver.findElement(By.id("ComplexityList"));
            dropdown.findElement(By.xpath("//option[3]")).click();
        }

        driver.findElement(By.id("ComplexityList")).click();

    }

    @When("^I click save$")
    public void iClickSave() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }



    @Then("^I display the success message Company successfully saved$")
    public void iDisplayTheSuccessMessageCompanySuccessfullySaved() {

        String successMessage= driver.findElement(By.cssSelector(".alert")).getText();
        System.out.println(successMessage);
       assertEquals("Företag sparat\n×", successMessage );
    }

}
