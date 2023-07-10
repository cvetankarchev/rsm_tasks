import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AmazonAutomationTest extends PageObjects {


    @Test
    public void amazonAutomationTask2() {

        driver.get("https://www.amazon.co.uk");
        // Verify the page is correct and loaded
        Assert.assertTrue("Page did not load correctly.",
                driver.getTitle().contains("Amazon.co.uk"));

        // Search for the book "Harry Potter and the Cursed Child, 1 & 2" in the books section
        clear(getSearchBox());
        sendKeys(getSearchBox(), "Harry Potter and the Cursed Child, 1 & 2");
        click(getSearchSubmitButton());
        click(getAcceptCookies());

        //Checking the first result in the list
        Assert.assertEquals("The Title of the first result is wrong, please check!",
                "Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production",
                getAmazonSearchResults().get(0).findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getAttribute("innerHTML"));
        Assert.assertTrue("Paperback version is not available, please check!",
                getAmazonSearchResults().get(0).findElement(By.linkText("Paperback")).isDisplayed());
        Assert.assertEquals("The Paperback price is wrong, please check!", "£4.00",
                getAmazonSearchResults().get(0).findElement(By.className("a-offscreen")).getAttribute("innerHTML"));

        //Go to Paperback page with the details.
        click(getAmazonSearchResults().get(0).findElement(By.linkText("Paperback")));

        //Checking the Paperback page.
        Assert.assertEquals("The Title of the first result is wrong, please check!",
                "Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production",
                getPaperPageProductTitle().getAttribute("innerHTML").trim());
        Assert.assertTrue("Paperback version is not available, please check!",
                getPaperPageVersion().isDisplayed());
        Assert.assertEquals("The Paperback price is wrong, please check!", "£4.00",
                getPaperPagePrice().getAttribute("innerHTML").trim());

        // Mark it as a gift
        if (!getGiftCheckbox().isSelected()) {
            getGiftCheckbox().click();
        }

        // Add it to the basket
        click(getAddToBasketButton());

        click(getGoToBasketButton());

        Assert.assertEquals("It's not added as a gift, please check!", "This order contains a gift",
                getGiftTitle().getAttribute("innerHTML").trim());
        Assert.assertEquals("The title is wrong, please check!",
                "Harry Potter and the Cursed Child - Parts One and Two: The Official Playscript of the Original West End Production",
                getProductTitle().getAttribute("innerHTML").trim());
        Assert.assertEquals("The Paperback is missing, please check!", "Paperback",
                getPaperBackView().getAttribute("innerHTML").trim());
        Assert.assertEquals("It's not added 1 item, please check!", "Subtotal (1 item):",
                getSubtotalLabelBuyBox().getAttribute("innerHTML").trim());
        Assert.assertEquals("The price is wrong, please check!", "£4.00",
                getBasketPrice().getAttribute("innerHTML").trim());
        Assert.assertEquals("The is more or less then 1 item in the basket, please check!", 1,
                getActiveItemsInTheBasket().size());

    }

}
