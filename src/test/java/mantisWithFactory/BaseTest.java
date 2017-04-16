package mantisWithFactory;

import com.spbstu.MantisSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by luck on 09.04.17.
 */

public class BaseTest {

    SoftAssert softAssert;

    WebDriver driver;

    @BeforeMethod()
    public void beforeMethod(Method method) {
        softAssert = new SoftAssert();
        System.out.println(String.format("Before %s method.", method.getName()));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--lang=en-GB");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MantisSite.init(driver);
    }

    @AfterMethod()
    public void afterMethod(ITestResult testResult) {
        MantisSite.deleteIssue.clickViewIssues();

        try {
            MantisSite.deleteIssue.markToDelete();
        } catch (Exception e){
            e.printStackTrace();
        }
        MantisSite.deleteIssue.clickOnDelete();
        MantisSite.deleteIssue.clickOnDeleteIssues();
        System.out.println(String.format("Test method %s has been finished successfully: %s", testResult.getName(), testResult.isSuccess()));
        Assert.assertFalse(MantisSite.testAfterDeleting.isContains());
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

    }

    @AfterSuite(alwaysRun = true)
    public void afterSute() {

    }

}