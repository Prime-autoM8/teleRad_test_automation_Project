package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class uploadStudy extends SetUp.base {

    WebDriver driver = getDriver();
    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(45))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
    Actions action = new Actions(driver);
    DataTable loginCreds;
    loginPage fromLoginPage = new loginPage();

//    Locator Objects
    // Login Page
    By business = By.xpath("//div[contains(text(),'Favors Point Clinic') and @class='Workspace__title']");
    By dashboardTitle = By.xpath("//div[contains(text(),'Dashboard') and @class='TopNavigation--header_title']");
    By dashBoardOption = By.xpath("//div[contains(text(),'Dashboard') and @class='Sidebar__menu__item__text']");
    By uploadOption = By.xpath("//div[contains(text(),'Upload') and @class='Sidebar__menu__item__text']");
    By templatesOption = By.xpath("//div[contains(text(),'Templates') and @class='Sidebar__menu__item__text']");
    By insightsOption = By.xpath("//div[contains(text(),'Insights') and @class='Sidebar__menu__item__text']");
    By institutionsOption = By.xpath("//div[contains(text(),'Institutions') and @class='Sidebar__menu__item__text']");


    By uploadTab = By.xpath("//button[contains(text(),'Upload') and @class='chakra-tabs__tab css-d0j1v1'][1]");

    //By zipUploadTab = By.xpath("//button[contains(text(),'Zip Upload') and @class='chakra-tabs__tab css-d0j1v1'][1]");
    By zipUploadTab = By.xpath("//button[contains(text(),'Zip Upload')]");
    By uploadPageTitle = By.xpath("//div[contains(text(),'Upload') and @class='TopNavigation--header_title']");

    //By zipUploadPageTitle = By.xpath("//div[contains(text(),'SFTP Upload') and @class='TopNavigation--header_title']");
    By zipUploadPageTitle = By.xpath("//div[@class='TopNavigation--header_title']");

    By uploadButton = By.xpath("//div[2]/div/div/button[contains(text(),'Upload') and @type='button']");
    By fileUploadModal = By.xpath("//div[@class='App']/div[2]/div/div[3]/div/span[contains(text(),'click to browse')]");
    By uploadFileLinkText = By.xpath("(//div[@class='App']/div[2]/div/div[3]/div/span[contains(text(),'click to browse')])[1]");

    By uploadZipFileLink = By.xpath("//input[ @accept='.zip']");

    //    By uploadSuccesMessage =
    //By wrongFileFormatNotification = By.xpath("//div[contains(text(),'Kindly select a valid Dicom files') and @class='swal-text']");

    By wrongFileFormatNotification = By.xpath("//div[contains(text(),'Process failed, ensure you select a valid file and have the permission to perform this action') and @class='swal-text']");
    By lastEntryUploaded = By.xpath("//table/tbody/tr[1]/td/p");
    By lastUploadedPatientName = By.xpath("//table/tbody/tr[1]/td[3]/p");
    By uploadStatus1 = By.xpath("//table/tbody/tr[1]/td/div/div/div[contains(text(),'On Worklist')]");
    By uploadStatus2 = By.xpath("//table/tbody/tr[1]/td/div/div/div[contains(text(),'Already exists')]");
    By cancelUploadWindow = By.cssSelector("#root > div > div:nth-child(2) > div > div.UploadMaximize--control.css-0 > svg:nth-child(2)");
    By zipUploadSuccess = By.xpath("//div[contains(text(),'Upload successfully.')]");
    By zipSuccessOk = By.xpath("//button[contains(text(),'OK')]");

    //    Step Definitions

    @Given("that user is logged in using below credentials")
    public void user_is_logged_in_using_valid_credentials(DataTable radGraphCreds) throws InterruptedException {

//        Open Website
        fromLoginPage.user_is_on_teleRad_website();
//        Provide login Credentials
        fromLoginPage.userProvidesValidUsernameAndPassword(radGraphCreds);
//        Click Signin button
        fromLoginPage.userClicksTheSignInButton();
//        Select Business
        wait.until(ExpectedConditions.elementToBeClickable(business));
        driver.findElement(business).click();
//        System displays dashboard
        wait.until(ExpectedConditions.elementToBeClickable(dashboardTitle));
        Assert.assertTrue(driver.findElement(dashboardTitle).isDisplayed());

    }

    @When("user clicks upload option on the side bar menu")
    public void userClicksUploadOptionOnTheSideBarMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadOption));
        driver.findElement(uploadOption).click();
    }

    @When("user navigates to the upload tab")
    public void userNavigatesToTheUploadTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadTab));
        driver.findElement(uploadTab).click();
    }

    @When("user navigates to the zip upload tab")
    public void userNavigatesToTheZipUploadTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipUploadTab));
        driver.findElement(zipUploadTab).click();
    }

    @Then("system displays scan upload page")
    public void systemDisplaysScanUploadPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPageTitle));
        Assert.assertTrue(driver.findElement(uploadPageTitle).isDisplayed());
    }

    @Then("system displays zip upload page")
    public void systemDisplaysZipUploadPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipUploadPageTitle));
        Assert.assertTrue(driver.findElement(zipUploadPageTitle).isDisplayed());
    }

    @When("user clicks the upload button")
    public void userClicksTheUploadButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadButton));
        driver.findElement(uploadButton).click();
    }

    @Then("System displays the upload modal")
    public void SystemDisplaysTheUploadModal() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fileUploadModal));
        Assert.assertTrue(driver.findElement(fileUploadModal).getText().contains("click to browse"));

    }

    @When("User uploads file {string}")
    public void userUploadsFile(String filename) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        String uploadableDoc = uploadableDocPath + filename;
        driver.findElement(uploadFileLinkText).click();
        fileUpload(uploadableDoc);
    }


    @When("User uploads zip file {string}")
    public void userUploadsZipFile(String filename) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        String uploadableDoc = uploadableDocPath + filename;
        driver.findElement(uploadZipFileLink).sendKeys(uploadableDoc);

    }

    @Then("system displays wrong file format error notification")
    public void systemDisplaysWrongFileFormatErrorNotification() throws InterruptedException, AWTException {
        /*Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        boolean isErrorMsgDisplayed = alertText.contains("The file name is not valid");
        Assert.assertTrue(isErrorMsgDisplayed);*/

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(wrongFileFormatNotification).isDisplayed());
        //wait.until(ExpectedConditions.elementToBeClickable(cancelUploadWindow));
        //Thread.sleep(2000);
        //driver.findElement(cancelUploadWindow).click();
        Thread.sleep(15000);
    }

    @Then("system uploads record successfully")
    public void systemUploadsRecordSuccessfully() throws InterruptedException, AWTException {
        String upload_status = null;
        String uploadFlag = null;


//       This block is to validate the status of the file uploaded

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastEntryUploaded));
        Thread.sleep(4000);
        List<WebElement> uploadParams = driver.findElements(lastEntryUploaded);
        String patientName = driver.findElement(lastUploadedPatientName).getText();
        WebElement fileUploadStatus1 = null;
        WebElement fileUploadStatus2 = null;
        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(uploadStatus1));
            fileUploadStatus1 = driver.findElement(uploadStatus1);
            if (fileUploadStatus1.getText() != (null)) {
                upload_status = ("On Worklist");
            }
        } catch (Exception ignored) {
        }
        try {
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(uploadStatus2));
            fileUploadStatus2 = driver.findElement(uploadStatus2);
            if (fileUploadStatus2.getText() != (null)) {
                upload_status = ("Already exists");
            }
        } catch (Exception ignored) {
        }

        if (("FALOUGHI-EKEZIE TONYE").contains(patientName) && upload_status == ("Already exists")) {
            uploadFlag = ("Duplicate Record Uploaded");
        } else if (("FALOUGHI-EKEZIE TONYE").contains(patientName) && upload_status == ("On Worklist")) {

            uploadFlag = ("Upload completed!!");
        }
        //Assert.assertEquals(uploadFlag, "Record Uploaded Successfully");

        Thread.sleep(15000);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFlag));

        Assert.assertEquals(uploadFlag, "Upload completed!!");


        Thread.sleep(5000);

    }

    @Then("User logs out afterwards")
    public void userLogsOutAfterwards() throws InterruptedException {
        fromLoginPage.theUserNavigatesToTheProfileIcon();
        fromLoginPage.userClicksTheLogoutButton();
        fromLoginPage.userIsLoggedOutSuccessfully();
    }

    @Then("system uploads zip file successfully")
    public void systemUploadsZipFileSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipUploadSuccess));
        Assert.assertTrue(driver.findElement(zipUploadSuccess).isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipSuccessOk));
        driver.findElement(zipSuccessOk).click();
    }
}
