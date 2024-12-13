package org.govstack.framework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.govstack.utils.CommonMethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReporter extends CommonMethods {

    private static ExtentReports extentD;
    private static ExtentReports extentDwss;

    public static ExtentTest testParent;
    public static ExtentTest testParentWss;
    public static String reportPath;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> testWss = new ThreadLocal<>();
    public static ThreadLocal<Boolean> isPassed = new ThreadLocal<>();

    public static void initReport() {
        String path = System.getProperty("user.dir") + "\\Reports\\";
        String fileName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        if(new File(path + "Report_" + fileName).mkdirs()) {
            reportPath = path + "Report_" + fileName;
            System.setProperty("Report_Path", reportPath);
        }
        extentD = new ExtentReports(reportPath + "/Browser-Browser-Results.htm", true);
        extentDwss = new ExtentReports(reportPath + "/Browser-Browser-Results-withScreens.htm", true);
    }

    public ExtentReporter(String testName, String description) {
        initParent(testName, description);
    }

    public ExtentReporter(String testName) {
        initParent(testName);
    }

    public static void logWithScreenshot(LogStatus logStatus, String stepName) {
        test.get().log(logStatus, stepName);
        String path;
        switch (logStatus) {
            case PASS:
            case FAIL:
                path = CommonMethods.captureScreen();
                testWss.get().log(logStatus, stepName + testWss.get().addScreenCapture(path));
                break;
            default:
                break;
        }

    }

    public static void log(LogStatus logStatus, String stepName) {
        test.get().log(logStatus, stepName);
        switch (logStatus) {
            case PASS:
            case WARNING:
            case INFO:
            case FAIL:
                testWss.get().log(logStatus, stepName);
            default :

        }
    }

    public void initParent(String testName, String description) {
        testParent = extentD.startTest(testName, description);
        testParentWss = extentDwss.startTest(testName, description);
    }

    public void initParent(String testName) {
        testParent = extentD.startTest(testName);
        testParentWss = extentDwss.startTest(testName);
    }

    public static void initTest(String testName) {
        isPassed.set(true);
        test.set(getExtent().startTest(testName));
        testWss.set(getExtentWss().startTest(testName));
    }


    public static void endReport() {
        extentD.endTest(testParent);
        extentDwss.endTest(testParentWss);
        extentD.flush();
        extentDwss.flush();
    }

    private static ExtentReports getExtent() {
        return extentD;
    }

    private static ExtentReports getExtentWss() {
        return extentDwss;
    }


}

