package UploadingFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UploadFiles {

	public static void main(String[] args) throws AWTException {
System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(opt);
		
		driver.get("https://demoqa.com/upload-download");  // open URL
		//file upload   when type =files is available then used sendkeys is work
		//driver.findElement(By.xpath("//input[@Type='file']")).sendKeys("C:\\Users\\PSahani\\Pawan Sahani.pdf"); 
		
		WebElement button=driver.findElement(By.xpath("//input[@id='uploadFile']"));
		
	    Actions act =new Actions(driver);
		act.moveToElement(button).click().perform();
		
		// 2 Approach use to open local desk not this rules i have chcek 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", button);
		
		Robot rb =new Robot();
		rb.delay(2000);
		
		//copy in to clipboard
		StringSelection ss= new StringSelection("C:\\Users\\PSahani\\PawanSahani.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);  // copy to clipboad
		
		//perform control +V action to paste
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		// Release the key
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		// press key
		rb.keyPress(KeyEvent.VK_ENTER);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		// js.executeScript("window.scrollBy(100,50)");

		
	}

}
