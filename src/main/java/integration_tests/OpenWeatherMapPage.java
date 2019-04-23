package integration_tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenWeatherMapPage extends BasePage {

    @FindBy(xpath = "//a[@href='//openweathermap.desk.com/']")
    private WebElement supportCenter;

    @FindBy(id = "nav-search")
    private WebElement weatherInYourCity;

    @FindBy(xpath = "//input[@placeholder='Search' and @type='text']")
    private WebElement searchBoxNavBar;

    @FindBy(xpath = "//button[@type='submit']/i[contains(@class,'search')]")
    private WebElement searchButtonNavBar;

    @FindBy(id = "nav-search-close")
    private WebElement searchBoxCloseNavBar;

    @FindBy(xpath = "//a[contains(@href, 'sign_in') and @onclick]")
    private WebElement signIn;

    @FindBy(xpath = "//a[contains(@href, 'sign_up') and @onclick]")
    private WebElement signUp;

    @FindBy(xpath = "//a[@class='slide-button']")
    private WebElement temperatureUnit;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li")
    private List<WebElement> rightNavBar;

    @FindBy(xpath = "//li/a[(.)='Maps ']")
    private WebElement maps;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> mapsDropDownMenu;

    @FindBy(xpath = "//div[@id='main-slideshow']//h2")
    private WebElement heading;

    @FindBy(xpath = "//div[@id='main-slideshow']//h4")
    private WebElement subHeading;

    @FindBy(xpath = "//input[@placeholder='Your city name' and @type='text']")
    private WebElement searchCity;

    @FindBy(xpath = "//form[@id='searchform']/button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class,'search-cities') and @type='button']")
    private WebElement currentLocation;

    @FindBy(css = ".owm-block-mainpage__container h2")
    private List<WebElement> mainPageCards;

    @FindBy(css = ".portfolio-item h3 a")
    private List<WebElement> portfolio_items;

    @FindBy(css = ".row .services .services-item h3")
    private List<WebElement> rowServicesItems;

    @FindBy(css = ".footer-dark .col-sm-4 h3")
    private List<WebElement> footerLabels;

    @FindBy(id = "forecast_list_ul")
    private WebElement searchResult;

    @FindBy(xpath = "//span[contains(@class,'badge-info')]")
    private WebElement cityWeatherDetails;

    public OpenWeatherMapPage() throws Exception {
    }

    public void verifyLabels() {

        Assert.assertEquals(true, driver.getTitle().contains("OpenWeatherMap"));
        Assert.assertEquals(true, supportCenter.isDisplayed());
        Assert.assertEquals(true, weatherInYourCity.isDisplayed());

        weatherInYourCity.click();

        Assert.assertEquals(true, searchBoxNavBar.isDisplayed());
        Assert.assertEquals(true, searchButtonNavBar.isDisplayed());
        Assert.assertEquals(true, searchBoxCloseNavBar.isDisplayed());
        Assert.assertEquals(true, signIn.isDisplayed());
        Assert.assertEquals(true, signUp.isDisplayed());
        Assert.assertEquals(true, temperatureUnit.isDisplayed());
        Assert.assertEquals("Weather", rightNavBar.get(2).getText());

        Assert.assertEquals("Maps", maps.getText());

        Assert.assertEquals("Guide", rightNavBar.get(4).getText());
        Assert.assertEquals("API", rightNavBar.get(5).getText());
        Assert.assertEquals("Price", rightNavBar.get(6).getText());
        Assert.assertEquals("Partners", rightNavBar.get(7).getText());
        Assert.assertEquals("Stations", rightNavBar.get(8).getText());
        Assert.assertEquals("Widgets", rightNavBar.get(9).getText());
        Assert.assertEquals("Blog", rightNavBar.get(10).getText());

        maps.click();

        Assert.assertEquals(3, mapsDropDownMenu.size());
        Assert.assertEquals("Weather maps", mapsDropDownMenu.get(0).getText());
        Assert.assertEquals("Current satellite maps", mapsDropDownMenu.get(1).getText());
        Assert.assertEquals("Beautiful places", mapsDropDownMenu.get(2).getText());

        Assert.assertEquals("We Deliver 2 Billion Forecasts Per Day", heading.getText());
        Assert.assertEquals("2,000 new subscribers a day | 1,700,000 customers | 20+ weather APIs", subHeading.getText());

        Assert.assertEquals(true, searchCity.isDisplayed());
        Assert.assertEquals(true, searchButton.isEnabled());
        Assert.assertEquals(true, currentLocation.isEnabled());

        Assert.assertEquals("Free trial of Hourly Weather Forecast until 1st May 2019", mainPageCards.get(0).getText());
        Assert.assertEquals("Dashboard for Agricultural Monitoring", mainPageCards.get(1).getText());
        Assert.assertEquals("Agricultural API for Satellite and Weather data", mainPageCards.get(2).getText());

        Assert.assertEquals("Forecast & Historical weather map", portfolio_items.get(0).getText());
        Assert.assertEquals("15 Weather map layers", portfolio_items.get(1).getText());
        Assert.assertEquals("Interactive current weather map", portfolio_items.get(2).getText());

        Assert.assertEquals("Google Weather-Based Campaign Management with OpenWeatherMap API", rowServicesItems.get(0).getText());
        Assert.assertEquals("2500+ OpenWeatherMap weather API repositories on GitHub", rowServicesItems.get(1).getText());
        Assert.assertEquals("Weather APIs for developers", rowServicesItems.get(2).getText());
        Assert.assertEquals("Connect your weather station to OpenWeatherMap", rowServicesItems.get(3).getText());

        Assert.assertEquals("Weather in your city", footerLabels.get(0).getText());
        Assert.assertEquals("Weather APIs", footerLabels.get(1).getText());
        Assert.assertEquals("Map layers", footerLabels.get(2).getText());
        Assert.assertEquals("How to subscribe", footerLabels.get(3).getText());
        Assert.assertEquals("Weather station network", footerLabels.get(4).getText());
        Assert.assertEquals("About", footerLabels.get(5).getText());
        Assert.assertEquals("Go Social", footerLabels.get(6).getText());
    }

    public void enterCityName(String city) {
        searchCity.clear();
        searchCity.sendKeys(city);
        searchButton.click();;
    }

    public void verifyInvalidSearchResult(String result) {
        Assert.assertEquals(true, searchResult.getText().contains(result));
    }

    public void verifySearchResult(String city) {
        WebElement weatherDetails = searchResult.findElement(By.xpath("//table//b/a"));
        Assert.assertEquals(true, weatherDetails.getText().contains(city));
        Assert.assertEquals(true, !(cityWeatherDetails.getText().isEmpty()));

    }

    public void clickOnWeatherInYourCity() {
        weatherInYourCity.click();
    }

    public void verifySearchBox() {
        Assert.assertEquals(true, searchBoxNavBar.isEnabled());
    }

    public void enterCityNameInSearchBar(String city) {
        searchBoxNavBar.clear();
        searchBoxNavBar.sendKeys(city);
    }

    public void clickSearchButtonInTopNavBar() {
        searchButtonNavBar.click();
    }
}
