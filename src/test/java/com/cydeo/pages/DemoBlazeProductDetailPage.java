package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlazeProductDetailPage {

    public DemoBlazeProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy (xpath = "//*[.='Add to cart']//a")
    public WebElement addToCartBtn;

}
