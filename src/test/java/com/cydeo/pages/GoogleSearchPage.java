package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage {

    public GoogleSearchPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (name="q")
    public WebElement searchBox;

    @FindBy(linkText = "About")
    public WebElement aboutLink;

    @FindBy (xpath = "//a[@class='pHiOh']")
    public List<WebElement> footerLinks;



}
