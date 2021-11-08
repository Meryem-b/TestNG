package google;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features ={"src/test/resources/features/google"})
public class GoogleTestRunner extends AbstractTestNGCucumberTests {

}


