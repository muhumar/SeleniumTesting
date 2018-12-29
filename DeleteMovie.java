package myPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DeleteMovie {
	WebDriver driver = null;

	DeleteMovie(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	void loginuser(String username, String password) throws InterruptedException {
		Login login = new Login(driver);
		driver.findElement(By.cssSelector("#email")).sendKeys(username);
		driver.findElement(By.cssSelector("#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("#signin")).click();
		Thread.sleep(3000);
	}

	boolean gotoDeleteMoviePage() {
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

	void RemoveMovie(String movie_name) throws InterruptedException {
		if (!gotoDeleteMoviePage())
			return;
		Thread.sleep(2000);
//		System.out.println(movie_name+"_delete");
		driver.findElement(
				By.id(movie_name + "_delete")).click();
		Thread.sleep(2000);
//		System.out.println(movie_name+"_delete");
	}

	boolean find(String name) {
		/*to be implemented*/
		
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

		AddMovie a = new AddMovie(driver);
		a.loginuser("admin@gmail.com", "12345");
		// a.InsertMovie("test1","2018","/Content/image/abcd2.png","test","test","test","test","test");

		DeleteMovie a1 = new DeleteMovie(driver);
		a1.RemoveMovie("test1");
	}
}
