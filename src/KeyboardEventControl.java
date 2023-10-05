import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventControl {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
         // page scrolling with using
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
		
		System.out.println(driver.getTitle());

		WebElement input1 =driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement input2 =driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		
		input1.sendKeys("Wecolme to Selenium page");
		
		Actions act=new Actions(driver);
		
		//CTRL +A
		act.keyDown(Keys.CONTROL);
		act.keyUp("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL C
		act.keyDown(Keys.CONTROL);
		act.keyUp("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//TAB - shif to input 2
		act.sendKeys(Keys.TAB);
		act.perform();
		
		//CTRL V
		act.keyDown(Keys.CONTROL);
		act.keyUp("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		
		//compare to
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
		{
			System.out.println("Both are same ");
		}
		else {
			{
				System.out.println("Both NOt  are same ");
			}
		}
		
		/*
		 * act.sendKeys(Keys.ENTER).perform(); Thread.sleep(1000);
		 * act.sendKeys(Keys.BACK_SPACE).perform(); Thread.sleep(1000);
		 * act.sendKeys(Keys.ESCAPE).perform();
		 */
	}

}
