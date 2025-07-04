package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends StepDefinition {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    //--------------------------------

    public void clickOnAddToCartButton() {
        addToCartButton.get(0).click();
    }

    public void clickOnAddToCartButtonMultipleTimes() {
        addToCartButton.get(0).click();
        addToCartButton.get(0).click();
        addToCartButton.get(0).click();
    }

}
