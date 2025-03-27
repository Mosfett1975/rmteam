package ru.rmteam.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.rmteam.annotation.Name;
import ru.rmteam.core.BasePage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name("Контакты")
public class ContactsSection extends BasePage {

    @Name("Кнопка Контакты")
    @FindBy(xpath = "//li[a[span[text()='Контакты']]]")
    public SelenideElement contactUsButton;

    @Name("Кнопка Связаться с нами")
    @FindBy(xpath = "//button[.//span[contains(text(), 'Связаться с нами')]]")
    public SelenideElement contactWithUsButton;

    @Name("ФИО")
    @FindBy(xpath = "//input[@formcontrolname='fio']")
    public SelenideElement fioField;

    @Name("EMAIL")
    @FindBy(xpath = "//input[@formcontrolname='email']")
    public SelenideElement emailField;

    @Name("Номер телефона")
    @FindBy(xpath = "//input[@formcontrolname='phone']")
    public SelenideElement phoneField;

    @Name("Код подтверждения")
    @FindBy(xpath = "//input[@formcontrolname='code']")
    public SelenideElement verificationCodeField;

    @Name("Кнопка получения кода подтверждения")
    @FindBy(xpath = "//button[.//span[contains(text(), 'Получить код подтверждения')]]")
    public SelenideElement getVerificationCodeButton;

    @Name("Чекбокс персональные данные")
    @FindBy(xpath = "//mat-checkbox[@formcontrolname='agreement1']//input[@type='checkbox']")
    public SelenideElement termsCheckbox;

    @Name("Чекбокс политика конфеденциальности")
    @FindBy(xpath = "//mat-checkbox[@formcontrolname='agreement2']//input[@type='checkbox']")
    public SelenideElement privacyCheckbox;

    @Name("Чекбокс пользовательское соглашение")
    @FindBy(xpath = "//mat-checkbox[@formcontrolname='agreement3']//input[@type='checkbox']")
    public SelenideElement userAgreementCheckbox;

    @Name("Кнопка Свяжитесь со мной")
    @FindBy(xpath = "//button[.//span[contains(text(),'Свяжитесь со мной')]]")
    public SelenideElement connectWithMeButton;
}