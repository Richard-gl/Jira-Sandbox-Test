@Suite
Feature: Regresión One Click Deploy

Background: Iniciar Sesión Jira Desarrollo

  Given estoy logueado en Jira Desarrollo

@INCTDIS-2778 @regresion @OCD
Scenario: [INCT] Validar creación de issue de tipo criticidad OCD cambio express Diversos en OCD - [OK]

  When selecciono crear un nuevo issue
  And completo los campos de registro
    | Campo               | Valor                |
    | Proyecto            | One Click Deploy     |
    | Tipo de Actividad   | Story OCD            |
    | Summary             | PRUEBA DIVERSOS      |
    | Criticidad OCD      | Cambio Express       |
    | Categorías          | Seguridad            |
    | Aplicación          | INCT                 |
    | Analista Seguridad  | APNCPRORD@bcp.com.pe |
    | Quality Engineer    | APNCPRORD@bcp.com.pe |
    | PO                  | APNCPRORD@bcp.com.pe |
    | LT                  | APNCPRORD@bcp.com.pe |
    | OPS                 | APNCPRORD@bcp.com.pe |
    | CL - DEV            | APNCPRORD@bcp.com.pe |
    | Aplicación AgileOps | INCT                 |
    | Grupo AgileOps      | SelfServices         |
  Then selecciono la opcion CREATE
  And se valida la correcta creación del issue cambio express

