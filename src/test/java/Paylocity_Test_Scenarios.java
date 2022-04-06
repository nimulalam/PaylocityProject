import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotation;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Paylocity_Test_Scenarios extends Reusable_Annotation {
    @Test
    public void Delete_Existing_Employees() throws InterruptedException {
        //navigate to the paylocity login page
        driver.navigate().to("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/LogIn");
        //enter username
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='Username']","TestUser186",logger,"Username");
        //enter password
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='Password']","PI;{TH.#ijH+",logger,"Password");
        //click on login button
        Reusable_Actions_Loggers.clickMethod(driver,"//*[text()='Log In']",logger,"Login Button");
        Thread.sleep(4000);
        try {
            logger.log(LogStatus.INFO,"Deleting all existing employees");
            List<WebElement> editLinks = new ArrayList<>(driver.findElements(By.xpath("//i[@class='fas fa-times']")));
            for (int i = 0; i < editLinks.size(); i++) {
                driver.findElement(By.xpath("//i[@class='fas fa-times']")).click();
                Reusable_Actions_Loggers.clickMethod(driver, "//*[@id='deleteEmployee']", logger, "Delete Button");
                Thread.sleep(2000);
            }
            logger.log(LogStatus.PASS,"Successfully deleted all existing employees");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL,"Unable to delete existing employees " + e);
        }//end of exception
        
    }//end of test 1

    @Test(dependsOnMethods = "Delete_Existing_Employees")
    public void Add_Employee() throws InterruptedException {
        Thread.sleep(2000);
        //click on add employee
        Reusable_Actions_Loggers.clickMethod(driver,"//*[@id='add']",logger,"Add Employee");
        //Enter First Name
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='firstName']","Nimul",logger,"First Name");
        //Enter Last Name
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='lastName']","Alam",logger,"Last Name");
        //Enter Dependants
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='dependants']","1",logger,"Dependants");
        //Click on Add
        Reusable_Actions_Loggers.clickMethod(driver,"//*[@id='addEmployee']",logger,"Add Button");
    }//end of Test 2

    @Test(dependsOnMethods = "Add_Employee")
    public void Edit_Employee() throws InterruptedException {
        Thread.sleep(2000);
        //click on Edit Button
        Reusable_Actions_Loggers.clickMethod(driver,"//i[@class='fas fa-edit']",logger,"Edit Employee");
        //Update Dependants to 2
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='dependants']","2",logger,"Update Dependants");
        //Click on Update Button
        Reusable_Actions_Loggers.clickMethod(driver,"//*[@id='updateEmployee']",logger,"Update Button");
    }//end of test 3

}//end of java class
