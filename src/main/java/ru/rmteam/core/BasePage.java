package ru.rmteam.core;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.reflections.Reflections;
import ru.rmteam.annotation.Name;
import io.qameta.allure.Step;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.support.How;

import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.*;
import static ru.rmteam.core.UserProperties.*;

public class BasePage {

    public static Map<String, String> variable = new HashMap<>();


    /**
     * Extract class by annotation @Name
     * @param pageName Name of class
     * @return имя класса
     */
    public static @NotNull Object getPageObjectClass ( String pageName ) {
        Reflections ref = new Reflections ( "ru.rmteam.pages" );
        for ( Class < ? > cl : ref.getTypesAnnotatedWith ( Name.class ) ) {
            Name findable = cl.getAnnotation ( Name.class );
            System.out.printf ( "Found class: %s, with meta name: %s%n",
                    cl.getSimpleName ( ), findable.value ( ) );
            if ( findable.value ( ).equals ( pageName ) ) {
                return cl;
            }
        }
        throw new IllegalArgumentException ( "Class not found" );
    }

    /**
     * @return get class by annotation @Name and set variable currentPage
     */
    public static void currentPageName ( String nameOfPage ) {
        setVarObj ( "currentPage"+sessionId (), getPageObjectClass ( nameOfPage ) );
    }

    /**
     * Return
     * @param pageElementName - @Name of PageFactory element
     * @return SelenideElement
     */
    @NotNull
    public static SelenideElement getElementPageFactory ( String pageElementName ) {
        Field[] fields = getFields ( );
        FindBy findExpression;
        for ( Field field : fields ) {
            Name findClass = field.getAnnotation ( Name.class );
            findExpression = field.getAnnotation ( FindBy.class );
            if ( field.getType ( ) == SelenideElement.class ) {
                field.setAccessible ( true );
                if ( findClass.value ( ).equals ( pageElementName ) ) {
                    return getElementSelector ( findExpression );
                }
            }
        }
        throw new IllegalArgumentException ( "SelenideElement not found" );
    }

    /**
     * Extract element selector
     * @param findExpression
     * @return
     */
    private static SelenideElement getElementSelector(FindBy findExpression) {
        if (!findExpression.css().isEmpty()) {
            return $(By.cssSelector(findExpression.css()));
        } else if (!findExpression.className().isEmpty()) {
            return $(By.className(findExpression.className()));
        } else if (!findExpression.id().isEmpty()) {
            return $(By.id(findExpression.id()));
        } else if (!findExpression.xpath().isEmpty()) {
            return $(By.xpath(findExpression.xpath()));
        } else if (!findExpression.tagName().isEmpty()) {
            return $(By.tagName(findExpression.tagName()));
        } else if (!findExpression.linkText().isEmpty()) {
            return $(By.linkText(findExpression.linkText()));
        } else if (!findExpression.partialLinkText().isEmpty()) {
            return $(By.partialLinkText(findExpression.partialLinkText()));
        } else if (!findExpression.name().isEmpty()) {
            return $(By.name(findExpression.name()));
        } else if (findExpression.how() != How.UNSET && !findExpression.using().isEmpty()) {
            switch (findExpression.how()) {
                case CSS:
                    return $(By.cssSelector(findExpression.using()));
                case CLASS_NAME:
                    return $(By.className(findExpression.using()));
                case ID:
                    return $(By.id(findExpression.using()));
                case XPATH:
                    return $(By.xpath(findExpression.using()));
                case TAG_NAME:
                    return $(By.tagName(findExpression.using()));
                case LINK_TEXT:
                    return $(By.linkText(findExpression.using()));
                case PARTIAL_LINK_TEXT:
                    return $(By.partialLinkText(findExpression.using()));
                case NAME:
                    return $(By.name(findExpression.using()));
                default:
                    break;
            }
        }

        throw new IllegalArgumentException("Element locator not found in @FindBy annotation");
    }

}