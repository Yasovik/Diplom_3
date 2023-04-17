import TestData.Data;
import api.DeleteUser;
import api.LoginUser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectModel.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends Data {
    private static String accessToken;
    LoginUser loginUser = new LoginUser();
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registrationTest() {
        RegistrationPage objRegistration = new RegistrationPage(driver);
        SerializationData data = new SerializationData(email, password);
        objRegistration.inputName();
        objRegistration.inputEmail();
        objRegistration.inputPassword(password);
        objRegistration.clickRegisterButton();
        Response loginUserResponse = loginUser.loginUser(data);
        loginUserResponse.then().statusCode(200);
        accessToken = loginUserResponse.then().extract().path("accessToken").toString().substring(6).trim();
    }

    @Test
    @DisplayName("Ввод некорректного пароля")
    public void registrationWithIncorrectPassword() {
        RegistrationPage objRegistration = new RegistrationPage(driver);
        objRegistration.inputName();
        objRegistration.inputEmail();
        objRegistration.inputPassword("12345");
        objRegistration.clickRegisterButton();
        String incorrectPassword = driver.findElement(By.xpath(".//*[text() = 'Некорректный пароль']")).getText();
        assertEquals("Некорректный пароль", incorrectPassword);
    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            DeleteUser.deleteUser(accessToken);
        }

    }

}


