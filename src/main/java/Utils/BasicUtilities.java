package Utils;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasicUtilities {

    WebDriver driver;
    BasicUtilities utils;
    public BasicUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectByVisibleText(WebElement dropdown, String text){
        Select s = new Select(dropdown);
        s.selectByVisibleText(text);
    }

    public void enterValue(WebElement element, String value){
        element.sendKeys(value);
    }

    public void click(WebElement element){
        wait(element);
        element.click();
    }

    public void pageRefresh(){
        driver.navigate().refresh();
    }

    public boolean verifyElementPresent(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean verifyElementIsNotPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,90);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        }
        catch (Exception e) {
            System.out.println("Element still present");
            return false;
        }
    }

    public String verifyValue(WebElement element){
        if(verifyElementPresent(element)){
            return element.getText().trim();
        }
        else{
            return "";
        }
    }

    public boolean verifyTitle(String title){
        if(driver.getTitle().equalsIgnoreCase(title)){
            System.out.println("Title is verified");
            return true;
        }
        else{
            System.out.println("Title not verified");
            return false;
        }
    }

    public void clearText(WebElement element){
        element.clear();
    }

    public static String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        return generatedString;
    }

}
