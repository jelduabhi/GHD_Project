package org.govstack.stepdefinition;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.govstack.framework.ExtentReporter;

public class Hooks {

    @Before
    public void initReport(Scenario scenario) {
        ExtentReporter.initTest(scenario.getName());
    }
    @After
    public void endResults(Scenario scenario){
        if(scenario.isFailed()){
            ExtentReporter.log(LogStatus.FAIL,scenario.getName());
        }
    }
}
