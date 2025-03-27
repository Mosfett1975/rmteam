package ru.rmteam.pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.rmteam.annotation.Name;
import ru.rmteam.core.BasePage;

@Name("Продукты")
public class ProductsSection extends BasePage {

    @Name("кнопка Продукты")
    @FindBy(xpath = "//a[contains(.,'Продукты')]")
    public SelenideElement productsButton;

    @Name("Заголовок раздела Продукты")
    @FindBy(xpath = "//h2[contains(.,'Продукты')]")
    public SelenideElement productsSectionHeader;

   @Name("Кнопка открытия информации о конструкторе визитки")
   @FindBy(xpath = "//div[@class='description']/p[text()='Конструктор визитки']")
    public SelenideElement productInfoButtonXpath;

    @Name("Модальное окно конструктор визитки")
    @FindBy(xpath = "//div[contains(@class,'id-and-close-button-block')]//span[@class='id' and text()='Конструктор визитки']")
    public SelenideElement productInfoModal;

    @Name("Картинка в модальном окне")
    @FindBy(xpath = "//img[contains(@src, \"/api/rest/files/images/logo(5).png\")]")
    public SelenideElement productPictureModal;

    @Name("модальное окно описание")
    @FindBy(xpath = "//product-feature-dialog//p[@class='description']")
    public SelenideElement productModalDescription;

}