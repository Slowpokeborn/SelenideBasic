package pageObjects.youTube;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class YouTubeVideoPage {
    SelenideElement videoTitle = $x("//div[@id='above-the-fold']/div[@id='title']//yt-formatted-string");

    SelenideElement autoNavButton = $x("//div[@class='ytp-autonav-toggle-button']");

    SelenideElement endScreen = $x("//div[contains(@class, 'videowall-endscreen ytp-show-tiles')]");

    public void checkVideo(){
        Assertions.assertThat(videoTitle.should(Condition.visible).getOwnText())
                .as("Черт, не то!")
                .contains("Чего на самом деле хотел ГАТС ? BERSERK");

        if (autoNavButton.getAttribute("aria-checked").contains("true"))
            autoNavButton.should(Condition.enabled).click();

        endScreen.should(Condition.enabled, Duration.ofMinutes(5));
    }

}
