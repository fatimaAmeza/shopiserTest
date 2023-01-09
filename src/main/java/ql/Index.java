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
	public WebElement buttonAddPanier;
	
	@FindBy(xpath = "//div[@id='miniCartSummary']//a[@href='#']")  
	public WebElement buttonPanier;
	
	@FindBy (xpath="//a[normalize-space()='Paiement']")
	public WebElement buttonEnterPanier;

	@FindBy (xpath="//*[@id=\"miniCartSummary\"]/a")
	public WebElement panierMouseHover;
	
	
	public void ajoutProduitAuPanier(WebDriver driver) {
		//Explicit wait
		//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		buttonAddPanier.click();
		//return PageFactory.initElements(driver, Panier.class);
		//wait.until(ExpectedConditions.elementToBeClickable(buttonEnterPanier));
		
		
    }
	
	public Panier clickEnterPanier(WebDriver driver) {
		//buttonPanier.click();

		Actions action = new Actions(driver);
		action.moveToElement(panierMouseHover).perform();
		buttonEnterPanier.click();

		return PageFactory.initElements(driver, Panier.class);
		}
	
	
	
	
	
	
}
