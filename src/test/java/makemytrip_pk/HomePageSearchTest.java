package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class HomePageSearchTest extends Base {
	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void getPopularFilters() throws InterruptedException {

		HomePageSearch hps = new HomePageSearch(driver);

		hps.getSearchBtnClicked();
		hps.getCheckboxesChecked();
		hps.getMoreLinkClicked();
		hps.getmoreItemsChecked();
		hps.ValidatePopularItems();
		hps.getValidatePIandCh();
		hps.getItensInTheSet();
		hps.CompareItems();
		hps.getClearBTNClicked();
		hps.validateItemsAfterClear();

	}

}
