package com.jira.pe.definitions.login;

import com.jira.pe.steps.OneClickDeployStep;
import com.jira.pe.steps.login.LoginJiraStep;
import com.jira.pe.utilities.website.WebSite;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;
import java.util.Map;


public class OneClickDeployDef {

    @Steps(shared = true)
    WebSite url;

    @Steps(shared = true)
    LoginJiraStep login;

    @Steps(shared = true)
    OneClickDeployStep ocdsteps;


    @Given("estoy logueado en Jira Desarrollo")
    public void estoy_logueado_en_Jira_Desarrollo() {
        url.navigateTo("https://bcp-ti-sandbox-995.atlassian.net.mcas.ms/jira");

        login.continuar_proxyweb();
        login.ingresar_correo_jira("erickrgomez@bcp.com.pe");
        login.ingresar_correo_microsoft("erickrgomez@bcp.com.pe");
        login.ingresar_password_microsoft("Lima2033");
        login.continuar_atlassian();
        login.ingresar_correo_jira("erickrgomez@bcp.com.pe");
    }

    @When("selecciono crear un nuevo issue")
    public void selecciono_crear_un_nuevo_issue() throws InterruptedException {
        ocdsteps.clic_crear_incidencia();
    }
    @And("completo los campos de registro")
    public void completo_los_campos_de_registro(DataTable dataTable) throws InterruptedException {

        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        // Acceder a cada campo
        ocdsteps.seleccionar_proyecto_OCD(datos.get("Proyecto"));
        ocdsteps.seleccionar_Tipo_Actividad(datos.get("Tipo de Actividad"));
        ocdsteps.escribir_resumen_OCD(datos.get("Summary"));
        ocdsteps.seleccionar_criticicdad_express(datos.get("Criticidad OCD"));
        ocdsteps.seleccionarCategoria(datos.get("Categorías"));
        ocdsteps.seleccionarAplicacion(datos.get("Aplicación"));
        ocdsteps.seleccionarSeguridad(datos.get("Analista Seguridad"));
        ocdsteps.seleccionarQualityEngineer(datos.get("Quality Engineer"));
        ocdsteps.seleccionarProductOwner(datos.get("PO"));
        ocdsteps.seleccionarlidertecnico(datos.get("LT"));
        ocdsteps.seleccionarOPS(datos.get("OPS"));
        ocdsteps.seleccionarcldev(datos.get("CL - DEV"));
        ocdsteps.seleccionarAplicacionAgileOps(datos.get("Aplicación AgileOps"));
        ocdsteps.seleccionarGrupoAgileOps(datos.get("Grupo AgileOps"));

    }
    @Then("selecciono la opcion CREATE")
    public void selecciono_la_opcion_create() {
    }
    @And("se valida la correcta creación del issue cambio express")
    public void se_valida_la_correcta_creación_del_issue_cambio_express() {
    }

}
