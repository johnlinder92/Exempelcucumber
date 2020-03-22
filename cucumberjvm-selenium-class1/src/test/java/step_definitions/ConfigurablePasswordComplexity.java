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
public JavascriptExecutor js;
    private Map<String, Object> vars;

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






    @Given("new user has been created")
    public void newUserHasBeenCreated() {
        driver.manage().deleteAllCookies();
        driver.get("https://testsitename.atronic.se");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();


        driver.findElement(By.linkText("Användare")).click();


        driver.findElement(By.linkText("Lägg till ny")).click();
        driver.findElement(By.id("Username")).click();
        driver.findElement(By.id("Username")).sendKeys("AAAA");


        Select roles = new Select(driver.findElement(By.id("Roles_UserRoles")));
        roles.selectByValue("1");

        Select customer = new Select(driver.findElement(By.id("CustomerId")));
        customer.selectByValue("3");


        driver.findElement(By.id("FirstName")).sendKeys("AAAA");
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).sendKeys("AAAA");
        driver.findElement(By.id("RequiredEmployeeNumber")).click();
        Random rand = new Random();

        // Obtain a number between [0 - 10000].
        int employeenumber = rand.nextInt(100000);
        String employeestring = String.valueOf(employeenumber);


        driver.findElement(By.id("RequiredEmployeeNumber")).sendKeys(employeestring);

        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).sendKeys("microdebtest@gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".btn-primary")).submit();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roles")));
        boolean status = element.isDisplayed();
    }

    @And("password link has been sent")
    public void passwordLinkHasBeenSent() {
    driver.manage().deleteAllCookies();
        driver.get("https://testsitename.atronic.se");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();


        driver.findElement(By.linkText("Användare")).click();
        Select roles = new Select(driver.findElement(By.id("roles")));
        roles.selectByValue("1");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select customer = new Select(driver.findElement(By.id("filterCustomer")));
        customer.selectByValue("3");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("AAAA");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait2=new WebDriverWait(driver, 15);
       boolean element2 = wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("87609")));

        boolean element3 = wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("3054")));

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean element4 = wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("890")));

        driver.findElement(By.linkText("Skicka inbjudan")).click();
        WebDriverWait wait=new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roles")));
        boolean status = element.isDisplayed();

    }


    @And("password link has been clicked on")
    public void passwordLinkHasBeenClickedOn() {


        driver.manage().window().maximize();

        String url = "https://gmail.com";

        driver.get(url);

        driver.findElement(By.id("identifierId")).sendKeys("microdebtest@gmail.com");

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait=new WebDriverWait(driver, 20);

        driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Brazil1234");
        driver.findElement(By.xpath("//div[@id='passwordNext']/span/span")).click();
        driver.findElement(By.xpath("//tr[@id=':2q']/td[5]")).click();
        driver.findElement(By.xpath("//div[@id=':ca']/img")).click();

        driver.findElement(By.xpath("//div[@id=':ca']/img")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Verifiera min e-postadress')])[3]")).click();
        vars.put("window_handles", driver.getWindowHandles());
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window(vars.get("win9606").toString());

    }

    @And("a password with medium security has been entered in both fields")
    public void aPasswordWithMediumSecurityHasBeenEnteredInBothFields() {
        driver.switchTo().window(vars.get("win9606").toString());
    }

    @When("the user clicks submit")
    public void theUserClicksSubmit() {
    }

    @Then("I display the message not enought password complexity")
    public void iDisplayTheMessageNotEnoughtPasswordComplexity() {



        // Cleanup!
        driver.manage().deleteAllCookies();
        driver.get("https://testsitename.atronic.se");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Niklas");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.id("submit")).click();


        driver.findElement(By.linkText("Användare")).click();
        Select roles = new Select(driver.findElement(By.id("roles")));
        roles.selectByValue("1");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select customer = new Select(driver.findElement(By.id("filterCustomer")));
        customer.selectByValue("3");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("AAAA");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait2=new WebDriverWait(driver, 20);
        boolean element2 = wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("87609")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.className("fa fa-trash-o fa-lg deleteItem")).click();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roles")));
        boolean status = element.isDisplayed();


    }

}