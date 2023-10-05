import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

public class ExplicityWait {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
         ChromeOptions opt= new ChromeOptions();
         opt.addArguments("--remote-allow-origins=*");
         WebDriver driver=new ChromeDriver(opt);
         
         //maximize browser
         driver.manage().window().maximize();
         //open URL 
         driver.get("https://sellglobal.ebay.in/seller-center/");
         
         
         // explicit wait of 15 seconds
         WebDriverWait  wait =new WebDriverWait(driver, Duration.ofSeconds(15));
         Stopwatch watch=null;
         
         
         try
         {
        	watch = Stopwatch.createStarted();
        	
        	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("START SELLING")));  // Correct Web Element
        	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("XYZ")));  //Wrong WebELEMENT
        	element.click();
         }
         catch(Exception e)
         {
        	 watch.stop();
        	 System.out.println(e);
        	 System.out.println(watch.elapsed(TimeUnit.SECONDS)+ " seconds");
        	 
         }
         

	}

}
