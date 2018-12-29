package myPackage;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddMovieTest {
  @Test
  public void f() throws Exception {
		WebDriver driver;
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);

		AddMovie movie = new AddMovie(driver);
		movie.loginuser("admin@gmail.com", "12345");

		Scanner scan = new Scanner(new File("addmovies.txt"));

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			String year = scan.nextLine();
			String picture = scan.nextLine();
			String language = scan.nextLine();
			String cast = scan.nextLine();
			String rating = scan.nextLine();
			String trailer = scan.nextLine();
			String review = scan.nextLine();
			
			movie.InsertMovie(name, year, picture, language, cast, rating, trailer, review);
			
			//Assert.assertEquals(movie.find(name));
		}

		scan.close();
  }
}
