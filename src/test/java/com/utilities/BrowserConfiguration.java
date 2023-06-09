package com.utilities;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration  extends AbstractTestNGCucumberTests{
	public static WebDriver configureBrowser() throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Testing\\projects\\SeamLabs_Task\\src\\test\\resources\\properties\\config.properties");
        props.load(fis);

        String browser = props.getProperty("browser");
        int pageLoadTimeout = Integer.parseInt(props.getProperty("pageLoadTimeout"));

        WebDriver driver;
        if (browser.equals("chrome")) {
            // Use WebDriverManager to download and setup the Chrome driver
            WebDriverManager.chromedriver().setup();

            // Create a Chrome driver instance
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            // Use WebDriverManager to download and setup the Firefox driver
            WebDriverManager.firefoxdriver().setup();

            // Create a Firefox driver instance
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the page load timeout
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        
        // Set the base URL
        driver.get(props.getProperty("baseUrl"));

        // Return the driver instance
        return driver;
    }
}
