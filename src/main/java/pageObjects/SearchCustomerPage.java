package pageObjects;

import Utils.BasicUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchCustomerPage {

    WebDriver driver;
    BasicUtilities utils;
    public SearchCustomerPage(WebDriver driver){
        this.driver = driver;
        utils = new BasicUtilities(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(how = How.XPATH,using = "//a[contains(@href,'Create')]")
    private WebElement btnAddNewCustomer;

    @FindBy(how = How.ID,using = "SearchEmail")
    private WebElement txtEmail;

    @FindBy(how = How.ID,using = "SearchFirstName")
    private WebElement txtFirstName;

    @FindBy(how = How.ID,using = "SearchLastName")
    private WebElement txtLastName;

    @FindBy(how = How.ID,using = "SearchMonthOfBirth")
    private WebElement drpdownDobMonth;

    @FindBy(how = How.ID,using = "SearchDayOfBirth")
    private WebElement drpdownDobDay;

    @FindBy(how = How.ID,using = "SearchCompany")
    private WebElement txtCompany;

    @FindBy(how = How.ID,using = "SearchIpAddress")
    private WebElement txtIpAddress;

    @FindBy(how = How.ID,using = "search-customers")
    private WebElement btnSearch;

    @FindBy(how = How.XPATH,using = "//table[contains(@id,'customers-grid')]")
    private WebElement table;

    @FindBy(how = How.XPATH,using = "//table[contains(@id,'customers-grid')]/tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(how = How.XPATH,using = "//table[contains(@id,'customers-grid')]/tbody/tr/td")
    private List<WebElement> tableColumns;

    public void clickAddNew(){
        btnAddNewCustomer.click();
    }

    public void setEmail(String email){
        utils.verifyElementPresent(txtEmail);
        utils.clearText(txtEmail);
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String fname){
        utils.verifyElementPresent(txtFirstName);
        utils.clearText(txtFirstName);
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname){
        utils.verifyElementPresent(txtLastName);
        utils.clearText(txtLastName);
        txtLastName.sendKeys(lname);
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public int getNoOfRows(){
        return (tableRows.size());
    }

    public int getNoOfColumns(){
        return (tableColumns.size());
    }

    public boolean verifyCustomerByEmail(String email){

        boolean flag = false;
        for(int i=1; i<=getNoOfRows(); i++){
            String emailId = driver.findElement(By.xpath("//table[contains(@id,'customers-grid')]/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailId);

            if(emailId.equalsIgnoreCase(email)){
                flag = true;
            }
            else{
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    public boolean searchCustomerbyName(String fnamelname){
        boolean flag = false;
        for(int i=1; i<=getNoOfRows(); i++){
            String name = driver.findElement(By.xpath("//table[contains(@id,'customers-grid')]/tbody/tr["+i+"]/td[3]")).getText();
            String[] names = name.split(" ");
            String[] argname = fnamelname.split(" ");
            System.out.println(names[0]);
            System.out.println(names[1]);
            System.out.println(argname[0]);
            System.out.println(argname[1]);
                    if(names[0].equalsIgnoreCase(argname[0]) && names[1].equalsIgnoreCase(argname[1])){
                        flag = true;
                    }
                    else{
                        flag = false;
                        return flag;
                    }
        }
        return flag;
    }

}
