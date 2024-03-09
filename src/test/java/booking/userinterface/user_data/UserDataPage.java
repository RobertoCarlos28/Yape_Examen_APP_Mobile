package booking.userinterface.user_data;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UserDataPage {
    public static final Target INPUT_NOMBRE = Target.the("text box for first name")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_firstname_value']/android.widget.EditText"));
    public static final Target INPUT_APELLIDO = Target.the("text box for last name")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_lastname_value']/android.widget.EditText"));
    public static final Target INPUT_EMAIL = Target.the("text box for email")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_email_value']/android.widget.AutoCompleteTextView"));
    public static final Target INPUT_DIRECCION = Target.the("text box for direccion")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_address_value']/android.widget.EditText"));
    public static final Target INPUT_CODIGO_POSTAL = Target.the("text box for zip code")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_zipcode_value']/android.widget.EditText"));
    public static final Target INPUT_CIUDAD = Target.the("text box for ciudad")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_city_value']/android.widget.EditText"));
    public static final Target INPUT_PAIS = Target.the("text box for country/region")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_country_value']/android.widget.AutoCompleteTextView"));
    public static final Target INPUT_TELEFONO = Target.the("text box for mobile telefono")
            .located(By.xpath("//javaClass[@resource-id='com.booking:id/bstage1_contact_telephone_value']/android.widget.EditText"));
    public static final Target RADIO_BTN_HOBBIE = Target.the("radio button leisure")
            .located(By.xpath("//android.widget.RadioButton[@resource-id='com.booking:id/business_purpose_leisure']"));
    public static final Target LBL_PRECIO = Target.the("label with the PRECIO total")
            .located(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/title']"));
    public static final Target BTN_NEXT_STEP = Target.the("button next step")
            .located(By.xpath("//android.widget.Button[@resource-id='com.booking:id/action_button']"));

    private UserDataPage() {
        //Nothing
    }
}
