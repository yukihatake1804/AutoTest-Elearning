package Integration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import package1.Init;

public class Dashboard extends Init {
	
	@BeforeClass
	public void login() throws InterruptedException {
  		WebElement loginpage = driver.findElement(By.xpath("//*[@class='login']//a"));
  		loginpage.click();
  		Thread.sleep(1000);
  		WebElement loginimg = driver.findElement(By.xpath("//*[@class='modal-body']//p//a"));
  		loginimg.click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
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
	}
	
	@Test
	public void A_dashboard_profile() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WaebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		WebElement profile = driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Profile')]"));
  		Actions builder = new Actions(driver);
		Action movetoProfile = builder.moveToElement(profile).build();
		movetoProfile.perform();
  		Thread.sleep(300);
  		profile.click();
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/user/profile.php?id=7159";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void A_profile_dashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Dashboard')]")).click();
		Thread.sleep(500);
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void B_dashboard_grades() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		WebElement grades = driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Grades')]"));
  		Actions builder = new Actions(driver);
		Action movetoGrades = builder.moveToElement(grades).build();
		movetoGrades.perform();
  		Thread.sleep(300);
  		grades.click();
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/grade/report/overview/index.php";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
  	
	@Test
	public void B_grades_dashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Dashboard')]")).click();
  		Thread.sleep(500);
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void C_dashboard_messages() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		WebElement messages = driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Messages')]"));
  		Actions builder = new Actions(driver);
		Action movetoMessages = builder.moveToElement(messages).build();
		movetoMessages.perform();
  		Thread.sleep(300);
  		messages.click();
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/message/index.php";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void C_messages_dashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Dashboard')]")).click();
  		Thread.sleep(500);
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void D_dashboard_preferences() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		WebElement preferences = driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Preferences')]"));
  		Actions builder = new Actions(driver);
		Action movetoPreferences = builder.moveToElement(preferences).build();
		movetoPreferences.perform();
  		Thread.sleep(300);
  		preferences.click();
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/user/preferences.php";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	
	@Test
	public void D_messages_dashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Dashboard')]")).click();
  		Thread.sleep(500);
  		String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
  		String actualURL = driver.getCurrentUrl();
  		Assert.assertEquals(actualURL,expectedURL);
	}
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}

