package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

public class OneWayRoundTest extends Base {
	public WebDriver driver;

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	// From

	@Test(dataProvider = "getData")
	public void RoundOne(String cityFrom, String cityTo, String cityToValue, String cityFromValue, int CityIndex,
			int adNum, int chNum, int infNum, int tc, int acceptedPass) throws InterruptedException {
		{
			HomePage hp = new HomePage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 90);

			// One Way Round
			hp.ValidateOnWay();

			Actions a = new Actions(driver);
			
			
			
			// From
			a.moveToElement(hp.getCounFrom()).click().build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(hp.from));
			a.moveToElement(hp.getCounFrom()).sendKeys(cityFrom).sendKeys(Keys.ARROW_DOWN).build().perform();
			a.moveToElement(hp.getCounFrom()).sendKeys(Keys.ENTER).build().perform();
			
	
			
			// To
			a.moveToElement(hp.getCl()).click().build().perform();
			a.moveToElement(hp.selectTo()).sendKeys(cityTo).build().perform();
			hp.validateCityTo(CityIndex);

			// Departure
			a.moveToElement(hp.geteDpartureBox()).click().build().perform();
			a.moveToElement(hp.geteDpartureDate()).click().build().perform();

			// Travelers class
			a.moveToElement(hp.getTravelClickBox()).click().build().perform();
			int TotalPassengers = hp.getTravelClassDetails(adNum, chNum, infNum, tc);

			// get Total passengers numbers
			hp.getAcceptedPassNum(TotalPassengers, acceptedPass);

			// get Travel Resson
			hp.getTravelsRessonsDetails();

			// Validations

			// Validate To 'City'
			hp.ValidateToOneWay(cityToValue);

			// Validate From 'City'
			hp.ValidateFromOneWay(cityFromValue);

		}
	}

	@DataProvider
	public Object[][] getData() throws InterruptedException {
		Object[][] data = new Object[2][10];
		data[0][0] = "egy"; // From
		data[0][1] = "de"; // To
		data[0][2] = "Delhi"; // City validation 'To'
		data[0][3] = "Cairo"; // City validation 'From'
		data[0][4] = 1; // City To index
		data[0][5] = 1; // Adults#
		data[0][6] = 3; // Kids#
		data[0][7] = 1; // Infants#
		data[0][8] = 1; // Travel class
		data[0][9] = 9; // accepted Passengers
		
		data[1][0] = "s"; // From
		data[1][1] = "al"; // To
		data[1][2] = "Alta"; // City validation 'To'
		data[1][3] = "surat"; // City validation 'From'
		data[1][4] = 2; // City to index
		data[1][5] = 2; // Adults#
		data[1][6] = 4; // Kids#
		data[1][7] = 3; // Infants#
		data[1][8] = 2; // Travel class
		data[1][9] = 9; // Accepted Passengers

		return data;

	}

}
