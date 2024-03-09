package booking.steps.booking;

import booking.interactions.Pause;
import booking.questions.IsEnabled;
import booking.tasks.booking.*;
import booking.tasks.common.scroll.Scroll;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.accommodation_search.ViewBookingPage.RESULTADO_BOOKING;
import static booking.userinterface.info_booking.InfoBookingPages.BTN_FINAL_STEP;
import static booking.userinterface.payment_method.FinishBookingPage.BTN_BOOK_NOW;
import static booking.userinterface.user_data.UserDataPage.INPUT_NOMBRE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SeleccionarMedioPagoSteps {

    @Dado("que el usuario se encuentra en la pantalla de  medio de pago con estos datos {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void queElUsuarioSeEncuentraEnLaPantallaDeMedioDePagoConEstosDatos(String ciudad, String fechaInicio, String fechaFin, String anios, String precio, String checkIn, String checkOut) {
        USUARIO.attemptsTo(SeleccionarDestinoAlojamiento.withCustomerData(
                ciudad,
                fechaInicio,
                fechaFin,
                anios));
        USUARIO.should(seeThat(IsEnabled.theTarget(RESULTADO_BOOKING), equalTo(true)));
        USUARIO.attemptsTo(Scroll.toElement(), Click.on(RESULTADO_BOOKING));
        USUARIO.attemptsTo(SeleccionarHabitaciones.chooseRoom());
        USUARIO.should(seeThat(IsEnabled.theTarget(INPUT_NOMBRE), equalTo(true)));
        USUARIO.attemptsTo(InformacionUsuario.withTheFollowingFields());
        USUARIO.attemptsTo(ValidarInformacionReserva.inTheResume(precio, checkIn, checkOut), Click.on(BTN_FINAL_STEP), Pause.withDuration(5));

    }

    @Cuando("el usuario ingresa el número de su tarjeta {string} y la fecha de expedición {string}")
    public void elUsuarioIngresaElNúmeroDeSuTarjetaYLaFechaDeExpedición(String cardNumber, String expirationDate) {
        USUARIO.attemptsTo(SeleccionarMetodoPago.withTheFollowingFields(cardNumber, expirationDate));
    }

    @Entonces("finalizara correctamente su reserva")
    public void finalizaraCorrectamenteSuReserva() {
        USUARIO.attemptsTo(Click.on(BTN_BOOK_NOW), Pause.withDuration(25));
    }
}


