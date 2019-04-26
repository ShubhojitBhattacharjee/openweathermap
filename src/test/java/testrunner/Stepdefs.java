package testrunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import integration_tests.OpenWeatherMapPage;
import org.openqa.selenium.WebDriver;

public class Stepdefs {

    private OpenWeatherMapPage openWeatherMapPage;

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
        openWeatherMapPage.classTeardown();
    }

    @Given("^I launch OpenWeatherMap application$")
    public void launchApp() throws Exception {
        openWeatherMapPage = new OpenWeatherMapPage();
    }

    @Then("^I verify all the important labels$")
    public void verifyLabels() {

        openWeatherMapPage.verifyLabels();
    }

    @When("I enter city as {string}")
    public void enterCity(String city) {
        openWeatherMapPage.enterCityName(city);
    }

    @Then("I expect the website to display {string}")
    public void verifyInvalidCity(String noResult) {
        openWeatherMapPage.verifyInvalidSearchResult(noResult);
    }

    @Then("I expect the website to display weather details of {string}")
    public void verifyWeatherDetailsOf(String city) {
        openWeatherMapPage.verifySearchResult(city);
    }

    @When("I click on {string} in top navigation bar")
    public void clickWeatherInYourCity(String string) {
        openWeatherMapPage.clickOnWeatherInYourCity();
    }

    @Then("a search box is displayed and enabled in the top navigation bar")
    public void verifySearchBox() {
        openWeatherMapPage.verifySearchBox();
    }

    @When("I enter city as {string} in search box of navigation bar")
    public void enterCityInSearchBoxOfNavigationBar(String city) {
        openWeatherMapPage.enterCityNameInSearchBar(city);
    }

    @When("I click on search button")
    public void clickSearchButton() {
        openWeatherMapPage.clickSearchButtonInTopNavBar();
    }
}
