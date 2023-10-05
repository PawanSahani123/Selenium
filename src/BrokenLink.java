import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLink {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(opt);
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> linklist =driver.findElements(By.tagName("a"));
		System.out.println("Total Broken link : "+linklist.size());
		
		int resCode =200; //2xx response code is valid link
		int brokenlinkCnt =0;
		
		for(WebElement e:linklist)
		{
			String url =e.getAttribute("href");
			
			try {
				URL urlink=new URL(url);
				HttpURLConnection huc=(HttpURLConnection)urlink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode =huc.getResponseCode();
				if(resCode >=400)
				{
					System.out.println(url + "Broken link ");
					brokenlinkCnt ++;
				}
				
			     }
			catch(MalformedURLException e1)
			{
				
			}	
			catch(Exception e1)
			{
				
			}
		 System.out.println("Total Broken link : "+brokenlinkCnt);
		}
		
	}	

}
