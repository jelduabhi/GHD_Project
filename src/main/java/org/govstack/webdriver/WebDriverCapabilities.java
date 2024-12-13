package org.govstack.webdriver;

import org.govstack.framework.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class WebDriverCapabilities {

    public static synchronized ChromeOptions setChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("force-device-scale-factor=0.80");
        options.addArguments("high-dpi-support=0.80");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        if (Objects.requireNonNull(ConfigurationManager.getPropertyValue("HEADLESS_MODE")).equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    public static synchronized EdgeOptions setEdgeCapabilities() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("force-device-scale-factor=0.80");
        options.addArguments("high-dpi-support=0.80");
        if (Objects.requireNonNull(ConfigurationManager.getPropertyValue("HEADLESS_MODE")).equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }
        return options;
    }
}
