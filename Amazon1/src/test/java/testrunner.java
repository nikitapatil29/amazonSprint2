import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepdefinition"},
        tags = "",plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		 monochrome=true
)
public class testrunner extends AbstractTestNGCucumberTests
{@Test
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}