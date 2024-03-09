# language: es

Necesidad del negocio: Creación de un servicio de alojamiento
  Como usuario,
  quiero utilizar el servicio de reservas,
  para buscar una opción de alojamiento

  Antecedentes: Ingresar a la pestaña de Stays
    Dado que el usuario se encuentra en la opción de Stays

  @apk_booking
  Escenario: [CP001] - Validar ingreso de los datos
    Cuando el usuario ingresa los datos para la búsqueda de su alojamiento "Cusco", "14 March 2024", "28 March 2024" y "5 years old"
    Entonces deberá visualizar la lista de resultados de alojamientos disponibles

  @apk_booking
  Escenario: [CP002] - Validar la selección de resultados de alojamiento
    Cuando el usuario selecciona la opción de alojamiento "Cusco", "14 March 2024", "28 March 2024" y "5 years old"
    Entonces elige y reserva su habitacion

  @apk_booking
  Esquema del escenario: [CP003] - Validar el formulario de información del cliente
    Dado que el usuario se encuentra en la pantalla de ingreso "Cusco", "14 March 2024", "28 March 2024" y "5 years old"
    Cuando el usuario ingresa sus datos personales en el formulario
    Entonces valida la cantidad a pagar "<Precio>", fecha de inicio "<Check-in>" y fecha fin "<Check-Out>"
    Ejemplos:
      | Precio    | Check-in          | Check-Out       |
      | US$6,909  | Thu March 14 2024 | Thu Mar 28 2024 |

  @apk_booking
  Esquema del escenario: [CP004] - Validar medio de pago y finalizacion de la reserva
    Dado que el usuario se encuentra en la pantalla de  medio de pago con estos datos "Cusco", "14 March 2024", "28 March 2024", "5 years old", "US$6,909", "Thu March 14 2024","Thu Mar 28 2024"
    Cuando el usuario ingresa el número de su tarjeta "<numeroTarjeta>" y la fecha de expedición "<fechaExpiracion>"
    Entonces finalizara correctamente su reserva
    Ejemplos:
      | numeroTarjeta       | fechaExpiracion |
      | 4078550001800976    | 02/26          |