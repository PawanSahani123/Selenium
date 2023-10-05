import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PSahani\\eclipse-workspace\\SeleniumDemo_Project\\chrome\\chromedriver.exe");
         ChromeOptions opt = new ChromeOptions();
         opt.addArguments("--remote-allow-origins=*");
         WebDriver driver=new ChromeDriver(opt);
         
         driver.get("https://www.rediff.com/");
         driver.manage().window().maximize();
         
      //   Absolute Xpath
       //  driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys("T Shirts");
         //driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/form[1]/input[1]")).click();   
         
		/*
		 * //Relative Path //OR //
		 * driver.findElement(By.xpath("//input[@type='text' or name='srchword']")).
		 * sendKeys("Shoes");
		 * //driver.findElement(By.xpath("//input[@type='submit']")).click();
		 */
			/*
			 * //and
			 * driver.findElement(By.xpath("//input[@type='text' and @id='srchword']")).
			 * sendKeys("Shoes");
			 * driver.findElement(By.xpath("//input[@type='submit']")).click();
			 */
          //Contains
         
          //driver.findElement(By.xpath("//input[contains(@id,'srchword')]")).sendKeys("Shoes");
         driver.findElement(By.xpath("//input[contains(@id,'srch')]")).sendKeys("Shoes");
          driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
