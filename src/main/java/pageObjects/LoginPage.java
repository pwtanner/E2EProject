package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath="//div[@class='pull-left']")
    WebElement title;

    @FindBy(xpath="//nav[@class='main-menu']")
    WebElement navigationBar;

    @FindBy(xpath="//a[@class='theme-btn register-btn']")
    WebElement loginButton_1;

    @FindBy(css="#user_email")
    WebElement email;

    @FindBy(css="#user_password")
    WebElement password;

    @FindBy(xpath="//input[@class='btn btn-primary btn-md login-button']")
    WebElement loginButton_2;

    public WebElement getTitle(){
        return title;
    }

    public WebElement getNavigationBar(){
        return navigationBar;
    }

    public WebElement LoginButton_1(){
        return loginButton_1;
    }

    public WebElement Email(){
        return email;
    }

    public WebElement Password(){
        return password;
    }

    public WebElement LoginButton_2(){
        return loginButton_2;
    }

}
