import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exePath = "D:\\chromeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://ikman.lk/en/ads/sri-lanka/vehicles");
		//String title = driver.getPageSource();
       // System.out.println(title);	
      WebElement search = driver.findElement(By.xpath("//*[@id=\"query\"]"));
       search.sendKeys("vitz");
       search.submit();
       
       List<WebElement> cars = driver.findElements(By.className("ui-item"));
	   cars.get(0).click();
	   WebElement item_prop = driver.findElement(By.tagName("dt"));
	   System.out.println(item_prop.getText());
	   
	}

}
