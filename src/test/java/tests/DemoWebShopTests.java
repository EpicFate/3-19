package tests;

import config.ApiConfigHelper;
import org.junit.jupiter.api.Test;
import utils.FileUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoWebShopTests {

    @Test
    void WishlistTestWithUtils() {

        given()
                .body(FileUtils.readFromFile("src/test/resources/body.txt"))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(FileUtils.readFromFile("src/test/resources/cookie.txt"))
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/53/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }

    @Test
    void WishlistTestWithOwner() {

        String body = ApiConfigHelper.getBody();
        String cookie = ApiConfigHelper.getCookie();
        String contentType = ApiConfigHelper.getContentType();
        String Post = ApiConfigHelper.getPost();

        given()
                .body(body)
                .contentType(contentType)
                .cookie(cookie)
                .when()
                .post(Post)
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }

    @Test
    void WishlistTestWithOwnerAndModel() {

        String body = ApiConfigHelper.getBody();
        String cookie = ApiConfigHelper.getCookie();
        String contentType = ApiConfigHelper.getContentType();
        String Post = ApiConfigHelper.getPost();

        WishlistResponse response = given()
                .body(body)
                .contentType(contentType)
                .cookie(cookie)
                .when()
                .post(Post)
                .then()
                .statusCode(200)
                .extract().as(WishlistResponse.class);

        assertEquals(response.getSuccess(), true);
    }
}
