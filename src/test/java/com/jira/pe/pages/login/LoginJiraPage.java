package com.jira.pe.pages.login;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginJiraPage extends PageObject {

    @FindBy(id = "username")
    protected WebElementFacade input_correo_login_jira;

    @FindBy(id = "login-submit")
    protected WebElementFacade button_login_jira;

    @FindBy(id = "i0116")
    protected WebElementFacade input_correo_microsoft;

    @FindBy(id = "i0118")
    protected WebElementFacade input_password_microsoft;

    @FindBy(id = "proxyweb-dismiss-btn-main")
    private WebElementFacade boton_continuar_proxyweb;

    @FindBy(id = "hiddenformSubmitBtn")
    private WebElementFacade boton_continuar_atlassian;

    @FindBy(xpath = "//div[contains(text(), 'bcp-ti-sandbox-995')]")
    private WebElementFacade jira_bcp_ti_sandbox;

    public void ingresar_correo_microsoft(String correo_microsoft){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));

        input_correo_microsoft.sendKeys(correo_microsoft);
        input_correo_microsoft.sendKeys(Keys.ENTER);

    }
    public void ingresar_password_microsoft(String password_microsoft){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));

        input_password_microsoft.sendKeys(password_microsoft);
        input_password_microsoft.sendKeys(Keys.ENTER);
    }

    public void continuar_proxyweb(){
        boton_continuar_proxyweb.waitUntilVisible().click();
    }
    public void ingresar_correo_jira(String correo_jira){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        input_correo_login_jira.sendKeys(correo_jira);
        button_login_jira.click();
    }

    public void continuar_atlassian(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenformSubmitBtn")));

        boton_continuar_atlassian.waitUntilVisible().click();
    }

    /*
    public void ir_jira_sandbox(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'bcp-ti-sandbox-995')]")));

        jira_bcp_ti_sandbox.click();
    }*/
}
