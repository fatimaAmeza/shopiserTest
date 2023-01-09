package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Panier {

	@FindBy(xpath = "//div[@id='MainImageContent']")
	private WebElement mainMenu;
	
	@FindBy(xpath = "//input[@name=\"quantity\"]")
	private WebElement quantitArticle;
	
	@FindBy(xpath = "//a[normalize-space()='Recalculer']")
	private WebElement buttonRecalculer;
	
	@FindBy(xpath = "//td[@data-th='Prix']//strong[contains(text(),'78,00 USD')]")
	private WebElement prixChamp;
	
	@FindBy(xpath = "//strong[normalize-space()='156,00 USD']")
	private WebElement totalChamp;
	
	@FindBy(xpath = "//a[normalize-space()='Effectuer le paiement']")
	private WebElement buttonPaiement;
	
	public void doublerCommande(WebDriver driver) {

		quantitArticle.clear();
		quantitArticle.sendKeys("2");

	}


	public void recalculer() {
		buttonRecalculer.click();
	}
	public boolean verifPanier() {

		return (quantitArticle.getText() == "2");
	}

	public float verifTotal() {
		String prixUnitaire = prixChamp.getText();
		String prixUnitaire1 = prixUnitaire.replace("USD", "  ");
		String prixUnitaire2 = prixUnitaire1.replace(",", ".");
		float prixUnitaire3 = Float.parseFloat(prixUnitaire2);
		float prix = prixUnitaire3*2;
		return (prix);
	}
	public float converTotal() {
		String prixTotal = totalChamp.getText();
		String prixTotal2 = prixTotal.replace("USD", "  ");
		String prixTotal3 = prixTotal2.replace(",", ".");
		float prixTotal4 = Float.parseFloat(prixTotal3);
		return (prixTotal4);
	}
	

	public Paiement clickEffectuerPaiement(WebDriver driver) throws InterruptedException {
		Thread.sleep(1500);
			buttonPaiement.click();

		return PageFactory.initElements(driver, Paiement.class);
		}
	
	
	
}
