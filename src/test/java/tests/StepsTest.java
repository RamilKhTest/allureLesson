package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBaseTest {
    private static final String repoName = "RamilKhTest/allureLesson";
    private static final int issueNumber = 1;
    private static final String issueName = "New issue first";

    @Test
    public void stepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открывает страницу профиля", () -> {
            open("/RamilKhTest");
        });

        step("В поиске вводит значение" + repoName, () -> {
            $("[placeholder = Search]").click();
            $("[placeholder = Search]").setValue(repoName);
            $("[placeholder = Search]").submit();
        });

        step("Нажимает по ссылке" + repoName, () -> {
            $(linkText(repoName)).click();
        });

        step("Нажимает на вкладку Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверяет, что задаче под новером" + issueNumber +  "соответствует название" + issueName, () -> {
            $(String.format("#issue_%s_link", issueNumber)).shouldHave(text(issueName));
        });
    }

    @Test
    public void stepsWithAnnotationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepAnnotationTest steps = new StepAnnotationTest();

        steps.openProfilePage();
        steps.setRepositoryNameInPlaceholder(repoName);
        steps.clickRepositoryLink(repoName);
        steps.clickIssue();
        steps.checkRepositoryNumber(issueNumber, issueName);
    }
}

