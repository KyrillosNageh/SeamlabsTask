package com.utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverHelper  {
 
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
     
 
    public WebDriverHelper(WebDriver driver) throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("D:\\Testing\\projects\\SeamLabs_Task\\src\\test\\resources\\properties\\config.properties");
        props.load(fis);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(props.getProperty("elementTimeout"))));
        jsExecutor = (JavascriptExecutor) driver;
    }

    public void hoverAndClick(By locator) {
        WebElement element = highlightElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
        	 new Actions(driver)
        	 .moveToElement(element)
        	 .click()
        	 .perform();
        	
        }catch (Exception e) {
       	 new Actions(driver)
       	 .moveToElement(element)
       	 .click()
       	 .perform();		
       	 }
        unhighlightElement(element);
    }
    
    public void hover(By locator) {
        WebElement element = highlightElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
        	 new Actions(driver)
        	 .moveToElement(element)
        	 .perform();
        	
        }catch (Exception e) {
       	 new Actions(driver)
       	 .moveToElement(element)
       	 .perform();		
       	 }
        unhighlightElement(element);
    }

    public void sendKeysWhenReady(By locator, String text) {
        WebElement element = highlightElement(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).clear();
        element.sendKeys(text);
        unhighlightElement(element);
    }
    
    
    public String getElementText(By locator) {
    	String text;
        WebElement element = highlightElement(locator);
        text = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
        unhighlightElement(element);
        return text;
    }
    
    public String getElementLinkUrl(By locator) {
    	String text;
        WebElement element = highlightElement(locator);
        text = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("href");
        unhighlightElement(element);
        return text;
    }
    
    public Boolean isElementDisplayed(By locator) {
    	Boolean flag;
        WebElement element = highlightElement(locator);
        flag = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
        unhighlightElement(element);
        return flag;
    }

    public void waitUntilRedirectTo(String url)  {
    	
    	wait.until(ExpectedConditions.urlToBe(url));
    	wait.until(ExpectedConditions.titleContains("Outdoors"));
    	
    }
    private WebElement highlightElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return element;
    }

    private void unhighlightElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white;');", element);
    }


}
