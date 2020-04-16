package com.gp.workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(String locator){
        try {
            driver.findElement(By.className(locator));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getUrl(){
       return driver.getCurrentUrl();
    }

    public void navigate(String url){
        driver.get(url);
    }

}
