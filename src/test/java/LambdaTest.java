import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {
        @Test
        public void issueSearchSLambdaTest() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            step("Открыть главную страницу", () -> {
                    open("");
        });
            step("Вполнить поиск по eroshenkoam/allure-example", () -> {
                    $(".header-search-button").click();
                    $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
                    $("#query-builder-test").submit();
            });
            step("Перейти по ссылке в репозиторий", () -> {
                    $(linkText("eroshenkoam/allure-example")).click();
            });
            step("Открыть таб Issues", () -> {
                    $("#issues-tab").click();
            });
            step("Проверить наличие Issue с номером 89", () -> {
            $(withText("#89")).should(Condition.exist);
            });
        }

    }

