package org.govstack.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "target/FailedCases/fail.txt",
        glue = "org.govstack.stepdefinition",
        tags = "${cucumber.filter.tags}",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunnerFailed extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}