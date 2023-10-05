import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleWebTableHandle {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new ChromeDriver(opt);
		driver.get("C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\SimpleWebTable\\WebTable.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       
		//Find in web table  chosen value and print   data .
		
	String text=driver.findElement(By.xpath("//table//tbody//tr[4]//td[2]")).getText();
		
	System.out.println(" We will fetch speical value form table : "+ text);
	
	//Total Rows and column are find out 
	List<WebElement> rowlist=driver.findElements(By.xpath("//table//tbody//tr"));
	System.out.println("Total Rows : "+rowlist.size());
	
	List<WebElement> columnlist=driver.findElements(By.xpath("//table//tbody//tr//th"));
	System.out.println("Total Column : "+ columnlist.size());
	
	//Using a looping statement
	System.out.println("!! Table All Data Print ..!!");
	
	for(int r=2 ;r<=rowlist.size();r++)
	{
		for(int c=1;c<=columnlist.size();c++)
		{
			String data=driver.findElement(By.xpath("//table//tbody//tr["+r +"]//td["+c+"]")).getText();
			System.out.print(data+ " ");
		}
		System.out.println();
	}
	
	
	}

}
