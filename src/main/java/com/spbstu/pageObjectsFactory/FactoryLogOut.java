package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 16.04.17.
 */
public class FactoryLogOut {
    //@FindBy(css = "class='user-info'")
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/a/span")
    WebElement roleSpan;

    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li[2]/ul/li[4]/a")
    WebElement logOut;

    public void clickOnLogOutSpan(){
        roleSpan.click();
        logOut.click();
    }

}
