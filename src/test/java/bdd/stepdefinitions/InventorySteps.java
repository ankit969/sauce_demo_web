package bdd.stepdefinitions;

import org.testng.Assert;

import driver.DriverManager;
import io.cucumber.java.en.Then;
import pages.InventoryPage;

public class InventorySteps {
	
	InventoryPage inventoryPage = new InventoryPage(DriverManager.getDriver());

    @Then("user should be on inventory page")
    public void verifyInventoryPage() {
        Assert.assertTrue(inventoryPage.isUserOnInventoryPage());
    }

    @Then("inventory title should be {string}")
    public void verifyTitle(String expectedTitle) {
        Assert.assertEquals(inventoryPage.getProductsTitle(), expectedTitle);
    }

    @Then("product list should be displayed")
    public void verifyProductList() {
        Assert.assertTrue(inventoryPage.isProductListDisplayed());
    }

    @Then("product count should be greater than 0")
    public void verifyProductCount() {
        Assert.assertTrue(inventoryPage.getProductCount() > 0);
    }

    @Then("all product names should be visible")
    public void verifyNames() {
        Assert.assertTrue(inventoryPage.areAllProductNamesVisible());
    }

    @Then("all product prices should be visible")
    public void verifyPrices() {
        Assert.assertTrue(inventoryPage.areAllProductPricesVisible());
    }

    @Then("all product images should be visible")
    public void verifyImages() {
        Assert.assertTrue(inventoryPage.areAllProductImagesVisible());
    }

    @Then("all add to cart buttons should be visible")
    public void verifyButtons() {
        Assert.assertTrue(inventoryPage.areAllAddToCartButtonsVisible());
    }

    @Then("all product components count should match")
    public void verifyConsistency() {
        int names = inventoryPage.getProductNameCount();
        int prices = inventoryPage.getProductPriceCount();
        int images = inventoryPage.getProductImageCount();
        int buttons = inventoryPage.getAddToCartButtonCount();

        Assert.assertEquals(names, prices);
        Assert.assertEquals(prices, images);
        Assert.assertEquals(images, buttons);
    }

    @Then("total product count should be {int}")
    public void verifyTotalCount(int expected) {
        Assert.assertEquals(inventoryPage.getProductCount(), expected);
    }

}
