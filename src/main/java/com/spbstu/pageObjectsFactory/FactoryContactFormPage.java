package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryContactFormPage {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a/i")
    WebElement leftReportIssue;

    @FindBy(xpath = "//*[@id=\"summary\"]")
    WebElement summary;

    @FindBy(xpath = "//*[@id=\"description\"]")
    WebElement description;

    @FindBy(xpath = "//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
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
