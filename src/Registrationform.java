import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.support.ui.Select;

public class Registrationform {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PSahani\\eclipse-workspace\\Project_Bank\\chrome1\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://en-gb.facebook.com/reg/");
		Thread.sleep(3000);
		driver.manage().window().maximize();  /// Full window display

		WebElement First = driver.findElement(By.name("firstname"));
		First.sendKeys("Pawan");
		WebElement Last = driver.findElement(By.name("lastname"));
		Last.sendKeys("sahani");
		WebElement Email1 = driver.findElement(By.name("reg_email__"));
		Email1.sendKeys("malasahani2000@gmail.com");
		WebElement Email2 = driver.findElement(By.name("reg_email_confirmation__"));
		Email2.sendKeys("malasahani2000@gmail.com");

		WebElement Password = driver.findElement(By.id("password_step_input"));
		Password.sendKeys("1234578");

		WebElement day = driver.findElement(By.name("birthday_day"));
		Select day_select = new Select(day);
		day_select.selectByVisibleText("18");

		WebElement month = driver.findElement(By.name("birthday_month"));
		month.sendKeys("OCT");

		WebElement year = driver.findElement(By.id("year"));
		Select year_select = new Select(year);
		year_select.selectByValue("2000");

		List<WebElement> gender = driver.findElements(By.cssSelector("input[name=sex]"));
		WebElement gender_male = gender.get(1);
		gender_male.click();

		 WebElement submit =driver.findElement(By.name("websubmit"));
		 submit.click();
		 System.out.println("Title of page "+driver.getTitle());
			Thread.sleep(3000);
			driver.findElement(By.name("reset_action"));
		/*
		 * WebElement Applied
		 * =driver.findElement(By.linkText("Already have an account?"));
		 * Applied.click();
		 * 
		 * 
		 * WebElement Applied2
		 * =driver.findElement(By.partialLinkText("Sign up for Facebook"));
		 * Applied2.click();
		 */

		System.out.println("Title of subject" + driver.getTitle());
		String curl = driver.getCurrentUrl();
		System.out.println(curl);
		
		driver.navigate().to("https://www.guru99.com/locators-in-selenium-ide.html ");
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
