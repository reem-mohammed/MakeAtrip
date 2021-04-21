package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class RoundTripTest extends Base {
	public WebDriver driver;

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void RoundOne() throws InterruptedException {
		HomePage hp = new HomePage(driver);

		// RoundTrip
		hp.getTripRound().click();
		
		//Validate Round Trip
		hp.ValidateRoundWay();
		
		// Handle the return calendar.
		hp.getReturnRound().click();
		hp.getRoundDate().click();
	}

}
