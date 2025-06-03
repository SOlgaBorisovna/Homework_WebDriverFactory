package pages;

import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationPage extends AbsBasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillValues(User user)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String name = user.getName();
        js.executeScript("document.getElementById('username').value = '" + user.getName() + "';");
        js.executeScript("document.getElementById('email').value = '" + user.getEmail() + "';");
        js.executeScript("document.getElementById('password').value = '" + user.getPassword() + "';");
        js.executeScript("document.getElementById('confirm_password').value = '" + user.getPassword() + "';");
        js.executeScript("document.getElementById('birthdate').value = '" + user.getDate() + "';");
        js.executeScript("document.getElementById('language_level').value = '" + user.getLanguageLevel() + "';");
    }

    public void checkSubmit(User user) {
        WebElement passwordValue = driver.findElement(By.id("password"));
        WebElement confirmPasswordValue = driver.findElement(By.id("confirm_password"));
        assertThat(passwordValue.getAttribute("value"))
                .as("Пароли должны совпадать")
                .isEqualTo(confirmPasswordValue.getAttribute("value"));

        WebElement registrationBtn = driver.findElement(By.cssSelector("input[type=submit]"));
        registrationBtn.click();
        WebElement registrationOutput = driver.findElement(By.id("output"));

        String expectedText = String.format(
                "Имя пользователя: %s\n" +
                        "Электронная почта: %s\n" +
                        "Дата рождения: %s\n" +
                        "Уровень языка: %s"
                , user.getName()
                , user.getEmail()
                , user.getDate()
                , user.getLanguageLevel());

        assertThat(registrationOutput.getText())
                .as("Данные пользователя должны совпадать")
                .isEqualTo(expectedText);
    }
}