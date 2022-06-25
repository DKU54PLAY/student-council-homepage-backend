package dankook.play.studentcouncilhomepage.domain.user.acceptance;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class AcceptanceFixture {

    private AcceptanceFixture() {
    }

    public static <T> ExtractableResponse<Response> post(T params, String path) {
        return RestAssured.given().log().all()
                .body(params)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .post(path)
                .then().log().all()
                .extract();
    }

    public static <T> ExtractableResponse<Response> post(T params, String path, Header header) {
        return RestAssured.given().log().all()
                .header(header)
                .body(params)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .post(path)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> get(String path) {
        return RestAssured.given().log().all()
                .when()
                .get(path)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> get(String path, Header header) {
        return RestAssured.given().log().all()
                .header(header)
                .when()
                .get(path)
                .then().log().all()
                .extract();
    }

    public static <T> ExtractableResponse<Response> patch(T params, String path, Header header) {
        return RestAssured.given().log().all()
                .header(header)
                .body(params)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .patch(path)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> delete(String path) {
        return RestAssured.given().log().all()
                .when()
                .delete(path)
                .then().log().all()
                .extract();
    }

    public static <T> ExtractableResponse<Response> delete(T params, String path, Header header) {
        return RestAssured.given().log().all()
                .header(header)
                .body(params)
                .contentType(APPLICATION_JSON_VALUE)
                .when()
                .delete(path)
                .then().log().all()
                .extract();
    }
}
