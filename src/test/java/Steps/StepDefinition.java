package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinition {

    public static WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //------------------- GIVEN

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        userIsOnLoginPage();
        userInputsValidUsername();
        userInputsValidPassword();
        userClicksOnLoginButton();
    }

    //------------------- WHEN

    @When("user inputs valid username")
    public void userInputsValidUsername() {
        loginPage.inputUsername("standard_user");
    }

    @When("user inputs invalid {string} into username field")
    public void userInputsInvalidUsernameIntoUsernameField(String username) {
        loginPage.inputUsername(username);
    }

    @When("user clicks on add button")
    public void userClicksOnAddButton() {
        homePage.clickOnAddToCartButton();
    }

    @When("user clicks on add button multiple times")
    public void userClicksOnAddButtonMultipleTimes() {
        homePage.clickOnAddToCartButtonMultipleTimes();
    }
    //------------------- AND

    @And("user inputs valid password")
    public void userInputsValidPassword() {
        loginPage.inputPassword("secret_sauce");
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @And("redirected to homepage")
    public void redirectedToHomepage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @And("user inputs invalid {string} into password field")
    public void userInputsInvalidPasswordIntoPasswordField(String password) {
        loginPage.inputPassword(password);
    }

    @And("error message appears")
    public void errorMessageAppears() {
        Assert.assertTrue(loginPage.error.isDisplayed());
    }

    //------------------- THEN

    @Then("user is logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(homePage.cartButton.isDisplayed());
    }

    @Then("user is not logged in")
    public void userIsNotLoggedIn() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Then("item is added to cart")
    public void itemIsAddedToCart() {
        Assert.assertEquals(homePage.cartBadge.getText(), "1");
    }

    @Then("items are added to cart")
    public void itemsAreAddedToCart() {
        Assert.assertEquals(homePage.cartBadge.getText(), "3");
    }
}
