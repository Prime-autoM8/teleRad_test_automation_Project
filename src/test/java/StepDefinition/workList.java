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

import java.awt.*;
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

    By assigneesOne = By.xpath("//*[@class='chakra-text css-itvw0n'])[1]");

    //By radiographerOption = By.xpath("//div[@id='root']/div/div/main/div/div/div[2]/table/tbody/tr[1]/td[11]/button");
    By radiographerOption = By.xpath("(//button[@class='chakra-menu__menu-button css-kjvu41'])[1]");
    By studyMenuOption = By.xpath("//button[@data-cy='actionButton']");
    By viewStudyoption = By.xpath("//p[@class='chakra-text css-zdr7gl']");
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

    By addButton_Brain_wo_w_contrast = By.xpath("//div[@class='Modal-content']" + "/div/section/div/button//div[@class='Modal-content']/div/section/div/button");

   // By addButton_Brain_wo_w_contrast = By.xpath("//div[@class='Modal-content']/div/section/div/button)[1]");

    By markAsReadForReport = By.xpath("//button[text()='Mark as Ready For Reporting']");

    By reportText = By.xpath("//div[contains(text(),'the reporting queue?')]");

    By reportPopUp = By.xpath("//button[text()='Yes']");

    By searchUser = By.xpath("//input[@placeholder='Search user']");

    By yesButton = By.xpath("//button[@class='swal-button swal-button--confirm']");

    By readyText = By.xpath("//span[text()='Ready']");

    By acceptButton = By.xpath("//button[text()='Accept']");

    By acceptPopup = By.xpath("//div[text()='Are you sure?']");

    By acceptOkButton = By.xpath("//button[text()='OK']");

    By goToReportButton = By.xpath("//button[text()='Go to Report']");

    By reportPage = By.xpath("//div[text()='Report']");

    By firstTechnique = By.xpath("(//textarea[@data-cy='area'])[1]");

    //By firstTechnique = By.xpath("//div[@class='chakra-stack css-hcbred']/div/div/div/div/div/div/div/div[@class='ql-editor']");

    By saveReport = By.xpath("//button[text()='Save Report']");

    By saveReportPopup = By.xpath("//header[text()='Save report as']");

    By saveBtn = By.xpath("//button[text()='Save']");

    By reportSaved = By.xpath("//div[text()='Report saved']");

    By dictatedBtn = By.xpath("//p[text()='Dictated']");

    By finalBtn =By.xpath("//p[text()='Final']");

    By signReportBtn = By.xpath("//div[text()='Sign this Report?']");

    By finalYesBtn = By.xpath("(//button[text()='Yes'])[2]");

    By generatingPdfOkBtn = By.xpath("//button[text()='OK']");

    By finalText = By.xpath("//span[text()='FINAL']");


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
        //js.executeScript("arguments[0].click();", radiographerOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignees));
        List<WebElement> assigneeNames = driver.findElements(assignees);
        String val = driver.findElement(searchUser).getAttribute("placeholder");
        Assert.assertEquals(val,"Search user");
        for (WebElement i : assigneeNames) {
            String q = i.getText();
            if (q.equalsIgnoreCase(arg0)) {
                i.click();
                break;
            }
        }
        Thread.sleep(10000);
        String newAssigned = driver.findElement(radiographerOption).getText();
        Assert.assertEquals(newAssigned, arg0);
    }

    @When("user clicks the menu option to view a study details")
    public void userClicksTheMenuOptionToViewAStudyDetails() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(studyMenuOption));
        WebElement menu = driver.findElement(studyMenuOption);
        Thread.sleep(5000);
        //js.executeScript("arguments[0].scrollIntoView()",menu);
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
    public void userProvidesUpdateDetailsAsSpecifiedBelow(DataTable editDtls) throws InterruptedException {
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
        Thread.sleep(20000);

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
    public void systemDisplaysTheSuccessPopUpSuccessfully() throws InterruptedException {
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

    @And ("user clicks the Mark as Read Button")
    public void userClickstheMarkAsReadButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(markAsReadForReport));
        driver.findElement(markAsReadForReport).click();
    }

    @Then("System displays reporting queue popup")
    public void system_displays_reporting_queue_popup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportText));
        Assert.assertTrue(driver.findElement(reportText).isDisplayed());
    }

    @Then("user clicks the Yes button")
    public void user_clicks_the_yes_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportPopUp));
        driver.findElement(reportPopUp).click();
    }

    @When("Radigrapher assigns study to {string}, where radiographer is yet to be assigned for last study uploaded")
    public void radigrapher_assigns_study_to_where_radiographer_is_yet_to_be_assigned_for_last_study_uploaded(String arg1) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(radiographerOption));
        driver.findElement(radiographerOption).click();
        //js.executeScript("arguments[0].click();", radiographerOption);
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignees));
        List<WebElement> assigneeNames = driver.findElements(assignees);
        String val = driver.findElement(searchUser).getAttribute("placeholder");
        Assert.assertEquals(val, "Search user");
        for (WebElement i : assigneeNames) {
            String q = i.getText();
            if (q.equalsIgnoreCase(arg1)) {
                i.click();
                break;
            }
        }
        Thread.sleep(10000);
        String newAssigned = driver.findElement(radiographerOption).getText();
        Assert.assertEquals(newAssigned, arg1);
    }

    // new

    @Then("User Click The Yes Button")
    public void user_click_the_yes_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();

    }
    @When("System Displays Ready Tag In Study Details")
    public void system_displays_ready_tag_in_study_details() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(readyText));
        Assert.assertTrue(driver.findElement(readyText).isDisplayed());
    }

    @Then("User Click Accept Button")
    public void user_click_accept_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptButton));
        driver.findElement(acceptButton).click();
    }

    @When("System Displays Popup Like Are You Sure Accept Study For Reporting")
    public void system_displays_popup_like_are_you_sure_accept_study_for_reporting() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptPopup));
        Assert.assertTrue(driver.findElement(acceptPopup).isDisplayed());
    }

    @Then("User Click Yes Button")
    public void user_click_yes_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptOkButton));
        driver.findElement(acceptOkButton).click();

    }

    @Then("User clicks the Go To Report")
    public void user_clicks_the_go_to_report() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToReportButton));
        driver.findElement(goToReportButton).click();
    }

    @When("System Displays Report Write Page")
    public void system_displays_report_write_page() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportPage));
        Assert.assertTrue(driver.findElement(reportPage).isDisplayed());
        Thread.sleep(10000);
    }

    @When("User write the report as specified below")
    public void user_write_the_report_as_specified_below(DataTable userwrtrpt) throws InterruptedException, AWTException {
         Map<String, String> userDtalsretPg = userwrtrpt.asMap(String.class, String.class);
         Thread.sleep(10000);
         wait.until(ExpectedConditions.visibilityOfElementLocated(firstTechnique));
         driver.findElement(firstTechnique).sendKeys(userDtalsretPg.get("Technique"));
    }

    @Then("User clicks the Save Report button")
    public void user_clicks_the_save_report_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveReport));
        driver.findElement(saveReport).click();
    }


    @When("System displays save report popup")
    public void system_displays_save_report_popup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveReportPopup));
        Assert.assertTrue(driver.findElement(saveReportPopup).isDisplayed());
    }

    @When("User Clicks the save button")
    public void user_clicks_the_save_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();
    }

    @Then("System displays Report saved popup")
    public void system_displays_Report_saved_popup() throws InterruptedException {
        Thread.sleep(7000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(reportSaved));
        Assert.assertTrue(driver.findElement(reportSaved).isDisplayed());
    }

    @Then("User clicks the Dictated radio button")
    public void user_clicks_the_Dictated_radio_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dictatedBtn));
        driver.findElement(dictatedBtn).click();
    }

    @Then("User clicks the Final radio button")
    public void user_clicks_the_Final_radio_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finalBtn));
        driver.findElement(finalBtn).click();
    }

    @Then("System displays sign this report popup")
    public void system_displays_sign_this_report_popup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signReportBtn));
        Assert.assertTrue(driver.findElement(signReportBtn).isDisplayed());
    }

    @Then("User Clicks the yes button")
    public void user_Clicks_the_yes_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finalYesBtn));
        driver.findElement(finalYesBtn).click();
    }

}