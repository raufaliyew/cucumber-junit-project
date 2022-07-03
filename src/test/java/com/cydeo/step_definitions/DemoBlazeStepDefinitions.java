package com.cydeo.step_definitions;

import com.cydeo.pages.DemoBlazeCartPage;
import com.cydeo.pages.DemoBlazeMainPage;
import com.cydeo.pages.DemoBlazeProductDetailPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class DemoBlazeStepDefinitions {

    DemoBlazeMainPage demoBlazeMainPage = new DemoBlazeMainPage();
    DemoBlazeCartPage demoBlazeCartPage = new DemoBlazeCartPage();
    DemoBlazeProductDetailPage demoBlazeProductDetailPage = new DemoBlazeProductDetailPage();

    @Given("User is on the DemoBlaze page")
    public void user_is_on_the_demo_blaze_page() {
        Driver.getDriver().get("https://www.demoblaze.com/");
    }

    @When("User navigates to {string} category")
    public void userNavigatesToCategory(String categoryName) {
        demoBlazeMainPage.chooseCategory(categoryName);
    }

    @When("User selects {string}")
    public void user_selects(String productName) {
        demoBlazeMainPage.chooseProduct(productName);
    }

    @When("User clicks Add to cart")
    public void user_clicks_add_to_cart() {
        demoBlazeProductDetailPage.addToCartBtn.click();
    }

    @Then("User should see Product added pop up notification and confirm it")
    public void user_should_see_product_added_pop_up_notification_and_confirm_it() {
        BrowserUtils.waitForAlertIsPresent(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }


    @When("User navigates to Cart menu")
    public void user_navigates_to_cart_menu() {
        demoBlazeCartPage.cartMenu.click();
    }

    @When("User deletes {string} from cart")
    public void user_deletes_from_cart(String product) {
        demoBlazeCartPage.deleteChosenProduct(product);
        BrowserUtils.waitFor(1);
    }

    @When("User clicks Place order")
    public void user_clicks_place_order() {
        demoBlazeCartPage.placeOrder.click();
    }

    @And("User fills Place Order form")
    public void userFillsPlaceOrderForm() {
        demoBlazeCartPage.fullFillPlaceOrderForm();
    }

    @When("User clicks Purchase")
    public void user_clicks_purchase() {
        demoBlazeCartPage.purchaseBtn.click();
        BrowserUtils.waitFor(1);

    }



    @When("User verifies amount is correct")
    public void user_verifies_amount_is_correct() {
        String expectedAmount = demoBlazeCartPage.totalPrice.getText();
        String actualAmount = demoBlazeCartPage.getFinalAmount();
        Assert.assertEquals(actualAmount,expectedAmount);

    }

    @When("User clicks Ok")
    public void user_clicks_ok() {
        demoBlazeCartPage.purchaseConfOkBtn.click();
    }

    @Then("User should see there is no product in the cart")
    public void user_should_see_there_is_no_product_in_the_cart() {
        demoBlazeCartPage.cartMenu.click();
        Assert.assertEquals(demoBlazeCartPage.tableBody.getText(),"");

    }


}
