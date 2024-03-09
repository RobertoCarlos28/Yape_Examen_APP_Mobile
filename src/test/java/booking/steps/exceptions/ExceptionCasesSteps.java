package booking.steps.exceptions;

import booking.questions.IsEnabled;
import booking.questions.ObtainText;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.stays.HomePage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExceptionCasesSteps {

    @Cuando("el usuario selecciona la opción de buscar sin colocar la cuidad de destino")
    public void elUsuarioSeleccionaLaOpciónDeBuscarSinColocarLaCuidadDeDestino() {
        USUARIO.should(seeThat(IsEnabled.theTarget(SEARCH_FIELDS), equalTo(true)));
        USUARIO.attemptsTo(Click.on(SEARCH_BOX_ACCOMMODATION));
    }

    @Entonces("debera visualizar el mensaje de {string}")
    public void viewErrorMessage(String message) {
        USUARIO.should(seeThat(ObtainText.element(ALERT_MESSAGE_ERROR), containsString(message)));
    }


}
