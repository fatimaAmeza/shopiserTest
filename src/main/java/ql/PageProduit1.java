package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProduit1 {

    WebDriver driver;
    WebDriverWait wait;

    public PageProduit1(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(xpath="//span[@itemprop=\"price\"]")
    public WebElement prix;

    @FindBy(xpath="//*[@id=\"input-400\"]/div/button")
    public WebElement boutonAjouterPanier;

    @FindBy(xpath="//*[@class=\"sinple-c-title\"]")
    public WebElement titreProduit;
}
