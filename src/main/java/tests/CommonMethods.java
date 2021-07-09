package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.LoginConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommonMethods {

    public final SelenideElement topBarLink = $(".top-bar").$(byText("Trieste Photo Days 2021"));
    public final SelenideElement logoDefaultLink = $(".custom-logo-link");
    public final SelenideElement uploadButton = $("#menu-item-21 a");
    public final SelenideElement rulesButton = $("#menu-item-30 a");
    public final SelenideElement juryButton = $("#menu-item-994 a");
    public final SelenideElement contactButton = $("#menu-item-124 a");
    public final SelenideElement languageButton = $("#menu-item-569 a");
    public final SelenideElement promotedByLogos = $(".su-row .su-column-size-2-3");
    public final SelenideElement partnersLogos = $(".su-row .su-column-size-1-3");
    public final SelenideElement widget = $(".header-widget-area");
    public final SelenideElement mainPageContentHeader = $(byText("Trieste Photo Young 2021"));
    public final ElementsCollection linkToFPP = $$(byText("Fondazione Pietro Pittini"));
    public final SelenideElement pagLink = $(byText("PAG – Progetto Area Giovani")).parent();
    public final SelenideElement photoCourseLink = $(byText("PhotographyCourse.net")).parent();
    public final SelenideElement mainPlatformLink = $(byText("my.exhibitaround.com")).parent();
    public final SelenideElement emailLink = $(byText("info@triestephotodays.com"));
    public final SelenideElement smallImage = $(".wp-image-975");
    public final SelenideElement bigImage = $(".mfp-img");
    public final SelenideElement galleryImage = $(".rgg-imagegrid a");
    public final SelenideElement leftArrow = $(".mfp-arrow-left");
    public final SelenideElement rightArrow = $(".mfp-arrow-right");
    public final SelenideElement imageCounter = $(".mfp-counter");
    public final SelenideElement closingButton = $(".mfp-close");
    public final ElementsCollection buttons = $$(".su-button-center a");
    public final ElementsCollection sources = $$("#custom_html-5 .su-column a");

    public void checkTopBarLink(){
        topBarLink.shouldHave(Condition.attribute("href", "https://www.triestephotodays.com/"));
    }

    public void checkLogoDefaultLink(){
        logoDefaultLink.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/"));
    }

    public void checkUploadButton(){
        uploadButton.shouldHave(Condition.attribute("href","https://my.exhibitaround.com/"));
    }

    public void checkRulesButton(){
        rulesButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/rules/"));
    }

    public void checkJuryButton(){
        juryButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/jury/"));
    }

    public void checkContactButton(){
        contactButton.shouldHave(Condition.attribute("href","https://young.triestephotodays.com/contact/"));
    }

    public void checkLanguageButton(){
        languageButton.shouldBe(Condition.visible);
    }

    public void checkWidget(){
        widget.shouldBe(Condition.visible);
    }

    public void checkPromotedByLogos(){
        promotedByLogos.find("a",0).shouldHave(Condition.attribute("href","https://www.comune.trieste.it/"));
        promotedByLogos.find("a",1).shouldHave(Condition.attribute("href","https://www.dotart.it/"));
        promotedByLogos.find("a",2).shouldHave(Condition.attribute("href","https://www.triestephotodays.com/"));
        promotedByLogos.find("a",3).shouldHave(Condition.attribute("href","https://pag.comune.trieste.it/"));
        promotedByLogos.find("a",4).shouldHave(Condition.attribute("href","https://www.exhibitaround.com/"));
    }

    public void checkPartnersLogos(){
        partnersLogos.find("a",0).shouldHave(Condition.attribute("href","https://fondazionepittini.it/"));
        partnersLogos.find("a",1).shouldHave(Condition.attribute("href","https://photographycourse.net/"));
    }

    public void checkHeaderLanguageIsEng(){
        uploadButton.shouldHave(Condition.text("UPLOAD "));
        rulesButton.shouldHave(Condition.text("Rules"));
        juryButton.shouldHave(Condition.text("Jury"));
        contactButton.shouldHave(Condition.text("Contact"));
        languageButton.shouldHave(Condition.text("Language "));
        languageButton.$("img").shouldHave(Condition.attribute("src","https://young.triestephotodays.com/wp-content/plugins/qtranslate-x/flags/gb.png"));
    }

    public void checkHeaderLanguageIsItalian(){
        uploadButton.shouldHave(Condition.text("UPLOAD "));
        rulesButton.shouldHave(Condition.text("Regolamento"));
        juryButton.shouldHave(Condition.text("Giuria"));
        contactButton.shouldHave(Condition.text("Contatti"));
        languageButton.shouldHave(Condition.text("Lingua "));
        languageButton.$("img").shouldHave(Condition.attribute("src","https://young.triestephotodays.com/wp-content/plugins/qtranslate-x/flags/it.png"));
    }
}
