import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip_New_Tab {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions otp = new ChromeOptions();
		otp.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(otp);
		
		driver.get("https://demo.nopcommerce.com/computers");
		driver.manage().window().maximize();
		
		String tab=Keys.chord(Keys.CONTROL ,Keys.RETURN);    // New tab open for this commands
	    driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(tab);
	    
	    
//	    Open in both are open New Window Tab 
//		driver.get("https://demo.nopcommerce.com/computers");
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.opencart.com/");
//	 
	 
	}

}
