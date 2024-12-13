package org.govstack.webdriver;


import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

public class WebDriverManager extends WebDriverCapabilities {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String browserName = ConfigurationManager.getPropertyValue("BROWSER");

    public static void initDriver() {
        switch (Objects.requireNonNull(browserName).toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver(setChromeCapabilities()));
                break;
            case "edge":
                driver.set(new EdgeDriver(setEdgeCapabilities()));
                break;
            default:
                ExtentReporter.log(LogStatus.FAIL, "Browser is name is null");
        }

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeCurrentBrowser() {
        driver.get().close();
    }

    public synchronized static void closeAllBrowsers() {
        driver.get().quit();
    }

}
