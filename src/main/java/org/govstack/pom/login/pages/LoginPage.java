package org.govstack.pom.login.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.govstack.webdriver.WebDriverManager;
import org.govstack.framework.ConfigurationManager;
import org.govstack.framework.ExtentReporter;
import org.govstack.framework.TestData;
import org.govstack.pom.login.locators.LoginLocators;
import org.govstack.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;


public class LoginPage extends WebDriverManager {
    private static final String ENV = ConfigurationManager.getPropertyValue("ENV");

    public static final String GOVSTACK_CMS_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_" + ENV);
    public static final String GOVSTACK_CMS_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_" + ENV);
    public static final String GOVSTACK_CMS_ALERT_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_ALERT_" + ENV);
    public static final String GOVSTACK_CMS_CONTACT_DIRECTORY_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_CONTACT_DIRECTORY_" + ENV);
    public static final String GOVSTACK_CMS_OUTBOUND_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_OUTBOUND_" + ENV);
    public static final String GOVSTACK_CMS_RSS_FEEDS_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_RSS_FEEDS_" + ENV);
    public static final String GOVSTACK_CMS_BUSINESS_DIRECTORY_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_BUSINESS_DIRECTORY_" + ENV);
    public static final String GOVSTACK_CMS_PARKS_AND_FACILITIES_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_PARKS_AND_FACILITIES_" + ENV);
    public static final String BIDS_TENDER_CMS_URL = ConfigurationManager.getPropertyValue("BIDS_TENDER_CMS_" + ENV);
    public static final String GOVSTACK_CMS_TENANT = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_TENANT_" + ENV);
    public static final String GOVSTACK_CMS_AUTO_MEDIA_MANAGER_FRONT_END_URL = ConfigurationManager.getPropertyValue("GOVSTACK_CMS_FRONT_END_AUTO_MEDIA_MANAGER_" + ENV);

    WebDriver driver = getDriver();
    LoginLocators loginLocators = new LoginLocators();
    CommonMethods methods = new CommonMethods();

    public void launchGovStack() {
        driver.get(GOVSTACK_CMS_URL);
    }

    public void loginToGovStack_BackOffice() {
        try {
            driver.get(GOVSTACK_CMS_URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            methods.sendTextToElement(loginLocators.userNameTxt, ConfigurationManager.getPropertyValue("CMS_QA_USERNAME"));
            methods.clickElement(loginLocators.nextBtn);
            methods.sendTextToElement(loginLocators.passwordTxt, ConfigurationManager.getPropertyValue("CMS_QA_PASSWORD"));
            methods.clickElement(loginLocators.signInBtn);
            if(!Objects.equals(ConfigurationManager.getPropertyValue("Platform"), "GitHubActions")) {
                methods.clickElement(loginLocators.staySignedInChk);
                methods.clickElement(loginLocators.staySignedInBth);
            }
            methods.waitForElement(7);
            ExtentReporter.log(LogStatus.PASS, GOVSTACK_CMS_URL + " Launched application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to the application");
            Assert.fail();
        }
    }

    public void launchCMSWithoutCred() {
        driver.get(GOVSTACK_CMS_URL);
        methods.waitForElement(10);
    }

    public void launchTenantApplication() {
        try {
            driver.get(GOVSTACK_CMS_TENANT);
            driver.manage().window().maximize();
            methods.sendTextToElement(loginLocators.userNameTxt, ConfigurationManager.getPropertyValue("CMS_QA_USERNAME"));
            methods.clickElement(loginLocators.nextBtn);
            methods.sendTextToElement(loginLocators.passwordTxt, ConfigurationManager.getPropertyValue("CMS_QA_PASSWORD"));
            methods.clickElement(loginLocators.signInBtn);
            //methods.clickElement(loginLocators.staySignedInChk);
            methods.clickElement(loginLocators.staySignedInBth);
            methods.waitForElement(7);
            ExtentReporter.log(LogStatus.PASS, GOVSTACK_CMS_URL + " Launched application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to the application");
            Assert.fail();
        }
    }

    public void loginToGovStack_BackOffice_FedUserOrLocalUser() {
        try {
            driver.get(GOVSTACK_CMS_URL);
            driver.manage().window().maximize();
            methods.sendTextToElement(loginLocators.userNameTxt, TestData.getData("username"));
            methods.clickElement(loginLocators.nextBtn);
            methods.sendTextToElement(loginLocators.passwordTxt, TestData.getData("password"));
            methods.clickElement(loginLocators.signInBtn);
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Application logged in ");
            Assert.fail();
        }
    }


    public void launchCMSApplication() {
        for (WebElement ele : loginLocators.dashBoardBusinessDirectory) {
            if (ele.getAttribute("href").contains("govstackcms")) {
                methods.clickElement(ele);
                methods.clickElement(loginLocators.signinWithB2Cbtn);
                break;
            }
        }
        methods.waitForElement(2);
    }

    public void launchApplication(String app) {
        for (WebElement ele : loginLocators.dashBoardBusinessDirectory) {
            if (ele.getAttribute("href").contains(app)) {
                methods.clickElement(ele);
                if (app.contains("cms")) {
                    methods.clickElement(loginLocators.signinWithB2Cbtn);
                }
                break;
            }
        }
        methods.waitForElement(2);
    }

    public void businessDirectoryCMSApplication() {
        for (WebElement ele : loginLocators.dashBoardBusinessDirectory) {
            if (ele.getAttribute("href").contains("content") | ele.getAttribute("href").contains("businessdirectoryui")) {
                methods.clickElement(ele);
                break;
            }
        }
        methods.waitForElement(2);
    }

    public void Park_Facilities_CMSApplication() {
        for (WebElement ele : loginLocators.dashBoardBusinessDirectory) {
            if (ele.getAttribute("href").contains("parksandfacilitiesui")) {
                methods.scrollAndClickElement(ele);
                break;
            }
        }
        methods.waitForElement(2);
    }


    public void launchFrontEndApplication() {
        driver.get(GOVSTACK_CMS_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void launchFrontEndApplication_ContactDirectory() {
        driver.get(GOVSTACK_CMS_CONTACT_DIRECTORY_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void launchFrontEndApplication_Rss_Feeds() {
        driver.get(GOVSTACK_CMS_RSS_FEEDS_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "News/RSS/Feeds page open i new tab successfully");
    }

    public void launchFrontEndApplication_Alert() {
        driver.get(GOVSTACK_CMS_ALERT_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void launchFrontEndApplication_OutBound() {
        driver.get(GOVSTACK_CMS_OUTBOUND_FRONT_END_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    public void verifyDashBoard() {
        if (driver.getCurrentUrl().contains("dashboard")) {
            if (!loginLocators.dashBoardBusinessDirectory.isEmpty()) {
                ExtentReporter.logWithScreenshot(LogStatus.PASS, "");
            }
        } else {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Dash board url changed");
            Assert.fail();
        }
    }

    public void launchSubNavMainPage(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void launchAndLoginToCalendarEventManagement(String url) {
        try {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            methods.clickElement(loginLocators.alreadyHaveAccountBtn);
            methods.clickElement(loginLocators.ssoLoginBtn);
            methods.sendTextToElement(loginLocators.userNameTxt, ConfigurationManager.getPropertyValue("CMS_QA_USERNAME"));
            methods.clickElement(loginLocators.nextBtn);
            methods.sendTextToElement(loginLocators.passwordTxt, ConfigurationManager.getPropertyValue("CMS_QA_PASSWORD"));
            methods.clickElement(loginLocators.signInBtn);
            methods.clickElement(loginLocators.staySignedInChk);
            methods.clickElement(loginLocators.staySignedInBth);
            methods.waitForElement(3);
            ExtentReporter.log(LogStatus.PASS, "Launched application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to the application");
            Assert.fail();
        }
    }

    public void launchCalendarEventView(String url) {
        try {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            ExtentReporter.log(LogStatus.PASS, "Launched application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to the application");
            Assert.fail();
        }
    }

    public void launchAndLoginToFormManagement(String url) {
        try {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            methods.sendTextToElement(loginLocators.emailFormBuilderTxt, TestData.getData("Username"));
            methods.sendTextToElement(loginLocators.passwordFormBuilderTxt, TestData.getData("Password"));
            methods.clickElement(loginLocators.loginFormBuilderBtn);
            methods.waitForElement(3);
            ExtentReporter.log(LogStatus.PASS, "Launched application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to the application");
            Assert.fail();
        }
    }


    public void launchFrontEndApplication_BusinessDirectory() {
        driver.get(GOVSTACK_CMS_BUSINESS_DIRECTORY_FRONT_END_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void launchFrontEndApplication_ParksAndFacilities() {
        driver.get(GOVSTACK_CMS_PARKS_AND_FACILITIES_FRONT_END_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void loginToBidsTenders_BackOffice() {
        try {
            driver.get(BIDS_TENDER_CMS_URL);
            driver.manage().window().maximize();
            methods.sendTextToElement(loginLocators.btAgencyNameField, ConfigurationManager.getPropertyValue("BIDS_TENDER_STAGE_AGENCY"));
            methods.clickElement(loginLocators.btUseBtBtn);
            methods.sendTextToElement(loginLocators.btEmailLoginField, ConfigurationManager.getPropertyValue("BIDS_TENDER_STAGE_USERNAME"));
            methods.sendTextToElement(loginLocators.btPasswordLoginField, ConfigurationManager.getPropertyValue("BIDS_TENDER_STAGE_PASSWORD"));
            methods.clickElement(loginLocators.btLoginBtn);
            methods.waitForElement(5);
            ExtentReporter.log(LogStatus.PASS, BIDS_TENDER_CMS_URL + " Launched Bids and tender application");
        } catch (Exception e) {
            ExtentReporter.log(LogStatus.FAIL, "Unable to login to Bids and tender application");
            Assert.fail();
        }
    }

    public void launchProdFrontEnd(String url, String ClientName) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Client:-"+ "<b><i><u>"+TestData.getData("Client Name")+"</u></i></b>"+"\n"+"CMS_PRD_1:"+url + " Launched");
        ExtentReporter.logWithScreenshot(LogStatus.PASS, "Client:-"+ "<b><i><u>"+ ClientName +"</u></i></b>"+"\n"+"CMS_PRD_1:"+url + " Launched");
    }

    public void loginProdBackOffice(String url) {
        String prodUrl = url + "/umbraco#/content?mculture=en-US";
        try {
            driver.get(prodUrl);
            methods.waitForElement(7);
            if (!driver.getTitle().equals("Login Page")) {
                methods.clickElement(loginLocators.signinWithB2Cbtn);
                methods.waitForElement(2);
            }
            methods.sendTextToElement(loginLocators.userNameTxt, ConfigurationManager.getPropertyValue("CMS_QA_USERNAME"));
            methods.clickElement(loginLocators.nextBtn);
            methods.sendTextToElement(loginLocators.passwordTxt, ConfigurationManager.getPropertyValue("CMS_QA_PASSWORD"));
            methods.clickElement(loginLocators.signInBtn);
            methods.clickElement(loginLocators.staySignedInChk);
            methods.clickElement(loginLocators.staySignedInBth);
            methods.waitForElement(5);
            ExtentReporter.logWithScreenshot(LogStatus.PASS, prodUrl + " Launched application");
        } catch (Exception e) {
            ExtentReporter.logWithScreenshot(LogStatus.FAIL, "Unable to launch");
        }
    }

    public void launchFrontEndApplication_AutoMediaManager() {
        driver.get(GOVSTACK_CMS_AUTO_MEDIA_MANAGER_FRONT_END_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

}

