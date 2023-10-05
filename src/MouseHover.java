import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		
		WebDriver driver =new ChromeDriver(opt);
		driver.get("https://sellglobal.ebay.in/seller-center/#");
		
		WebElement element =driver.findElement(By.linkText("Payments & Fees"));
		WebElement element1 =driver.findElement(By.linkText("Payments & Fees"));
		Actions act= new Actions(driver);
		act.moveToElement(element1).perform();
	}

}
