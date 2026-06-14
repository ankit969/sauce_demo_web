package tdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;

public class InventoryTest extends BaseTest{
	
	private InventoryPage inventoryPage;
	
	@Override
	protected void preCondition() {
		loginPage.login("standard_user", "secret_sauce");
		inventoryPage = new InventoryPage(driver);
	}
	
	// TC_INV_001 & TC_INV_002
	@Test(priority = 1)
	public void verifyUserLandsOnInventoryPage() {
		Assert.assertTrue(inventoryPage.isUserOnInventoryPage(), "User should be navigate to inventory page");
	}
	
	// TC_INV_003
	@Test(priority = 2)
	public void verifyInventoryTitle() {
		Assert.assertTrue(inventoryPage.isProductsTitleDisplayed());
		Assert.assertEquals(inventoryPage.getProductsTitle(), "Products");
	}
	
	// TC_INV_004
	@Test(priority = 3)
	public void verifyProductListLoaded() {
		Assert.assertTrue(inventoryPage.isProductListDisplayed());
	}
	
	// TC_INV_005
	@Test(priority = 4)
	public void verifyProductCountGreaterThanZero() {
		Assert.assertTrue(inventoryPage.getProductCount() > 0);
	}
	
	// TC_INV_006-009(Grouped)
	public void verifyAllProductDetailsVisible() {
		Assert.assertTrue(inventoryPage.areAllProductNamesVisible());
        Assert.assertTrue(inventoryPage.areAllProductPricesVisible());
        Assert.assertTrue(inventoryPage.areAllProductImagesVisible());
        Assert.assertTrue(inventoryPage.areAllAddToCartButtonsVisible());
	}
	
	// TC_INV_010
    @Test(priority = 6)
    public void verifyProductComponentConsistency() {
        int names = inventoryPage.getProductNameCount();
        int prices = inventoryPage.getProductPriceCount();
        int images = inventoryPage.getProductImageCount();
        int buttons = inventoryPage.getAddToCartButtonCount();

        Assert.assertEquals(names, prices);
        Assert.assertEquals(prices, images);
        Assert.assertEquals(images, buttons);
    }
    
    // TC_INV_011
    @Test(priority = 7)
    public void verifyExpectedProductCount() {
        Assert.assertEquals(inventoryPage.getProductCount(), 6);
    }
	
	

}
