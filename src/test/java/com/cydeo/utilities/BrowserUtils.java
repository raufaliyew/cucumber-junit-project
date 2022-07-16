package com.cydeo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {

    /**
     * A method to pause the thread certain seconds
     * @param seconds
     */
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static List<String> getElementsText(List<WebElement> elements) {


        List<String> elementsText=new ArrayList<>();

        for (WebElement element : elements) {
            elementsText.add( element.getText());
        }

        return elementsText;
    }


    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickAbility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Waits for alertIsPresent
     *
     */
    public static void waitForAlertIsPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }


    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in //try catch block to continue the broken link analysis
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter
            URL link = new URL(urlLink);

            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout(2000);

            //connect using connect method
            httpConn.connect();

            //use getResponseCode() to get the response code.
            if(httpConn.getResponseCode()== 200)
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());

            if(httpConn.getResponseCode()== 404)
                System.out.println(urlLink+" - "+httpConn.getResponseMessage());
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the //server.
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void highlightElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use executeScript() method and pass the arguments
        //Here I pass values based on css style. Yellow background color with solid red  // color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border:  2px solid red;');", element);
    }


}
