import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;

@Owner("npolly")
public class MainPageTests extends BaseTest {

    @BeforeEach()
    public void openPage(){
        open("");
    }

    @Test
    @Story("Main page")
    @DisplayName("Header checking")
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
    @Story("Main page")
    @DisplayName("Widget is visible")
    public void widgetElemetChecking(){
        checkWidget();
    }

    @Test
    @Story("Main page")
    @DisplayName("Widget is visible")
    public void pageContentChecking(){
        mainPageContentHeader.shouldBe(Condition.visible);
    }

    @Test
    @Story("Main page")
    @DisplayName("Fondazione Pietro Pittini links are correct")
    public void linksToFPPChecking(){
        linkToFPP.get(0).parent().shouldHave(Condition.attribute("href","https://fondazionepittini.it/"));
        linkToFPP.get(1).parent().shouldHave(Condition.attribute("href","https://fondazionepittini.it/"));
        linkToFPP.get(2).shouldHave(Condition.attribute("href","https://fondazionepittini.it/"));
    }

    @Test
    @Story("Main page")
    @DisplayName("Other links are correct")
    public void otherLinksChecking(){
        pagLink.shouldHave(Condition.attribute("href","https://pag.comune.trieste.it/"));
        photoCourseLink.shouldHave(Condition.attribute("href","https://photographycourse.net/"));
        mainPlatformLink.shouldHave(Condition.attribute("href","http://my.exhibitaround.com/"));
        emailLink.shouldHave(Condition.attribute("href","mailto:info@triestephotodays.com"));
    }

    @Test
    @Story("Main page")
    @DisplayName("Image zooms")
    public void imageZoomChecking(){
        smallImage.click();
        bigImage.shouldBe(Condition.visible);
        bigImage.click();
        bigImage.shouldNotBe(Condition.visible);
    }

    @Test
    @Story("Main page")
    @DisplayName("Buttons links are correct")
    public void buttonsChecking(){
        buttons.get(0).shouldHave(Condition.attribute("href","https://young.triestephotodays.com/rules/"));
        buttons.get(1).shouldHave(Condition.attribute("href","https://my.exhibitaround.com/"));
        buttons.get(2).shouldHave(Condition.attribute("href","https://young.triestephotodays.com/rules/"));
        buttons.get(3).shouldHave(Condition.attribute("href","https://my.exhibitaround.com/"));
    }

    @Test
    @Story("Main page")
    @DisplayName("Photos from photo gallery are zooming and clickable")
    public void photoGalleryChecking(){
        galleryImage.hover();
        galleryImage.shouldHave(Condition.cssClass("rgg-in"));
        galleryImage.click();
        bigImage.shouldBe(Condition.visible);
        leftArrow.click();
        imageCounter.shouldHave(Condition.text("21 of 21"));
        rightArrow.click();
        imageCounter.shouldHave(Condition.text("1 of 21"));
        closingButton.click();
        bigImage.shouldNotBe(Condition.visible);
    }

    @Test
    @Story("Main page")
    @DisplayName("Partners and promoters logo link are correct")
    public void partnersChecking(){
        checkPromotedByLogos();
        checkPartnersLogos();
    }

    @Test
    @Story("Main page")
    @DisplayName("Sources links are correct")
    public void sourcesLinksChecking(){
        sources.get(0).shouldHave(Condition.attribute("href","https://concorsidifotografiaonline.it/"));
        sources.get(1).shouldHave(Condition.attribute("href","https://photocontestdeadlines.com/"));
        sources.get(2).shouldHave(Condition.attribute("href","https://photocontestguru.com/"));
        sources.get(3).shouldHave(Condition.attribute("href","https://www.reflexlist.com/"));
    }
}
