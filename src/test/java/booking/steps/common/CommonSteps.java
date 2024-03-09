package booking.steps.common;

import booking.tasks.common.LoadDataTask;
import booking.tasks.common.NavigateTo;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static booking.models.UserInfoModel.userInformation;
import static booking.steps.conf.Hooks.USUARIO;
import static booking.userinterface.stays.HomePage.SEARCH_FIELDS;

public class CommonSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonSteps.class.getSimpleName());


    @Dado("que el usuario se encuentra en la opción de Stays")
    public void queElUsuarioSeEncuentraEnLaOpciónDeStays() {
        USUARIO.attemptsTo(
                NavigateTo.theStaysTab(),
                Ensure.that(SEARCH_FIELDS).isEnabled()
        );
        USUARIO.wasAbleTo(LoadDataTask.informationBooking(userInformation()));

        LOGGER.info("El usuario es: {}", userInformation().values());
    }
}
