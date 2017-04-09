package com.spbstu.pageObjectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by luck on 09.04.17.
 */

public class FactoryHomePage {
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submit.click();
    }

}
