import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.pagefactory.ByAll;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByAllLocator {

	

	public static void main(String[] args) {
		
		WebDriverManager .chromedriver().setup();

		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		
		// BYALL LOactor
		WebElement element =driver.findElement(new ByAll(By.name("q"),By.id("APjFqb")));
		
		System.out.println("This google page :" +element);
		
		element.sendKeys("india gate");
		element.sendKeys(Keys.ENTER);
		
		
	}

}
