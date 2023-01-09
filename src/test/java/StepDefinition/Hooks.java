package StepDefinition;

import io.cucumber.java.After;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Hooks extends SetUp.base {
    WebDriver driver = getDriver();
    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);
    loginPage fromLoginPage = new loginPage();

    @After("@beSureToLogOut")
    public void tearDown() throws InterruptedException {
//            driver.manage().deleteAllCookies();
//            driver.get("chrome://settings/clearBrowserData");
//            driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
//            driver.navigate().refresh();
      //  fromLoginPage.theUserNavigatesToTheProfileIcon();
      //  fromLoginPage.userClicksTheLogoutButton();
      //  fromLoginPage.userIsLoggedOutSuccessfully();


    }
}
