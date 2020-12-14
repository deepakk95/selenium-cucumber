package pageObjects;

import Utils.BasicUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    BasicUtilities utils;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        utils = new BasicUtilities(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID,using = "Email")
    private WebElement txtEmail;

    @FindBy(how = How.ID,using = "Password")
    private WebElement txtPassword;

    @FindBy(how = How.ID,using = "RememberMe")
    private WebElement chkRememberMe;

    @FindBy(how = How.CSS,using = "input[class*='login-button']")
    private WebElement btnLogin;

    @FindBy(how = How.XPATH,using = "//a[contains(@href,'logout')]")
    private WebElement btnLogout;

    public void setEmail(String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void clickLogin(){
        btnLogin.click();
    }
    public void clickLogout(){
        btnLogout.click();
    }
}
