package booking.tasks.booking;

import booking.interactions.Pause;
import booking.tasks.common.scroll.Scroll;
import booking.tasks.common.scroll.ScrollByIdAndText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static booking.interactions.HideKeyboard.theActorHidesKeyboard;
import static booking.userinterface.stays.AccommodationDatesPage.*;
import static booking.userinterface.stays.AccommodationDestinationPage.INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static booking.userinterface.stays.AccommodationDestinationPage.SELECT_ACCOMMODATION_DESTINATION;
import static booking.userinterface.stays.AccommodationOccupancyPage.*;
import static booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMMODATION_DESTINATION;
import static booking.userinterface.stays.HomePage.SEARCH_BOX_ACCOMODATION_OCCUPANCY;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class SeleccionarDestinoAlojamiento implements Task {

    private final String ciudad;
    private final String fechaInicio;
    private final String fechaFin;
    private final String anios;

    public SeleccionarDestinoAlojamiento(String ciudad, String fechaInicio, String fechaFin, String anios) {
        this.ciudad = ciudad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.anios = anios;
    }

    public static SeleccionarDestinoAlojamiento withCustomerData(String ciudad, String fechaInicio, String fechaFin, String anios) {
        return instrumented(SeleccionarDestinoAlojamiento.class, ciudad, fechaInicio, fechaFin, anios);
    }

    @Override
    @Step("{0} enters-select search information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMMODATION_DESTINATION),

                WaitUntil.the(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                SendKeys.of(ciudad).into(INPUT_SEARCH_BOX_ACCOMMODATION_DESTINATION),
                Pause.withDuration(1),
                theActorHidesKeyboard(),

                WaitUntil.the(SELECT_ACCOMMODATION_DESTINATION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SELECT_ACCOMMODATION_DESTINATION)
        );

        actor.attemptsTo(
                Click.on(CALENDAR_MONTH_LIST),
                Scroll.toElement(),
                Click.on(SELECT_START_DATE.of(fechaInicio)),
                Click.on(SELECT_END_DATE.of(fechaFin)),

                Pause.withDuration(2),
                Click.on(BTN_CONFIRM_DATES)
        );

        actor.attemptsTo(
                WaitUntil.the(SEARCH_BOX_ACCOMODATION_OCCUPANCY, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(SEARCH_BOX_ACCOMODATION_OCCUPANCY),

                WaitUntil.the(BTN_SELECT_CHILDREN_OPTION, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SELECT_CHILDREN_OPTION),

                ScrollByIdAndText.toFindTheParameters("android:id/numberpicker_input", anios),
                Click.on(BTN_OK),

                WaitUntil.the(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_CONFIRM_SELECT_ROOMS_AND_GUESTS),

                Click.on(BTN_SEARCH),
                Pause.withDuration(2)
        );
    }
}