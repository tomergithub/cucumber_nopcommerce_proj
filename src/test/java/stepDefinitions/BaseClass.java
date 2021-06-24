package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearCustomerPage;

public class BaseClass {
public WebDriver driver;
public LoginPage lp;
public AddcustomerPage addCust;
public SearCustomerPage searchCust;

// created for generating random string for unique email id
public static String randomeString()
{
	String generatedString1=RandomStringUtils.randomAlphabetic(5);
    return (generatedString1);
}




}
