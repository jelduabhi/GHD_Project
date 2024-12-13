package org.govstack.runner;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.*;
import org.govstack.framework.TestData;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/main/resources/TestCases",
        glue = "org.govstack.stepdefinition",
        tags = "${cucumber.filter.tags}",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:target/FailedCases/fail.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @After
    public void endThread(){
        TestData.endThreadLocal();
    }
}
