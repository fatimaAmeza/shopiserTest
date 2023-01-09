package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Index {

	WebDriverWait wait;
	WebElement aa;
	@FindBy(xpath = "//section[@class='products-grid']//div[2]//div[2]//div[1]//div[1]//a[1]")  
	private WebElement buttonAddPanier;
	
	@FindBy(xpath = "//div[@id='miniCartSummary']//a[@href='#']")  
	private WebElement buttonPanier;
	
	@FindBy (xpath="//a[normalize-space()='Paiement']")
	private WebElement buttonEnterPanier;

	@FindBy (xpath="//*[@id=\"miniCartSummary\"]/a")
	private WebElement panierMouseHover;
	
	
	public void ajoutProduitAuPanier(WebDriver driver) {
		buttonAddPanier.click();
    }
	
	public Panier clickEnterPanier(WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(panierMouseHover).perform();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
				}

		buttonEnterPanier.click();
		return PageFactory.initElements(driver, Panier.class);
		}
	
	
	
	
	
	
}
