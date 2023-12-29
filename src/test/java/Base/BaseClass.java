package Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Properties prop;
	
public WebDriver openBrowser(String browserName) {
	
	 prop = new Properties();
	
	File propFile = new File ("src\\test\\resources\\data.properties");
	try {
	FileInputStream fis = new FileInputStream(propFile);
	prop.load(fis);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	
	WebDriver driver = null;
	if (browserName.equalsIgnoreCase("Chrome")) {
		
		WebDriverManager.chromedriver().setup();
 	    driver = new ChromeDriver();
	}
	
	else if (browserName.equalsIgnoreCase("Edge")){
WebDriverManager.edgedriver().setup();		
 driver = new EdgeDriver();	

	}
	
	else if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
	
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	return driver;

}
}
