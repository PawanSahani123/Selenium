import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Cookie;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CookiesHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Capture all the cookies 
		Set <Cookie>  cookiesList = driver.manage().getCookies();
		
		System.out.println("Before Size : " +cookiesList.size());  //Find the cookies size
		
		for(Cookie ck : cookiesList)
		{
			System.out.println(ck.getName() +" : "+ ck.getValue());
		}
		System.out.println("\n");
		
		//get specific according to name
		System.out.println(driver.manage().getCookieNamed("i18n-prefs"));
		
		//Create cookies
		Cookie cookieobje =new Cookie("TestCookie" ,"https://www.amazon.in/");
		
		// Add above cookie to browser
	      driver.manage().addCookie( cookieobje);
	      
	      
	       cookiesList = driver.manage().getCookies();
			
			System.out.println("After Size : " +cookiesList.size());  //Find the cookies size
			
			for(Cookie ck : cookiesList)
			{
				System.out.println(ck.getName() +" : "+ ck.getValue());
			}
			
			System.out.println("\n");
			
			// delete Cookie
			driver.manage().deleteCookie(cookieobje);
			
			  cookiesList = driver.manage().getCookies();
				
				System.out.println("After Size : " +cookiesList.size());  //Find the cookies size
				
				for(Cookie ck : cookiesList)
				{
					System.out.println(ck.getName() +" : "+ ck.getValue());
				}

	}

}
