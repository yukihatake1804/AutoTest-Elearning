package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

	public abstract class Init {
		public WebDriver driver ; 
		public String baseUrl = "https://elearning.vanlanguni.edu.vn/";
		
		@BeforeClass
		public void init() {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseUrl);
		}
}
