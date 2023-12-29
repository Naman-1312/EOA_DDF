package TestPackage;

//import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import pageobject.LoginPage;
import util.DataUtil;
import util.MyXLSReader;

public class Login extends BaseClass {
	WebDriver driver;
	MyXLSReader excelReader;
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test (dataProvider = "dataProvider")
	public void loginTest(HashMap<String,String> hMap) {
		
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			throw new SkipException("Run Mode is set No hence it is not executed");
		}
		
		driver = openBrowser(hMap.get("Browser"));
	    driver.get(prop.getProperty("url"));
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(hMap.get("Username"));
	    loginPage.enterPassword(hMap.get("Password"));
	    loginPage.loginClick();
	 
//	 driver.findElement(By.id("UserName")).sendKeys(hMap.get("Username"));
//	 driver.findElement(By.id("Password")).sendKeys(hMap.get("Password"));
//	 driver.findElement(By.name("LoginButton")).click();
	 
	 String expectedResult = hMap.get("ExpectedResult");
	 
	 boolean expectedConvertedResult = false;
	 if(expectedResult.equalsIgnoreCase("Success")) {
		 expectedConvertedResult = true;	 
	 }
	 else if(expectedResult.equalsIgnoreCase("Failure")) {
		 expectedConvertedResult = false;	 
	 }
	 
	 boolean actualResult = false;
try {
	 actualResult = driver.findElement(By.id("memberLogo")).isDisplayed();
}catch(Throwable e) {
	actualResult = false;
}
	 
	 
	 Assert.assertEquals(actualResult, expectedConvertedResult);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		
	}
	@DataProvider
	public Object[][] dataProvider() {
		Object[][] data = null;
		try {
		 excelReader = new MyXLSReader("D:\\KeyGenProject\\EOA_DataDrivenFramework\\src\\test\\resources\\TestExcel.xlsx");
		data  = DataUtil.getTestData(excelReader,"LoginTest","Data");
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return data;
	}
}
