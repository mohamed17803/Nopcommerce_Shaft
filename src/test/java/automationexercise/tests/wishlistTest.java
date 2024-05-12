package automationexercise.tests;
import automationexercise.pages.wishlistPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Epic("User activity")
@Story("Add to WishList")
public class wishlistTest extends testBase {
    private JSONFileManager testData;

    @Test(description = "Validate the Success message that appear when the user click on add to wishList button")
    public void validateSuccessMessage(){
        new wishlistPage(driver).urlNavigate().validateSuccesMessege(testData.getTestData("background-color"));
    }
    @Test(description = "Validate that the product added to wishList successfully ")
    public void validateWishList(){
        new wishlistPage(driver).urlNavigate().validateAddToWishList();
    }

    @BeforeClass
    @Description("Setting JSON File")
    public void beforeCLass(){
        testData =new JSONFileManager("src/test/resources/automationexercise/TestData/wishlistTestData.json");
    }
}
