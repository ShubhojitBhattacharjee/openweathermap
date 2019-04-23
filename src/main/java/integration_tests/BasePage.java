package integration_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdriver.WebDriverSetup;

public class BasePage {

    private static final String URL = "https://openweathermap.org/";
    WebDriver driver = null;

    public BasePage() throws Exception {

        String browserName = System.getProperty("browser");
        driver = new WebDriverSetup().getWebDriver(browserName);

        PageFactory.initElements(driver, this);
        driver.get(URL);
    }

    public void classTeardown() {

        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
