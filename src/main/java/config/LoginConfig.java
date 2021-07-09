package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:login.properties")
public interface LoginConfig extends Config {

    @Key("user.email")
    String email();

    @Key("user.password")
    String password();

}