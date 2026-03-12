package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By brandFilter = By.xpath("//div[text()='SAMSUNG']");
    By firstProduct = By.xpath("(//div[@class='_4rR01T'])[1]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyBrandFilter() {

        driver.findElement(brandFilter).click();
    }

    public void selectFirstProduct() {

        driver.findElement(firstProduct).click();
    }

	public void applyBrandFilter(String string) {
		// TODO Auto-generated method stub
		
	}
}
