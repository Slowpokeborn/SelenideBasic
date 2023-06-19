package pageObjects.youTube;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.page;

public class YouTubeSearchResultPage {
    ElementsCollection videoTitles = $$x("//a[@id='video-title']");

    @Step("Кликнуть на заголовок первого попавшегося видоса")
    public YouTubeVideoPage clickOnFirstVideo(){
        videoTitles.get(0).should(Condition.enabled).click();
        return Selenide.page(YouTubeVideoPage.class);
    }
}
