package org.quality.practica;
import org.testng.annotations.Test;
import page.LoginPage;
import page.OrderPage;
import page.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PracticaTestNG {
	
  WebDriver driver;
  LoginPage loginPage;
  SearchPage searchPage;
  OrderPage orderPage;

  
  @BeforeTest
  public void beforeClass() {
	  loginPage = new LoginPage(driver);
	  
	  driver = loginPage.chromeDriverConnection();
	  loginPage.visit("http://automationpractice.com");
      loginPage.loginUser("mendez123ariel@gmail.com","escuela123");
  }
  
  @Test
  public void testTextoBlue() throws InterruptedException {
	  
	  searchPage = new SearchPage(driver);
	  searchPage.SearchInput("blue");
	  
	  searchPage.IterarProductos();
	  searchPage.CarCheckout();
	  orderPage  = new OrderPage(driver);
	  orderPage.Checkout();
	  String text = orderPage.getTextMsj();
	  Assert.assertEquals(text,"Your order on My Store is complete.");
	  
  }
	
  @Test public void testTextoBlack() throws InterruptedException { 
	  searchPage = new SearchPage(driver);
	  searchPage.SearchInput("blue");
	  
	  searchPage.IterarProductos();
	  searchPage.CarCheckout();
	  orderPage  = new OrderPage(driver);
	  orderPage.Checkout();
	  String text = orderPage.getTextMsj();
	  Assert.assertEquals(text,"Your order on My Store is complete.");
  }
	 
  
  @AfterTest
  public void afterClass() {
	  driver.close();
  }


}
