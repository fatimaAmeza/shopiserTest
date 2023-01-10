package ql;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class UtilisationPanierFirefoxTest {

	WebDriver driver;
	WebDriverWait wait;


	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	//@After

	//public void teardown() {
		//driver.quit();
	//}

	@Test
	public void testAppliShopizer() throws InterruptedException {

		driver.get("http://192.168.102.40:8080/");

		//wait = new WebDriverWait(driver, 15);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// instanciation de la pageIndex

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// instanciation de la page_index

		Index page_index = new Index(driver, wait);
		String titre = driver.getTitle();
		assertEquals("Importa", titre);

		//Appel à la methode ajoutProduitAuPanier
		page_index.ajoutProduitAuPanier();

		// instanciation de la page_panier
		Panier page_panier = page_index.clickEnterPanier();

		//wait.until(ExpectedConditions.visibilityOf(page_panier.mainMenu));


		//Appel à la methode doublerCommande
		page_panier.doublerCommande();
		//assertTrue(page_panier.verifPanier());


        //Appel à la methode recalculer
		page_panier.recalculer();
		assertEquals(page_panier.verifTotal(),page_panier.converTotal(),0.01);

		//Appel à la methode clickEffectuerPaiement
		page_panier.clickEffectuerPaiement();
		// instanciation de la page_paiement
		Paiement page_paiement = new Paiement(driver, wait);


		
	}

}
