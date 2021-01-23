package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Home_page {
	WebDriver driver;
	
	public Home_page(WebDriver driver) {
		this.driver = driver;
	}
	
	By Logo = By.xpath("//span[@class='logo']");
	
	By UserMenu = By.xpath("//*[@class='usermenu']");
	
	By Profile = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Profile')]");
	
	By Dashboard = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Dashboard')]");
	
	By Grades = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Grades')]");
	
	By Messages = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Messages')]");
	
	By Preferences = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Preferences')]");

	By Logout = By.xpath("//*[@class='dropdown show']//span[contains(text(),'Log out')]");	
	
public void Logo_Click() {
	driver.findElement(Logo).click();
}

public void UserMenu_Click() {
	driver.findElement(UserMenu).click();
}

public void Profile_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Profile)).click().build();
	move.perform();
	Thread.sleep(300);
}

public void Dashboard_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Dashboard)).click().build();
	move.perform();
	Thread.sleep(300);
}

public void Grades_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Grades)).click().build();
	move.perform();
	Thread.sleep(300);
}

public void Messages_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Messages)).click().build();
	move.perform();
	Thread.sleep(300);
}

public void Preferences_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Preferences)).click().build();
	move.perform();
	Thread.sleep(300);
}

public void LogOut_Click() throws Exception {
	Actions builder = new Actions(driver);
	Action move = builder.moveToElement(driver.findElement(Logout)).click().build();
	move.perform();
	Thread.sleep(300);
}
//		driver.findElement(By.xpath("//*[@class='d-inline-block  dropdown-toggle icon-no-margin']")).click();

}
 