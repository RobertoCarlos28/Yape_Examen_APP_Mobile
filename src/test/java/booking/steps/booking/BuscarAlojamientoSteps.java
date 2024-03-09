package booking.steps.booking;

import booking.questions.IsEnabled;
import booking.tasks.booking.SeleccionarDestinoAlojamiento;
import booking.tasks.booking.SeleccionarHabitaciones;
import booking.tasks.common.scroll.Scroll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.accommodation_search.ViewBookingPage.RESULTADO_BOOKING;
import static booking.userinterface.user_data.UserDataPage.INPUT_NOMBRE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class BuscarAlojamientoSteps {
    @Cuando("el usuario selecciona la opción de alojamiento {string}, {string}, {string} y {string}")
    public void elUsuarioSeleccionaLaOpciónDeAlojamiento(String ciudad, String fechaInicio, String fechaFin, String anios) {
        USUARIO.attemptsTo(SeleccionarDestinoAlojamiento.withCustomerData(ciudad,fechaInicio,fechaFin,anios));

        USUARIO.attemptsTo(
                Scroll.toElement(),
                Click.on(RESULTADO_BOOKING));
    }

    @Entonces("elige y reserva su habitacion")
    public void eligeYReservaSuHabitacion() {
        USUARIO.attemptsTo(SeleccionarHabitaciones.chooseRoom());
        USUARIO.should(seeThat(IsEnabled.theTarget(INPUT_NOMBRE), equalTo(true)));
    }
}
