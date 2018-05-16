package lifebox.home.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
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
 * Test Case LB-2233: Home page - Profile drop-down menu - Log Out
 * <p>
 */
public class LB2233Test extends TestCaseTemplate {
    Logger logger = LoggerFactory.getLogger(LB2233Test.class);

    @Test
    public void testLoginWithGsmNumber() {
        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/input")).setValue(getInputDataProperty(EMAIL));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();

        $(Selectors.byXpath("/html/body/span/root/div/right-grid/div/div[1]/div[1]/drop-down")).click();

        SelenideElement element = $(".sidebar-top").$(Selectors.byAttribute("ng-click", "logout()"));
        element.isDisplayed();
        element.click();

        $(Selectors.byId("welcome")).isDisplayed();
    }
}
