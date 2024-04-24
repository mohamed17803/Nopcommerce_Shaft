package automationexercise.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage urlNavigate() {
        String pageURL = "https://demo.nopcommerce.com/";
        driver.browser().navigateToURL(pageURL);
        return this.urlNavigate();
    }

    private final By loginTabButton = By.xpath("//a[@class=\"ico-login\"]");
    private final By emailTextBox =By.xpath("//div[@class=\"returning-wrapper fieldset\"]//input[@id=\"Email\"]");
    private final By passwordTextBox=By.xpath("//div[@class=\"returning-wrapper fieldset\"]//input[@id=\"Password\"]");
    private final By loginButton =By.xpath("//div[@class=\"returning-wrapper fieldset\"]//div[@class=\"buttons\"]//button[@type=\"submit\"]");
    private final By myAccountTabButton =By.className("ico-account");
    private final By errorMessageOfInvalidLogin = By.xpath("//div[contains(text(),'Login was unsuccessful')]");
    @Step("Validate that the user logged in Successfully ")
    public LoginPage validateValidLogin(String expectedUrl){
      driver.verifyThat().browser().url().isEqualTo(expectedUrl).perform();
      driver.verifyThat().element(myAccountTabButton).isVisible().perform();
      return this;
    }
    @Step("Validate that the user Couldn't logIn Successfully")
    public void validateInValidLogin(String expectedErrorMesssage, String colorOfErrorMessage){
       driver.verifyThat().element(errorMessageOfInvalidLogin).text().isEqualTo(expectedErrorMesssage).perform();
       driver.verifyThat().element(errorMessageOfInvalidLogin).cssProperty("color").
               isEqualTo(colorOfErrorMessage);
    }
    public LoginPage clickOnLoginTabButton(){
        driver.element().click(loginTabButton);
        return this;
    }
    public LoginPage fillValidLoginData(String email, String password){
        driver.element().type(emailTextBox,email);
        driver.element().type(passwordTextBox,password);
        return this;
    }
    public LoginPage fillInValidLoginData(String wrongEmail, String password){
        driver.element().type(emailTextBox,wrongEmail);
        driver.element().type(passwordTextBox,password);
        return this;
    }
    public LoginPage clickOnLoginButton(){
        driver.element().click(loginButton);
        return this;
    }
}
