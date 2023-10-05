import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class Session_2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		
		WebElement name= driver.findElement(By.xpath("//*//input[contains(@type,'text')]"));
		 name.sendKeys("Pawan");
		
		/* scroll window 
		 * //JavascriptExecutor js=(JavascriptExecutor)driver;
		 * //js.executeScript("window.scrollBy(0,100)"); //veritical effect this width
		 * 
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * Thread.sleep(3000); WebElement policy
		 * =driver.findElement(By.linkText("privacy policy"));
		 * js.executeScript("arguments[0].scrollIntoView();", policy); policy.click();
		 */
		
		/* dropdownlist 
		 * //WebElement dropdownlist =driver.findElement(By.id("country")); //Select
		 * Countydropdownlist = new Select(dropdownlist);
		 * //Countydropdownlist.selectByIndex(1); //Amarican samoa
		 * //Countydropdownlist.selectByIndex(6);antigua
		 * //Countydropdownlist.selectByVisibleText("Armenia");
		 */		

		/* Radio button
		 * driver.get("https://demo.guru99.com/test/radio.html");
		 * driver.manage().window().maximize();
		 * 
		 * WebElement radio1 = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
		 * //radio button call radio1.click();
		 * 
		 * System.out.println("total number of radio button : "+ radio1.getSize()); //
		 * how many radio button available
		 * 
		 * 
		 * 
		 *  Check boxed
		 * WebElement checkbox1 = driver.findElement(By.id("vfb-6-0")); //box1.click();
		 * 
		 * 
		 * System.out.println(checkbox1.isDisplayed());//true
		 * System.out.println(checkbox1.isEnabled());//true
		 * System.out.println(checkbox1.isSelected());//false checkbox1.click();
		 * Thread.sleep(3000); System.out.println(checkbox1.isSelected());//true
		 * checkbox1.click();
		 * 
		 * WebElement checkbox2= driver.findElement(By.id("vfb-6-1"));
		 * checkbox2.click();
		 */
		/* how many link available in google and automatically click gmail
		 * driver.get("https://www.google.com/"); driver.manage().window().maximize();
		 * 
		 * List<WebElement> link= driver.findElements(By.tagName("a"));
		 * System.out.println(link.size());
		 * 
		 * for(int i=0; i<link.size(); i++) { //
		 * System.out.println(link.get(i).getText());
		 * if(link.get(i).getText().equalsIgnoreCase("gmail")) { link.get(i).click();
		 * break; //driver.navigate().to("https://demo.guru99.com/test/radio.html"); } }
		 */
		 

		/*
		 * driver.get("https://www.facebook.com/"); WebElement facebook =driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
		 * 
		 * System.out.println(facebook.getAttribute("class"));
		 * System.out.println(facebook.getAttribute("src"));
		 * System.out.println(facebook.getAttribute("alt"));
		 * 
		 * System.out.println("URL"+ driver.getCurrentUrl());
		 * System.out.println("title"+driver.getTitle());
		 */

	}

	
}