package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryDeleteIssue {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a/i")
    WebElement ViewIssues;

    @FindAll({
            @FindBy(xpath = "//td[@class='column-summary']")
            })
   List<WebElement> checkSummary;

    @FindBy(xpath = "//input[@type='submit' and @value='Delete']")
    WebElement pressDelete;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement pressDeleteIssues;

    public void clickViewIssues(){
        ViewIssues.click();
    }

    public void markToDelete() throws Exception {
        checkSummary.stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals("SoHelpMeGod"))
                .findFirst()
                .orElseThrow(Exception::new)
                .findElement(By.xpath("//td[@class='column-id']"))
                .click();
    }

    public void clickOnDelete(){
        pressDelete.click();
    }

    public void clickOnDeleteIssues(){
        pressDeleteIssues.click();
    }

}
