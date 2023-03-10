package ql;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CategorieTableChromeTest {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setup() {
//Instancier le driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://192.168.102.169:8080/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	@After

	public void teardown() {
		driver.quit();
	}

	@Test
	public void testAppliShopizer() {


		//wait = new WebDriverWait(driver, 15);


		
		// instanciation de la pageIndex
		Index page_index = new Index(driver, wait); // Instanciation de la page index
		page_index.tables(); // Execution de la fonction tables pour cliquer sur la page
		Tables tables = new Tables(driver, wait); // Instanciation de la page table
		wait.until(ExpectedConditions.visibilityOf(tables.ajoutPanierProduit1));
		verifPageTables(); // Pas de test 3 : On vérifie la présence d'élement
		tables.boutonAsianWoods.click();

		wait.until(ExpectedConditions.elementToBeClickable(tables.ajoutPanierProduit1));
		String prixProduitUn = tables.getPrixProduit1();
		String txtProduitUn = tables.getTitreProduit1();

		PageProduit1 pp1 = tables.clickProduit1(driver);
		assertEquals(pp1.prix.getText(), prixProduitUn);

		PageProduit1 pageProduit1 = new PageProduit1(driver, wait);
		assertTrue(pageProduit1.boutonAjouterPanier.isDisplayed());
		assertTrue(pageProduit1.titreProduit.isDisplayed());


	}

	public void verifPageTables(){
		Tables tables = new Tables(driver, wait);
		//Assert.assertEquals(true, tables.isDisplayed());
		assertTrue(tables.imageProduit1.isDisplayed());
		assertTrue(tables.imageProduit2.isDisplayed());
		assertTrue(tables.imageProduit3.isDisplayed());
		assertTrue(tables.imageProduit4.isDisplayed());
		assertTrue(tables.prixProduit1.isDisplayed());
		assertTrue(tables.prixProduit2.isDisplayed());
		assertTrue(tables.prixProduit3.isDisplayed());
		assertTrue(tables.prixProduit4.isDisplayed());
		assertTrue(tables.titreProduit1.isDisplayed());
		assertTrue(tables.titreProduit2.isDisplayed());
		assertTrue(tables.titreProduit3.isDisplayed());
		assertTrue(tables.titreProduit4.isDisplayed());
		assertTrue(tables.ajoutPanierProduit1.isDisplayed());
		assertTrue(tables.ajoutPanierProduit2.isDisplayed());
		assertTrue(tables.ajoutPanierProduit3.isDisplayed());
		assertTrue(tables.ajoutPanierProduit4.isDisplayed());

	}
}
