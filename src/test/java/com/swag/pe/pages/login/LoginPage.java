package com.swag.pe.pages.login;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {


    @FindBy(id = "user-name")
    protected WebElementFacade txt_username;

    @FindBy(id = "password")
    protected WebElementFacade txt_password;

    @FindBy(id = "login-button")
    protected WebElementFacade btn_login;

    public void enterUsername(String username) {
        txt_username.waitUntilVisible().sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.waitUntilVisible().sendKeys(password);
    }

    public void clickLoginButton() {
        btn_login.waitUntilClickable().click();
    }

}
