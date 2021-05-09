package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.Setup;

import java.io.IOException;

public class ValidateNavigationBar extends Setup {

    public WebDriver driver;

    @Test
    public void validateNavigationBar() throws IOException {

        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

        LoginPage landingPage = new LoginPage(driver);
        
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());

    }

    @AfterTest
    public void Teardown(){
        driver.close();
    }
}
