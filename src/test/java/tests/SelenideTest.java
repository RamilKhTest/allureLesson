package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBaseTest{

    @Test
    public void simpleTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Открываем страницу
        open("/RamilKhTest");
        $("[placeholder = Search]").click();
        $("[placeholder=Search]").setValue("allure");
        $(linkText("RamilKhTest/allureLesson")).click();
        $("#issues-tab").click();
        $(String.format("#issue_%s_link", 1)).shouldHave(text("New issue first"));
    }
}
