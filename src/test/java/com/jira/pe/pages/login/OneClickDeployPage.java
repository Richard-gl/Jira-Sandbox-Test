package com.jira.pe.pages.login;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Page Object para la página de One Click Deploy en JIRA
 * Implementa el patrón Page Object Model con buenas prácticas de automatización
 *
 * @author Erick Gomez Quality Engineer
 * @version 2.0
 */
public class OneClickDeployPage extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(OneClickDeployPage.class);

    // ==================== CONSTANTES ====================
    private static final int SHORT_TIMEOUT_SECONDS = 10;
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
    private static final int LONG_TIMEOUT_SECONDS = 60;
    private static final int ELEMENT_INTERACTION_DELAY_MS = 6000;

    // ==================== LOCALIZADORES CENTRALIZADOS ====================
    private static final String CREATE_BUTTON_XPATH = "//button[@data-testid='atlassian-navigation--create-button']";
    private static final String PROJECT_SELECT_XPATH = "//*[@id='issue-create.ui.modal.create-form.project-picker.project-select']/div/div[2]/div/span/span";
    private static final String ISSUE_TYPE_SELECT_XPATH = "//*[@id='issue-create.ui.modal.create-form.type-picker.issue-type-select']/div[1]/div[2]/div/span";
    private static final String SUMMARY_FIELD_XPATH = "//*[@id='summary-field']";
    private static final String REACT_SELECT_LISTBOX_XPATH = "//div[contains(@id,'react-select') and contains(@id,'listbox')]";

    // Custom Fields
    private static final String CRITICALITY_COMBO_XPATH = "//*[@id='customfield_10350-container']/div/div/div[1]/div/div[1]/div[2]/div/span";
    private static final String CRITICALITY_INPUT_XPATH = "//*[@id='customfield_10350-field']";
    private static final String CATEGORY_COMBO_XPATH = "//*[@id='customfield_14275-container']/div/div/div[1]/div/div[1]/div[2]/div/span";
    private static final String CATEGORY_INPUT_XPATH = "//*[@id='customfield_14275-field']";
    private static final String APPLICATION_COMBO_XPATH = "//*[@id='customfield_10351-container']/div/div/div[1]/div/div[1]/div[2]/div/span";
    private static final String APPLICATION_INPUT_XPATH = "//*[@id='customfield_10351-field']";

    // ==================== WAIT INSTANCES ====================
    private WebDriverWait shortWait;
    private WebDriverWait defaultWait;
    private WebDriverWait longWait;

    // ==================== ELEMENTOS WEB ====================
    @FindBy(xpath = CREATE_BUTTON_XPATH)
    private WebElementFacade createIncidentButton;

    @FindBy(xpath = PROJECT_SELECT_XPATH)
    private WebElementFacade projectComboBox;

    @FindBy(xpath = ISSUE_TYPE_SELECT_XPATH)
    private WebElementFacade activityTypeComboBox;

    @FindBy(xpath = SUMMARY_FIELD_XPATH)
    private WebElementFacade summaryInput;

    @FindBy(xpath = CRITICALITY_COMBO_XPATH)
    private WebElementFacade criticalityComboBox;

    @FindBy(xpath = CRITICALITY_INPUT_XPATH)
    private WebElementFacade criticalityInput;

    @FindBy(xpath = CATEGORY_COMBO_XPATH)
    private WebElementFacade categoryComboBox;

    @FindBy(xpath = CATEGORY_INPUT_XPATH)
    private WebElementFacade categoryInput;

    @FindBy(xpath = APPLICATION_COMBO_XPATH)
    private WebElementFacade applicationComboBox;

    @FindBy(xpath = APPLICATION_INPUT_XPATH)
    private WebElementFacade applicationInput;

    // Team Members
    @FindBy(xpath = "//*[@id='customfield_10352-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade securityAnalystComboBox;

    @FindBy(xpath = "//*[@id='customfield_10352-field']")
    private WebElementFacade securityAnalystInput;

    @FindBy(xpath = "//*[@id='customfield_10353-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade qualityEngineerComboBox;

    @FindBy(xpath = "//*[@id='customfield_10353-field']")
    private WebElementFacade qualityEngineerInput;

    @FindBy(xpath = "//*[@id='customfield_10354-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade productOwnerComboBox;

    @FindBy(xpath = "//*[@id='customfield_10354-field']")
    private WebElementFacade productOwnerInput;

    @FindBy(xpath = "//*[@id='customfield_10355-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade technicalLeaderComboBox;

    @FindBy(xpath = "//*[@id='customfield_10355-field']")
    private WebElementFacade technicalLeaderInput;

    @FindBy(xpath = "//*[@id='customfield_10356-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade opsComboBox;

    @FindBy(xpath = "//*[@id='customfield_10356-field']")
    private WebElementFacade opsInput;

    @FindBy(xpath = "//*[@id='customfield_10357-container']/div/div/div[1]/div/div/div[1]/div[1]/div/span")
    private WebElementFacade clDevComboBox;

    @FindBy(xpath = "//*[@id='customfield_10357-field']")
    private WebElementFacade clDevInput;

    @FindBy(xpath = "//form/div/div[2]/div/div[19]/div/div/div[1]/div/div[1]/div/div/div[2]/div/span")
    private WebElementFacade appOpsComboBox;

    @FindBy(xpath = "//form/div/div[2]/div/div[19]/div/div/div[1]/div/div[2]/div/div/div[2]/div/span")
    private WebElementFacade opsGroupComboBox;

    // ==================== MÉTODOS PÚBLICOS ====================

    /**
     * Inicia el proceso de creación de una nueva incidencia
     * @return true si la operación fue exitosa, false en caso contrario
     */
    public boolean createIncident() {
        try {
            logger.info("Iniciando creación de incidencia");
            waitForElementToBeVisible(CREATE_BUTTON_XPATH, LONG_TIMEOUT_SECONDS);
            clickElement(createIncidentButton);
            waitForStableState();
            logger.info("Botón de crear incidencia clickeado exitosamente");
            return true;
        } catch (Exception e) {
            logger.error("Error al crear incidencia: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Selecciona un proyecto específico en el formulario de creación
     * @param projectName nombre del proyecto a seleccionar
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectProject(String projectName) {
        try {
            logger.info("Seleccionando proyecto: {}", projectName);

            waitForElementToBeVisible(PROJECT_SELECT_XPATH, DEFAULT_TIMEOUT_SECONDS);
            clickElement(projectComboBox);

            String projectLabelFor = getProjectInputId();
            WebElement projectInput = waitForElementById(projectLabelFor, DEFAULT_TIMEOUT_SECONDS);

            typeText(projectInput, projectName);
            waitForDropdownOptions();
            sendKeys(projectInput, Keys.ENTER);

            waitForStableState();
            logger.info("Proyecto '{}' seleccionado exitosamente", projectName);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar proyecto '{}': {}", projectName, e.getMessage());
            return false;
        }
    }

    /**
     * Selecciona el tipo de actividad para la incidencia
     * @param activityType tipo de actividad a seleccionar
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectActivityType(String activityType) {
        try {
            logger.info("Seleccionando tipo de actividad: {}", activityType);

            waitForElementToBeVisible(ISSUE_TYPE_SELECT_XPATH, DEFAULT_TIMEOUT_SECONDS);
            clickElement(activityTypeComboBox);

            String typeLabelFor = getActivityTypeInputId();
            WebElement typeInput = waitForElementById(typeLabelFor, DEFAULT_TIMEOUT_SECONDS);

            typeText(typeInput, activityType);
            waitForDropdownOptions();
            sendKeys(typeInput, Keys.ENTER);

            logger.info("Tipo de actividad '{}' seleccionado exitosamente", activityType);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar tipo de actividad '{}': {}", activityType, e.getMessage());
            return false;
        }
    }

    /**
     * Escribe el resumen de la incidencia
     * @param summary texto del resumen
     * @return true si la operación fue exitosa, false en caso contrario
     */
    public boolean writeSummary(String summary) {
        try {
            logger.info("Escribiendo resumen: {}", summary);
            waitForElementToBeVisible(SUMMARY_FIELD_XPATH, DEFAULT_TIMEOUT_SECONDS);
            clearAndTypeText(summaryInput, summary);
            logger.info("Resumen escrito exitosamente");
            return true;
        } catch (Exception e) {
            logger.error("Error al escribir resumen: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Selecciona la criticidad de la incidencia
     * @param criticality nivel de criticidad
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectCriticality(String criticality) {
        return selectFromComboBox(criticalityComboBox, criticalityInput,
                CRITICALITY_COMBO_XPATH, CRITICALITY_INPUT_XPATH,
                criticality, "criticidad");
    }

    /**
     * Selecciona la categoría de la incidencia
     * @param category categoría a seleccionar
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectCategory(String category) {
        return selectFromComboBox(categoryComboBox, categoryInput,
                CATEGORY_COMBO_XPATH, CATEGORY_INPUT_XPATH,
                category, "categoría");
    }

    /**
     * Selecciona la aplicación relacionada con la incidencia
     * @param application nombre de la aplicación
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectApplication(String application) {
        return selectFromComboBox(applicationComboBox, applicationInput,
                APPLICATION_COMBO_XPATH, APPLICATION_INPUT_XPATH,
                application, "aplicación");
    }

    /**
     * Selecciona el analista de seguridad
     * @param securityAnalyst nombre del analista de seguridad
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectSecurityAnalyst(String securityAnalyst) {
        return selectTeamMember(securityAnalystComboBox, securityAnalystInput,
                securityAnalyst, "analista de seguridad");
    }

    /**
     * Selecciona el Quality Engineer
     * @param qualityEngineer nombre del Quality Engineer
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectQualityEngineer(String qualityEngineer) {
        return selectTeamMember(qualityEngineerComboBox, qualityEngineerInput,
                qualityEngineer, "Quality Engineer");
    }

    /**
     * Selecciona el Product Owner
     * @param productOwner nombre del Product Owner
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectProductOwner(String productOwner) {
        return selectTeamMember(productOwnerComboBox, productOwnerInput,
                productOwner, "Product Owner");
    }

    /**
     * Selecciona el Líder Técnico
     * @param technicalLeader nombre del Líder Técnico
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectTechnicalLeader(String technicalLeader) {
        return selectTeamMember(technicalLeaderComboBox, technicalLeaderInput,
                technicalLeader, "Líder Técnico");
    }

    /**
     * Selecciona el miembro de OPS
     * @param ops nombre del miembro de OPS
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectOpsTeamMember(String ops) {
        return selectTeamMember(opsComboBox, opsInput, ops, "OPS");
    }

    /**
     * Selecciona el CL-DEV
     * @param clDev nombre del CL-DEV
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectClDev(String clDev) {
        return selectTeamMember(clDevComboBox, clDevInput, clDev, "CL-DEV");
    }

    /**
     * Selecciona el grupo de aplicaciones de AgileOps
     * @param appOps nombre del grupo de aplicaciones
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectAgileOpsApplication(String appOps) {
        try {
            logger.info("Seleccionando aplicación AgileOps: {}", appOps);

            String appOpsXpath = "//form/div/div[2]/div/div[19]/div/div/div[1]/div/div[1]/div/div/div[2]/div/span";
            waitForElementToBeVisible(appOpsXpath, DEFAULT_TIMEOUT_SECONDS);
            clickElement(appOpsComboBox);

            WebElement listBox = waitForElementToBeVisible(REACT_SELECT_LISTBOX_XPATH, DEFAULT_TIMEOUT_SECONDS);
            String dynamicId = extractDynamicNumber(listBox);

            WebElement inputElement = waitForElementById("react-select-" + dynamicId + "-input", DEFAULT_TIMEOUT_SECONDS);
            typeText(inputElement, appOps);
            sendKeys(inputElement, Keys.ENTER);

            waitForStableState();
            logger.info("Aplicación AgileOps '{}' seleccionada exitosamente", appOps);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar aplicación AgileOps '{}': {}", appOps, e.getMessage());
            return false;
        }
    }

    /**
     * Selecciona el grupo de AgileOps
     * @param opsGroup nombre del grupo de ops
     * @return true si la selección fue exitosa, false en caso contrario
     */
    public boolean selectAgileOpsGroup(String opsGroup) {
        try {
            logger.info("Seleccionando grupo AgileOps: {}", opsGroup);

            String groupOpsXpath = "//form/div/div[2]/div/div[19]/div/div/div[1]/div/div[2]/div/div/div[2]/div/span";
            waitForElementToBeVisible(groupOpsXpath, DEFAULT_TIMEOUT_SECONDS);

            WebElement listBox = null;
            try {
                listBox = getShortWait().until(ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.xpath(REACT_SELECT_LISTBOX_XPATH)));
            } catch (TimeoutException e) {
                clickElement(opsGroupComboBox);
                listBox = waitForElementToBeVisible(REACT_SELECT_LISTBOX_XPATH, DEFAULT_TIMEOUT_SECONDS);
            }

            String dynamicId = extractDynamicNumber(listBox);
            WebElement inputElement = waitForElementById("react-select-" + dynamicId + "-input", DEFAULT_TIMEOUT_SECONDS);

            typeText(inputElement, opsGroup);
            sendKeys(inputElement, Keys.ENTER);

            logger.info("Grupo AgileOps '{}' seleccionado exitosamente", opsGroup);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar grupo AgileOps '{}': {}", opsGroup, e.getMessage());
            return false;
        }
    }

    // ==================== MÉTODOS PRIVADOS AUXILIARES ====================

    /**
     * Inicializa los objetos WebDriverWait de manera thread-safe
     */
    private void initializeWaits() {
        if (defaultWait == null) {
            defaultWait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        }
        if (longWait == null) {
            longWait = new WebDriverWait(getDriver(), Duration.ofSeconds(LONG_TIMEOUT_SECONDS));
        }
        if (shortWait == null) {
            shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(SHORT_TIMEOUT_SECONDS));
        }
    }

    private WebDriverWait getShortWait() {
        initializeWaits();
        return shortWait;
    }

    private WebDriverWait getDefaultWait() {
        initializeWaits();
        return defaultWait;
    }

    private WebDriverWait getLongWait() {
        initializeWaits();
        return longWait;
    }

    /**
     * Espera a que un elemento sea visible por su xpath
     * @param xpath localizador del elemento
     * @param timeoutSeconds tiempo máximo de espera
     * @return WebElement visible
     */
    private WebElement waitForElementToBeVisible(String xpath, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * Espera a que un elemento sea visible por su ID
     * @param id identificador del elemento
     * @param timeoutSeconds tiempo máximo de espera
     * @return WebElement visible
     */
    private WebElement waitForElementById(String id, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.id(id)));
    }

    /**
     * Hace clic en un elemento de manera segura
     * @param element elemento a clickear
     */
    private void clickElement(WebElementFacade element) {
        getDefaultWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Escribe texto en un campo, limpiándolo primero
     * @param element elemento donde escribir
     * @param text texto a escribir
     */
    private void clearAndTypeText(WebElementFacade element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Escribe texto en un elemento WebElement
     * @param element elemento donde escribir
     * @param text texto a escribir
     */
    private void typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Envía teclas a un elemento
     * @param element elemento objetivo
     * @param keys teclas a enviar
     */
    private void sendKeys(WebElement element, Keys keys) {
        element.sendKeys(keys);
    }

    /**
     * Espera a que aparezcan las opciones del dropdown
     */
    private void waitForDropdownOptions() {
        getDefaultWait().until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath(REACT_SELECT_LISTBOX_XPATH)));
    }

    /**
     * Espera un tiempo corto para que el estado se estabilice
     */
    private void waitForStableState() {
        try {
            Thread.sleep(ELEMENT_INTERACTION_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Espera interrumpida: {}", e.getMessage());
        }
    }

    /**
     * Obtiene el ID del input del proyecto
     * @return ID del input del proyecto
     */
    private String getProjectInputId() {
        WebElement projectLabel = getDefaultWait().until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath("//label[contains(@for,'project-')]")));
        return projectLabel.getAttribute("for");
    }

    /**
     * Obtiene el ID del input del tipo de actividad
     * @return ID del input del tipo de actividad
     */
    private String getActivityTypeInputId() {
        WebElement typeLabel = getDefaultWait().until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath("//label[contains(@for,'type-picker-')]")));
        return typeLabel.getAttribute("for");
    }

    /**
     * Método genérico para seleccionar elementos de combo box simples
     * @param comboElement elemento combo box
     * @param inputElement elemento input
     * @param comboXpath xpath del combo
     * @param inputXpath xpath del input
     * @param value valor a seleccionar
     * @param fieldName nombre del campo para logging
     * @return true si la selección fue exitosa
     */
    private boolean selectFromComboBox(WebElementFacade comboElement, WebElementFacade inputElement,
                                       String comboXpath, String inputXpath, String value, String fieldName) {
        try {
            logger.info("Seleccionando {}: {}", fieldName, value);

            waitForElementToBeVisible(comboXpath, DEFAULT_TIMEOUT_SECONDS);
            clickElement(comboElement);

            waitForElementToBeVisible(inputXpath, DEFAULT_TIMEOUT_SECONDS);
            clearAndTypeText(inputElement, value);
            sendKeys(inputElement, Keys.ENTER);

            logger.info("{} '{}' seleccionado exitosamente", fieldName, value);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar {} '{}': {}", fieldName, value, e.getMessage());
            return false;
        }
    }

    /**
     * Método genérico para seleccionar miembros del equipo
     * @param comboElement elemento combo box
     * @param inputElement elemento input
     * @param memberName nombre del miembro del equipo
     * @param roleType tipo de rol
     * @return true si la selección fue exitosa
     */
    private boolean selectTeamMember(WebElementFacade comboElement, WebElementFacade inputElement,
                                     String memberName, String roleType) {
        try {
            logger.info("Seleccionando {}: {}", roleType, memberName);

            clickElement(comboElement);
            clearAndTypeText(inputElement, memberName);
            waitForDropdownOptions();
            sendKeys(inputElement, Keys.ENTER);

            logger.info("{} '{}' seleccionado exitosamente", roleType, memberName);
            return true;
        } catch (Exception e) {
            logger.error("Error al seleccionar {} '{}': {}", roleType, memberName, e.getMessage());
            return false;
        }
    }

    /**
     * Extrae el número dinámico del ID de un elemento react-select
     * @param element elemento del cual extraer el número
     * @return número dinámico como String
     */
    private String extractDynamicNumber(WebElement element) {
        String elementId = element.getAttribute("id");
        String dynamicNumber = elementId.replaceAll("\\D+", "");
        logger.debug("Número dinámico extraído: {} del ID: {}", dynamicNumber, elementId);
        return dynamicNumber;
    }
}