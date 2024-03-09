# AUTOMATIZACIÓN DE PRUEBAS A SERVICIOS WEB - RESTFUL - BOOKER

### 📄 Contexto:

Booking.com es un agregador de tarifas de viaje y un metabuscador de viajes para reservas de
alojamiento. Booking.com forma parte de Booking Holdings Inc., y cuenta con más de 17.000 trabajadores
en 198 oficinas de 70 países de todo el mundo. Booking.com tiene su sede en Ámsterdam, Países Bajos.

### 🚩 Problemática:

Cada vez que se hacen cambios en la aplicación móvil de Booking.com se deben efectuar todo un conjunto
de pruebas manuales de los casos de prueba ya diseñados en sus Test Suite, con el objetivo de verificar
que ninguna funcionalidad disponible para los usuarios haya sido alterada o impactada por los nuevos
cambios implementados y desplegados en producción.

### 💡 Solución:

Para aumentar la velocidad y verificar el correcto funcionamiento de la aplicación móvil después de recibir cambios,
se plantean unos sets de pruebas automatizadas a nivel de pruebas de front de las funcionalidades que allí se ofrecen,
con el fin de
que se pueda probar de forma regular, con mayor rapidez y que así se permita identificar la mayoría de los errores
en la fase de desarrollo.

***

# ✅ PLAN DE PRUEBAS FUNCIONAL

(NIVEL API TESTING)

### RESUMEN

Este plan de pruebas muestra el detalle y organización de las pruebas funcionales de la feature:

> **FEATURE TEST PLAN**: Booking | Accommodation Service | Flujo E2E para la creación de una reserva de alojamiento en
> la app de booking.com
>
>*Como usuario de booking,  
Quiero realizar una reserva de alojamiento en el aplicativo  
Para agendar un lugar donde hospedarme en mi próximo viaje*

* Este Plan se llevará a cabo a nivel de **Pruebas funcionales y Pruebas de Regresión**.
* Este Plan se llevará a cabo en el framework **Serenity BDD** y **RestAssured** de manera automatizada.
* Este Plan se realizará para determinar **qué pruebas se harán** y **cómo se realizarán las pruebas.**

### OBJETIVO

Validar las funcionalidades básicas que puede realizar un usuario al realizar la creación de una reserva de alojamiento,
usando Serenity BDD en integración con Appium para automatizar el proceso.

### SUPUESTOS

* La app se encuentra siempre en funcionamiento.
* Acceso a la apk de la aplicación.
* Herramientas de pruebas como AndroidStudio, Appium Server y Appium Desktop correctamente instalados y configurados.
* Conocimientos en Mobile Testing.

### ALCANCE

* Capacidad de alcanzar la funcionalidad de reserva de un servicio de alojamiento.
    * No obstante, se podrá realizar pruebas adicionales en caso de tener ventaja para validar más funciones.
* Seguir las reglas de negocio sobre la reserva de alojamiento en el aplicativo.
* Contemplar mínimo un **_HAPPY PATH_** y **_UNHAPPY PATH_**.
* No se validarán los escenarios que no fueron contemplados en los flujos a probar.

### RIESGOS

| Riesgo                                                    | Mitigación                                                                                                             |
|:----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| No tener acceso a la apk del aplicativo                   | Solicitar al dev el envío de la apk.                                                                                   |
| No se tiene un dispositivo mobile real para pruebas       | Utilizar un emulador para la conexión.                                                                                 |
| No se puede realizar la conexión con el dispositivo       | Utilizar una plataforma de testeo móvil como (BrowserStack, Lambda Test, etc                                           |
| No se puede inspeccionar el dispositivo por 'secure' flag | Imprimir el Código Fuente de la pantalla con el comando **driver.getPageSource()** y realice la inspección con este código |

***

### RECURSOS

* **Android Studio**: como herramienta de apoyo para emular un dispositivo mobile.
* **Appium Server**: como herramienta para crear una sesión que permita interactuar con los dispositivos finales de las aplicaciones móviles.
* **Appium Inspector**: como herramienta de apoyo para mapear los elementos de la app. 

* **Serenity BDD en integración con Appium**: Frameworks principales para realizar la automatización de los
  scripts de pruebas.
* **Plan de pruebas**: Documento para la planificación de las pruebas.
* **APK**: Link de descarga del apk de [Booking.com](https://drive.google.com/file/d/1ruY_5qcqWlsE3-W3rgXpFyyMiO59wFUc/view?usp=sharing)

### CONFIGURACIÓN DEL AMBIENTE

* Las pruebas serán ejecutadas en un dispositivo **Android**.
* El dispositivo móvil será emulado desde **Android Studio**


### NIVELES Y TIPOS DE PRUEBA

**Niveles de pruebas:**

* Pruebas funcionales 

**Tipos de pruebas:**

* Pruebas en GUI: Para validar las nuevas funcionalidades.
* Pruebas Regresión: Para validar que todo funcione correctamente.

### CONSIDERACIONES DE LAS PRUEBAS

- [ ] Para el destino buscar la Ciudad de CUSCO. 
- [ ] Para las fechas de estadía seleccionar desde el 14/03 al 28/03 del 2024. 
- [ ] Seleccionar 1 habitación, 2 adultos y 1 niño de 5 años.
- [ ] Seleccionar el item 2 de los resultados de la búsqueda, elegir la habitación y reservar la primera opción.
- [ ] Elegir forma de pago tarjeta de crédito.
- [ ] Validar en todos los pasos posibles el costo de la reserva.
- [ ] Automatizar las funcionalidades del flujo completo de la reserva.
- [ ] Considerar la creación de escenarios Happy Paths y UnHappy Paths.
- [ ] Considerar en la automatización todas las aserciones posibles.

### FLUJOS A PROBAR (dentro de alcance)

Test diseñados para validar los escenarios **Happy Paths** 😃
***
> **✨ FEATURE**: Booking | Creación de un servicio completo de alojamiento
> - [x] [CP001] - Validar ingreso de los datos
>
> - [x] [CP002] - Validar la selección de resultados de alojamiento
>
> - [x] [CP003] - Validar el formulario de información del cliente
>
> - [x] [CP004] - Validar medio de pago y finalizacion de la reserva
***
Test diseñados para validar los escenarios **UNHappy Paths** 🤡

> **✨ FEATURE**: UnHappy Paths | Funcionamiento del servicio de alojamiento
> - [x] [CP005] - Validar que no se permita buscar un alojamiento sin seleccionar una ciudad de destino
***

### CRITERIOS DE SALIDA
> ✅ Las pruebas han terminado y no hay defectos funcionales  
> ✅ Todos los defectos restantes tienen una severidad baja

### ENTEGRABLES DE PRUEBAS

> ☑️ El plan de pruebas actual, la ruta de su ubicación es: `resources/PlanPruebas/PLAN_DE_PRUEBAS.markdown`  
> ☑️ El informe del resultado de pruebas, la ruta de su ubicación es: `target/site/serenity/serenity-summary.html`   
***

### ❗ INFORMACIÓN ADICIONAL

> *Toda la información relacionada a la estructura del proyecto se especifica en el archivo README.md*
> *Las validaciones del precio se realizan correctamente*
***