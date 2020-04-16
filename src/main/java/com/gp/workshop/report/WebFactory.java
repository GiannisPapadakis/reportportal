package com.gp.workshop.report;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class WebFactory {

    private static WebDriver driver;

    public static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", new File("src/test/resources/drivers/chromedriver").getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver =  new ChromeDriver();
        return driver;
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", new File("src/test/resources/drivers/geckodriver").getAbsolutePath());
        driver =  new FirefoxDriver();
        return driver;
    };

    //zalenium driver supplier
    private static final Supplier<WebDriver> zaleniumDriverSupplier = () -> {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        capabilities.setCapability("name","Web Test");
        capabilities.setCapability("recordVideo", true);
        Cookie cookie = new Cookie("zaleniumTestPassed", "true");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().addCookie(cookie);
        return driver;
    };

    //add more suppliers here

    //add all the drivers into a map
    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.ZALENIUM, zaleniumDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver getDriver(DriverType type){
        if(driver == null){
            driver = driverMap.get(type).get();
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        }
        return driver;
    }

    public static final void close(){
        WebFactory.driver.close();
        WebFactory.driver = null;
    }


    public enum DriverType {
        CHROME,
        FIREFOX,
        ZALENIUM;
    }

}
