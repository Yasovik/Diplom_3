package pageObjectModel;

import TestData.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Data {
    //поле ввода имя
    private final By inputName = By.xpath("//fieldset[1]/div/div/input");
    //поле ввода email
    private final By inputEmail = By.xpath("//fieldset[2]/div/div/input");
    //поле ввода пароль
    private final By inputPassword = By.xpath("//fieldset[3]/div/div/input");
    //кнопка зарегистрироваться
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    //кнопка войти внизу страницы
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    public WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вводим Имя")
    public void inputName() {
        driver.findElement(inputName).sendKeys(name);

    }

    @Step("вводим почту")
    public void inputEmail() {
        driver.findElement(inputEmail).sendKeys(email);

    }

    @Step("Вводим пароль")
    public void inputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Клик по кнопке регистрация")
    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Клик по кнопке войти")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
