import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("http://seleniumpractise.blogspot.com/");
		
		// How many rows in the table 
		
	int rows =	driver.findElements(By.xpath("//table[@name='cust_123']//tbody//tr")).size();
	System.out.println("Total Number of row : "+rows); // row is 7
	
	// How many Columns in the table 
	
	int cols =driver.findElements(By.xpath("//table[@name='cust_123']//tbody//tr//th")).size();
	System.out.println("Total number of Column : " +cols);  //column is 5
	
	// Retrieve the specific row and column data
	
	String Retrivedata =driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[5]//td[2]")).getText();
	System.out.println("The value is  :"+Retrivedata);
	
	String Retrivedata1 =driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[7]//td[4]")).getText();
	System.out.println("The value is  :"+Retrivedata1);
	
	// Retrieve all table data require looping 
	
	System.out.println("!!.....Data From Table .....!!!");
	
	for(int r=2; r<=rows ; r++)  //r = 1 2
	{
		for(int c=1; c<=cols ;c++) //c=1 2 3 4 5  //12345
		{
			String data =driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+r+"]//td["+c+"]")).getText();
			System.out.print(data+"    ");
		}
		System.out.println("  ");
	}
		
	}

}
