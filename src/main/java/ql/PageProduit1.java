package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProduit1 {

    public PageProduit1(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@itemprop=\"price\"]")
    public WebElement prix;

    @FindBy(xpath="//*[@id=\"input-400\"]/div/button")
    public WebElement boutonAjouterPanier;

    @FindBy(xpath="//*[@class=\"sinple-c-title\"]")
    public WebElement titreProduit;
}
