package com.spbstu;

import com.spbstu.Entities.WriteAnIssue;
import com.spbstu.pageObjectsFactory.FactoryDeleteIssue;
import com.spbstu.Entities.UserAuthorization;
import com.spbstu.pageObjectsFactory.FactoryLogOut;
import com.spbstu.pageObjectsFactory.FactoryTestAfterDeleting;
import com.spbstu.pageObjectsFactory.FactoryTestIsAssignedToUsername;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by luck on 09.04.17.
 */
public class MantisSite {

    public static WriteAnIssue createAnIssue;
    public static UserAuthorization homePage;
    public static FactoryDeleteIssue deleteIssue;
    public static FactoryTestAfterDeleting testAfterDeleting;
    public static FactoryLogOut logOut;
    public static FactoryTestIsAssignedToUsername testIsAssignedToUsername;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.createAnIssue = PageFactory.initElements(driver, WriteAnIssue.class);
        MantisSite.homePage = PageFactory.initElements(driver, UserAuthorization.class);
        MantisSite.deleteIssue = PageFactory.initElements(driver, FactoryDeleteIssue.class);
        MantisSite.testAfterDeleting = PageFactory.initElements(driver, FactoryTestAfterDeleting.class);
        MantisSite.logOut = PageFactory.initElements(driver, FactoryLogOut.class);
        MantisSite.testIsAssignedToUsername = PageFactory.initElements(driver, FactoryTestIsAssignedToUsername.class);
        MantisSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}