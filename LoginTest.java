package myPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
	@Test
	public void f() throws Exception {
		WebDriver driver;
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);

		Login login = new Login(driver);

		/*
		 * NOW WE WILL LOGIN INVALID USERS
		 */

		Scanner scan = new Scanner(new File("login_invalid.txt"));

		while (scan.hasNextLine()) {
			String id = scan.nextLine();
			String pass = scan.nextLine();

			login.loginuser(id, pass);
			Assert.assertEquals(driver.getTitle(), "Sign in");
		}

		scan.close();
		
		/*
		 * 	NOW WE WILL LOGIN VALID USERS
		 */
		
		scan = new Scanner(new File("login_valid.txt"));

		while (scan.hasNextLine()) {
			String id = scan.nextLine();
			String pass = scan.nextLine();

			login.loginuser(id, pass);
			Assert.assertEquals(driver.getTitle(), "Admin");
			driver.findElement(By.partialLinkText("Logout")).click();
		}

		scan.close();
	}
}
