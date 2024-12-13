package org.govstack.listners;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.framework.ExtentReporter;
import org.govstack.utils.ReportUtils;
import org.govstack.webdriver.WebDriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners_Failed implements ITestListener {

    public void onTestStart(ITestResult result) {
        WebDriverManager.initDriver();
    }

    public void onTestSuccess(ITestResult result) {
        WebDriverManager.closeAllBrowsers();
    }

    public void onTestFailure(ITestResult result) {
        ExtentReporter.logWithScreenshot(LogStatus.FAIL, "");
        WebDriverManager.closeAllBrowsers();
    }

    public void onTestSkipped(ITestResult result) {
        WebDriverManager.closeAllBrowsers();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentReporter.logWithScreenshot(LogStatus.FAIL, "");
        ExtentReporter.endReport();
        WebDriverManager.closeAllBrowsers();
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        ExtentReporter.initReport();
    }

    public void onFinish(ITestContext context) {
        ExtentReporter.endReport();
        ReportUtils.generateReport();
    }
}
