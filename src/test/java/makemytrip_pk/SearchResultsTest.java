package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class SearchResultsTest extends Base{

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(searchUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void getSearchResults() throws InterruptedException {
		HomePageSearch hps = new HomePageSearch(driver);
		hps.getResults();
		hps.getViewProductsClicked();
		
		//Click Book BTN 
		hps.getBookBtnClicked();
	}
}
