package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;
import pageObjects.GoogleMainPage;
import pageObjects.youTube.YoutubeMainPage;

import static com.codeborne.selenide.Selenide.open;

public class GoogleTest extends BaseTest{
    GoogleMainPage googleMainPage = new GoogleMainPage();
    YoutubeMainPage youtubeMainPage = new YoutubeMainPage();

    @Test(
            description = "Поиск"
    )
    public void googleSearchTest(){
        open("https://www.google.com");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();

        //Зачем-то написал в функциональном стиле. Пусть уж будет.
        googleMainPage.search("youtube")
                .goLinkByName("YouTube");

        youtubeMainPage.searchVideo("чего хотел Гатс")
                .clickOnFirstVideo()
                .checkVideo();

    }
}
