package SetUp;

import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;


public class ExtentReport extends SetUp.base{

 String fileName = reportsLocation + "testReport.html";
 public void ExtentReportMtd () {
     extent = new ExtentReport();
     ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
     htmlReporter.config().setTheme(Theme.DARK);
     htmlReporter.config().setDocumentTitle("TeleRad - Cucumber Framework Test Automation");
     htmlReporter.config().setEncoding("UTF-8");
     htmlReporter.config().setReportName("TeleRad -- Test Report");


 }
}
