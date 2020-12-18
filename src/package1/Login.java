package package1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Init {
		
			@Test
			public void login() throws InterruptedException {
		  		init();
		  		WebElement loginpage = driver.findElement(By.xpath("//*[@class='login']//a"));
		  		loginpage.click();
		  		Thread.sleep(1000);
		  		WebElement loginimg = driver.findElement(By.xpath("//*[@class='modal-body']//p//a"));
		  		loginimg.click();
		  		WebDriverWait wait = new WebDriverWait(driver, 10); //20 seconds
		  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='placeholderContainer']//input[1]"))).sendKeys("hieu.187pm13916@vanlanguni.vn");
		  		WebElement next = driver.findElement(By.xpath("//*[@value='Next']"));
		  		next.click();
		  		WebElement password = driver.findElement(By.name("passwd"));
		  		password.sendKeys("VLU187pm13916");
		  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  		WebElement submitbtn = driver.findElement(By.xpath("//*[@value='Sign in']"));
		  		submitbtn.click();
		  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  		WebElement yesbtn = driver.findElement(By.xpath("//*[@value='Yes']"));
		  		yesbtn.click();
		  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  		
		  		String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
		  		String actualURL = driver.getCurrentUrl();
		  		Assert.assertEquals(actualURL,expectedURL);
		  		Thread.sleep(2000);
		  		driver.close();
		    }
}
