package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdateUser {
	WebDriver driver = null;

	UpdateUser(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String name, String pass) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(name);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoUpdateUserPage() {
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

	void UpdateUserName(String name, String name2) throws InterruptedException {
		if (!gotoUpdateUserPage())
			return;
		Thread.sleep(2000);
		driver.findElement(By.id(name + "_update")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(name2);;
		driver.findElement(By.id("submituser")).submit();
		Thread.sleep(2000);
	}
	boolean find(String name) {
		//to be implemented
		
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

		UpdateUser a1 = new UpdateUser(driver);
		a1.loginuser("admin@gmail.com", "12345");
		a1.UpdateUserName("JD","JayD");
	}
}
