package ql;


import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTestShopizer {

	WebDriver driver;
	WebDriverWait wait;
	
	
	
	
	@Before
	public void setup() {
//Instancier le driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//wait = new WebDriverWait(driver, 15);
		// System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		// driver = new FirefoxDriver();
		
	}

	//@After

	//public void teardown() {
		//driver.quit();
	//}

	@Test
	public void testAppliShopizer() {

		driver.get("http://192.168.1.120:8080/");
		// driver.get("https://petstore.octoperf.com/");
		//wait = new WebDriverWait(driver, 15);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		// instanciation de la pageIndex
		Index page_index = PageFactory.initElements(driver, Index.class);
		page_index.ajoutProduitAuPanier(driver);
		
		Panier page_panier = page_index.clickEnterPanier(driver);
		wait.until(ExpectedConditions.visibilityOf(page_panier.mainMenu));
		
		
		

		
		
		
		
		
		
	}

}
