package ru.rmteam.utils;

import io.cucumber.java.Before;
import io.qameta.allure.Allure;

public class AllureEnvironmentSetup {

    @Before
    public void setAllureEnvironment() {
        Allure.addAttachment("Test Info", "text/plain", "RMTeam Website Testing");

        // Добавляем полезную информацию об окружении
        Allure.parameter("Browser", "Chrome");
        Allure.parameter("URL", "https://www.rmteam.ru/routing/public");
        Allure.parameter("Environment", "Test");
    }
}
