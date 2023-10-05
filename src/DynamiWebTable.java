import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamiWebTable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new ChromeDriver(opt);
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Login page 
		WebElement username =driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("demo");
		
		WebElement pass =driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("demo");
		
		WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
		login.sendKeys(Keys.ENTER);
		
		//Alert message cancel
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		
		//Sales -Orders 
		
	      driver.findElement(By.xpath("//ul//li//a/i[@class='fas fa-shopping-cart' or  text()='Sales']")).click();
	      driver.findElement(By.xpath("//ul//li//a[ text()='Orders']")).click();
	      
	      //Table
	     String text= driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
	     System.out.println(text); //Showing 1 to 10 of 202 (21 Pages)

	      int total_page= Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Page")-1));
	      System.out.println("total count of page :"+total_page);
	      
	      for(int p=1 ;p<=total_page ;p++)
	      {
	    	WebElement active_page =  driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
	    	System.out.println("Active_page : "+active_page.getText());
	    	active_page.click();
	    
	   	int  rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
;	    	System.out.println("Total number of  Rows : " +rows);//td
	    	
	    	String pageno =Integer.toString(p+1);
	    	driver.findElement(By.xpath("//ul[@class='pa(gination']//li//a[text()='"+ pageno +"']")).click();
	    	
	    	
	      }
	      
	      
	      
	      
	      
	}

}
