package api;

import TestData.Data;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class DeleteUser extends Data {
    @Step("Удалить пользователя")
    public static void deleteUser(String accessToken) {
        given()
                .auth().oauth2(accessToken)
                .header("Content-type", "application/json")
                .body(userCreateData)
                .when()
                .delete("/api/auth/user").then().statusCode(202).log().all();
    }
}
