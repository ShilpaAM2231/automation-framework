package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;

    // Initialize Driver
    public static WebDriver initDriver() {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");   // 🔥 IMPORTANT
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");

        // Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    // Quit Driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}