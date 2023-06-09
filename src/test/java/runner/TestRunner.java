package runner;

import com.utilities.BrowserConfiguration;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\featuers"
, glue = "steps"
, plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends BrowserConfiguration{

 
}
