import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.http.HttpConnection;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrkoenImage {

	public static void main(String[] args) throws IOException {
	
System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(opt);
		
		driver.get("https://www.theworldsworstwebsiteever.com/");
		
		List<WebElement> images =driver.findElements(By.tagName("img"));
		System.out.println("Total Image : "+images.size());
		
		for (WebElement image :images)
		{
			String imageSrc=image.getAttribute("Src");
			URL url=new URL(imageSrc);
			URLConnection urlConnection=url.openConnection();
			
			HttpURLConnection httpconnection=(HttpURLConnection ) urlConnection;
			httpconnection.connect();
			if(httpconnection.getResponseCode()==200)
				
				System.out.println(imageSrc +" This is image are Correct  >>"+httpconnection.getResponseCode()+">>");
			else
				System.out.println(imageSrc +" This is image are incorrect >>"+httpconnection.getResponseCode()+">>");
		}
	}

}
