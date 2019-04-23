Feature: Funtional Tests of OpenWeatherMap application

    Background:
        Given I launch OpenWeatherMap application

    Scenario: Verify important information and labels in the Sample application
        Then I verify all the important labels

    Scenario: Verify message upon entering invalid city
        When I enter city as "JunkCityName"
        Then I expect the website to display "Not found"

    Scenario: Verify weather details displayed upon entering a valid city
        When I enter city as "Bangalore"
        Then I expect the website to display weather details of "Bangalore"

    Scenario: Verify weather details displayed upon entering a valid city in top navigation bar
        When I click on "Weather in your city" in top navigation bar
        Then a search box is displayed and enabled in the top navigation bar
        When I enter city as "Bangalore" in search box of navigation bar
        And I click on search button
        Then I expect the website to display weather details of "Bangalore"