package step_definitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ConfigurablePasswordComplexity {
    public WebDriver driver;
    public ConfigurablePasswordComplexity()
    {
        driver = Hooks.driver;
    }


    @Given("^I am logged in as a company admin$")
    public void iAmLoggedInAsACompanyAdmin() {
        driver.get("https://testsitename.atronic.se/account/login?ReturnUrl=%2F");
        driver.manage().window().setSize(new Dimension(1001, 724));
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();
    }

    @And("^I have selected high complexity in the dropdown$")
    public void iHaveSelectedHighComplexityInTheDropdown() {

    }

    @When("^I click save$")
    public void iClickSave() {
    }

    @Then("^I display the success message \"([^\"]*)\"$")
    public void iDisplayTheSuccessMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the complexity is set to high$")
    public void theComplexityIsSetToHigh() {
    }

    @And("^i have created a new user$")
    public void iHaveCreatedANewUser() {
    }

    @And("^the new user has clicked on the email link to create new password$")
    public void theNewUserHasClickedOnTheEmailLinkToCreateNewPassword() {
    }

    @And("^the user has typed in a password of medium complexity$")
    public void theUserHasTypedInAPasswordOfMediumComplexity() {
    }

    @When("^the user clicks submit$")
    public void theUserClicksSubmit() {
    }

    @Then("^I display the message \"([^\"]*)\"$")
    public void iDisplayTheMessage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
