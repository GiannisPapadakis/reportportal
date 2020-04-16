package com.gp.workshop.testng;

import com.gp.workshop.pages.GoogleSearchPage;
import com.gp.workshop.report.WebFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({WebListener.class})
public class WebTest {

    private GoogleSearchPage page;

    @Test
    @Parameters(value = {"url","content"})
    public void passedSearchTest(String url, String content) {
        page = new GoogleSearchPage(WebFactory.getDriver(WebFactory.DriverType.ZALENIUM));
        page.navigate(url);
        assert page.getUrl().contains(content);
    }

    @Test(dependsOnMethods = "passedSearchTest")
    public void failedSearchTest() {
       assert page.isElementPresent("#searchengine") : "Search engine not found in screen";
    }

    @AfterClass
    public void teardown() {
        WebFactory.close();
    }
}
