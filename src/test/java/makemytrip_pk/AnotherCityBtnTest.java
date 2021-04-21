package makemytrip_pk;


import java.io.IOException;


import resources.Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnotherCityBtnTest extends Base {
	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void makeTrip() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		//hp.getAddCityBlock().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
