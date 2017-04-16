package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by luck on 16.04.17.
 */
public class FactoryTestIsAssignedToUsername {

    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a/i")
    WebElement ViewIssues;

    @FindAll({
            @FindBy (xpath = "//td[@class='column-summary']")
    })
    List<WebElement> checkSummary;

    public boolean isContains(String username) throws Exception {
        ViewIssues.click();

       return checkSummary.stream()
                .filter(row -> row.findElement(By.xpath("//td[@class='column-summary']")).getText().equals("SoHelpMeGod"))
                .findFirst()
                .orElseThrow(Exception::new)
                .findElement(By.xpath("//td[@class='column-status']")).getText().equals("assigned ("+username+")");

    }
}
