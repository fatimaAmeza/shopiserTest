package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Panier {

	@FindBy(xpath = "//div[@id='MainImageContent']")
	public WebElement mainMenu;
	
	@FindBy(xpath = "//*[@id=\'118\']")
	public WebElement quantitArticle;
	
	@FindBy(xpath = "//a[normalize-space()='Recalculer']")
	public WebElement buttonRecalculer;
	
	@FindBy(xpath = "")
	public WebElement prixChamp;
	
	@FindBy(xpath = "//*[@id=\'mainCartTable\']/tbody/tr/td[4]/strong")
	public WebElement totalChamp;
	
	@FindBy(xpath = "")
	public WebElement buttonPaiement;
	
	public void doublerCommande(WebDriver driver, String number) {
		quantitArticle.clear();
		quantitArticle.sendKeys("2");	
	}
	
	public void recalculer() {
		buttonRecalculer.click();
		
	}
	
	public boolean verifPrice() {
		String prixUnitaire = prixChamp.getText();
		String prixTotal = totalChamp.getText();
		prixUnitaire = prixUnitaire.replace("USD", "");
		prixTotal = prixTotal.replace("USD", "");
		float prixUnitaire2 = Float.parseFloat(prixUnitaire);
		float prixTotal2 = Float.parseFloat(prixTotal);
		return (prixTotal2 == prixUnitaire2*2);
	
	}
	
	
	public Paiement clickEffectuerPaiement(WebDriver driver) {
		buttonPaiement.click();
		//wait.until(ExpectedConditions.visibilityOf(buttonEnterRanier));
		return PageFactory.initElements(driver, Paiement.class);
		}
	
	
	
}
