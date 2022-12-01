package StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.Map;

public class signUpPage extends SetUp.base {

    WebDriver driver = getDriver();
    Faker faker = new Faker();

    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(45))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
    Actions action = new Actions(driver);
    DataTable loginCreds;

    //    Locator Objects
    // Login Page
    By usersOption = By.xpath("//div[contains(text(),'Users') and @class='Sidebar__menu__item__text']");
    By addUserBtn = By.xpath("//button[contains(text(),'Add User')]");
    By addUser1stPage = By.xpath("//div[contains(text(),'Add User') and @class='Modal-title']");
    By selectCenter = By.xpath("//select[@name='center']");
    By selectDesignation = By.xpath("//select[@name='designation']");
    By emailField = By.xpath("//input[@name='email']");
    By nextModalBtn = By.xpath("//button[contains(text(),'Next')]");
    By firstName = By.name("first_name");
    By lastName = By.name("last_name");
    By userName = By.name("username");
    By title = By.name("title");
    By dob = By.name("dob");
    By gender = By.name("gender");
    By phoneNumber = By.name("phone_number");
    By address = By.name("address");
    By city = By.name("city");
    By state = By.name("state");
    By country = By.name("country");
    By addUserStepTwo = By.xpath("//div[contains(text(),'Add user - step 2/2') and @class='Modal-title']");
    By signatureButton = By.xpath("//span[contains(text(),'Upload Signature')]");

    //    Step Definitions
    @When("user clicks users option on the side bar menu")
    public void userClicksUsersOptionOnTheSideBarMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(usersOption));
        driver.findElement(usersOption).click();}
    @And("user clicks the add user button")
    public void userClicksTheAddUserButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addUserBtn));
        driver.findElement(addUserBtn).click();}
    @Then("System displays the add user modal")
    public void systemDisplaysTheAddUserModal() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUser1stPage));
        Assert.assertTrue(driver.findElement(addUser1stPage).isDisplayed());
        Thread.sleep(5000);}
    @When("User provides site and role details as specified below")
    public void userProvidesSiteAndRoleDetailsAsSpecifiedBelow(DataTable usrdtlOne) throws InterruptedException {
//        Convert DataTable to List of Maps
        Map<String, String> userDetails1stPg = usrdtlOne.asMap(String.class, String.class);
//        Select Center
        Select center = new Select(driver.findElement(selectCenter));
        center.selectByVisibleText(userDetails1stPg.get("Center"));
        Thread.sleep(5000);
//        Select Designation
        Select designation = new Select(driver.findElement(selectDesignation));
        designation.selectByVisibleText(userDetails1stPg.get("Designation"));
        Thread.sleep(5000);
//        Specify Email
        String randFullname = faker.name().lastName();
        String randEmail = randFullname.replaceAll("\\s","");
        driver.findElement(emailField).sendKeys(randEmail+"@automated.com");
        Thread.sleep(5000);}
    @And("user clicks the Next button to complete on-boarding")
    public void userClicksTheNextButtonToCompleteOnBoarding() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextModalBtn));
        driver.findElement(nextModalBtn).click();
    }

    @Then("System displays user on-boarding form")
    public void systemDisplaysUserOnBoardingPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserStepTwo));
        Assert.assertTrue(driver.findElement(addUserStepTwo).isDisplayed());
    }
    @When("user provides relevant details as specified below")
    public void userProvidesRelevantDetailsAsSpecifiedBelow(DataTable userDtlsTwo) throws InterruptedException, AWTException {
        Map<String, String> dtls = userDtlsTwo.asMap(String.class, String.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(dtls.get("firstName"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(lastName).sendKeys(dtls.get("lastName"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys(dtls.get("userName"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        driver.findElement(title).sendKeys(dtls.get("title"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(dob));
        driver.findElement(dob).sendKeys(dtls.get("dateOfBirth"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
        Select gEnDeR = new Select(driver.findElement(gender));
        gEnDeR.selectByVisibleText(dtls.get("gender"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber));
        driver.findElement(phoneNumber).sendKeys(dtls.get("phoneNumber"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        driver.findElement(address).sendKeys(dtls.get("address"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(city));
        driver.findElement(city).sendKeys(dtls.get("city"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(state));
        driver.findElement(state).sendKeys(dtls.get("state"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        driver.findElement(country).sendKeys(dtls.get("country"));

        wait.until(ExpectedConditions.elementToBeClickable(signatureButton));
        driver.findElement(signatureButton).click();
        fileUpload(signaturepath+(dtls.get("signatureFileName")));
    }

    @And("user clicks the save changes button")
    public void userClicksTheSaveChangesButton() {

    }

    @Then("System saves user information successfully")
    public void systemSavesUserInformationSuccessfully() {

    }


}
