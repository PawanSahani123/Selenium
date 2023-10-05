import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		
		WebDriver driver =new ChromeDriver(opt);
		driver.get("https://demoqa.com/buttons");
		
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"));
		
		Actions act=new Actions(driver);
		act.contextClick(button).perform(); // right click action
		
		WebElement button2 =driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"));
		
		act.doubleClick(button2).perform();// double click

	}

}
