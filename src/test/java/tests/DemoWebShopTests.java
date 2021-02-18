package tests;

import config.ApiConfigHelper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static template.ReportTemplate.filters;

public class DemoWebShopTests {

    @Test
    void WishlistTest() {

        String body = ApiConfigHelper.getBody();
        String cookie = ApiConfigHelper.getCookie();
        String contentType = ApiConfigHelper.getContentType();
        String Post = ApiConfigHelper.getPost();

        WishlistResponse response = given()
                .filter(filters().customTemplates())
                .log().uri()
                .body(body)
                .contentType(contentType)
                .cookie(cookie)
                .when()
                .post(Post)
                .then()
                .statusCode(200)
                .extract().as(WishlistResponse.class);

        assertTrue(response.getSuccess());
    }
}
