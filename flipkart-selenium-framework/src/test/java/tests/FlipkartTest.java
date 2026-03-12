package tests;

import base.BaseTest;
import pages.SearchPage;
import pages.ProductPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ScreenshotUtil;

import java.time.Duration;

public class FlipkartTest extends BaseTest {

    @Test
    public void flipkartEndToEndTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Search product
        driver.findElement(By.name("q")).sendKeys("Samsung Mobile");
        driver.findElement(By.name("q")).submit();

        // 2. Apply brand filter
        SearchPage searchPage = new SearchPage(driver);
        searchPage.applyBrandFilter("Samsung"); // Pass brand name

        // 3. Wait for first product and select
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_4rR01T'])[1]")));
        searchPage.selectFirstProduct();

        // 4. Switch to new tab
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        ProductPage productPage = new ProductPage(driver);

        // 5. Select size if available
        productPage.selectSize("128 GB"); // optional, ignore if not present

        // 6. Select quantity
        productPage.selectQuantity(2); // change quantity to 2

        // 7. Wait and print dynamic price
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.price));
        String price = productPage.getProductPrice();
        System.out.println("Product Price: " + price);

        // 8. Add to cart
        productPage.clickAddToCart();

        // 9. Take screenshot
        ScreenshotUtil.captureScreenshot(driver, "Flipkart_Product");
    }
}
