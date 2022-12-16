package SetUp;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class base {
    public static WebDriver driver;
    protected String URL = "http://teleradfrontendstable.azurewebsites.net";
    //File Uploads paths
   // protected String uploadableDocPath = "C:/Users/USER/Documents/Projects/TeleRad-UI-Automation-Framework/src/main/resources/uploadables/";

    //protected String uploadableDocPath = "D:\\PROJECTS\\Nigeria_Project\\CLINT_FILE\\WORKING_FILE\\teleRad_test_automation_Project-main\\src\\main\\resources\\uploadables\\";

    protected String uploadableDocPath = "C:\\Users\\hp\\Downloads\\141222\\141222\\teleRad_test_automation_Project-main\\src\\main\\resources\\uploadables\\";

    public ExtentReport extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportsLocation = "C:/Users/USER/Documents/Projects/TeleRad-UI-Automation-Framework/src/main/resources/reports";



    protected WebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    protected void fileUpload(String filePath) throws AWTException, InterruptedException {
        Robot rb = new Robot();
        rb.delay(3000);
//        copy filepath from ClipBoard
        StringSelection copyFile = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyFile,null);
//    press the Control key = V
        rb.keyPress((KeyEvent.VK_CONTROL));
        rb.keyPress((KeyEvent.VK_V));
//    release the Control key = V
        rb.keyRelease((KeyEvent.VK_V));
        rb.keyRelease((KeyEvent.VK_CONTROL));
//    click the enter key
        rb.delay(3000);
        rb.keyRelease((KeyEvent.VK_CONTROL));
        rb.keyRelease((KeyEvent.VK_CONTROL));
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


    }

    protected void fileUpload(String filePath, int wait_time) throws InterruptedException, AWTException {
        fileUpload(filePath);
        Thread.sleep(wait_time);
    }

//    FilePath
    protected String signaturepath = "Documents/Projects/TeleRad-UI-Automation-Framework/src/main/resources/uploadables/";


}