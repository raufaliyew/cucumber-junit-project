package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {
    public WikiSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "searchInput")
    public WebElement search;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement searchBtn;

    @FindBy (id = "firstHeading")
    public WebElement mainHeaderAfterSearch;

    @FindBy (className = "fn")
    public WebElement imgHeaderAfterSearch;
}
