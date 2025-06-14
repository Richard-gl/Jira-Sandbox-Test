package com.jira.pe.steps;

import com.jira.pe.pages.login.OneClickDeployPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;


public class OneClickDeployStep extends ScenarioSteps {

    OneClickDeployPage ocdpage;

    @Step("Click en crear incidencia")
    public void clic_crear_incidencia() throws InterruptedException {
        ocdpage.createIncident();

    }

    @Step("seleccionar proyecto OCD")
    public void seleccionar_proyecto_OCD(String proyecto) throws InterruptedException {
        ocdpage.selectProject(proyecto);
    }
    @Step("Seleccionar Tipo Actividad")
    public void seleccionar_Tipo_Actividad(String actividad){
        ocdpage.selectActivityType(actividad);
    }

    @Step("Escribir resumen (Summary): '{0}'")
    public void escribir_resumen_OCD(String resumen){
        ocdpage.writeSummary(resumen);
        Serenity.takeScreenshot();
        Serenity.recordReportData().withTitle("Resumen de la Incidencia").andContents(resumen);
    }
    @Step("Seleccionar Criticidad Express")
    public void seleccionar_criticicdad_express(String criticidad){
        ocdpage.selectCriticality(criticidad);
    }
    @Step("Seleccionar Categoria")
    public void seleccionarCategoria(String categoria){
        ocdpage.selectCategory(categoria);
    }
    @Step("Seleccionar Aplicación")
    public void seleccionarAplicacion(String aplicacion){
        ocdpage.selectApplication(aplicacion);
    }

    @Step("Seleccionar Analista Seguridad")
    public void seleccionarSeguridad(String seguridad){
        ocdpage.selectSecurityAnalyst(seguridad);
    }
    @Step("Seleccionar Quality Engineer")
    public void seleccionarQualityEngineer(String quality){
        ocdpage.selectQualityEngineer(quality);
    }

    @Step("Seleccionar Product Owner")
    public void seleccionarProductOwner(String po){
        ocdpage.selectProductOwner(po);
    }

    @Step("Seleccionar Lider Tecnico")
    public void seleccionarlidertecnico(String lidertecnico){
        ocdpage.selectTechnicalLeader(lidertecnico);
    }

    @Step("Seleccionar OPS")
    public void seleccionarOPS(String ops){
        ocdpage.selectOpsTeamMember(ops);
    }

    @Step("Seleccionar CL-Dev")
    public void seleccionarcldev(String cldev){
        ocdpage.selectClDev(cldev);
    }

    @Step("Seleccionar Aplicacion AgileOps")
    public void seleccionarAplicacionAgileOps(String appOps) throws InterruptedException {
        ocdpage.selectAgileOpsApplication(appOps);
    }
    @Step("Seleccionar Grupo AgileOps")
    public void seleccionarGrupoAgileOps(String grupoOps){
        ocdpage.selectAgileOpsGroup(grupoOps);
    }



}
