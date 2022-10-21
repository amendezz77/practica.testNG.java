package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends PageBase{

	private By btnProcessCheckSummary = By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium");
	private By btnProcessCheck = By.cssSelector("button.button.btn.btn-default.button-medium");
	private By checkShipping = By.id("uniform-cgv");
	private By btnProcessShipping = By.cssSelector("button.button.btn.btn-default.standard-checkout.button-medium");
	private By btnPayBankWirePayment = By.cssSelector("a.bankwire");
	private By confirmationOrder = By.cssSelector("p.cheque-indent strong");
	  
	public OrderPage(WebDriver driver) {
		super(driver);
	}
	
	public void Checkout() {
		ElementMoventClickBy(btnProcessCheckSummary);
		ElementMoventClickBy(btnProcessCheck);
		ElementMoventClickBy(checkShipping);
		ElementMoventClickBy(btnProcessShipping);
		ElementMoventClickBy(btnPayBankWirePayment);
		ElementMoventClickBy(btnProcessCheck);
	}
	
	public String getTextMsj() {
		return getText(confirmationOrder);
	}
}
