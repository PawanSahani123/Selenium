import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BroswerHandlesstesting {

	public static void main(String[] args){
	
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options= new FirefoxOptions();
		 options.setHeadless(true);
		 WebDriver driver=new FirefoxDriver(options);
		
				
				///Lunch chrome Browser
				// Handless broswer for chrome
//				WebDriverManager.chromedriver().setup();
//			     ChromeOptions options = new ChromeOptions();
//			     options.setHeadless(true);
//				WebDriver driver = new ChromeDriver(options);
		        
		       // open url
		        driver.get("https://www.google.com/");
		        
		        //print title of web page
		        System.out.println("Before Search : "+driver.getTitle());
		        
		        // find search box web element
		        WebElement searchbox=driver.findElement(By.name("q"));
		        
		        //enter search keyword
		        searchbox.sendKeys("india gate");
		        searchbox.sendKeys(Keys.ENTER);
		        
		       
		        //print title of web page
		        System.out.println("After Search : "+driver.getTitle());
		        System.out.println("After Search : "+driver.getCurrentUrl());
		        
			}

		


	}


