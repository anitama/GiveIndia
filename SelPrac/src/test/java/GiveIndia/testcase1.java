package GiveIndia;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase1 
{
	
	@Test
	public void test1() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","D://Drivers//chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Selenium");
		driver.findElement(By.xpath("//a[@href='#External_links']")).click();
		String str=driver.findElement(By.xpath("//span[@id='External_links']")).getText();
		System.out.println(str);
		Assert.assertEquals(str, "External links","External link text is not present");
		driver.findElement(By.xpath("//table[@aria-describedby='periodic-table-legend']/tbody/tr/td/a[@title='Oxygen']")).click();
		driver.findElement(By.xpath("//a[@href='/wiki/Talk:Oxygen']")).click();
		String str1=driver.findElement(By.xpath("//a[@href='/wiki/Wikipedia:Featured_articles']")).getText();
		System.out.println(str1);
		Assert.assertEquals(str1,"featured article","featured article text is not present");
		driver.navigate().back();
		WebElement wb=driver.findElement(By.xpath("//table[@class='infobox']/tbody/tr/th[contains(text(),'Physical properties')]"));
		WebElement wb1=driver.findElement(By.xpath("//table[@class='infobox']/tbody/tr/th[contains(text(),'Other properties')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wb);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("D://selenium_pd//SelPrac//src//test//java//GiveIndia//screenshot1.png");
		FileUtils.copyFile(srcfile, destfile);
		js.executeScript("arguments[0].scrollIntoView();", wb1);
		TakesScreenshot ts1=(TakesScreenshot)driver;
		File srcfile1=ts1.getScreenshotAs(OutputType.FILE);
		File destfile1=new File("D://selenium_pd//SelPrac//src//test//java//GiveIndia//screenshot2.png");
		FileUtils.copyFile(srcfile1, destfile1);
		driver.findElement(By.xpath("//a[@href='#References']")).click();
		List<WebElement>wb2=driver.findElements(By.xpath("//div[@class='reflist columns references-column-width']//ol//li//span[contains(text(),'(PDF)')]"));
		System.out.println(wb2.size());
		/*for(WebElement wee:wb2)
		{
			System.out.println(wee.getText());
			
			
		}*/
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("pluto");
		List<WebElement>wb3=driver.findElements(By.xpath("//div[@class='suggestions-results']//a"));
		for(int i=1;i<wb3.size();i++)
		{
	
			if(wb3.get(i).getText().equals("Plutonium"))
			{
				
				System.out.println("Index of Plutonium is :"+i);
				
				
				
			}
			
			
		}
		driver.quit();
		
		
		
		
		
	}
	
	

}
