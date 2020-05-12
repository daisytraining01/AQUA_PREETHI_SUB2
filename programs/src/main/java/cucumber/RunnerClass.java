package cucumber;

import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "FeatureFiles/test.feature"
 ,glue = {"stepDef"}
// plugin = { "pretty","html:target/cucumber-reports" }
,tags = "@tag1,@tag2"
 )
 
public class RunnerClass 
{
 
}