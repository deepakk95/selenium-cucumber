package pageObjects;

import Utils.BasicUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    BasicUtilities utils;
    public WebDriver driver;
    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        utils = new BasicUtilities(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID,using = "Email")
    private WebElement txtEmail;

    @FindBy(how = How.ID,using = "Password")
    private WebElement txtPassword;

    @FindBy(how = How.ID,using = "FirstName")
    private WebElement txtFirstName;

    @FindBy(how = How.ID,using = "LastName")
    private WebElement txtLastName;

    @FindBy(how = How.ID,using = "Gender_Male")
    private WebElement rdoGenderMale;

    @FindBy(how = How.ID,using = "Gender_Female")
    private WebElement rdoGenderFemale;

    @FindBy(how = How.ID,using = "DateOfBirth")
    private WebElement txtDateOfBirth;

    @FindBy(how = How.ID,using = "Company")
    private WebElement txtCompany;

    @FindBy(how = How.ID,using = "SelectedCustomerRoleIds")
    private WebElement custRoles;

    @FindBy(how = How.XPATH,using = "//ul[contains(@id,'SelectedCustomerRoleIds_taglist')]/following-sibling::input")
    private WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'k-list-scroller')]//li[contains(text(),'Administrators')]")
    private WebElement itemAdministrators;

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'k-list-scroller')]//li[contains(text(),'Registered')]")
    private WebElement itemRegistered;

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'k-list-scroller')]//li[contains(text(),'Guests')]")
    private WebElement itemGuests;

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'k-list-scroller')]//li[contains(text(),'Vendors')]")
    private WebElement itemVendors;

    @FindBy(how = How.ID,using = "VendorId")
    private WebElement drpdwnVendorManager;

    @FindBy(how = How.ID,using = "AdminComment")
    private WebElement txtAdminContent;

    @FindBy(how = How.CSS,using = "button[name='save']")
    private WebElement btnSave;

    @FindBy(how = How.XPATH,using = "//span[contains(@title,'delete')]/../span[contains(text(),'Registered')]")
    private WebElement dfltRegistered;

    @FindBy(how = How.XPATH,using = "//span[contains(@title,'delete')]")
    private WebElement dltExistingCustRole;

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'alert-success')]")
    private WebElement msgCustomerAdded;

    public void setEmail(String email){
        utils.enterValue(txtEmail,email);
    }

    public void setPassword(String password){
        utils.enterValue(txtPassword,password);
    }

    public void setTxtFirstName(String fname){
        utils.enterValue(txtFirstName,fname);
    }

    public void setLastName(String lname){
        utils.enterValue(txtLastName,lname);
    }

    public void setGender(String gender){
        if(gender.equalsIgnoreCase("Male")){
            utils.click(rdoGenderMale);
        }
        else if(gender.equalsIgnoreCase("Female")){
            utils.click(rdoGenderFemale);
        }
        else utils.click(rdoGenderMale); // Default
    }

    public void setDOB(String dob){
        utils.enterValue(txtDateOfBirth,dob);
    }

    public void setCompanyName(String company){
        utils.enterValue(txtCompany,company);
    }

    public void setcustomerRoles(String role){
        WebElement lstItem = null;
        if(dfltRegistered.isDisplayed()){
            dltExistingCustRole.click();
            utils.click(txtCustomerRoles);
        }
        if(role.equalsIgnoreCase("Administrators")){
            lstItem = itemAdministrators;
        }
        else if(role.equalsIgnoreCase("Guests")){
            lstItem = itemGuests;
        }
        else if(role.equalsIgnoreCase("Registered")){
            lstItem = itemRegistered;
        }
        else if(role.equalsIgnoreCase("Vendors")){
            lstItem = itemVendors;
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",lstItem);
    }

    public void setManagerOfVendor(String value){
        utils.selectByVisibleText(drpdwnVendorManager,value);
    }

    public void setAdminContent(String content){
        utils.enterValue(txtAdminContent,content);
    }

    public void clickSave(){
        utils.click(btnSave);
    }

    public boolean verifyCustomerAdded(String message){
        if(utils.verifyValue(msgCustomerAdded).contains(message)){
            return true;
        }
        else{
            return false;
        }
    }

}
