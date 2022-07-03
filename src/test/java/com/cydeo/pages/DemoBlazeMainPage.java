package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DemoBlazeMainPage {

    public DemoBlazeMainPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }




    public void chooseCategory(String categoryName) {

        WebElement category = Driver.getDriver().findElement(By.xpath("//*[.='"+categoryName+"']"));
        category.click();
        BrowserUtils.waitFor(1);

    }


    public void chooseProduct(String productName) {
        WebElement product = Driver.getDriver().findElement(By.xpath("//*[.='" + productName + "']"));
        product.click();
        BrowserUtils.waitFor(1);
    }

}
