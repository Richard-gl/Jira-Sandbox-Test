package com.swag.pe.definitions.shopping;

import com.swag.pe.steps.products.SelectProductsStep;
import com.swag.pe.steps.validations.ValidationStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class ShoppingDef {

    @Steps(shared = true)
    SelectProductsStep selectProduct;

    @Steps(shared = true)
    ValidationStep validate;

    @And("agregar productos al carrito de compras")
    public void userAddProducts(){
        selectProduct.addProductos(3);
    }

    @And("da click en el icono del carrito")
    public void userClickShoppingCartIcon(){
        selectProduct.clickShoppingCartIcon();
    }

    @Then("el sistema deberia listar los productos agregados en el carrito de compras")
    public void systemListProducts(){
        Assert.assertTrue(validate.productsAreDisplayed());
    }
}
