package makemytrip_pk;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.Base;

public class MultiRoundTest extends Base {

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void multiRound(String cityFrom , String cityTo , int adNum , int chNum, int infNum, int tc , int acceptedPass) throws InterruptedException {
		HomePage hp = new HomePage(driver);

		// MultiCity Radio
		hp.getMultiCityRadio().click();
		
		//Validate MultiRound
		hp.ValidateMultiRoundWay();

		Actions a = new Actions(driver);
		//Travelers List
		List<WebElement> webElementsCityFrom = hp.getMultiCityFrom();
		List<WebElement> webElementsCityTo   = hp.getMultiCityTo();
		List<WebElement> webElementsCityDep  = hp.getMultiCityDep();
		List<WebElement> webElementsCityBox  = hp.getMultiCityBox();

		for (int j = 0; j < webElementsCityBox.size(); j++) {

			a.moveToElement(webElementsCityFrom.get(j)).click().sendKeys(cityFrom).sendKeys(Keys.ARROW_DOWN).build()
					.perform();
			a.moveToElement(webElementsCityFrom.get(j)).sendKeys(Keys.ENTER);

			a.moveToElement(webElementsCityTo.get(j)).click().sendKeys(cityTo).sendKeys(Keys.ARROW_DOWN).build()
					.perform();
			a.moveToElement(webElementsCityTo.get(j)).sendKeys(Keys.ENTER);

			a.moveToElement(webElementsCityDep.get(j)).click().build().perform();
			a.moveToElement(webElementsCityBox.get(j)).click().build().perform();

			// To handle the extra cell
			if (j == webElementsCityBox.size() - 1) {
				break;
			}
		}

		// get Total passengers numbers
		a.moveToElement(hp.getMultiTravelClass()).click().build().perform();

		// get accepted passengers
		int TotalPassengers = hp.getTravelClassDetails(adNum, chNum, infNum, tc);
		hp.getAcceptedPassNum(TotalPassengers, acceptedPass);

		// Add otherCities
		a.moveToElement(hp.getAddCityBlock()).click().build().perform();

	}
	
	
	@DataProvider
	public Object[][] getData() throws InterruptedException {
		Object[][] data= new Object[2][7];
		data[0][0]="se";
		data[0][1]="De";
		data[0][2]=1;
		data[0][3]=3;
		data[0][4]=1;
		data[0][5]=1;
		data[0][6]=9;
		
		
		
		data[1][0]="al";
		data[1][1]="ind";
		data[1][2]=2;
		data[1][3]=4;
		data[1][4]=3;
		data[1][5]=2;
		data[1][6]=9;
		

		return data;

	}


}
