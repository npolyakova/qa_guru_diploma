import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JuryPageTests extends BaseTest {

    private final SelenideElement text = $(".entry-content");

    @Override
    public void checkJuryButton(){
        juryButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/jury/"));
        juryButton.parent().shouldHave(Condition.cssClass("current-menu-item"));
    }

    @BeforeEach()
    public void openPage(){
        open("/jury");
    }

    @Test
    @Story("Jury page")
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
    @Story("Jury page")
    @DisplayName("Widget is visible")
    public void widgetElemetChecking(){
        checkWidget();
    }

    @Test
    @Story("Jury page")
    @DisplayName("Content is visible")
    public void contentChecking(){
        text.shouldBe(Condition.visible);
    }

    @Test
    @Story("Jury page")
    @DisplayName("Partners and promoters logo link are correct")
    public void partnersChecking(){
        checkPromotedByLogos();
        checkPartnersLogos();
    }
}
