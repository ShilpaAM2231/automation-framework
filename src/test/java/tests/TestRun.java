package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;

public class TestRun extends BaseTest {

    @Test
    public void openBrowserTest() throws InterruptedException {

        // Login
        HomePage home = new HomePage(driver);
        home.login("standard_user", "secret_sauce");

        Thread.sleep(3000);

        // Add to cart
        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        product.goToCart();

        Thread.sleep(3000);

        // Verify cart page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart.html"), "Cart navigation failed!");

        Thread.sleep(3000);
        Assert.assertTrue(product.isProductDisplayedInCart(), "Product not found in cart!");
        product.removeProduct();

     // Verify cart is empty
     Assert.assertTrue(driver.findElements(By.className("cart_item")).isEmpty(), 
                       "Cart is not empty!");
    }
    
    
}