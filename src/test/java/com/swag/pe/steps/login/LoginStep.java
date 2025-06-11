package com.swag.pe.steps.login;

import com.swag.pe.pages.login.LoginPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class LoginStep extends ScenarioSteps {

    LoginPage loginPage;

    @Step("Ingresar usuario {0}")
    public void typeUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Step("Ingresar contraseña {0}")
    public void typePassword(String password) {
        loginPage.enterPassword(password);
    }

    @Step("Click en el boton login")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }


}
