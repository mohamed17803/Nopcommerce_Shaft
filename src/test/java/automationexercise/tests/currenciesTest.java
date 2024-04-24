package automationexercise.tests;
import automationexercise.pages.currenciesPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User activity")
@Story("Change Currence")
public class currenciesTest extends testBase {
    private JSONFileManager testData;

    @Test(description = "Validate that when  the user changes currence then the currency will be changed Automatically in the products ")
    public void validateCurrence(){
        new currenciesPage(driver).urlNavigate().clickOnCurrenceDropDownList(testData.getTestData("currency"))
                .getAndAssertText(testData.getTestData("currencySymbol"));

    }
    @BeforeClass
    @Description("Setting json file   ")
    public void beforeClass(){
        testData=new JSONFileManager("src/test/resources/automationexercise/TestData/currenciesTestData.json");
    }
}
