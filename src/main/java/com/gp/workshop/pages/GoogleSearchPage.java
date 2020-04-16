package com.gp.workshop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends PageObject {

    @FindBy(id="lst-ib")
    private WebElement search;

    @FindBy(name="btnK")
    private WebElement submit;

    @FindBy(id="hplogo")
    private WebElement logo;


    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }


    public GoogleSearchPage enter(String search){
        this.search.clear();
        this.search.sendKeys(search);
        return this;
    }

    public GoogleResultsPage submit(){
        logo.click();
        submit.click();
        return new GoogleResultsPage(driver);
    }
}
