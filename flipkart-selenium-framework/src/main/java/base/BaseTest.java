package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import config.ConfigReader;
import utils.DriverFactory;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    Properties prop;

    @BeforeMethod
    public void setup() {

        prop = ConfigReader.getProperties();

        driver = DriverFactory.initializeDriver();

        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
