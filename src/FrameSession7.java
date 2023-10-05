import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.github.dockerjava.api.model.Driver;

public class FrameSession7 {

	
	      //static method 
      public static void takeScreenshot(WebDriver driver, String filePath) throws IOException 
      {
    	  TakesScreenshot screenshot1=((TakesScreenshot)driver);
    	  File srcshot =screenshot1.getScreenshotAs(OutputType.FILE);
    	  File Destination1 = new File(filePath);
    	  FileHandler.copy(srcshot, Destination1);
      }

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //implicitly wait 30
		
		//driver.manage().window().maximize();
		 FrameSession7.takeScreenshot(driver,"C:\\Users\\PSahani\\Desktop\\Java Logic\\Selenium Screen Shot\\"+System.currentTimeMillis() +".jpg");  // screen related
		
		int framesize =driver.findElements(By.tagName("iframe")).size();
		System.out.println("How many Frame is available :  "+framesize);  // how many frame in web page
		
		//driver.switchTo().frame("0");
		WebElement demo=driver.findElement(By.className("demo-frame"));
	    driver.switchTo().frame(demo);                            
	    
		WebElement source =driver.findElement(By.id("draggable"));
		WebElement target =driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
		
		 FrameSession7.takeScreenshot(driver,"C:\\Users\\PSahani\\Desktop\\Java Logic\\Selenium Screen Shot\\"+System.currentTimeMillis() +".jpg");
		//Screen short taken in desire destination
		
		/*TakesScreenshot screenshot =((TakesScreenshot)driver);
		File srcFile =screenshot.getScreenshotAs(OutputType .FILE);
		File destinationfile =new File("C:\\Users\\PSahani\\Desktop\\Java Logic\\Selenium Screen Shot\\20 march.jpg");	
		FileHandler.copy(srcFile, destinationfile); */
	}
}
