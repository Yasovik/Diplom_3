package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    //кнопка оформить заказ
    public final By makeOrderButton = By.xpath(".//button[(text()='Оформить заказ')]");
    //Секция булки
    public final By bunsSection = By.xpath(".//div[@style]/div[1]");
    // Секция соусы
    public final By sauceSection = By.xpath(".//div[@style]/div[2]");
    // Секция Начинки
    public final By fillingSection = By.xpath(".//div[@style]/div[3]");
    // Личный кабинет
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка войти в аккаунт
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка булки
    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");
    //кнопка соусы
    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");
    //кнопка начинки
    private final By fillingsButton = By.xpath(".//*[text()='Начинки']");
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке войти")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public String orderButtonGetText() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(makeOrderButton).getText() != null
                && !driver.findElement(makeOrderButton).getText().isEmpty()));
        return driver.findElement(makeOrderButton).getText();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Клик по кнопке булки")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("Клик по кнопке соусы")
    public void clickSaucesButton() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(saucesButton).getText() != null
                && !driver.findElement(saucesButton).getText().isEmpty()));
        driver.findElement(saucesButton).click();
    }

    @Step("Клик по кнопке начинки")
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }
}
