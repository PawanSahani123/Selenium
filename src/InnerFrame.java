import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnerFrame {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
         
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver a =new ChromeDriver(opt);
		a.get("https://demo.automationtesting.in/Frames.html");
		a.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(a,Duration.ofSeconds(10));  //Explicit Wait using		
		int size=a.findElements(By.tagName("iframe")).size();
		System.out.println("How many Frame : "+size);
		a.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		WebElement outerframe =a.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		a.switchTo().frame(outerframe);  // here we are passing frame as web element
		
		WebElement innerframe =a.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		a.switchTo().frame(innerframe);
		
		a.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
		
		TakesScreenshot screen1=((TakesScreenshot)a);
		File srcfiles =screen1.getScreenshotAs(OutputType .FILE);
		File Desti1 = new File("C:\\Users\\PSahani\\Downloads\\Java Logic\\img.jpg");
		FileHandler.copy(srcfiles ,Desti1);
		
		Boolean element=wait.until(ExpectedConditions.titleContains("Fram"));
		System.out.println(element);
		
	}

	

}
