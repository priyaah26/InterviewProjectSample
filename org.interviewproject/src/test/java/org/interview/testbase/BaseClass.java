package org.interview.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public static WebDriver driver;
	public static String browserName;
	public static String link;
	public static FileInputStream fis;
	public static Properties prop = new Properties();
	public static File file;
	
	@BeforeMethod
	public void setUp() {
		
		file = new File("C:\\Users\\Admin\\eclipse-workspace\\org.interviewproject\\src\\test\\resources\\cofigurationFile\\config.properties");

		try {

			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		browserName = prop.getProperty("browser");
		link = prop.getProperty("url");
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else {
			System.out.println("Browser Not Found");

			/** Exception Browser not Found */
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(link);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
