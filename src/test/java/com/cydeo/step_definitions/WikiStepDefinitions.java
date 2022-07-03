package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }
    @When("User searches {string} in the wiki search page")
    public void user_searches_in_the_wiki_search_page(String searchValue) {
        wikiSearchPage.search.sendKeys(searchValue+ Keys.ENTER);
    }
    @Then("User should see {string} in the wiki title")
    public void user_should_see_in_the_wiki_title(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }


    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedHeader) {
        Assert.assertTrue(wikiSearchPage.mainHeaderAfterSearch.getText().contains(expectedHeader));

    }

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String expectedHeader) {
        String actualHeader = wikiSearchPage.imgHeaderAfterSearch.getText();

        Assert.assertEquals(actualHeader,expectedHeader);
    }
}
