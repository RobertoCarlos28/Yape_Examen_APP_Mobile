package booking.userinterface.accommodation_search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ViewBookingPage {
    public static final Target RESULTADO_BOOKING = Target.the("result booking with name")
            .located(By.xpath("//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));

    private ViewBookingPage() {
    }
}
