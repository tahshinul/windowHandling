package actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.reporters.EmailableReporter;

public class handlingChildWindows {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		String parent = i.next();
		String child = i.next();
		driver.switchTo().window(child);		
		String emaiString = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(emaiString);
		
	}

}
