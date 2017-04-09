package com.spbstu.pageObjectsFactory;

import com.spbstu.MantisSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryDeleteIssue {

    @FindAll({
            @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr/td[11]")
            })
   List<WebElement> checkSummary;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[10]/form/fieldset/input[4]")
    WebElement pressDelete;

    @FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
    WebElement pressDeleteIssues;

    public int searchIssue() {
        int i = 0;
        boolean exitFromCycle = true;
        while (exitFromCycle && i < checkSummary.size()) {
            if (checkSummary.get(i).getText().equals("SoHelpMeGod")) {
                Assert.assertTrue(true);
                exitFromCycle = false;
            }
            i++;
        }
        return i;
    }

    public void clickOnID(int i){
        MantisSite.getDriver().findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr["+i+"]/td[4]/a")).click();
    }

    public void clickOnDelete(){
        pressDelete.click();
    }

    public void clickOnDeleteIssues(){
        pressDeleteIssues.click();
    }

}
