package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="dp")
	public Object[][] getData(){
		return ExcelUtility.getExcelData((System.getProperty("user.dir")+"\\testdata\\Userdata.xlsx"),"Sheet1");
	}
	
	@DataProvider(name = "userNames")
	public Object[][] getUserNames() {

	    return ExcelUtility.getUserNames((System.getProperty("user.dir") + "\\testdata\\Userdata.xlsx"),"Sheet1");
	}

}
