package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Setup {

    public WebDriver driver;
    public Properties properties = new Properties();

    public WebDriver initializeDriver() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");
        //String browserName = System.getProperty("browser");

        if(browserName.contains("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")){
                options.addArguments("--headless");
                options.addArguments("start-maximized");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
            }
            driver = new ChromeDriver(options);
        } else if(browserName.contains("firefox")) {
            System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        /*
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("start-maximized");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;

        }

         */

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public String getScreenshotPath(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testName + ".png";
        FileUtils.copyFile(file, new File(destinationFile));
        return destinationFile;
    }
}
