import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlUnitHandlessBrowser {

	public static void main(String[] args) {
		
                HtmlUnitDriver driver =new HtmlUnitDriver();
		
		        
		       // Open URL
		        driver.get("https://www.google.com/");
		        
		        //print title of web page
		        System.out.println("Before Search : "+driver.getTitle());
		        
		        // find search box web element
		        WebElement serachbox=driver.findElement(By.name("q"));
		        
		        //enter search keyword
		        serachbox.sendKeys("india gate");
		        serachbox.sendKeys(Keys.ENTER);
		        
		       
		        //print title of web page
		        System.out.println("After Search : "+driver.getTitle());
		        System.out.println("After Search : "+driver.getCurrentUrl());
		        
			}

		}


