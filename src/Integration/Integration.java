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

import Page.Home_page;
import Page.Login_page;
import package1.ExcelUtils;
import package1.Init;

public class Integration extends Init {
	public String path = "C:\\Users\\admin\\Desktop\\AutoTest\\Book1.xlsx";
	public String sheetname = "Dropbox";
	
	Login_page objLogin; 
	Home_page objHome;
	
	//col
	public int testtype = 0;
	public int case_col = 1;
	public int expectedurl = 2;
	public int result = 3;
	
	@BeforeClass
	public void login() throws Exception {
		objLogin = new Login_page(this.driver);
		objHome = new Home_page(this.driver);

  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		
  		objLogin.LoginText_Click();
  		objLogin.LoginImg_Click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		objLogin.setUserName("hieu.187pm13916@vanlanguni.vn");
  		objLogin.Next_Click();
  		objLogin.setPassword("VLU187pm13916");
  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  		objLogin.SignIn_Click();
  		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='No']")));
  		objLogin.No_Click();
	}
	
	@Test 
	public void IntegrationTest() throws Exception {
		ExcelUtils.setExcelFile(path, sheetname);
		int rows = ExcelUtils.getRowUsed();
		System.out.println("RowUsed=" + ExcelUtils.getRowUsed());
		System.out.println("===========================");
		
		for (int i = 2; i <= rows; i++) {
			System.out.println("Start the loop with i=" + i);
			System.out.println("CellData:" + ExcelUtils.getCellData(i, case_col));
	  		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			objHome.UserMenu_Click();
			
			if (i % 2 == 1) {
				System.out.println("Action: Dashboard.click();");
				objHome.Dashboard_Click();
			}
			else 
				switch (i) {
					case 2:
						System.out.println("Action: Profile_click();");
						objHome.Profile_Click();
						break;
					case 4:
						System.out.println("Action: Grades_click();");
						objHome.Grades_Click();
						break;
					case 6:
						System.out.println("Action: Messages_click();");
						objHome.Messages_Click();
						break;
					case 8:
						System.out.println("Action: Preferences_click();");
						objHome.Preferences_Click();
						break;
					case 10:
						System.out.println("Action: LogOut_click();");
						objHome.LogOut_Click();
						break;
					}
			String expectedURL = ExcelUtils.getCellData(i, expectedurl);
			String actualURL = driver.getCurrentUrl();	
			Assert.assertEquals(actualURL, expectedURL);
			if(actualURL.equals(expectedURL)) {
				ExcelUtils.setCellData(i, result, "PASSED");
				ExcelUtils.saveFile(path);
				System.out.println("PASSED");
				System.out.println("===========================");
			} 
		}
	}
	
/*
	@Test
	public void A_dashboard_profile() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();
  		WebDriverWait wait = new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown-menu dropdown-menu-right menu align-tr-br show']")));
  		WebElement profile = driver.findElement(By.xpath("//*[@class='dropdown show']//span[contains(text(),'Profile')]"));
  		Actions builder = new Actions(driver);
		Action movetoProfile = builder.moveToElement(profile).build();
		movetoProfile.perform();
  		Thread.sleep(300);
  		profile.click();
  		String expectedURL = "a";
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
	*/
}

