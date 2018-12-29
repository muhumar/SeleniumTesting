package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddUser {
	WebDriver driver = null;

	AddUser(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String username, String password) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoAddUserPage() {
		if (driver.getTitle().equalsIgnoreCase("admin" + "_adduser")) {
			return true;
		}
		if (!driver.getTitle().contains("Admin")) {
			return false;
		}
		if (!driver.getTitle().equalsIgnoreCase("Admin")) {
			// not signed in
			return false;
		}
		// click that button of add user
		driver.findElement(By.partialLinkText("User")).click();
		return true;
	}

	void InsertUser(String fname, String email, String pass) throws InterruptedException {
		if(!gotoAddUserPage())
			return;
		Thread.sleep(2000);
		driver.findElement(By.id("fname")).sendKeys(fname);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.cssSelector("#submitadduser")).click();
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
		AddUser a = new AddUser(driver);
		a.loginuser("admin@gmail.com", "12345");
		a.InsertUser("test", "test@gmail.com", "ramo");
	}

}
