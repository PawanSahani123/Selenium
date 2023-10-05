import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.base.Stopwatch;

public class Implicit {

	public static void main(String[] args) {
		
		//Lunch Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
         ChromeOptions opt= new ChromeOptions();
         opt.addArguments("--remote-allow-origins=*");
         WebDriver driver=new ChromeDriver(opt);
         
         //maximize browser
         driver.manage().window().maximize();
         //open URL 
         driver.get("https://sellglobal.ebay.in/seller-center/");
         
                                                                        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds
         
         Stopwatch watch = null;
         
              //This is correct because of correct  WebElement given  "STAR SELLING" as WEb Application mention.
              // driver.findElement(By.linkText("START SELLING")).click();
         
         // This is Wrong web element given because of implicit using 
         
         try 
         {
        	 watch =Stopwatch.createStarted();            // watch started
        	 
             driver.findElement(By.linkText("SELLING")).click();
         }
         catch( Exception e)
         {
        	 watch.stop();
        	 System.out.println(e);
        	 System.out.println(watch.elapsed(TimeUnit.SECONDS) + "Seconds ");
         }
         
         // find WebElement "Youtube"
         driver.findElement(By.xpath("//img[@src='https://sellglobal.ebay.in/seller-center/wp-content/uploads/2021/11/youtube-1.jpg']")).click();
         
         
         
         
	}
	

}
