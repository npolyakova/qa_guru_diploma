package config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean isRemote();

    @DefaultValue("http://localhost:4444/wd/hub")
    @Key("webdriver.remote.url")
    URL getRemoteUrl();

    @DefaultValue("chrome")
    @Key("webdriver.browser.name")
    String getBrowserName();

}
