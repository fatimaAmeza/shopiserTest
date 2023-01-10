package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Panier {

	WebDriverWait wait;
	WebDriver driver;

	@FindBy(xpath = "//div[@id='MainImageContent']")
	private WebElement mainMenu;
	
	@FindBy(xpath = "//input[@name=\"quantity\"]")
	private WebElement quantitArticle;
	
	@FindBy(xpath = "//a[normalize-space()='Recalculer']")
	private WebElement buttonRecalculer;
	
	@FindBy(xpath = "//td[@data-th=\"Prix\"]/strong")
	private WebElement prixChamp;
	
	@FindBy(xpath = "//td[@data-th=\"Total\"]/strong")
	private WebElement totalChamp;
	
	@FindBy(xpath = "//a[normalize-space()='Effectuer le paiement']")
	private WebElement buttonPaiement;

	public Panier(WebDriver driver, WebDriverWait wait){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	public void doublerCommande() {

		quantitArticle.clear();
		quantitArticle.sendKeys("2");

	}


	public void recalculer() {
		buttonRecalculer.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verifPanier() {

		return (quantitArticle.getText() == "2");
	}

	public float verifTotal() {
		String prixUnitaire = prixChamp.getText().replace("US$", "");
		float prix = Float.parseFloat(prixUnitaire) * Float.parseFloat(quantitArticle.getAttribute("value"));
		return (prix);
	}
	public float converTotal() {
		String prixTotal = totalChamp.getText().replace("US$", "");
		float prix = Float.parseFloat(prixTotal);
		return (prix);
	}
	

	public Paiement clickEffectuerPaiement(){
		wait.until(ExpectedConditions.elementToBeClickable(buttonPaiement));
		buttonPaiement.click();
		return new Paiement(driver, wait);
		}
	
	
	
}
