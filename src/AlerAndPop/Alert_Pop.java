package AlerAndPop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Pop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// Alert Window with OK 1 Button
	
		driver.findElement(By.xpath("//ul//li//button[normalize-space()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();   // ok button click 
		
		
		//Alert window with Ok and Cancel Button
		
		driver.findElement(By.xpath("//ul//li//button[normalize-space()='Click for JS Confirm']")).click();
		//driver.switchTo().alert().accept(); // close alert by using a OK button
		driver.switchTo().alert().dismiss();// close alert by cancel button
		
		Thread.sleep(3000);
	       
		//Alert window with input box ,capture text from alert
		driver.findElement(By.xpath("//ul//li//button[normalize-space()='Click for JS Prompt']")).click();
		 // 1 approach 
		
		  driver.switchTo().alert().sendKeys("pawan Wecolme");
		  driver.switchTo().alert().accept();
		 
		// 2 approach 
     //  Alert alertwindow=driver.switchTo().alert();
       //System.out.println("This message diplay on alert: "+alertwindow.getText());
       Thread.sleep(1000);
       
       //alertwindow.sendKeys("Wlecome to th page");
       //alertwindow.accept();
	}

}
