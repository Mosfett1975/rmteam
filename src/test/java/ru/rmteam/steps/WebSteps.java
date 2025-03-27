package ru.rmteam.steps;


import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static ru.rmteam.core.BasePage.currentPageName;
import static ru.rmteam.core.BasePage.getElementPageFactory;
import static ru.rmteam.core.UserProperties.checkValueAndReturnString;

@Log4j2
public class WebSteps {


    @И("совершен переход по ссылке {string}")
    public void openUrl(String address) {
        String url = checkValueAndReturnString(address);
        open(url);
    }


    @И( "текущая страница установлена {string}" )
    public void setCurrentPage ( String setCurrentPage ) {
        currentPageName ( setCurrentPage );
    }


    @И( "выполнено нажатие на кнопку {string}" )
    @И( "выполнено нажатие на {string}" )
    public void clickOnElement ( String elementName ) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.click();
    }

    @И("элемент {string} отображается")
    public void elementVisible (String elementName){
        SelenideElement element = getElementPageFactory ( elementName );
        element.shouldBe(visible);
    }

    @И("страница прокручена до появления элемента {string}")
    public void scrollWhileElemNotFoundOnPage(String elementName) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.scrollTo().shouldBe(visible);
    }

    @И( "поле {string} содержит текст {string}" )
    public void equalText ( String elementName, String compareText ) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.shouldHave(text(compareText));
    }

    @И( "кнопка {string} активна" )
    public void enabledButtonCheck ( String elementName ) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.shouldBe(enabled);
    }

    @И( "кнопка {string} не активна" )
    public void disabledButtonCheck ( String elementName ) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.shouldBe(disabled);
    }

    @И( "поле ввода {string} заполняется значением {string}" )
    public void fillField ( String elementName, String val ) {
        SelenideElement element = getElementPageFactory ( elementName );
        element.shouldBe(visible).setValue(val);
    }

}
