package booking.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(publish = true,
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "booking.steps",
        tags = "@TestException",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
}
