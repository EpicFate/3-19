package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({

        "system:properties",
        "classpath:Api.properties"
})
public interface ApiConfig extends Config {

    @Key("Body")
    String Body();

    @Key("Cookie")
    String Cookie();

    @Key("ContentType")
    String ContentType();

    @Key("Post")
    String Post();
}
