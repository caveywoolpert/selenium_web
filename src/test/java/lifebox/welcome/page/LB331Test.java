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
 * Test Case LB-331: Start page - Login with GSM Number
 * <p>
 * #:	|   Step actions:	                                                                                        |   Expected Results:
 * <p>
 * 1	|   Open Lifebox / Start page.	                                                                            |   Login page is displayed. 'E-mail' tab is selected by default.
 * 2	|   Select the 'GSM Number' tab.	                                                                        |   -
 * 3	|   Fill in all required fields (GSM Number, Password) using data, which were entered during Registration.	|   -
 * 4	|   Click "Login".	                                                                                        |   Login successfully completed. Home page is displayed.
 */
public class LB331Test extends TestCaseTemplate {
    Logger logger = LoggerFactory.getLogger(LB331Test.class);

    @Test
    public void testLoginWithGsmNumber() {
        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[2]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/drop-down/input")).setValue(getInputDataProperty(MOBILE_OPERATOR_COUNTRY_CODE));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div/input")).setValue(getInputDataProperty(PHONENUMBER_WITH_INNTER_CODE));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[3]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();
    }
}
