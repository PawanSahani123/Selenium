package UploadingFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploadingfiles {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.navigate().to("https://www.foundit.in/");
		driver.manage().window().maximize();
		
		//sometime this is not work
		//driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).sendKeys("C:\\Users\\PSahani\\PawanSahani.pdf");	
		
		
	   //	Using in Robot class method
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();
		
		WebElement button =driver.findElement(By.xpath("//input[@id='file-upload']"));
		// 1 approach use to click open then fileupload to local 
		//Actions acts=new Actions(driver);
		//acts.moveToElement(button).click().perform();
		
		// 2 approach use to click open then fileupload to local 
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", button);  //click action on the button
		
		/* i Copy the path
		 * ii CTRL =V
		 * iii enter
		 */
		Robot rb =new Robot();
		rb.delay(500);
		// put path to the file in a clipboard
		StringSelection ss=new StringSelection("C:\\Users\\PSahani\\Pawansahani.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// CTRL V
		rb.keyPress(KeyEvent.VK_CONTROL); // Press on CTRL
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL); // Press on CTRL
		rb.keyRelease(KeyEvent.VK_V);
		
		// Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		
		//Thread.sleep(200);
		
		driver.findElement(By.xpath("//input[@id='pop_upload']")).click();  // to submit button
	}

}
