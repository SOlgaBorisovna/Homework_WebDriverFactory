package main;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class TestSuite extends AbsBaseSuite{

    @Test
    public void checkRegistrationBtn() {
        logger.info("Run test checkRegistrationBtn");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open("");
        registrationPage.fillValues(user);
        registrationPage.checkSubmit(user);
        logger.info("Finish test checkInputTextLabel");
    }
}

