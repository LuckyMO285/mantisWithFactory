package com.spbstu.Entities;

import com.spbstu.pageObjectsFactory.entities.Issues;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

//TODO
public class WriteAnIssue {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a/i")
    WebElement leftReportIssue;

    @FindBy(id = "summary")
    WebElement summary;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitIssue;

    @FindBy(xpath = "//*[@id=\"handler_id\"]/option[.='username1']")
    WebElement AssignedToUser;

    public void writeAnIssue(Issues issue){
        this.leftReportIssue.click();
        this.AssignedToUser.click();
        this.summary.sendKeys(issue.getSummary());
        this.description.sendKeys(issue.getDescription());
    }

    public void submitIssue(){
        this.submitIssue.click();
    }
}
