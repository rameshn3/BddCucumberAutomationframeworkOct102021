package step_def;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\eclipseworkspaceAug2018\\BDDCucumberFrameworkOct102021\\src\\test\\java\\Feature",
				glue="step_def",
				plugin={"pretty","html:target/cucumber-report.html", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
				dryRun=false, //mapping between feature & stepdefinition is proper or not
				monochrome=true //console output will show in readable format
					
		)

public class TestRunner {

}
