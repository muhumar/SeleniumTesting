package myPackage;

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

public class Login {
	WebDriver driver = null;

	Login(WebDriver driver) throws InterruptedException {		
		this.driver=driver;
		goToSignInPage();
	}

	void goToSignInPage() throws InterruptedException {
		if (driver.getTitle().equals("Sign in"))
			return;
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#signin1")).click();
		Thread.sleep(2000);
	}
		void loginuser(String name, String pass) throws InterruptedException {
		goToSignInPage();
		driver.findElement(By.cssSelector("#email")).sendKeys(name);
		driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}



	public static void main(String[] args) throws InterruptedException {
		
	}
}
