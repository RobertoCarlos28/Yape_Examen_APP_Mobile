package booking.tasks.booking;

import booking.interactions.Pause;
import booking.questions.ObtainText;
import booking.tasks.common.scroll.Scroll;
import booking.utils.data.BookingData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static booking.interactions.HideKeyboard.theActorHidesKeyboard;
import static booking.userinterface.user_data.UserDataPage.*;
import static booking.utils.data.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.containsString;

public class InformacionUsuario implements Task {


    public InformacionUsuario() {
    }

    public static InformacionUsuario withTheFollowingFields() {
        return instrumented(InformacionUsuario.class);
    }

    @Override
    @Step("{0} fill in your info")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(INPUT_NOMBRE, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(INPUT_NOMBRE),
                Enter.theValue(BookingData.getData().get(NOMBRE).toString()).into(INPUT_NOMBRE),

                Click.on(INPUT_APELLIDO),
                Enter.theValue(BookingData.getData().get(APELLIDO).toString()).into(INPUT_APELLIDO),

                Click.on(INPUT_EMAIL),
                Enter.theValue(BookingData.getData().get(EMAIL).toString()).into(INPUT_EMAIL),
                theActorHidesKeyboard(),

                Click.on(INPUT_DIRECCION),
                Enter.theValue(BookingData.getData().get(DIRECCION).toString()).into(INPUT_DIRECCION),
                theActorHidesKeyboard(),

                Scroll.toElement(),
                Pause.withDuration(1),

                Click.on(INPUT_CODIGO_POSTAL),
                Enter.theValue(BookingData.getData().get(CODIGO_POSTAL).toString()).into(INPUT_CODIGO_POSTAL),
                theActorHidesKeyboard(),

                Click.on(INPUT_CIUDAD),
                Enter.theValue(BookingData.getData().get(CIUDAD).toString()).into(INPUT_CIUDAD),
                theActorHidesKeyboard(),

                Click.on(INPUT_PAIS),
                Clear.field(INPUT_PAIS),
                Enter.theValue(BookingData.getData().get(PAIS).toString()).into(INPUT_PAIS),
                theActorHidesKeyboard(),

                Click.on(INPUT_TELEFONO),
                Clear.field(INPUT_TELEFONO),
                Enter.theValue(BookingData.getData().get(TELEFONO).toString()).into(INPUT_TELEFONO),
                theActorHidesKeyboard(),

                Scroll.toElement(),
                Click.on(RADIO_BTN_HOBBIE)
        );

        actor.should(seeThat(ObtainText.element(LBL_PRECIO), containsString(actor.recall(PRECIO_BOOKING))));

        actor.attemptsTo(Click.on(BTN_NEXT_STEP), Pause.withDuration(5), Scroll.toElement());
    }
}