package stepDefinitions;

import Utils.BasicUtilities;
import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.CommonPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps extends Driver {

    WebDriver driver;
    LoginPage lp;
    CommonPage cp;
    AddCustomerPage acp;
    SearchCustomerPage scp;
    BasicUtilities utils;

    @Before
    public void setup(){
        driver = new Driver().createDriver();
    }
    @Given("user launch browser")
    public void user_launch_browser() {
        lp = new LoginPage(driver);
        cp = new CommonPage(driver);
        acp = new AddCustomerPage(driver);
        scp = new SearchCustomerPage(driver);
        utils = new BasicUtilities(driver);
    }

    @When("user opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setEmail(email);
        lp.setPassword(password);
    }

    @When("click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            System.out.println("Page Title not Verified");
            Assert.assertTrue(false);
        }
        else{
            Assert.assertEquals(title,driver.getTitle());
            System.out.println("Page Title not verified");
        }
    }

    @When("user click on log out link")
    public void user_click_on_log_out_link() {
        lp.clickLogout();

    }

    @After
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

//    @AfterClass
//    public void tearDown() throws IOException {
//        String browserName = PropertyFileHandler.getdataFromConfigurationFile("browser");
//        if(browserName.equalsIgnoreCase("chrome")){
//            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
//        }
//        else if(browserName.equalsIgnoreCase("edge")){
//            Runtime.getRuntime().exec("taskkill /im msedgedriver.exe /f");
//        }
//    }

    // Steps for Adding a New Customer
    @Then("user can view dashboard")
    public void user_can_view_dashboard() {
        Assert.assertTrue(utils.verifyTitle("Dashboard / nopCommerce administration"));
    }


    @When("user click on customers menu")
    public void user_click_on_customers_menu() {
        cp.clickCustomersMenu();
    }
    @When("click on customers menu item")
    public void click_on_customers_menu_item() {
        cp.clickCustomersLink();
    }
    @When("click on add new button")
    public void click_on_add_new_button() {
        scp.clickAddNew();
    }
    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertTrue(utils.verifyTitle("Add a new customer / nopCommerce administration"));
    }
    @When("user enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = BasicUtilities.randomString() + "@gmail.com";
        acp.setEmail(email);
        acp.setPassword("123qweasd");
        acp.setTxtFirstName("John");
        acp.setLastName("Doe");
        acp.setGender("Male");
        acp.setDOB("12/10/1995"); //mm/dd/yyyy
        acp.setCompanyName("Company123");
        Thread.sleep(3000);
        acp.setcustomerRoles("Guests");
        Thread.sleep(3000);
        acp.setManagerOfVendor("Vendor 2");
        acp.setAdminContent("Happy Testing...");

    }
    @When("click on save button")
    public void click_on_save_button() {
        acp.clickSave();
    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(acp.verifyCustomerAdded(message));
    }

    // Steps for searching customer using Email Id
    @When("enter customer email")
    public void enter_customer_email() {
        scp.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("user click on search button")
    public void user_click_on_search_button() throws InterruptedException {
        scp.clickSearch();
        Thread.sleep(3000);
    }
    @Then("user should find email in the table")
    public void user_should_find_email_in_the_table() {
        Assert.assertTrue(scp.verifyCustomerByEmail("victoria_victoria@nopCommerce.com"));
    }

    @When("enter customer firstname as {string}")
    public void enter_customer_firstname(String fname) {
        scp.setFirstName(fname);
    }

    // Steps for searching customer using FirstName and LastName
    @When("enter customer lastname as {string}")
    public void enter_customer_lastname(String lname) {
        scp.setLastName(lname);
    }
    @Then("user should find Name as {string} in the table")
    public void user_should_find_name_in_the_table(String name) {
        Assert.assertTrue(scp.searchCustomerbyName(name));
    }

}
