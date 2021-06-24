package stepDefinitions;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearCustomerPage;

public class Steps extends BaseClass{

	
@Given("User Launch Chrome browser")
public void user_Launch_Chrome_browser() {
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();	
	lp=new LoginPage(driver);
    
}

@When("User opens URL {string}")
public void user_opens_URL(String url) {
	
	driver.get(url);
    
}

@When("User enters Email as {string} and Password as {string}")
public void user_enters_Email_as_and_Password_as(String email, String password) {
   lp.setUserName(email);
   lp.setPassword(password);
}

@When("Click on Login")
public void click_on_Login() throws InterruptedException {
   lp.clickLogin();
   Thread.sleep(3000);
}


@Then("Page Title should be {string}")
public void page_Title_should_be(String title) throws InterruptedException {
	System.out.println(driver.getTitle());
    if(driver.getPageSource().contains("Login was unsuccessful."))
    {
    	driver.close();
    	Assert.assertTrue(false);
    	
    }
    else {
    	System.out.println(driver.getTitle());
    	Assert.assertEquals(title,driver.getTitle());
    	Thread.sleep(3000);
    }
}

@When("User click on Log out link")
public void user_click_on_Log_out_link() throws InterruptedException {
	Thread.sleep(3000);
	lp.clickLogout();
 Thread.sleep(3000);
}

@Then("close browser")
public void close_browser() {
    driver.quit();
}

//Customer feature step definitions...

@Then("USer can view Dashboard")
public void user_can_view_Dashboard() {
    addCust=new AddcustomerPage(driver);
    Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
}

@When("User click on customers Menu")
public void user_click_on_customers_Menu() throws InterruptedException {
	Thread.sleep(3000);
   addCust.clickOnCustomersMenu(); 
}

@When("click on customers Menu Item")
public void click_on_customers_Menu_Item() throws InterruptedException {
    
	Thread.sleep(2000);
	addCust.clickOnCustomersMenuItem();
}

@When("click on Add new button")
public void click_on_Add_new_button() throws InterruptedException {
	Thread.sleep(2000);
	addCust.clickOnAddnew();
	Thread.sleep(2000);
}

@Then("User can view Add new customer page")
public void user_can_view_Add_new_customer_page() {
    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
    
}

@When("User enter customer info")
public void user_enter_customer_info() throws InterruptedException{
    
	String email=randomeString()+"@gmail.com";
    addCust.setEmail(email);
    addCust.setPassword("test123");
    //Registered-default
    //The customer cannot be in both 'Guests' and 'Registered' customer roles
    //Add the customer to 'Guests' or 'Registered' customer role
    addCust.setCustomerRoles("Guests");  
    
    Thread.sleep(3000);
    addCust.setManagerOfVendor("Vendor 2");
    addCust.setGender("Male");
    addCust.setFirstName("Pavan");
    addCust.setLastName("Kumar");
    addCust.setDob("7/5/1985");//Format:D/MM/YYYY
    addCust.setCompanyName("busyQA");
    addCust.setAdminContent("This is for testing........");
}

@When("click on save button")
public void click_on_save_button() throws InterruptedException {
    addCust.clickOnSave();
    Thread.sleep(2000);
}

@Then("User can view confiramtion message {string}")
public void user_can_view_confiramtion_message(String msg) {
    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
    		.contains("The new customer has been added successfully"));
    
}
// steps from searching a customer using Email ID......
@When("Enter customer EMail")
public void enter_customer_EMail() {
    searchCust=new SearCustomerPage(driver);
    searchCust.setEmail("victoria_victoria@nopCommerce.com");
}

@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
    searchCust.clickSearch();
    Thread.sleep(3000);
}

@Then("USer should found Email in the Search table")
public void user_should_found_Email_in_the_Search_table() {
   boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com"); 
   Assert.assertEquals(true, status);
}

@When("Enter customer FirstName")
public void enter_customer_FirstName() {
	searchCust=new SearCustomerPage(driver);
	searchCust.setFirstName("Victoria");
}

@When("Enter customer LastName")
public void enter_customer_LastName() {
	//searchCust=new SearCustomerPage(driver);
	searchCust.setLastName("Terces");
}

@Then("USer should found Name in the Search table")
public void user_should_found_Name_in_the_Search_table() throws InterruptedException  {
	boolean status=searchCust.searchCustomerByName("Victoria Terces");
	Thread.sleep(2000);
	Assert.assertEquals(true, status);
}


}
