package package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.JobHoldUntil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.Home_page;
import Page.Login_page;

public class CoursesSelect extends Init{
	public String path = "C:\\Users\\admin\\Desktop\\AutoTest\\Book2.xlsx";
	public String sheetname = "Sheet2";
	Login_page objLogin;
	Home_page objHome;
	
	public int testtype = 0;
	public int case_col = 2;
	public int expectedurl = 3;
	public int result = 4;
	
	
	@Test
	public void CoursesSelect() throws Exception {
		ExcelUtils.setExcelFile(path, sheetname);
		// String input_1 = ReadExcel(i,0);
		int rows = ExcelUtils.getRowUsed();
		objLogin = new Login_page(this.driver);
		objHome = new Home_page(driver);
		
		System.out.println("RowUsed=" + ExcelUtils.getRowUsed());
		objLogin.LoginText_Click();
		objLogin.LoginImg_Click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Username: hieu.187pm13916@vanlanguni.vn");
		objLogin.setUserName("hieu.187pm13916@vanlanguni.vn");
		objLogin.Next_Click();
		System.out.println("Password: VLU187pm13916");
		objLogin.setPassword("VLU187pm13916");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		objLogin.SignIn_Click();
		
		Thread.sleep(1000);
		objLogin.No_Click();
		
		objHome.Logo_Click();
		
		List<WebElement> childElements = driver.findElement(By.xpath("//div[@class='subcategories']"))
				.findElements(By.tagName("div"));
		for (int i = 2;i <= rows; i++ ) {
			System.out.println("Start the loop with i=" + i);
			System.out.println("CellData:" + ExcelUtils.getCellData(i, case_col));
			
			for (WebElement element: childElements) {
				
				String course = ExcelUtils.getCellData(i, case_col);
				if (element.getText().contains(course)) {
					//driver.findElement(By.xpath("//*[@class='info']//a[1]")).click();
					Thread.sleep(2000);
					String actualURL = driver.getCurrentUrl();	
					String expectedURL = ExcelUtils.getCellData(i, expectedurl);

					Assert.assertEquals(actualURL, expectedURL);
					if(actualURL.equals(expectedURL)) {
						ExcelUtils.setCellData(i, result, "PASSED");
						ExcelUtils.saveFile(path);
						System.out.println("PASSED");
					}
					break;
				}
				objHome.Logo_Click();
			}
		}
	}
}

