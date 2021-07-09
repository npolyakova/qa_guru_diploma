import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactPageTests extends BaseTest {

    private final SelenideElement emailLink = $("#main a");

    @Override
    public void checkContactButton(){
        contactButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/contact/"));
        contactButton.parent().shouldHave(Condition.cssClass("current-menu-item"));
    }

    @BeforeEach()
    public void openPage(){
        open("/contact");
    }

    @Test
    @Story("Contact page")
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
    @Story("Contact page")
    @DisplayName("Widget is visible")
    public void widgetElemetChecking(){
        checkWidget();
    }

    @Test
    @Story("Contact page")
    @DisplayName("Email link is correct")
    public void emailLinkChecking(){
        emailLink.shouldHave(Condition.attribute("href","mailto:info@triestephotodays.com"));
    }

    @Test
    @Story("Contact page")
    @DisplayName("Partners and promoters logo link are correct")
    public void partnersChecking(){
        checkPromotedByLogos();
        checkPartnersLogos();
    }
}
