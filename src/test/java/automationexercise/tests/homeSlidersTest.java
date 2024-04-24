package automationexercise.tests;
import automationexercise.pages.homeSlidersPage;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.*;

public class homeSlidersTest extends testBase {
    private JSONFileManager testData;

    @Test
    public void validateIphoneSlider(){
        new homeSlidersPage(driver).urlNavigate().validateIphoneSlider(testData.getTestData("expectedIphoneUrl"));

    }
    @Test
    public void validateGalaxySlider(){
        new homeSlidersPage(driver).urlNavigate().validateGalaxySLider(testData.getTestData("expectedGalaxyUrl"));
    }
    @BeforeClass
    public void beforeClass(){
        testData = new JSONFileManager("src/test/java/automationexercise/tests/homeSlidersTest.java");
    }
}
