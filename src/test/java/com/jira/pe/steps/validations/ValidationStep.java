package com.jira.pe.steps.validations;

import com.jira.pe.pages.validations.ValidationPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class ValidationStep extends ScenarioSteps {

    ValidationPage validationPage;

    @Step("Validar visualizacion del modulo de productos")
    public boolean titleisVisible() {
        return validationPage.isProductLabelVisible();
    }

    @Step("Validar visualizacion del mensaje de error")
    public boolean errorMessageIsDisplayed() {
        return validationPage.isErrorMessageVisible();
    }





}
