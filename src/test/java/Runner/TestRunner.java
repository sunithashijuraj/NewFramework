package Runner;

import java.io.*;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", 
				 glue = {"StepDefinition"},
				 monochrome = true,
				 plugin = {"pretty",
		  				   "html:target/cucumber.html",
		  				"json:target/Cucumber.json",
		  				   "html:target/cucumber.xml"}
	
		)

public class TestRunner {

	
	}

