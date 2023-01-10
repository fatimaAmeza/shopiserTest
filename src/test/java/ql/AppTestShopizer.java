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

<<<<<<< HEAD
=======
import static org.junit.Assert.assertEquals;
>>>>>>> 247fa01dd70e855927bc1949803043793ea66a65
import static org.junit.Assert.assertTrue;

public class AppTestShopizer {

	WebDriver driver;
	WebDriverWait wait;
	String titre;


	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	//@After

	//public void teardown() {
		//driver.quit();
	//}

	@Test
	public void testAppliShopizer() throws InterruptedException {

		driver.get("http://192.168.102.150:8080/");
<<<<<<< HEAD
		//wait = new WebDriverWait(driver, 15);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// instanciation de la pageIndex
=======
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// instanciation de la page_index
>>>>>>> 247fa01dd70e855927bc1949803043793ea66a65
		Index page_index = PageFactory.initElements(driver, Index.class);
		titre = driver.getTitle();
		assertEquals("Vintage Bags - Shopizer demo", titre);

		//Appel à la methode ajoutProduitAuPanier
		page_index.ajoutProduitAuPanier(driver);

		// instanciation de la page_panier
		Panier page_panier = page_index.clickEnterPanier(driver);
<<<<<<< HEAD
		//wait.until(ExpectedConditions.visibilityOf(page_panier.mainMenu));
		
=======

		//Appel à la methode doublerCommande
		page_panier.doublerCommande(driver);
		//assertTrue(page_panier.verifPanier());


        //Appel à la methode recalculer
		page_panier.recalculer();
		assertEquals(page_panier.verifTotal(),page_panier.converTotal(),0.01);

		//Appel à la methode clickEffectuerPaiement
		page_panier.clickEffectuerPaiement(driver);
		// instanciation de la page_paiement
		Paiement page_paiement = PageFactory.initElements(driver, Paiement.class);








>>>>>>> 247fa01dd70e855927bc1949803043793ea66a65
		
		

		
		
		
		
		
		
	}

}
