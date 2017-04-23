package mantisWithFactory.stepdefs;

import com.spbstu.MantisSite;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import mantisWithFactory.helper.LoadFromResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by luck on 23.04.17.
 */
public class Hook {
    WebDriver driver;

    @Before
    public void before(Scenario scenario){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MantisSite.init(driver);
    }

    @After
    public void after(Scenario scenario){
        MantisSite.logOut.clickOnLogOutSpan();

        MantisSite.homePage.login(LoadFromResources.getUser("administrator"));

        MantisSite.deleteIssue.clickViewIssues();

        try {
            MantisSite.deleteIssue.markToDelete();
        } catch (Exception e){
            e.printStackTrace();
        }
        MantisSite.deleteIssue.clickOnDelete();
        MantisSite.deleteIssue.clickOnDeleteIssues();
        Assert.assertFalse(MantisSite.testAfterDeleting.isContains(LoadFromResources.getIssue("issue_1").getSummary()));
        driver.close();
    }

}
