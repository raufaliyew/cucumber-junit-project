package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoBlazeCartPage {

    public DemoBlazeCartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "cartur")
    public WebElement cartMenu;

    @FindBy (id = "totalp")
    public WebElement totalPrice;

    @FindBy (xpath = "//*[@class='btn btn-success']")
    public WebElement placeOrder;

    @FindBy (css = "input[id='name']")
    private WebElement nameField;

    @FindBy (css = "input[id='country']")
    private WebElement countryField;

    @FindBy (css = "input[id='city']")
    private WebElement cityField;

    @FindBy (css = "input[id='card']")
    private WebElement creditCardField;

    @FindBy (css = "input[id='month']")
    private WebElement monthField;

    @FindBy (css = "input[id='year']")
    private WebElement yearField;

    @FindBy (css = "button[onclick=\"purchaseOrder()\"]")
    public WebElement purchaseBtn;

    @FindBy (xpath = "//p[@class='lead text-muted ']")
    public WebElement amount;

    @FindBy (xpath = "//button[.='OK']")
    public WebElement purchaseConfOkBtn;

    //For checking if table's body empty or not
    @FindBy(id = "tbodyid")
    public WebElement tableBody;

    public void deleteChosenProduct(String product){

        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//tbody//td[.='"+product+"']//following-sibling::td[2]//a"));
        deleteBtn.click();
    }



    public void fullFillPlaceOrderForm (){
        Faker faker = new Faker();
        nameField.sendKeys(faker.name().firstName());
        countryField.sendKeys(faker.country().name());
        cityField.sendKeys(faker.country().capital());
        creditCardField.sendKeys(faker.finance().creditCard());
        monthField.sendKeys("July");
        yearField.sendKeys("2022");

    }

    public String getFinalAmount(){
        List<String> list = new ArrayList<>();
        list = Arrays.asList(amount.getText().split(" "));
        return list.get(2);
    }
}
