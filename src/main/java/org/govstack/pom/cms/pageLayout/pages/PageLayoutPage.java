package org.govstack.pom.cms.pageLayout.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.pom.cms.pageLayout.locators.PageLayoutLocator;
import org.govstack.utils.CommonMethods;
import org.testng.Assert;

public class PageLayoutPage {
    CommonMethods methods = new CommonMethods();
    PageLayoutLocator pageLayoutloc = new PageLayoutLocator();

    public void contentTab() {
        try {
            methods.waitForElement(10);
            methods.clickElement(pageLayoutloc.contentTab);
            ExtentReporter.log(LogStatus.PASS, "Verify CENTER NAV LEFT and CENTER NAV RIGHT option not visible");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, e.getMessage());
            Assert.fail("failed to Verify CENTER NAV LEFT and CENTER NAV RIGHT option not visible");
        }
    }
}
