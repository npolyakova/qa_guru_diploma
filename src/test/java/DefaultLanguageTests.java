import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DefaultLanguageTests extends BaseTest {

    private final SelenideElement mPItPhrase = $(byText("Trieste Photo Days presenta"));
    private final SelenideElement rPItPhrase = $(".entry-title");
    private final SelenideElement jPItPhrase = $(byText("La giuria del Trieste Photo Young 2021 è in fase di definizione."));
    private final SelenideElement cPItPhrase = $(byText("Dubbi? Scrivi a"));

    @Test
    @Story("Language checking")
    @DisplayName("Default language is Italian in main page")
    public void checkDefaultLanguageMP(){
        open("");
        checkHeaderLanguageIsEng();
        mPItPhrase.should(Condition.visible);
    }

    @Test
    @Story("Language checking")
    @DisplayName("Default language is Italian on rules page")
    public void checkDefaultLanguageRP(){
        open("/rules");
        checkHeaderLanguageIsEng();
        rPItPhrase.shouldHave(Condition.text("Regolamento"));
    }

    @Test
    @Story("Language checking")
    @DisplayName("Default language is Italian on jury page")
    public void checkDefaultLanguageJP(){
        open("/jury");
        checkHeaderLanguageIsEng();
        jPItPhrase.should(Condition.visible);
    }

    @Test
    @Story("Language checking")
    @DisplayName("Default language is Italian on contacts page")
    public void checkDefaultLanguageCP(){
        open("/contact");
        checkHeaderLanguageIsEng();
        cPItPhrase.should(Condition.visible);
    }
}
