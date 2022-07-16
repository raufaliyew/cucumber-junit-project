package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();


    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        //Assert.fail("Unpurpose failing here!!!!!!!!");
        Driver.getDriver().get("https://www.google.com");

    }

    @Then("User should see Google in the title")
    public void user_should_see_title_is_google() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        // Both assertions are not needed.
        Assert.assertTrue("Actual title does not match expected title!", actualTitle.equals(expectedTitle));
        Assert.assertEquals("Actual title does not match expected title!", actualTitle, expectedTitle);

    }


    @When("User searches apple")
    public void userSearchesApple() {
        BrowserUtils.highlightElement(googleSearchPage.aboutLink);
        BrowserUtils.waitFor(3);
        //sending value into search box using page object
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
        String expectedTitle = "apple - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("User searches {string}")
    public void userSearches(String searchValue) {

        //sending value into search box using page object
        googleSearchPage.searchBox.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchValue) {
        String expectedTitle = searchValue + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("User should see About link")
    public void userShouldSeeAboutLink() {

        Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());
    }

    @And("User clicks About link")
    public void userClicksAboutLink() {
        googleSearchPage.aboutLink.click();
    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {

        String expectedTitle = "Google - About Google, Our Culture & Company News";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Then("User should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linkStrings) {
        int expectedSize = linkStrings.size();
        int actualSize = googleSearchPage.footerLinks.size();

        Assert.assertEquals(actualSize,expectedSize);

    }

}
