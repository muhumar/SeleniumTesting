package myPackage;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;

public class firstClass {
	public static void main(String[] args) throws InterruptedException {
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";
		
		WebDriver driver = new EdgeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Bollywood")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Hollywood")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Pakistani")).click();
		Thread.sleep(2000);
		//driver.quit();
	}
}