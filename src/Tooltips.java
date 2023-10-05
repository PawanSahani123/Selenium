import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltips {

	public static void main(String[] args) {
		
		WebDriverManager .chromedriver().setup();

		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.guru99.com/");
	WebElement object =driver.findElement(By.xpath("//a[@title='Machine Learning']"));  // tooltips
		
		System.out.println(object.getAttribute("title"));
		
		WebElement obejct2 =driver.findElement(By.xpath("//a[@title='Selenium']"));
		System.out.println(obejct2.getAttribute("title"));
		
		WebElement obejct3 =driver.findElement(By.id("gsc-i-id1"));
		System.out.println(obejct3.getText());
		
		if(object.equals(obejct2))
		{
			System.out.println("both are equal ");
		}
		else
		{
			System.out.println("both are not equal");
		}
	}
	
}

