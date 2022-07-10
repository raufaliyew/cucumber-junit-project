package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMilageCalculatePage {

    public GasMilageCalculatePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "uscodreading")
    public WebElement inputCurrentOdo;

    @FindBy (id = "uspodreading")
    public WebElement inputPreviousOdo;

    @FindBy (id = "usgasputin")
    public WebElement inputGas;

    @FindBy (xpath = "(//input[@alt='Calculate'])[1]")
    public WebElement calculateBtn;

    @FindBy (xpath = "//b[contains(text(),'mpg')]")
    public WebElement resultInGas;


}
