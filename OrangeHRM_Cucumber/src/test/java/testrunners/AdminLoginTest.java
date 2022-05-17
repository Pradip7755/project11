package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Featurefiles/login.feature",glue="stepdefinitions",dryRun=false
,plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/login.html"})
public class AdminLoginTest 
{

}
