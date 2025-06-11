@Suite
Feature: Regresión One Click Deploy

Background: Iniciar Sesión Jira Desarrollo

  Given estoy logueado en Jira Desarrollo

@INCTDIS-2778 @regresion @OCD
Scenario: [INCT] Validar creación de issue de tipo criticidad OCD cambio express Diversos en OCD - [OK]

  Given que me encuentro en el tablero OneClickDeploy
  When selecciono crear un nuevo issue
  And completo los campos de registro
  |Project|Issue type|Summary|Criticidad OCD|Categorías|Aplicación|PO|Aplicación-Grupo AgileOps|
  |OneClickDeploy|StoryOCD|PRUEBA DIVERSOS|Cambio Express|Seguridad|DEMO|APNCPRORD@bcp.com.pe|INCT|
  Then selecciono la opcion CREATE
  And se valida la correcta creación del issue cambio express

