package com.jira.pe;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Jira",
        glue = "com.jira.pe.definitions",
        tags = "@regresion"
)
public class Runner {
}
