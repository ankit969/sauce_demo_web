package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class InventoryPage extends BasePage{
	
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	private final By productsTitle = By.cssSelector(".title");
    private final By productList = By.id("inventory_container");
    private final By productItems = By.className("inventory_item");
    private final By productNames = By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");
    private final By productImages = By.cssSelector(".inventory_item_img img");
    private final By addToCartButtons = By.cssSelector("button.btn_inventory");
	
	/* ------- BASIC  --------- */
    
	public String getProductsTitle() {
        return getText(productsTitle);
    }

    public boolean isProductsTitleDisplayed() {
        return isDisplayed(productsTitle);
    }

    public boolean isUserOnInventoryPage() {
        return getCurrentUrl().contains("inventory.html");
    }
    
    public boolean isProductListDisplayed() {
    	return isDisplayed(productList);
    }
    
    /* ------- Counts  --------- */
	
    public int getProductCount() {
    	return getElements(productItems).size();
    }
    
    public int getProductNameCount() {
    	return getElements(productNames).size();
    }
    
    public int getProductPriceCount() {
    	return getElements(productPrices).size();
    }
    
    public int getProductImageCount() {
    	return getElements(productImages).size();
    }
    
    public int getAddToCartButtonCount() {
    	return getElements(addToCartButtons).size();
    }
    
    /* ------- visibility checks  --------- */
    
    public boolean areAllProductNamesVisible() {
    	return getElements(productNames).stream().allMatch(WebElement::isDisplayed);
    }
    
    public boolean areAllProductPricesVisible() {
    	return getElements(productPrices).stream().allMatch(WebElement::isDisplayed);
    }
    
    public boolean areAllProductImagesVisible() {
    	return getElements(productImages).stream().allMatch(WebElement::isDisplayed);
    }
    
    public boolean areAllAddToCartButtonsVisible() {
    	return getElements(addToCartButtons).stream().allMatch(WebElement::isDisplayed);
    }

}
