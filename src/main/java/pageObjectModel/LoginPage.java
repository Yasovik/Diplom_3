package pageObjectModel;

import TestData.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Data {
    public WebDriver driver;
    // Кнопка регистрации
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //кнопка восстановить пароль
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    //кнопка войти
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    //поле ввода почты в окне входа
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //поле ввода пароля в окне входа
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Вводи почту")
    public void inputEmail(){
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Вводим пароль")
    public void inputPassword(){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик по кнопке войти")
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
    @Step("Клик по кнопке регистрация")
    public void clickRegistrationButton(){
        driver.findElement(registerButton).click();
    }
    @Step("Клик по кнопке восстановить пароль")
    public void clickRecoverPasswordButton(){
        driver.findElement(restorePasswordButton).click();
    }
    public String clickSignInButtonGetText(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(signInButton).getText() != null
                && !driver.findElement(signInButton).getText().isEmpty()));
        return driver.findElement(signInButton).getText();

    }
}
