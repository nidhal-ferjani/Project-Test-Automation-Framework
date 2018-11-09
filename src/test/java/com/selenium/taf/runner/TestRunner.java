package com.selenium.taf.runner;

import com.selenium.taf.tests.TestBase;

import cucumber.api.CucumberOptions;

/*@CucumberOptions(features="src\\test\\java\\com\\selenium\\taf\\features",
glue= {"com.selenium.taf.steps"},
plugin= {"pretty","html:target/cucumber-html-report"})*/



@CucumberOptions(
		features = {"src\\test\\java\\com\\selenium\\taf\\features"},
		plugin = {"pretty", "html:target/cucumber-html-report"},
		glue={"com.selenium.taf.stepDefinitions"})   
public class TestRunner extends TestBase {

}
