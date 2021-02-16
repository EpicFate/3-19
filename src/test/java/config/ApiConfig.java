package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
//        "classpath:${environment}.properties"
//        "file:\\C:\\Users\\bogti\\Desktop\\Api.properties",

        "system:properties",
        "classpath:Api.properties"

})
public interface ApiConfig extends Config {

//    @DefaultValue("")
    @Key("Body")
    String Body();

//    @DefaultValue("")
    @Key("Cookie")
    String Cookie();

//    @DefaultValue("")
    @Key("ContentType")
    String ContentType();

//    @DefaultValue("")
    @Key("Post")
    String Post();
}
