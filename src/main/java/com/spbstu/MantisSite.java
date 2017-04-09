package com.spbstu;

import com.spbstu.pageObjectsFactory.FactoryContactFormPage;
import com.spbstu.pageObjectsFactory.FactoryDeleteIssue;
import com.spbstu.pageObjectsFactory.FactoryHomePage;
import com.spbstu.pageObjectsFactory.FactoryTestAfterDeleting;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by luck on 09.04.17.
 */
public class MantisSite {

    public static FactoryContactFormPage contactFormPage;
    public static FactoryHomePage homePage;
    public static FactoryDeleteIssue deleteIssue;
    public static FactoryTestAfterDeleting testAfterDeleting;
    private static WebDriver driver;

    public static void init(WebDriver driver){
        MantisSite.contactFormPage = PageFactory.initElements(driver, FactoryContactFormPage.class);
        MantisSite.homePage = PageFactory.initElements(driver, FactoryHomePage.class);
        MantisSite.deleteIssue = PageFactory.initElements(driver, FactoryDeleteIssue.class);
        MantisSite.testAfterDeleting = PageFactory.initElements(driver, FactoryTestAfterDeleting.class);
        MantisSite.driver = driver;
    }

    public static void open() {
        driver.navigate().to("http://127.0.0.1/mantisbt");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}