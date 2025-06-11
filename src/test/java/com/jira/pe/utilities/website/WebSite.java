package com.jira.pe.utilities.website;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;



public class WebSite {

    @Steps(shared = true)
    PageObject jira;

    @Step("Navegar al sitio web")
    public void navigateTo(String url){
        jira.setDefaultBaseUrl(url);
        jira.open();
    }

}
