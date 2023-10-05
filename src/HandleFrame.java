import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.base.Stopwatch;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
        ChromeOptions opt =new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ; //Implicit wait
		Stopwatch watch =null;
		
		  int f =driver.findElements(By.tagName("iframe")).size();
		     System.out.println("How Many Frame is aviable in web page : "+f);
		
		try {
			
			watch=Stopwatch.createStarted();
	   
		
		// 1 iframe
		driver.switchTo().frame("packageListFrame"); //name of the frame
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent();  // Go back to the main page 
		
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			watch.stop();
			
			System.out.println(e);
			System.out.println(watch.elapsed(TimeUnit.SECONDS)+"seconds");
		}
		//2 iframe
		
		driver.switchTo().frame("packageFrame");  //name of the frame
		driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
		
		driver.switchTo().defaultContent();  // Go back to the main page
		Thread.sleep(4000);
		
		//3 iframe
		
		driver.switchTo().frame("classFrame");   //name of the frame
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		
		driver.switchTo().defaultContent(); // Go back to the main page
	   
	}

}
