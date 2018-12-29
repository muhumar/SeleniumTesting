package myPackage;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class UpdateMovieTest {
  @Test
	public void f() throws Exception {
		WebDriver driver;
		File file = new File("C:/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);

		UpdateMovie movie = new UpdateMovie(driver);
		movie.loginuser("admin@gmail.com", "12345");
		
		Scanner scan = new Scanner(new File("updatemovienames.txt"));

		while (scan.hasNextLine()) {
			String name = scan.nextLine();
			String name2 = scan.nextLine();
			movie.UpdateMovieName(name, name2);
			// Assert.assertEquals(movie.find(name));
		}

		scan.close();
	}
}
