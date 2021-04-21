package makemytrip_pk;

import org.testng.annotations.Test;

import resources.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class HomePageTest extends Base {
	public WebDriver driver;

	@Test
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
	}
}
