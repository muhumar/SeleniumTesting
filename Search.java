package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Search {
	WebDriver driver = null;

	Search(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void searchMovie(String name) throws InterruptedException {
		driver.findElement(By.cssSelector("#tosearch")).sendKeys(name);
		driver.findElement(By.cssSelector("#tosearch")).submit();

		Thread.sleep(3000);
	}
	
	public static void main(String []args) throws InterruptedException {
		
	}
}
