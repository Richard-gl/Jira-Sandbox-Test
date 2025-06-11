package com.jira.pe.pages.validations;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ValidationPage extends PageObject {

    @FindBy(xpath = "//div[@class='product_label']")
    protected WebElementFacade lbl_product;

    @FindBy(xpath = "//h3[@data-test='error' and 'Username and password do not match any user in this service']")
    protected WebElementFacade lbl_errorMessage;

    public boolean isProductLabelVisible() {
        return lbl_product.isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        return lbl_errorMessage.isDisplayed();
    }

}

