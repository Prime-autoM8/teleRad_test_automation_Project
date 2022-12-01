package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class loginPage extends SetUp.base {

    WebDriver driver = getDriver();
    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(45))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
    Actions action = new Actions(driver);
    DataTable loginCreds;

//    Locator Objects
    // Login Page
    By signInButton = By.xpath("//button[contains(text(),'Sign in')]");
    By emailField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@class='button-btn  btn btn-primary']");
    By acceptPolicyAndCookies = By.xpath("//button[contains(text(),'I agree')]");
    By errorCredentialsNotif = By.xpath("//div[contains(text(),'Invalid credentials, try again')]");
    By OKbutton = By.xpath("//button[contains(text(),'OK')]");
    By dashBoardTitle = By.xpath("//div[@class='TopNavigation--header_title']");
    By loginBackButton = By.xpath("//span[contains(text(),'Back')]");
    By businessOption = By.className("Workspace");
    By profileIcon = By.xpath("//img[@class='MuiAvatar-img']");
    By logoutButton = By.xpath("//button[text()='Log out']");

    //    Step Definitions
    @Given("user is on Xcel Website")
    public void user_is_on_teleRad_website() {
        driver.manage().window().maximize();
        driver.get(URL);
    }

//    @Given("That user is logged-in as {string} using valid credentials")
//    public void thatUserIsLoggedInUsingValidCredentials(String user, DataTable loginCreds) throws InterruptedException {
//
//        Map<String, String> loginCredentials = loginCreds.asMap(String.class, String.class); //Convert DataTable to List of Maps
//        driver.manage().window().maximize();                //Maximize Windows
//        driver.get(loginCredentials.get("QTHomesUrl"));     // Open URL
//        Thread.sleep(2000);
//        try{
//            wait.until(ExpectedConditions.visibilityOfElementLocated(acceptPolicyAndCookies));
//            driver.findElement(acceptPolicyAndCookies).click();
//        } catch(Exception ignored){
//
//        }
//        if (user.equalsIgnoreCase("admin")) {
//            systemDisplaysLoginPopUp();
////                Fill Credentials
//            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//            driver.findElement(emailField).sendKeys(loginCredentials.get("username"));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
//            driver.findElement(passwordField).sendKeys(loginCredentials.get("password"));
//            userClicksTheLoginButton();
//            systemLogsInSuccessfully();
//        }
//        else {
//            userClicksProfileIconDropdownButton();
//            userClicksLoginOption();
//            systemDisplaysLoginPopUp();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//            driver.findElement(emailField).sendKeys(loginCredentials.get("username"));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
//            driver.findElement(passwordField).sendKeys(loginCredentials.get("password"));
//            userClicksTheLoginButton();
//            systemLogsInSuccessfully();
//        }
//    }


//    @When("User clicks profile icon dropdown button")
//    public void userClicksProfileIconDropdownButton() throws InterruptedException {
//        Thread.sleep(1000);
//        wait.until(ExpectedConditions.elementToBeClickable(profileDropDown));
//        driver.findElement(profileDropDown).click();
//    }

//    @When("User clicks login option")
//    public void userClicksLoginOption() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginOption));
//        driver.findElement(loginOption).click();
//    }

    @Then("System displays Login page successfully")
    public void systemDisplaysLoginPage() {
        try {
            Thread.sleep(2000);
            driver.findElement(loginBackButton).click();
        } catch (Exception ignored) {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        WebElement Loginpage = driver.findElement(signInButton);
        Assert.assertTrue(Loginpage.isDisplayed());
    }

    @When("User provides valid username and password")
    public void userProvidesValidUsernameAndPassword(DataTable loginCreds) throws InterruptedException {
//        Convert DataTable to List of Maps
        Map<String, String> loginCredentials = loginCreds.asMap(String.class, String.class);
//        Fill Credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(loginCredentials.get("username"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(loginCredentials.get("password"));
    }

    @And("User clicks the sign-in button")
    public void userClicksTheSignInButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();

    }

    @Then("System displays the business selection page")
    public void SystemDisplaysTheBusinessSelectionPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessOption));
        Assert.assertTrue(driver.findElement(businessOption).isDisplayed());
    }

    @When("user selects business")
    public void userSelectsBusiness() {
        wait.until(ExpectedConditions.elementToBeClickable(businessOption));
        driver.findElement(businessOption).click();
    }

    @Then("System grants user access successfully")
    public void System_grants_user_access_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardTitle));
        Assert.assertEquals(driver.findElement(dashBoardTitle).getText(), "Dashboard");

    }

    @When("the user navigates and clicks the profile icon")
    public void theUserNavigatesToTheProfileIcon() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
        driver.findElement(profileIcon).click();
    }

    @And("user clicks the logout button")
    public void userClicksTheLogoutButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    @And("User provides invalid username and password")
    public void userProvidesInvalidUsernameAndPassword(DataTable invalidLoginCreds) throws InterruptedException {
        userProvidesValidUsernameAndPassword(invalidLoginCreds);
    }

    @Then("System displays error notification")
    public void systemDisplaysErrorNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorCredentialsNotif));
        Assert.assertTrue(driver.findElement(errorCredentialsNotif).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(OKbutton));
        driver.findElement(OKbutton).click();
// Clear Wrong Entries
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        WebElement Loginpage = driver.findElement(signInButton);
        Assert.assertTrue(Loginpage.isDisplayed());
    }

    //
    @Then("user then logged out successfully")
    public void userThenLoggedOutSuccessfully() throws InterruptedException {
        theUserNavigatesToTheProfileIcon();
        userClicksTheLogoutButton();
        userIsLoggedOutSuccessfully();
    }
}
