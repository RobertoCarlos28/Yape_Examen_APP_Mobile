package booking.steps.booking;

import booking.questions.IsEnabled;
import booking.tasks.booking.SeleccionarDestinoAlojamiento;
import booking.tasks.common.scroll.Scroll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.accommodation_search.ViewBookingPage.RESULTADO_BOOKING;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class IngresarDatosReservaSteps {

    @Cuando("el usuario ingresa los datos para la búsqueda de su alojamiento {string}, {string}, {string} y {string}")
    public void elUsuarioIngresaLosDatosParaLaBúsquedaDeSuAlojamiento(String ciudad, String fechaInicio, String fechaFin, String anios) {
        USUARIO.attemptsTo(SeleccionarDestinoAlojamiento.withCustomerData(ciudad,fechaInicio,fechaFin,anios));
    }
    @Entonces("deberá visualizar la lista de resultados de alojamientos disponibles")
    public void selectDestinationOption() {
        USUARIO.attemptsTo(Scroll.toElement());
        USUARIO.should(seeThat(IsEnabled.theTarget(RESULTADO_BOOKING), equalTo(true)));
    }


}

