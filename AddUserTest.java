package myPackage;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class AddUserTest {
  @Test
  public void f() throws Exception {
		WebDriver driver;
		File file = new File("C:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		String url = "http://localhost:1572/";

		driver = new EdgeDriver();
		driver.get(url);

		AddUser user = new AddUser(driver);
		user.loginuser("admin@gmail.com", "12345");

		Scanner scan = new Scanner(new File("addusers.txt"));

		while (scan.hasNextLine()) {
			String fname = scan.nextLine();
			String email = scan.nextLine();
			String pass = scan.nextLine();
			
			user.InsertUser(fname, email, pass);
			
			//Assert.assertEquals(user.find(fname));
		}

		scan.close();
  }
}
