package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_page {
	WebDriver driver;

	By Upload = By.xpath("//*[@class='fp-upload-btn btn-primary btn']");
	
	By File = By.xpath("//*[@class='fp-file fp-hascontextmenu']");
	
	By EditProfile = By.xpath("//*[@class='editprofile']//a");
	
	By AddFileBtn = By.xpath("//div[@class='fp-btn-add']");
	
	By BrowseBtn = By.xpath("//input[@name='repo_upload_file']");
	
	public Profile_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Upload_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Upload));

		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(driver.findElement(Upload)).click().build();
		move.perform();
	}
	
	public void File_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(File));
		
		driver.findElement(File).click();
	}
	
	public void EditProfile_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditProfile));
		
		driver.findElement(EditProfile).click();
	}
	
	public void AddFileBtn_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddFileBtn));
		
		driver.findElement(AddFileBtn).click();
	}
	
	public void BrowseBtn_Click() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BrowseBtn));
		
		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(driver.findElement(BrowseBtn)).click().build();
		move.perform();
	}
}

