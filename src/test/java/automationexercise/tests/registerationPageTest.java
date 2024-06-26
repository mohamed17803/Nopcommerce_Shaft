package automationexercise.tests;
import automationexercise.pages.registerationPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User Managment")
@Story("Register")
public class registerationPageTest extends testBase {
    private JSONFileManager testData;

    @Test(description= "Validate that the User can register with valid account successfully")
    public void validateRegister() {
        new registerationPage(driver).urlNavigate().clickOnRegisterTabButton().chooseGender().
                fillRegisterData(testData.getTestData("firstName"), testData.getTestData("lastName"),
                        testData.getTestData("email"), testData.getTestData("companyName"),
                        testData.getTestData("password"), testData.getTestData("confirmPassword"))
                .chooseDateOfBirth(testData.getTestData("Day"), testData.getTestData("Month"),
                        testData.getTestData("Year")).clickOnRegisterButton().
                validateRegister(testData.getTestData("alertText"),testData.getTestData("color"));
    }
    @BeforeClass
    @Description("Setting Json File ")
    public void beforeCLass(){
       testData= new JSONFileManager("src/test/resources/automationexercise/TestData/registerTestData.json");
    }
}
