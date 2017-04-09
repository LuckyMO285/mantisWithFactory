package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by luck on 09.04.17.
 */
public class FactoryTestAfterDeleting {

    @FindAll({
            @FindBy(xpath = "//*[@id=\"buglist\"]/tbody/tr/td[11]")
    })
    private List<WebElement> checkSummary2;

    public void check() {
        try {
            int i = 0;
            boolean exitFromCycle = true;
            while (exitFromCycle && i < this.checkSummary2.size()) {
                if (checkSummary2.get(i).getText().equals("SoHelpMeGod")) {
                    Assert.assertTrue(false);
                    exitFromCycle = false;
                }
                i++;
            }
        } catch (NoSuchElementException ignored) {
            Assert.assertTrue(true);
        }
    }

}
