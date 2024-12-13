package org.govstack.pom.cms.custom404.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.cms.custom404.locators.Custom404Locators;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class Custom404Page {


    CommonMethods methods = new CommonMethods();
    Custom404Locators customLocators = new Custom404Locators();

    public void enterDetails() {
        methods.waitForElement(10);
        methods.sendTextToElement(customLocators.customPageHeading, TestData.getData("Heading"));
    }



    public void pageNotFoundFrontendValidation() {
        try {
            ExtentReporter.log(LogStatus.INFO, "Page not found text visible");
            ExtentReporter.logWithScreenshot(LogStatus.INFO, "Page not found text visible");
            //Assert.assertTrue(methods.isElementPresent(customLocators.frontendCustomValidation));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ExtentReporter.log(LogStatus.FAIL, "Page not found text is not visible");
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "subscribePageValidation is not visible");
            Assert.fail();
        }
    }

}
