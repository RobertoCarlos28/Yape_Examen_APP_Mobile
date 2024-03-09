# language: es
Necesidad del negocio: Funcionamiento del servicio de alojamiento
  Como usuario,
  quiero utilizar el servicio de reservas correctamente

  Antecedentes: Ingresar a la pestaña de Stays
    Dado que el usuario se encuentra en la opción de Stays

  @apk_booking @Unhappy_test
  Escenario: [CP005] - Validar que no se permita buscar un alojamiento sin seleccionar una ciudad de destino
    Cuando el usuario selecciona la opción de buscar sin colocar la cuidad de destino
    Entonces debera visualizar el mensaje de "Please enter your destination"