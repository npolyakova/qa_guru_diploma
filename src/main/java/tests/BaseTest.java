package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

public class BaseTest extends CommonMethods {

    private final WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    private WebDriver driver;

    @BeforeEach
    public void setURL() {
        Configuration.baseUrl = "https://young.triestephotodays.com/";

        driver = createWebDriver();
        driver.manage().window().fullscreen();
        WebDriverRunner.setWebDriver(driver);

        final AllureSelenide logger = new AllureSelenide()
                .screenshots(true);
        SelenideLogger.addListener("allure", logger);
    }

    @AfterEach
    public void tearDown() {
        Optional.ofNullable(driver).ifPresent(WebDriver::quit);
    }

    private WebDriver createWebDriver() {
        if (webDriverConfig.isRemote()) {
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            return new RemoteWebDriver(webDriverConfig.getRemoteUrl(), capabilities);
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
