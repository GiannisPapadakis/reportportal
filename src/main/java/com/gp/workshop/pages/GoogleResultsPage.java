package com.gp.workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleResultsPage extends PageObject {

    public GoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchResultPresent(String search) {
        try {
            new WebDriverWait(driver, 5).
                    until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(search)));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public void accessResult(String search) {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(search))).
                click();
    }
}
