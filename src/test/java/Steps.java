import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps extends TestBase {

        @Step("Открыть главную страницу")
        public void openMainPage() {
            open("https://github.com");
        }
        @Step("Вполнить поиск по eroshenkoam/allure-example")
        public void searchForRepository() {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();
        }
        @Step("Перейти по ссылке в репозиторий")
        public void clickRepo() {
            $(linkText("eroshenkoam/allure-example")).click();
        }
        @Step("Открыть таб Issues")
        public void openIssuesTab() {
            $("#issues-tab").click();
        }
        @Step("Проверbnm наличие Issue с номером 89")
        public void shouldSeeIssueWithNumber() {
            $(withText("#89")).should(Condition.exist);
        }


}
