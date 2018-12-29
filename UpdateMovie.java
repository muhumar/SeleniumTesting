package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdateMovie {
	WebDriver driver = null;

	UpdateMovie(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String name, String pass) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(name);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoUpdateMoviePage() {
		if (driver.getTitle().equalsIgnoreCase("Admin_viewmovie")) {
			return true;
		}
		if (!driver.getTitle().contains("Admin")) {
			// not signed in
			return false;
		}
		// click that button of add user
		driver.findElement(By.partialLinkText("View Movies")).click();
		return true;
	}

	void UpdateMovieName(String name, String name2) throws InterruptedException {
		if (!gotoUpdateMoviePage())
			return;
		Thread.sleep(2000);
		driver.findElement(By.id(name + "_update")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(name2);;
		driver.findElement(By.id("submitmovie")).submit();
		Thread.sleep(2000);
	}
	boolean find(String name) {
		// to be implemented
		
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

		UpdateMovie a1 = new UpdateMovie(driver);
		a1.loginuser("admin@gmail.com", "12345");
		a1.UpdateMovieName("ABCD2","test2");
	}
}
