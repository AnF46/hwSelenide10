package ru.netology.card.delivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    public void CardOrderTest() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_size_m");
        form.$("[placeholder='Город']").setValue("Санкт-Петербург");
        form.$("[placeholder='Дата встречи']").sendKeys(Keys.COMMAND+"A");
        form.$("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        form.$("[placeholder='Дата встречи']").setValue(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        form.$("[data-test-id=name] input").setValue("Иванов Иван Иванович");
        form.$("[name='phone']").setValue("+79111112233");
        form.$(".checkbox").click();
        form.$(".button").click();
        form.$(".button").shouldBe(visible,Duration.ofSeconds(15));

        Thread.sleep(15000);
    }
}
