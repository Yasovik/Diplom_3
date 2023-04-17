package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    // Кнопка выйти
    public final By logoutButton = By.xpath(".//button[text() = 'Выход']");
    //кнопка конструктора
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    // Кнопка логотип
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по кнопке логотип")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    public String logoutButtonGetText() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(logoutButton).getText() != null
                && !driver.findElement(logoutButton).getText().isEmpty()));
        return driver.findElement(logoutButton).getText();
    }
    @Step("Клик по кнопке выйти")
    public void clickLogoutButton() {
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(logoutButton).getText() != null
                && !driver.findElement(logoutButton).getText().isEmpty()));
        driver.findElement(logoutButton).click();
    }

}
