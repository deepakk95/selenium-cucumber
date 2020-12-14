package pageObjects;

import Utils.BasicUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    BasicUtilities utils;
    public WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
        utils = new BasicUtilities(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//a[contains(@href,'#')]//span[contains(text(),'Customers')]")
    private WebElement customersMenu;

    @FindBy(how = How.XPATH,using = "(//span[contains(@class,'menu-item-title')][contains(text(),'Customers')])[1]")
    private WebElement customersLink;

    public void clickCustomersMenu(){
        utils.click(customersMenu);
    }

    public void clickCustomersLink(){
        utils.click(customersLink);
    }



}
