package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.Setup;

import java.io.IOException;

public class ValidateTitle extends Setup {

    public static Logger log = LogManager.getLogger(Setup.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        log.info("Driver has been initialized.");
        driver.get(properties.getProperty("url"));
        log.info("Navigated to home page.");
        driver.manage().window().maximize();
    }

    @Test
    public void validateTitle() throws IOException {

        LoginPage landingPage = new LoginPage(driver);
        Assert.assertEquals(landingPage.getTitle().getText(), "Featured Courses");
        log.info("Successfully validated title.");
    }

    @AfterTest
    public void Teardown(){
        driver.close();
    }
}
