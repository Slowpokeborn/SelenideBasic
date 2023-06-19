package pageObjects.youTube;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class YoutubeMainPage {

    SelenideElement searchBar = $x("//input[@id='search']");
    SelenideElement searchButton = $x("//button[@id='search-icon-legacy']");

    public YouTubeSearchResultPage searchVideo(String query){
        searchBar.should(Condition.enabled).setValue(query);
        searchButton.should(Condition.enabled).click();
        return page(YouTubeSearchResultPage.class);
    }
}
