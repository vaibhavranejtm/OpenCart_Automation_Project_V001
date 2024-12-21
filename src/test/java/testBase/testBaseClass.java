package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testBaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties properties;
	
	
	@BeforeClass
	@Parameters({"OS","Browser"})
	public void setUp(String OS, String Browser) throws IOException {
		
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(Browser.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("invalid browser"); return;
		}
		FileReader file= new FileReader("./src//test//resource//config.properties");
		properties=new Properties();
		properties.load(file);
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
		driver.get(properties.getProperty("URL1"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public String randomAlphabetics() {
		String rndmString=RandomStringUtils.randomAlphabetic(5);
		return rndmString;
	}
	
	public String randomNumerics() {
		String rndmnumeric=RandomStringUtils.randomNumeric(5);
		return rndmnumeric;
		
	}
	
	
	public String RandomAlphaNumeric() {
		String rndmString=RandomStringUtils.randomAlphabetic(5);

		String rndmnumeric=RandomStringUtils.randomNumeric(5);
		String combination =rndmString+rndmnumeric;
		return combination;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}


}
