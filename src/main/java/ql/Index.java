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
	WebDriver driver;
	@FindBy(xpath = "//section[@class='products-grid']//div[2]//div[2]//div[1]//div[1]//a[1]")  
	private WebElement buttonAddPanier;
	
	@FindBy(xpath = "//div[@id='miniCartSummary']//a[@href='#']")  
	private WebElement buttonPanier;
	
	@FindBy (xpath="//a[normalize-space()='Paiement']")
	private WebElement buttonEnterPanier;

	@FindBy (xpath="//*[@id=\"miniCartSummary\"]/a")
	private WebElement panierMouseHover;


	@FindBy (xpath="//*[@id=\"main_h\"]/div/div/div/div/nav/ul/li[2]/a")
	private WebElement boutonTables;

	public Index(WebDriver driver, WebDriverWait wait){
		PageFactory.initElements(driver, this);
		this.wait = wait;
		this.driver = driver;
	}

	public void ajoutProduitAuPanier() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddPanier));
		buttonAddPanier.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Panier clickEnterPanier() {

		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(panierMouseHover));
		action.moveToElement(panierMouseHover).perform();
		wait.until(ExpectedConditions.visibilityOf(buttonEnterPanier));
		wait.until(ExpectedConditions.elementToBeClickable(buttonEnterPanier));
		buttonEnterPanier.click();
		return new Panier(driver, wait);
	}

	public void tables(){
		boutonTables.click();
	}
	
	
	
	
	
}
