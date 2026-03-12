package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public By price = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
    By addToCart = By.xpath("//button[text()='Add to cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPrice() {

        return driver.findElement(price).getText();
    }

    public void clickAddToCart() {

        driver.findElement(addToCart).click();
    }

	public void selectSize(String string) {
		// TODO Auto-generated method stub
		
	}

	public void selectQuantity(int i) {
		// TODO Auto-generated method stub
		
	}
}
