package ru.rmteam.utils;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class ScreenshotHook {

    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Получаем скриншот с помощью Selenide
            byte[] screenshot = Selenide.screenshot(org.openqa.selenium.OutputType.BYTES);

            // Прикрепляем скриншот к Allure отчету
            Allure.addAttachment(
                    "Screenshot on failure",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png");
        }
    }
}
