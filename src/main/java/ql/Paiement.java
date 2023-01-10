package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Paiement {

	WebDriverWait wait;

	public Paiement(WebDriver driver, WebDriverWait wait){

	}
	
	@FindBy(xpath = "//h1[@class='entry-title']")
	private WebElement textPaiement;

}
