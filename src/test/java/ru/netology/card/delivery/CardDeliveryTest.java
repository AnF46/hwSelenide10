package ru.netology.card.delivery;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    public void NewTest() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $(".form_size_m");
        
        Thread.sleep(5000);
    }
}
