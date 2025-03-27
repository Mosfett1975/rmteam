package ru.rmteam.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static ru.rmteam.core.UserProperties.checkValueAndReturnString;

public class DriverInit {


    @BeforeAll
    public static void setUp() {
        String url = checkValueAndReturnString("baseURL");
        Configuration.baseUrl = url;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1900x1080x24";
        Configuration.browserPosition = "0x0";
        Configuration.timeout = 50000;
        Configuration.screenshots = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true));

    }
}
