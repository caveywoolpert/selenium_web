package lifebox.welcome.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import lifebox.TestCaseTemplate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;
import static utils.InputPropertiesConstants.*;
import static utils.ParametersLoader.getInputDataProperty;

/**
 * Created by Dmitriy.Kruchek on 22.12.2017.
 * <p>
 * Test Case LB-333: Start page - Login with Email
 * <p>
 */
public class LB333Test extends TestCaseTemplate {
    Logger logger = LoggerFactory.getLogger(LB333Test.class);

    @Test
    public void testLoginWithGsmNumber() {
        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/input")).setValue(getInputDataProperty(EMAIL));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();
    }
}
