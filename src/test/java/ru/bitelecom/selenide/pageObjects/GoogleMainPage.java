package ru.bitelecom.selenide.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleMainPage {

    @Step("Провести поиск")
    public GoogleSearchResultPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleSearchResultPage.class);
    }

}
