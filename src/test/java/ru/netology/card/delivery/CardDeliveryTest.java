package ru.netology.card.delivery;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    public static String generateDate(int days, String pattern) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    public void CardOrderTest() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_size_m");
        form.$("[placeholder='Город']").setValue("Санкт-Петербург");
        form.$("[placeholder='Дата встречи']").sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE);
        String visitDate = generateDate(6, "dd.MM.yyyy");
        form.$("[placeholder='Дата встречи']").setValue(visitDate);
        form.$("[data-test-id=name] input").setValue("Иванов Иван Иванович");
        form.$("[name='phone']").setValue("+79111112233");
        form.$(".checkbox").click();
        form.$(".button").click();
        form.$(".button").shouldBe(visible,Duration.ofSeconds(15));
        $(".notification__content").
                shouldBe(visible, Duration.ofSeconds(15))
                        .shouldHave(text("Встреча успешно забронирована на " + visitDate));
    }
}
