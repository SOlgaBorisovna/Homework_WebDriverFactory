package main;

import dto.User;
import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbsBaseSuite {
    protected static final Logger logger = LogManager.getLogger("Suite Logger");
    protected WebDriver driver = null;
    protected User user = null;

    @BeforeEach
    public void init() {
        user = new User();
        driver = new WebDriverFactory().getDriver();
    }

    @AfterEach
    public void close() {
        if(driver != null)
            driver.quit();
    }
}

