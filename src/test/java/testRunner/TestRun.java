package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

//import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
//import io.cucumber.
//import io.cucumber.//
//import cucumber.api.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import cucumber.api.junit.Cucumber;




//@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions
        (
        		features= {".//Features/Customer.feature",".//Features/Login.feature"},
        		glue="stepDefinitions",
        		dryRun=false,//it will crosscheck whether each step in feature file is have ing corresponding steps method in stepdef
        		monochrome=true,//remve uneccssary characters from console window
        		plugin= {"pretty",// nice and clear output
        				"html:test-output"//html report will be gnerated undrr test-output folder
        		}
		
		)
public class TestRun {

}
