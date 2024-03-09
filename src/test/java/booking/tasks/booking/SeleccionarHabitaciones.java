package booking.tasks.booking;

import booking.interactions.Pause;
import booking.questions.ObtainText;
import booking.tasks.common.scroll.ScrollById;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static booking.userinterface.accommodation_search.SelectRoomPage.*;
import static booking.utils.data.Constants.PRECIO_BOOKING;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.containsString;

public class SeleccionarHabitaciones implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleccionarHabitaciones.class.getSimpleName());

    public SeleccionarHabitaciones() {
        //Task
    }

    public static SeleccionarHabitaciones chooseRoom() {
        return instrumented(SeleccionarHabitaciones.class);

    }

    @Override
    @Step("{0} select-reserve the room")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollById.toFindTheParameters("com.booking:id/price_view_price"),
                Pause.withDuration(2));

        String precioBooking = LBL_PRECIO_ROOM.resolveFor(actor).getText();
        actor.remember(PRECIO_BOOKING, precioBooking);
        LOGGER.info("precio booking is: {}", precioBooking);

        actor.attemptsTo(
                WaitUntil.the(BTN_SELECT_ROOMS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SELECT_ROOMS));

        actor.should(seeThat(ObtainText.element(LBL_INFO_PRECIO_TOTAL), containsString(actor.recall(PRECIO_BOOKING))));

        actor.attemptsTo(
                Click.on(BTN_RESERVE_THESE_OPTION),
                Pause.withDuration(2));
    }
}