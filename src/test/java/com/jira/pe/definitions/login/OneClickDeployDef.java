package com.jira.pe.definitions.login;

import com.jira.pe.steps.login.LoginJiraStep;
import com.jira.pe.utilities.website.WebSite;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OneClickDeployDef {

    @Steps(shared = true)
    WebSite url;

    @Steps(shared = true)
    LoginJiraStep login;

    private WebDriver driver;



    @Given("estoy logueado en Jira Desarrollo")
    public void estoy_logueado_en_Jira_Desarrollo() throws InterruptedException {
        url.navigateTo("https://bcp-ti-sandbox-995.atlassian.net.mcas.ms/jira");

        login.continuar_proxyweb();
        login.ingresar_correo_jira("erickrgomez@bcp.com.pe");
        login.ingresar_correo_microsoft("erickrgomez@bcp.com.pe");
        login.ingresar_password_microsoft("Lima2033");
        login.continuar_atlassian();
        login.ingresar_correo_jira("erickrgomez@bcp.com.pe");
    }

}
