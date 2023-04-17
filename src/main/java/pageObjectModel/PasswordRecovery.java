package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecovery {
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    public WebDriver driver;

    public PasswordRecovery(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
