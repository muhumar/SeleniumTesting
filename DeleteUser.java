package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DeleteUser {
	WebDriver driver = null;

	DeleteUser(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String username, String password) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoDeleteUserPage() {
		if (driver.getTitle().equalsIgnoreCase("admin")) {
			return true;
		}
		if (!driver.getTitle().contains("Admin")) {
			// not signed in
			return false;
		}
		// click that button of add user
		driver.findElement(By.partialLinkText("Dashboard")).click();
		return true;
	}

	void RemoveUser(String fname) throws InterruptedException {
		if (!gotoDeleteUserPage())
			return;
		Thread.sleep(2000);
		driver.findElement(By.id(fname + "_delete")).click();
		Thread.sleep(2000);
	}

	boolean find(String fname) {
		/*to be implemented*/
		
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);
		Thread.sleep(2000);

		DeleteUser a = new DeleteUser(driver);
		a.loginuser("admin@gmail.com", "12345");
		a.RemoveUser("test");
	}
}
