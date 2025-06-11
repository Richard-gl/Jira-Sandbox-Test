package com.swag.pe.pages.products;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


public class SelectProductPage extends PageObject {

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    protected List<WebElementFacade> products;

    @FindBy(xpath = "//*[local-name()='svg']//ancestor::a")
    protected WebElementFacade shoppingCartIcon;

    public void addProductToCart(int index) {
        for (int i=0; i<index;i++){
            Actions act = new Actions(getDriver());
            act.click(products.get(i)).perform();
        }
    }

    public void clickShoppingCartIcon() {
        shoppingCartIcon.waitUntilClickable().click();
    }


}
