import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjects extends Tools {


    public WebElement getSearchBox() {
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement getAcceptCookies() {
        return driver.findElement(By.id("sp-cc-accept"));
    }

    public WebElement getSearchSubmitButton() {
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public List<WebElement> getAmazonSearchResults() {
        return driver.findElements(By.xpath("//*[@data-component-type='s-search-result']"));
    }

    public WebElement getPaperPageProductTitle() {
        return driver.findElement(By.id("productTitle"));
    }

    public WebElement getPaperPageVersion() {
        return driver.findElement(By.id("a-autoid-6-announce"));
    }

    public WebElement getPaperPagePrice() {
        return driver.findElement(By.xpath("//*[@id='a-autoid-6-announce']/span/span"));
    }

    public WebElement getGiftCheckbox() {
        return driver.findElement(By.id("gift-wrap"));
    }

    public WebElement getAddToBasketButton() {
        return driver.findElement(By.id("add-to-cart-button"));
    }

    public WebElement getGoToBasketButton() {
        return driver.findElement(By.partialLinkText("Go to basket"));
    }

    public WebElement getGiftTitle() {
        return driver.findElement(By.className("a-checkbox-label"));
    }

    public WebElement getProductTitle() {
        return driver.findElement(By.className("a-truncate-full"));
    }

    public WebElement getPaperBackView() {
        return driver.findElement(By.xpath("//*[@id='activeCartViewForm']/div[2]/div[3]/div[4]/div/div[2]/ul/li[2]/span/span"));
    }

    public WebElement getSubtotalLabelBuyBox() {
        return driver.findElement(By.id("sc-subtotal-label-buybox"));
    }

    public WebElement getBasketPrice() {
        return driver.findElement(By.xpath("//*[@id='sc-subtotal-amount-buybox']/span"));
    }

    public List<WebElement> getActiveItemsInTheBasket() {
        return driver.findElements(By.xpath("//div[@data-name='Active Items']//div[@data-asin]"));
    }
}
