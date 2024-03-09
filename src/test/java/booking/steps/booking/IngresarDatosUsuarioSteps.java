package booking.steps.booking;

import booking.interactions.Pause;
import booking.questions.IsEnabled;
import booking.tasks.booking.InformacionUsuario;
import booking.tasks.booking.SeleccionarDestinoAlojamiento;
import booking.tasks.booking.SeleccionarHabitaciones;
import booking.tasks.booking.ValidarInformacionReserva;
import booking.tasks.common.scroll.Scroll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.accommodation_search.ViewBookingPage.RESULTADO_BOOKING;
import static booking.userinterface.info_booking.InfoBookingPages.BTN_FINAL_STEP;
import static booking.userinterface.user_data.UserDataPage.INPUT_NOMBRE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class IngresarDatosUsuarioSteps {

    @Dado("que el usuario se encuentra en la pantalla de ingreso {string}, {string}, {string} y {string}")
    public void queElUsuarioSeEncuentraEnLaPantallaDeIngreso(String ciudad, String fechaInicio, String fechaFin, String anios) {
        USUARIO.attemptsTo(SeleccionarDestinoAlojamiento.withCustomerData(ciudad,fechaInicio,fechaFin,anios));

        USUARIO.attemptsTo(Scroll.toElement(), Click.on(RESULTADO_BOOKING));
        USUARIO.attemptsTo(SeleccionarHabitaciones.chooseRoom());
        USUARIO.should(seeThat(IsEnabled.theTarget(INPUT_NOMBRE), equalTo(true)));
    }

    @Cuando("el usuario ingresa sus datos personales en el formulario")
    public void elUsuarioIngresaSusDatosPersonalesEnElFormulario() {
        USUARIO.attemptsTo(InformacionUsuario.withTheFollowingFields());
    }

    @Entonces("valida la cantidad a pagar {string}, fecha de inicio {string} y fecha fin {string}")
    public void validaLaCantidadAPagarFechaDeInicioYFechaFin(String precio, String checkIn, String checkOut) {
        USUARIO.attemptsTo(ValidarInformacionReserva.inTheResume(precio,checkIn,checkOut), Click.on(BTN_FINAL_STEP), Pause.withDuration(2));
    }
}


