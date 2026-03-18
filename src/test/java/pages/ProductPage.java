package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class ProductPage {

    WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    // Actions
    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
    public boolean isProductDisplayedInCart() {
        return driver.findElement(By.className("inventory_item_name")).isDisplayed();
    }
    By removeBtn = By.id("remove-sauce-labs-backpack");

    public void removeProduct() {
        driver.findElement(removeBtn).click();
    }
}