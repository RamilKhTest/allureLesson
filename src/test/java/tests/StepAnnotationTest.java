package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepAnnotationTest extends TestBaseTest {
    @Step("Открывает страницу профиля")
    public void openProfilePage() {
        open("/RamilKhTest");
    }

    @Step("В поиске вводит значение {repoName}}")
    public void setRepositoryNameInPlaceholder(String repoName) {
        $("[placeholder = Search]").click();
        $("[placeholder = Search]").setValue(repoName);
        $("[placeholder = Search]").submit();
    }

    @Step("Нажимает по ссылке {repoName}}")
    public void clickRepositoryLink(String repoName) {
        $(linkText(repoName)).click();
    }

    @Step("Нажимает на вкладку Issue")
    public void clickIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяет, что задаче под новером {IssueNumber}} соответствует название {issueName}}")
    public void checkRepositoryNumber(int issueNumber, String issueName) {
        $(String.format("#issue_%s_link", issueNumber)).shouldHave(text(issueName));
    }

}
