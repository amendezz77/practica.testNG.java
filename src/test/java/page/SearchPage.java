package page;
import page.OrderPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase {
	WebDriver driver;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.cssSelector("button.btn.btn-default.button-search");
	private By addProducto = By.cssSelector("a.button.ajax_add_to_cart_button.btn.btn-default");
	private By closeAddProducto = By.cssSelector("span.cross");
	private By listProductosBuscados = By.cssSelector("ul.product_list.grid.row div.product-container");
	private By comboCart = By.cssSelector("div.shopping_cart span.ajax_cart_product_txt_s.unvisible");
	private By btnCheckOut = By.cssSelector("p.cart-buttons i.icon-chevron-right.right");
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void SearchInput(String text) {
		inputText(text, searchBoxLocator);
		Click(searchBtnLocator);
	}
	
	public void IterarProductos() {
		List<WebElement> allproducto = listfinElements(listProductosBuscados);
		for (WebElement producto: allproducto) {
		 	ElmentMovent(producto);
			producto.findElement(addProducto).click();
			ElementMoventClickBy(closeAddProducto);
		   }	
	}

	public void CarCheckout() {
		ElementMoventBy(comboCart);
		ElementMoventClickBy(btnCheckOut);
	}
	
	
}
