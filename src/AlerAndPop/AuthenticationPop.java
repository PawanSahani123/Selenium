package AlerAndPop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new ChromeDriver(opt);
		driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
		
		//syntax
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		//https://user:password@URL
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}
