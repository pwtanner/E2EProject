package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.Setup;

import java.io.IOException;

public class Login extends Setup {

    public WebDriver driver;

    @DataProvider
    public Object[][] getData(){

        Object[][] data = new Object[1][3];

        data[0][0] = "alfjaslfj@asfdj.com";
        data[0][1] = "abcd1234";
        data[0][2]= "Unrestricted User";

        return data;
    }

    @Test(dataProvider="getData")
    public void basePageNavigation(String _userName, String _password, String _testName) throws IOException {

        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.LoginButton_1().click();

        loginPage.Email().sendKeys(_userName);
        loginPage.Password().sendKeys(_password);
        loginPage.LoginButton_2().click();

    }

    @AfterTest
    public void Teardown(){
        driver.close();
    }
}
