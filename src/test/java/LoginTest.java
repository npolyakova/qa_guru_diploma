import com.codeborne.selenide.Condition;
import config.LoginConfig;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends BaseTest {

    public final LoginConfig loginData = ConfigFactory.create(LoginConfig.class, System.getProperties());

    @Test
    @Story("Log in")
    @DisplayName("The site my.exhibitaround.com is available to log in")
    public void loginChecking(){
        open("");
        uploadButton.click();
        switchTo().window(1);
        $("#fLogin").shouldBe(Condition.visible);
        $("#email").sendKeys(loginData.email());
        $("#password").sendKeys(loginData.password());
        $("#bLogin").click();
        $("[data-lang='home_benvenuto']").shouldBe(Condition.visible);
    }
}
