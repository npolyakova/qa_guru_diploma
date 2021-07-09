import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class RulesPageTests extends BaseTest {

    private final SelenideElement text = $("#post-28");
    private final SelenideElement signUpSiteLink = $$("#post-28 a").first();
    private final SelenideElement uploadButton = $(".su-button-center a");

    @Override
    public void checkRulesButton(){
        rulesButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/rules/"));
        rulesButton.parent().shouldHave(Condition.cssClass("current-menu-item"));
    }

    @BeforeEach()
    public void openPage(){
        open("/rules");
    }

    @Test
    @Story("Rules page")
    @DisplayName("Header is correct")
    public void headerChecking(){
        checkTopBarLink();
        checkLogoDefaultLink();
        checkUploadButton();
        checkRulesButton();
        checkJuryButton();
        checkContactButton();
        checkLanguageButton();
    }

    @Test
    @Story("Rules page")
    @DisplayName("Widget is visible")
    public void widgetElemetChecking(){
        checkWidget();
    }

    @Test
    @Story("Rules page")
    @DisplayName("Content is visible")
    public void contentChecking(){
        text.shouldBe(Condition.visible);
    }

    @Test
    @Story("Rules page")
    @DisplayName("Sign up site link is correct")
    public void linkChecking(){
        signUpSiteLink.shouldHave(Condition.attribute("href","https://my.exhibitaround.com/"));
    }

    @Test
    @Story("Rules page")
    @DisplayName("Upload button link is correct")
    public void uploadButtonChecking(){
        uploadButton.shouldHave(Condition.attribute("href","https://my.exhibitaround.com/"));
    }

    @Test
    @Story("Rules page")
    @DisplayName("Partners and promoters logo link are correct")
    public void partnersChecking(){
        checkPromotedByLogos();
        checkPartnersLogos();
    }
}
