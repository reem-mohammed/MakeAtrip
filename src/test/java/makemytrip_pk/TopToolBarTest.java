package makemytrip_pk;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

public class TopToolBarTest extends Base {

	@BeforeTest
	public void getUrl() throws IOException {
		driver = initalizeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void getToolBarInfo() {
		HomePageTopToolBar hpTp = new HomePageTopToolBar(driver);

		// Count ToolBar items
		hpTp.getToolBarSize();

		// Click on the toolBar items
		hpTp.getToolBarItems();


	}

//	@AfterMethod
//	public void teardown() {
//		// closes all the browser windows opened by web driver
//		driver.quit();
//	}

}
