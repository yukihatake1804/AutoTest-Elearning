package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_page {
	WebDriver driver;

    By ElearningName = By.xpath("//*[@type='email']");

    By ElearningPass = By.xpath("//*[@type='password']");
    
    By Next = By.xpath("//*[@value='Next']");
    
    By LoginImg = By.xpath("//*[@class='modal-body']//p//a");
  
    By LoginText = By.xpath("//*[text()='Log in']");
    
    By SignIn = By.xpath("//*[@value='Sign in']");
    
    By No = By.xpath("//*[@value='No']");

	public Login_page(WebDriver driver) {
		this.driver = driver;
	}

    
    public void setUserName(String strName){
        driver.findElement(ElearningName).sendKeys(strName);

    }
    
    public void setPassword(String strPass){

        driver.findElement(ElearningPass).sendKeys(strPass);

   }
    
    public void Next_Click() {
    	driver.findElement(Next).click();
    }
    
    public void LoginImg_Click() {
		driver.findElement(LoginImg).click();
	}
    public void LoginText_Click() {
		driver.findElement(LoginText).click();
	}
    public void SignIn_Click() {
    	driver.findElement(SignIn).click();
	}
    public void No_Click() {
  		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='No']")));
		
    	driver.findElement(No).click();
    }
    
}
