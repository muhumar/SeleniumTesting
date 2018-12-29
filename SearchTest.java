package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
  @Test
  public void f() throws InterruptedException, FileNotFoundException {
	  	WebDriver driver;
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);
		Thread.sleep(2000);
		Search search = new Search(driver);
		Thread.sleep(2000);
		
		/*
		 * 	SEARCH ALL THE MOVIES THAT DOES NOT EXIST
		 */
		Scanner scan = new Scanner(new File("movies_invalid.txt"));

		while (scan.hasNextLine()) {
			String movie = scan.nextLine();

			search.searchMovie(movie);
			Thread.sleep(1000);
			Assert.assertTrue(driver.findElement(By.id("notfound")).getText().contains("movie not Found!"));
			//Assert.assertTrue(driver.findElement(By.id("#notfound")) != null);
		}

		scan.close();
		
		/*
		 * 	NOW WE WILL Search valid USERS
		 */
		scan = new Scanner(new File("movies_valid.txt"));

		while (scan.hasNextLine()) {
			String movie = scan.nextLine();

			search.searchMovie(movie);
			Thread.sleep(1000);
			Assert.assertFalse(driver.findElement(By.id("notfound")).getText().contains("movie not Found!"));
		}
		
		scan.close();
  }
}
