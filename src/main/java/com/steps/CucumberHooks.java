package com.steps;

import com.backend.reports.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CucumberHooks {

	@Before
	public void beforeScenario(Scenario scenario){
		Reporter.startParent(scenario.getName(), scenario.getName());
	}
}
