import TestData.Data;
import api.CreateUser;
import api.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectModel.LoginPage;
import pageObjectModel.MainPage;
import pageObjectModel.ProfilePage;
import pageObjectModel.RegistrationPage;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.startsWith;

public class LoginUserTest extends Data {
    private static String accessToken;
    CreateUser createUser = new CreateUser();
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        Response userCreateResponse = createUser.createUser(userCreateData);
        accessToken = userCreateResponse.then().extract().path("accessToken").toString().substring(6).trim();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginUserMainPage() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        String textOrderButton = objPage.orderButtonGetText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));

    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginPersonalAccountButtonTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        objPage.clickPersonalAccountButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        String textOrderButton = objPage.orderButtonGetText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    public void loginRegistrationFormTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        RegistrationPage objRegistration = new RegistrationPage(driver);
        objPage.clickSignInButton();
        objLogin.clickRegistrationButton();
        objRegistration.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        String textOrderButton = objPage.orderButtonGetText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    public void loginRecoverForm() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        RegistrationPage objRegistration = new RegistrationPage(driver);
        objPage.clickSignInButton();
        objLogin.clickRecoverPasswordButton();
        objRegistration.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        String textOrderButton = objPage.orderButtonGetText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));

    }

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    public void profilePageClickTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        ProfilePage objProfile = new ProfilePage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        objPage.clickPersonalAccountButton();
        String actualResult = objProfile.logoutButtonGetText();
        MatcherAssert.assertThat(actualResult, startsWith("Выход"));

    }

    @Test
    @DisplayName("Переход по клику на Конструктор из Личного кабинета")
    public void constructorClickTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        ProfilePage objProfile = new ProfilePage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        objPage.clickPersonalAccountButton();
        objProfile.clickConstructorButton();
        String actualResult = objPage.orderButtonGetText();
        MatcherAssert.assertThat(actualResult, startsWith("Оформить заказ"));

    }

    @Test
    @DisplayName("Переход по клику на Логотип из Личного кабинета")
    public void logoClickTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        ProfilePage objProfile = new ProfilePage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        objPage.clickPersonalAccountButton();
        objProfile.clickLogoButton();
        String actualResult = objPage.orderButtonGetText();
        MatcherAssert.assertThat(actualResult, startsWith("Оформить заказ"));

    }

    @Test
    @DisplayName("Переход по клику на Выход из Личного кабинета")
    public void logoutClickTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        ProfilePage objProfile = new ProfilePage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        objPage.clickPersonalAccountButton();
        objProfile.clickLogoutButton();
        String actualResult = objLogin.clickSignInButtonGetText();
        MatcherAssert.assertThat(actualResult, startsWith("Войти"));

    }

    @Test
    @DisplayName("Переход по секциям")
    public void clickSectionTest() {
        MainPage objPage = new MainPage(driver);
        LoginPage objLogin = new LoginPage(driver);
        objPage.clickSignInButton();
        objLogin.inputEmail();
        objLogin.inputPassword();
        objLogin.clickSignInButton();
        objPage.clickSaucesButton();
        String actualResultSauce = objPage.getResultSauce();
        MatcherAssert.assertThat(actualResultSauce, containsString("current"));
        objPage.clickBunsButton();
        String actualResultBuns = objPage.getResultBuns();
        MatcherAssert.assertThat(actualResultBuns, containsString("current"));
        objPage.clickFillingsButton();
        String actualResultFillings = objPage.getResultFillings();
        MatcherAssert.assertThat(actualResultFillings, containsString("current"));

    }

    @After
    public void tearDown() {
        driver.quit();
        if (accessToken != null) {
            DeleteUser.deleteUser(accessToken);
        }

    }

}
