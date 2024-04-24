package automationexercise.tests;
import automationexercise.pages.LoginPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User Management")
@Story("Login")
public class LoginTest extends testBase{
    private JSONFileManager testDataForRegister;
    private JSONFileManager testDataForLogin;

    @Test(description="Validate that the user can  login Successfully")
    public void validateValidLogin(){
        new LoginPage(driver).urlNavigate().clickOnLoginTabButton().
                fillValidLoginData(testDataForRegister.getTestData("email"),testDataForRegister.getTestData("password"))
                .clickOnLoginButton().validateValidLogin(testDataForLogin.getTestData("expectedUrl"));
    }
    @Test(description = "Validate that the user can't login successfully ")
    public void validateInValidLogin(){
        new LoginPage(driver).urlNavigate().clickOnLoginTabButton().
                fillInValidLoginData(testDataForLogin.getTestData("wrongEmail"),
                        testDataForRegister.getTestData("password")).clickOnLoginButton().
                validateInValidLogin(testDataForLogin.getTestData("expectedErrorMessage"),
                        testDataForLogin.getTestData("colorOfErrorMessage"));
    }
    @BeforeClass
    @Description("Setting JSON file  ")
    public void beforeCLass(){
        testDataForRegister =new JSONFileManager("src/test/resources/automationexercise/TestData/loginTestData.json");
        testDataForLogin =new JSONFileManager("src/test/resources/automationexercise/TestData/loginTestData.json");
    }
}

