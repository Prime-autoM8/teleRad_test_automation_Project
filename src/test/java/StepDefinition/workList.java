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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class workList extends SetUp.base {

    WebDriver driver = getDriver();
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor)driver;


    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(45))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
    Actions action = new Actions(driver);
    DataTable loginCreds;

//    Locator Objects
    // Login Page
    By workListOption = By.xpath("//div[contains(text(),'Worklist') and @class='Sidebar__menu__item__text']");
    By workListPageTitle = By.xpath("//div[contains(text(),'Worklist') and @class='TopNavigation--header_title']");
    By assignees = By.xpath("//*[@class='chakra-menu__group']/button/span[2]/div/p");
    By radiographerOption = By.xpath("//div[@id='root']/div/div/main/div/div/div[2]/table/tbody/tr[1]/td[4]/button");
    By studyMenuOption = By.xpath("//tbody/tr[1]/td[5]/button");
    By viewStudyoption = By.xpath("//tbody/tr[1]/td[5]/div/div/div/a/button/p[contains(text(),'View Study')]");
    By clinicalHistoryTitle = By.xpath("//p[contains(text(),'Clinical history')]");
    By CPTtitle = By.xpath("//div/div[1]/p[contains(text(),'CPT codes')]");
    By editButton = By.xpath("//button[contains(text(),'Edit Study')]");
    By fullName = By.xpath("//*[@placeholder='Full Name']");
    By dob = By.xpath("//*[@placeholder='Date of birth']");
    By technique = By.xpath("//*[@placeholder='Technique']");
    By refPhysician = By.xpath("//*[@placeholder='Ref physician']");
    By sex = By.xpath("//*[@name='gender']");
    By technician = By.xpath("//*[@placeholder='Technician']");
    By description = By.xpath("//*[@placeholder='Description']");
    By saveButton = By.xpath("//button[contains(text(),'Save')]");
    By modality = By.xpath("//*[@name='modalty']");
    By editStudySuccessPopUp = By.xpath("//div[contains(text(),'Study saved')]");
    By addNewCptCode = By.xpath("//p[contains(text(),'CPT codes')]//parent::div/following-sibling::div/div/button");
    By ctpCodesPopUp = By.xpath("//div[contains(text(),'CPT Codes')]");
    By addCptCodeButton = By.xpath("//button[contains(text(),'Add CPT Codes')]");
    By addButton_Brain_wo_w_contrast = By.xpath("//div[@class='Modal-content']" +
            "/div/section/div/button//div[@class='Modal-content']/div/section/div/button");



    @When("user clicks work list option on the side bar menu")
    public void userClicksWorkListOptionOnTheSideBarMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(workListOption));
        driver.findElement(workListOption).click();
    }

    @Then("System displays work list page successfully")
    public void systemDisplaysWorkListPageSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(workListPageTitle));
        Assert.assertTrue(driver.findElement(workListPageTitle).getText().equalsIgnoreCase("Worklist"));
    }

    @When("User assigns study to {string}, where radiographer is yet to be assigned for last study uploaded")
    public void userAssignsStudyToWhereRadiographerIsYetToBeAssignedForLastStudyUploaded(String arg0) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(radiographerOption));
        driver.findElement(radiographerOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignees));
        List<WebElement> assigneeNames = driver.findElements(assignees);
        String val = driver.findElement(radiographerOption).getText();
        Assert.assertEquals(val,"select user");
        for (WebElement i : assigneeNames) {
            String q = i.getText();
            if (q.equalsIgnoreCase(arg0)) {
                i.click();
                break;
            }
        }
        Thread.sleep(500);
        String newAssigned = driver.findElement(radiographerOption).getText();
        Assert.assertEquals(newAssigned, arg0);
    }


    @When("user clicks the menu option to view a study details")
    public void userClicksTheMenuOptionToViewAStudyDetails() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(studyMenuOption));
        WebElement menu = driver.findElement(studyMenuOption);
        Thread.sleep(5000);
        js.executeScript("arguments[0].scrollIntoView()",menu);
        Thread.sleep(3000);
        driver.findElement(studyMenuOption).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewStudyoption));
        driver.findElement(viewStudyoption).click();
    }

    @Then("system displays study details page successfully")
    public void systemDisplaysStudyDetailsPageSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clinicalHistoryTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CPTtitle));
        Assert.assertTrue(driver.findElement(clinicalHistoryTitle).isDisplayed());
        Assert.assertTrue(driver.findElement(CPTtitle).isDisplayed());
    }

    @When("user clicks the edit buton")
    public void userClicksTheEditButon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
        driver.findElement(editButton).click();
    }

    @And("user provides update details as specified below")
    public void userProvidesUpdateDetailsAsSpecifiedBelow(DataTable editDtls) {
        Map<String, String> dtls = editDtls.asMap(String.class, String.class);
//        FullName
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName));
        driver.findElement(fullName).clear();
        driver.findElement(fullName).sendKeys(dtls.get("fullname"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(dob));
        driver.findElement(dob).clear();
        driver.findElement(dob).sendKeys(dtls.get("dateOfBirth"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(technique));
        driver.findElement(technique).clear();
        driver.findElement(technique).sendKeys(dtls.get("technique"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(refPhysician));
        driver.findElement(refPhysician).clear();
        driver.findElement(refPhysician).sendKeys(dtls.get("refPhysician"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(sex));
        Select gender = new Select(driver.findElement(sex));
        gender.selectByVisibleText(dtls.get("sex"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(technician));
        driver.findElement(technician).clear();
        driver.findElement(technician).sendKeys(dtls.get("technician"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        driver.findElement(description).clear();
        driver.findElement(description).sendKeys(dtls.get("description"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(modality));
        Select mdlty = new Select(driver.findElement(modality));
        mdlty.selectByVisibleText(dtls.get("modality"));
    }

    @And("user clicks the save button")
    public void userClicksTheSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }

    @Then("System displays the success pop up successfully")
    public void systemDisplaysTheSuccessPopUpSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editStudySuccessPopUp));
        Assert.assertTrue(driver.findElement(editStudySuccessPopUp).isDisplayed());
    }

    @Given("user is on the study view page")
    public void userIsOnTheStudyViewPage() {
        systemDisplaysStudyDetailsPageSuccessfully();
    }

    @When("user clicks the add new button to assign CPT Code")
    public void userClicksTheAddNewButtonToAssignCPTCode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addNewCptCode));
        driver.findElement(addNewCptCode).click();}


    @Then("system displays CPT code PopUp")
    public void systemDisplaysCPTCodePopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ctpCodesPopUp));
        Assert.assertTrue(driver.findElement(ctpCodesPopUp).isDisplayed());
    }

    @When("user clicks the add CPT Codes button")
    public void userClicksTheAddCPTCodesButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCptCodeButton));
        driver.findElement(addCptCodeButton).click();
    }

    @And("adds cpt code")
    public void addsCptCode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton_Brain_wo_w_contrast));
        driver.findElement(addButton_Brain_wo_w_contrast).click();
    }
}
