import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinkSelenium {

	public static void main(String[] args) throws IOException, InterruptedException {
System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(opt);
		
		driver.get("https://demo.guru99.com/test/newtours//");
		
		driver.manage().window().maximize();
		//Implicit wait for 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Capture link for web page
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//Number of link 
		System.out.println("Total Brokem list in web page: "+links.size());
		
		for(int i=0 ;i<links.size();i++)
		{
			//by using href attribute we can URL of Required
			
			WebElement element =links.get(i);
			String url = element.getAttribute("href");
			URL link =new URL(url);
			
			//Create a connection using a URL object 'link '
			HttpURLConnection httpCon= (HttpURLConnection) link.openConnection();
			        //wait 2 minture
			Thread.sleep(1000);
			        //establish connection
			httpCon.connect();
			
			int resCode =httpCon.getResponseCode();// return response code 
			if(resCode >=400)
			{
				System.out.println(url +"- "+" is broken link" );
			}
			else
			
				{
					System.out.println(url +"- "+" valid  link" );
				}
			
		}
		
		
		
	}

}
