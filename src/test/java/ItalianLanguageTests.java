import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItalianLanguageTests extends BaseTest {

    private final SelenideElement mPEngPhrase = $(byText("Trieste Photo Days presents"));
    private final SelenideElement rPEngPhrase = $(".entry-title");
    private final SelenideElement jPEngPhrase = $(byText("The guests of the festival will vote at the live final during Trieste Photo Days."));
    private final SelenideElement cPEngPhrase = $(byText("Need info? Write to"));

    @BeforeEach
    public void chooseItalianLanguage(){
        open("");
        languageButton.click();
        $("#menu-item-995").click();
    }

    @Test
    @Story("Language checking")
    @DisplayName("Language is Italian on main page")
    public void checkDefaultLanguageMP(){
        open("");
        checkHeaderLanguageIsItalian();
        mPEngPhrase.should(Condition.visible);
    }

    @Test
    @Story("Language checking")
    @DisplayName("Language is Italian on rules page")
    public void checkDefaultLanguageRP(){
        open("/rules");
        checkHeaderLanguageIsItalian();
        rPEngPhrase.shouldHave(Condition.text("Rules"));
    }

    @Test
    @Story("Language checking")
    @DisplayName("Language is Italian on jury page")
    public void checkDefaultLanguageJP(){
        open("/jury");
        checkHeaderLanguageIsItalian();
        jPEngPhrase.should(Condition.visible);
    }

    @Test
    @Story("Language checking")
    @DisplayName("Language is Italian on contacts page")
    public void checkDefaultLanguageCP(){
        open("/contact");
        checkHeaderLanguageIsItalian();
        cPEngPhrase.should(Condition.visible);
    }
}
