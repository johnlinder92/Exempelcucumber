package step_definitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.util.concurrent.TimeUnit;



public class ConfigurablePasswordComplexity {
    public WebDriver driver;
    public ConfigurablePasswordComplexity()
    {
        driver = Hooks.driver;
    }

    private Map<String, Object> vars;

   /* @Given("^I am logged in as a company admin$")
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
*/
    @Given("the user has clicked on the email link to create new password")
    public void theUserHasClickedOnTheEmailLinkToCreateNewPassword() {

        driver.get("https://testsitename.atronic.se/account/login?ReturnUrl=%2F");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();


        driver.findElement(By.linkText("Användare")).click();


        driver.findElement(By.linkText("Lägg till ny")).click();
        driver.findElement(By.id("Username")).click();
        driver.findElement(By.id("Username")).sendKeys("test");


        Select roles = new Select(driver.findElement(By.id("Roles_UserRoles")));
        roles.selectByValue("1");

        Select customer = new Select(driver.findElement(By.id("CustomerId")));
        customer.selectByValue("1");


        driver.findElement(By.id("FirstName")).sendKeys("thetester");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).sendKeys("thetester");
        driver.findElement(By.id("RequiredEmployeeNumber")).click();
        Random rand = new Random();

        // Obtain a number between [0 - 10000].
        int employeenumber = rand.nextInt(100000);
        String employeestring = String.valueOf(employeenumber);


        driver.findElement(By.id("RequiredEmployeeNumber")).sendKeys(employeestring);

        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).sendKeys("microdebtest@gmail.com");
        driver.findElement(By.cssSelector(".btn-primary")).submit();



        driver.findElement(By.cssSelector("#userindextable_filter > label > input")).sendKeys("thetester");

        driver.findElement(By.linkText("Skicka inbjudan")).click();


       /* driver.get("https://gmail.com");

        driver.findElement(By.id("identifierId")).sendKeys("microdebtest@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        driver.findElement(By.id("password")).sendKeys("Brazil1234");
        driver.findElement(By.id("#passwordNext")).click();
        driver.findElement(By.cssSelector(".qs41qe > .ZFr60d")).click();
        driver.findElement(By.cssSelector(".bqe:nth-child(1)")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("Verifiera min e-postadress")).click();

    }

    @And("the user has typed in a password of medium complexity")
    public void theUserHasTypedInAPasswordOfMediumComplexity() {
        vars = new HashMap<String, Object>();
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win143").toString());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("test12345");
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test12345");



    }

    @When("the user clicks submit")
    public void theUserClicksSubmit() {
        driver.findElement(By.id("submit")).click();

    }



    @Then("I display the message not enought password complexity")
    public void iDisplayTheMessageNotEnoughtPasswordComplexity() {

      String errormessage =  driver.findElement(By.cssSelector(".validation-summary-errors li")).toString();

      assertEquals("Please use 6 letters or more", errormessage);

      //cleanup

        driver.findElement(By.className("form-control")).click();
        driver.findElement(By.className("form-control")).sendKeys("thetester");
        driver.findElement(By.cssSelector(".fa-trash-o")).click();
        driver.findElement(By.id("btnContinueDelete")).click();

    }
}
*/
    }}