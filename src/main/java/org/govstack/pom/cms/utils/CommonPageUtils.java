package org.govstack.pom.cms.utils;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.*;
import java.util.List;

public class CommonPageUtils {

    CommonMethods methods = new CommonMethods();
    CommonLocators commonLocators = new CommonLocators();

    public void saveAndPublish() {
        methods.clickElement(commonLocators.saveAndPublishBtn);
        methods.waitForElement(3);
        methods.clickElement(commonLocators.confirmBtn);
        methods.waitForElement(7);
    }

    public void clickSaveAndPublish() {
        methods.clickElement(commonLocators.saveAndPublishBtn);
        methods.waitForElement(5);
    }

    public void clickSaveAndPreview() {
        methods.clickElement(commonLocators.saveAndPreviewBtn);
        methods.waitForElement(5);
    }

    public void clickCancelButton() {
        methods.clickElement(commonLocators.cancelBtn);
        methods.waitForElement(2);
    }


    public void unpublish() {
        methods.clickElement(commonLocators.buttonGroupToggle);
        methods.waitForElement(2);
        methods.clickElement(commonLocators.unpublishBtn);
        methods.waitForElement(2);
        methods.clickElement(commonLocators.confirmBtn);
        methods.waitForElement(8);
    }

    public void dismissAlerts() {
        if (methods.isElementPresent(commonLocators.dismissAllAlerts)) {
            methods.clickElement(commonLocators.dismissAllAlerts);
            methods.waitForElement(2);
        }
    }

    public void dismissAllAlerts() {
        if (methods.isElementPresent(commonLocators.dismissAllAlerts)) {
            methods.clickElement(commonLocators.dismissAllAlerts);
            methods.waitForElement(2);
        }
        if (methods.isElementPresent(commonLocators.bannerAlerts.getFirst())) {
            for (WebElement ele : commonLocators.bannerAlerts) {
                methods.clickElement(ele);
            }
        }
        methods.waitForElement(2);
    }

    public void verifyBrokenLinks(List<WebElement> links) {

        HttpURLConnection huc;
        int respCode;
        String url;
        for (WebElement link : links) {
            url = link.getAttribute("href");
            ExtentReporter.log(LogStatus.INFO, url);
            if (url == null || url.isEmpty()) {
                ExtentReporter.log(LogStatus.INFO, "URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                huc = (HttpURLConnection) (URI.create(url).toURL().openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    ExtentReporter.log(LogStatus.FAIL, url + " is a broken link");
                    Assert.fail();
                } else {
                    ExtentReporter.log(LogStatus.PASS, url + " is a valid link");
                }

            } catch (Exception e) {
                ExtentReporter.log(LogStatus.FAIL, "Unable to validate Dashboard " + e.getMessage());
            }
        }
    }
}
