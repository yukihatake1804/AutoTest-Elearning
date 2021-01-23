package package1;

import package1.ExcelUtils;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.Login_page;

public class LoginSuccesfully extends Init {
	public String path = "C:\\Users\\admin\\Desktop\\AutoTest\\Book1.xlsx";
	public String sheetname = "Login";
	Login_page objLogin;
	
//column
	public int testype = 0;
	public int testcasname = 1;
	public int case_col = 2;
	public int username = 3;
	public int password = 4;
	public int message = 5;
	public int result = 6;

	@Test
	public void loginsucessfully() throws Exception {
  
		ExcelUtils.setExcelFile(path, sheetname);
		// String input_1 = ReadExcel(i,0);
		int rows = ExcelUtils.getRowUsed();
		System.out.println("RowUsed=" + ExcelUtils.getRowUsed());
		
		for (int i = 2; i <= rows; i++) {
			System.out.println("Start the loop with i=" + i);
			System.out.println("CellData:" + ExcelUtils.getCellData(i, case_col));
			WebDriverWait wait = new WebDriverWait(driver, 20); // 20 seconds

			if (ExcelUtils.getCellData(i, case_col).equalsIgnoreCase("SUCCESFULLY"))
			{
				objLogin = new Login_page(this.driver);
				objLogin.LoginText_Click();
				objLogin.LoginImg_Click();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); //20sec
				System.out.println("Username:" + ExcelUtils.getCellData(i, username));
				objLogin.setUserName(ExcelUtils.getCellData(i, username));
				objLogin.Next_Click();
				System.out.println("Password:" + ExcelUtils.getCellData(i, this.password));
				objLogin.setPassword(ExcelUtils.getCellData(i, password)); 
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				objLogin.SignIn_Click();
				
				Thread.sleep(1000);
				objLogin.No_Click();
				
				String expectedURL = "https://elearning.vanlanguni.edu.vn/my/";
				String actualURL = driver.getCurrentUrl();	
				Assert.assertEquals(actualURL, expectedURL);
				if(actualURL.equals(expectedURL)) {
					ExcelUtils.setCellData(i, result, "PASSED");
					ExcelUtils.saveFile(path);
					System.out.println("PASSED");
				} 
				else
				{
					ExcelUtils.setCellData(i, result, "FAILED");
					ExcelUtils.saveFile(path);
					System.out.println("FAILED");
				}
				driver.close();
				init();
				
			} else if (ExcelUtils.getCellData(i, case_col).equalsIgnoreCase("UNSUCCESFULLY")){
				objLogin = new Login_page(this.driver);
				objLogin.LoginText_Click();
				objLogin.LoginImg_Click();
				
				String excel_username = ExcelUtils.getCellData(i, username);
				System.out.println("Username:" + ExcelUtils.getCellData(i, username));
				
				if(excel_username.equals("hieu.187pm13916@vanlanguni.vn")) 
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='email']")));
					objLogin.setUserName(ExcelUtils.getCellData(i, username));
					objLogin.Next_Click();
					objLogin.setPassword(ExcelUtils.getCellData(i, password)); 
					System.out.println("Password:" + ExcelUtils.getCellData(i, this.password));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					objLogin.SignIn_Click();
					
					//find error
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='error ext-error']")));
					WebElement error_message = driver.findElement(By.xpath("//*[@class='error ext-error']"));
					
					Assert.assertEquals(error_message.getText(), ExcelUtils.getCellData(i, message));
					System.out.println("Error:" + error_message.getText());
					Thread.sleep(1000);
					if (error_message.getText().equalsIgnoreCase(ExcelUtils.getCellData(i, message)))
					{
						ExcelUtils.setCellData(i, result, "PASSED");
						ExcelUtils.saveFile(path);
						System.out.println("PASSED");
					}
					else
					{
						ExcelUtils.setCellData(i, result, "FAILED");
						ExcelUtils.saveFile(path);
						System.out.println("FAILED");
					}
					driver.close();
					init();
				}
				else
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='email']")));
						objLogin.setUserName(ExcelUtils.getCellData(i, username));
						objLogin.Next_Click();
						System.out.println("Password:" + ExcelUtils.getCellData(i, this.password));
						//find error
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-24 error ext-error']")));
						WebElement error_message_0 = driver.findElement(By.xpath("//*[@class='col-md-24 error ext-error']"));
						
						Assert.assertEquals(error_message_0.getText(), ExcelUtils.getCellData(i, message));
						System.out.println("Error:" + error_message_0.getText());
						Thread.sleep(1000);
						if (error_message_0.getText().equalsIgnoreCase(ExcelUtils.getCellData(i, message)))
						{
							ExcelUtils.setCellData(i, result, "PASSED");
							ExcelUtils.saveFile(path);
							System.out.println("PASSED");
						}
						else
						{
							ExcelUtils.setCellData(i, result, "FAILED");	
							ExcelUtils.saveFile(path);
							System.out.println("FAILED");
						}
						driver.close();
						init();
					} //else
			} //if unsuccesfully
		}
		driver.close();
	}
}