package ql;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tables {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[1]/div[1]")
    public WebElement imageProduit1;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[2]/div[1]")
    public WebElement imageProduit2;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[3]/div[1]")
    public WebElement imageProduit3;

    @FindBy(xpath = "//*[@id=\"productsContainer\"]/div[4]/div[1]")
    public WebElement imageProduit4;

    @FindBy(xpath="(//span[@itemprop])[1]")
    public WebElement prixProduit1;

    @FindBy(xpath="(//span[@itemprop])[1]")
    public WebElement prixProduit2;

    @FindBy(xpath="(//span[@itemprop])[1]")
    public WebElement prixProduit3;

    @FindBy(xpath="(//span[@itemprop])[1]")
    public WebElement prixProduit4;

    @FindBy(xpath="(//h3[@itemprop])[1]")
    public WebElement titreProduit1;

    @FindBy(xpath="(//h3[@itemprop])[2]")
    public WebElement titreProduit2;

    @FindBy(xpath="(//h3[@itemprop])[3]")
    public WebElement titreProduit3;

    @FindBy(xpath="(//h3[@itemprop])[4]")
    public WebElement titreProduit4;

    @FindBy(xpath="(//a[@class=\"addToCart\"])[1]")
    public WebElement ajoutPanierProduit1;

    @FindBy(xpath="(//a[@class=\"addToCart\"])[2]")
    public WebElement ajoutPanierProduit2;

    @FindBy(xpath="(//a[@class=\"addToCart\"])[3]")
    public WebElement ajoutPanierProduit3;

    @FindBy(xpath="(//a[@class=\"addToCart\"])[4]")
    public WebElement ajoutPanierProduit4;

    @FindBy(xpath="//*[@id=\"mainContent\"]/div[2]/div/div/div[2]/ul[2]/li[3]/a")
    public WebElement boutonAsianWoods;

    public Tables(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.wait = wait;
        this.driver = driver;
    }

    public String getPrixProduit1(){
        return prixProduit1.getText();
    }
    public String getTitreProduit1(){
        return titreProduit1.getText();
    }

    public PageProduit1 clickProduit1(WebDriver driver){
        wait.until(ExpectedConditions.elementToBeClickable(titreProduit1));
        titreProduit1.click();
        return new PageProduit1(driver, wait);
    }

}
//*[@id="productsContainer"]/div[2]/div[2]/h4/span
//*[@id="productsContainer"]/div[1]/div[2]/h4/span