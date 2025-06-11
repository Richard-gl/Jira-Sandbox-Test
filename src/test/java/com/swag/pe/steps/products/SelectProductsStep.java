package com.swag.pe.steps.products;

import com.swag.pe.pages.products.SelectProductPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SelectProductsStep extends ScenarioSteps {

    SelectProductPage selectProductPage;

    @Step("Agregar productos al carrito de compras")
    public void addProductos(int quantity){
        selectProductPage.addProductToCart(quantity);
    }

    @Step("Click en el icono de carrito de compra")
    public void clickShoppingCartIcon(){
        selectProductPage.clickShoppingCartIcon();
    }
}
