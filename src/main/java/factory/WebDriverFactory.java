package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private String browserName = System.getProperty("browser");

    public WebDriver getDriver(){
        switch(browserName.toLowerCase()) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
        }

        throw new BrowserNotSupportedException(browserName);
    }
}