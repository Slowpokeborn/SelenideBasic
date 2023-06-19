package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResultPage {

    public ElementsCollection results() {
        return $$(By.xpath("//div[@class='g']"));
    }

    @Step("Кликнуть по заголовку")
    public void goLinkByName(String linkName) {
        try {
            SelenideElement resultLink = $$(By.xpath("//div[@class='g']")).find(Condition.matchText(linkName));

            resultLink.$(By.xpath(".//a[@href]")).should(Condition.enabled).click();

            $x("//body").should(Condition.exist).sendKeys("Keys.ESCAPE");


        } catch (Exception e) {
            ((JavascriptExecutor) WebDriverRunner.driver()).executeScript("return window.stop");
        }
        Assertions.assertThat(title().contains(linkName))
                .as("Не удалось переключится на вкладку: "+linkName)
                .isTrue();
    }

}
