package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginUser {
    @Step("авторизация пользователя")
    public Response loginUser(Object body) {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when().log().all()
                .post("/api/auth/login");


    }
}
