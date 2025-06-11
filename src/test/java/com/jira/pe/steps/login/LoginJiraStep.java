package com.jira.pe.steps.login;


import com.jira.pe.pages.login.LoginJiraPage;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginJiraStep extends ScenarioSteps {

    LoginJiraPage login;


    @Step("continuar_proxyweb")
    public void continuar_proxyweb(){
        login.continuar_proxyweb();
    }

    @Step("ingresar Correo Jira")
    public void ingresar_correo_jira(String correo_jira){
        login.ingresar_correo_jira(correo_jira);
    }

    @Step("Ingreso Correo Microsoft")
    public void ingresar_correo_microsoft(String correo_microsoft){
        login.ingresar_correo_microsoft(correo_microsoft);
    }

    @Step("Ingreso Password Microsoft")
    public void ingresar_password_microsoft(String password_microsoft){
        login.ingresar_password_microsoft(password_microsoft);
    }

    @Step("Continuar Atlassian")
    public void continuar_atlassian(){
        login.continuar_atlassian();
    }

    /*
    @Step("Ir Jira Sandbox")
    public void ir_jira_sandbox(){
        login.ir_jira_sandbox();
    }*/



}
