package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Reusable_Annotation {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void SetDriverAndReport(){
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }//end of before suite

    @BeforeMethod
    public void captureTestName(Method methodName){
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void endOfTestSuite(){
        driver.quit();
        reports.flush();
    }//end of after suite


}//end of class
