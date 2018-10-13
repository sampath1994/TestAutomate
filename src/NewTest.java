import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public WebDriver driver;
	
  @Test
  public void main() {
     WebElement search = driver.findElement(By.xpath("//*[@id=\"query\"]"));
     search.sendKeys("benz");
     search.submit();
     
     System.out.println("First Car Info");
     carInfo(0,driver);
     driver.navigate().back();
     System.out.println("");
     System.out.println("Second Car Info");
     carInfo(1, driver);
  }
  @BeforeMethod
  public void beforeMethod() {
	  String exePath = "D:\\chromeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
	    driver = new ChromeDriver();
		driver.get("https://ikman.lk/en/ads/sri-lanka/vehicles");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  
  public void carInfo(int carNo,WebDriver driver)
	{
		List<WebElement> cars = driver.findElements(By.className("ui-item"));
		   cars.get(carNo).click();
		   List<WebElement> item_props = driver.findElements(By.tagName("dt"));
		   List<WebElement> item_prop_detail = driver.findElements(By.tagName("dd"));
		   int i = 0; 
		   for(WebElement w : item_props)
		   {
			   
			   System.out.println(w.getText()+item_prop_detail.get(i++).getText());
		   }
	}
}
