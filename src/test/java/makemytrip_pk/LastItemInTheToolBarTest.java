package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class LastItemInTheToolBarTest extends Base {

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test
	public void getLastItemsPagesInNewTabs() throws InterruptedException {
		HomePageTopToolBar hpTp = new HomePageTopToolBar(driver);

		// get last item's pages
		hpTp.getLastItemPages();
	}

}
