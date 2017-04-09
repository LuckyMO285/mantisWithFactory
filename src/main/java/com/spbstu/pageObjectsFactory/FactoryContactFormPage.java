package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryContactFormPage {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a/i")
    WebElement leftReportIssue;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitIssue;

    public void fillContactForm(String summary, String description){
        this.leftReportIssue.click();
        this.summary.sendKeys(summary);
        this.description.sendKeys(description);
    }

    public void submitContactForm(){
        this.submitIssue.click();
    }
}
