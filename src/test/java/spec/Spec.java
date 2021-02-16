package spec;

import config.ApiConfig;
import config.ApiConfigHelper;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static template.ReportTemplate.filters;

public class Spec {
    private final static ApiConfig CONFIG = ApiConfigHelper.getConfig();

    public static RequestSpecification request() {
        return given()
                .body(CONFIG.Body())
                .cookie(CONFIG.Cookie())
                .contentType(CONFIG.ContentType())
//                .post(CONFIG.Post())
                .filter(filters().customTemplates())
                .log().uri();
    }
}
