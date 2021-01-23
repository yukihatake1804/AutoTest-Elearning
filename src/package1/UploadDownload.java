package package1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
 import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Page.Home_page;
import Page.Login_page;
import Page.Profile_page;

public class UploadDownload extends Init {
	Login_page objLogin;
	Home_page objHome;
	Profile_page objProfile;
	
	@BeforeClass
	public void login() throws InterruptedException {
		objLogin = new Login_page(this.driver);
		objHome = new Home_page(this.driver);
		objProfile = new Profile_page(this.driver);

  		objLogin.LoginText_Click();
  		objLogin.LoginImg_Click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		objLogin.setUserName("hieu.187pm13916@vanlanguni.vn");
  		objLogin.Next_Click();
  		objLogin.setPassword("VLU187pm13916");
  		
  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		objLogin.SignIn_Click();
  		
		objLogin.No_Click();
  	}
	
	@Test
	public void uploadfile() throws Exception {
  		objHome.UserMenu_Click();
		objHome.Profile_Click();
  		objProfile.EditProfile_Click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",btnFile);
        js.executeScript("window.scrollBy(0,1500)", "");
        
        Thread.sleep(1500);
        objProfile.AddFileBtn_Click();
        objProfile.BrowseBtn_Click();

  	    // copying File path to Clipboard
		final StringSelection str = new StringSelection("C:\\Users\\admin\\Desktop\\Tài liệu\\thăm ngàn.jpg");
  	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
  	    
  	    final Robot rb = new Robot();
  	    //wait for robo
  	    Thread.sleep(2000);
  	    
  	    // press Contol+V for pasting
  	    rb.keyPress(KeyEvent.VK_CONTROL);
  	    rb.keyPress(KeyEvent.VK_V);
  	    // release Contol+V for pasting
  	    rb.keyRelease(KeyEvent.VK_CONTROL);
  	    rb.keyRelease(KeyEvent.VK_V);
  	    
  	    rb.delay(500);
  	    rb.keyPress(KeyEvent.VK_ENTER);
  	    rb.keyRelease(KeyEvent.VK_ENTER);
  	    
  	    Thread.sleep(1000);
  	    objProfile.Upload_Click();
  	    Thread.sleep(500);
  	    
		objProfile.File_Click();
		Thread.sleep(500);
		
		WebElement textname = driver.findElement(By.xpath("//*[@class='moodle-dialogue-hd yui3-widget-hd']//h3"));
		String expected = "Edit thăm ngàn.jpg";
		String actual = textname.getText();	
		Assert.assertEquals(actual, expected);
		if(actual.equals(expected)) {
			System.out.println("PASS");
		}	
	}
}