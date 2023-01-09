package SetUp;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


public class base {


    public static WebDriver driver;
   // protected String URL = "http://dev-ui.xcelsolutions.io/";

//    Logger log = LogManager.getLogManager().getLogger(String.valueOf(WebDriver.class));
//    log.info("Launching Browser");
    protected String URL = "http://teleradfrontendstable.azurewebsites.net/auth/login";
    //File Uploads paths
    // protected String uploadableDocPath = "C:/Users/USER/Documents/Projects/TeleRad-UI-Automation-Framework/src/main/resources/uploadables/";
//    //String log4jConfPath = "C:\\Users\\hp\\Downloads\\281222\\281222\\teleRad_test_automation_Project-main\\src\\test\\java";
//    PropertyConfigurator.configure("C:\\Users\\hp\\Downloads\\281222\\281222\\teleRad_test_automation_Project-main\\src\\test\\java");
    //protected String uploadableDocPath = "D:\\PROJECTS\\Nigeria_Project\\CLINT_FILE\\WORKING_FILE\\teleRad_test_automation_Project-main\\src\\main\\resources\\uploadables\\";
//    BasicConfigurator.configure();
//    Properties prop = new Properties();
//    props.load(new FileInputStream("log4j property file path"));
//    props.setProperty("log4j.appender.File.File", "Folder where you want to store log files/" + "File Name");

    public Properties property;
    public InputStream input;

   // public Logger logger1;
   private static final Logger logger = LogManager.getLogger(base.class);

    public void lanch() throws FileNotFoundException {
//        property = new Properties();
//        try {
//            property.load(input);
//
//        } catch (Exception e) {
//            System.out.println("Exception");
//        }
//        logger1=Logger.getLogger(base.class);
//        PropertyConfigurator.configure("Log4j.properties");
//
//        logger1.info("Browser loading");


    }





    protected String uploadableDocPath = "C:\\Users\\hp\\Downloads\\281222\\281222\\teleRad_test_automation_Project-main\\src\\main\\resources\\uploadables\\";

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
 //   protected String signaturepath = "Documents/Projects/TeleRad-UI-Automation-Framework/src/main/resources/uploadables/";

      protected String signaturepath = "C:\\Users\\hp\\Downloads\\281222\\281222\\teleRad_test_automation_Project-main\\src\\main\\resources\\uploadables\\";




}