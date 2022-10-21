package page;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {

	private WebDriver driver;
	private WebElement webElement;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    return driver;
	}
	
	public void ElementMoventClickBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement webElementAction = wait.until(ExpectedConditions.elementToBeClickable(locator));
		actionsBase().moveToElement(webElementAction).click().perform();	
	}
	
	public void ElementMoventBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement webElementAction = wait.until(ExpectedConditions.elementToBeClickable(locator));
		actionsBase().moveToElement(webElementAction).perform();	
	}
	
	public void ElementMoventVisibleBy(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement webElementAction = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		actionsBase().moveToElement(webElementAction).perform();	
	}
	
	public WebElement waitByElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public Actions actionsBase() {
		Actions actions = new Actions(driver);
		return actions;
	}
	
	public void inputText(String text, By locator) {
		webElement = driver.findElement(locator);
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	public void Click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void ElmentMovent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	    WebElement webElementAction = wait.until(ExpectedConditions.elementToBeClickable(element));
	    actionsBase().moveToElement(webElementAction).perform();
	}
	
	public void ElmentMoventClick(WebElement element) {
		//webElement = waitElement(element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement webElementAction = wait.until(ExpectedConditions.elementToBeClickable(element));
		actionsBase().moveToElement(webElementAction).click().perform();
	}
	
	public List<WebElement> listfinElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void visit(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
}
