package booking.steps.conf;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    public static final Actor USUARIO = Actor.named("USUARIO");
    @Steps(shared = true)
    SharedComponents sharedComponents;

    @Before
    public void setup(Scenario scenario) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("deviceName", "AutomationTesting");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/apk/booking-com-32-9.apk");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        sharedComponents.setDriver(driver);

        OnStage.setTheStage(new OnlineCast());
        USUARIO.whoCan(BrowseTheWeb.with(driver));
    }
}
