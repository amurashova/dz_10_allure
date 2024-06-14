import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepsTest extends TestBase {
    @Test
    void searchIssueAnnotatedStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        steps.openMainPage();
        steps.searchForRepository();
        steps.clickRepo();
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber();
    }
}
