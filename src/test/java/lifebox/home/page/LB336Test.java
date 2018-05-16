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
 * Test Case LB-336: Home page - Profile drop-down menu
 * <p>
 */
public class LB336Test extends TestCaseTemplate {
    Logger logger = LoggerFactory.getLogger(LB336Test.class);

    @Test
    public void testLoginWithGsmNumber() {
        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/input")).setValue(getInputDataProperty(EMAIL));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();

        $(Selectors.byXpath("/html/body/span/root/div/right-grid/div/div[1]/div[1]/drop-down")).click();

        SelenideElement userDropDownList = $(".user-dropdown-list");

        userDropDownList.$(Selectors.byAttribute("translate", "HOME")).isDisplayed();
        userDropDownList.$(Selectors.byAttribute("translate", "WEB_PROFILE")).isDisplayed();
        userDropDownList.$(Selectors.byAttribute("translate", "SETTINGSS")).isDisplayed();
        userDropDownList.$(Selectors.byAttribute("ng-click", "logout()")).isDisplayed();

        SelenideElement sidebarTop = $(".sidebar-top");

        sidebarTop.$(Selectors.byAttribute("translate", "WEB_PROFILE")).click();
        $(".tab-view-content").$(Selectors.byAttribute("translate", "WEB_CONTACT_INFORMATION")).isDisplayed();

        $(Selectors.byXpath("/html/body/span/settings/div/div[1]/div/div/div[1]/div/div/div/div/drop-down/div[1]")).click();

        sidebarTop.$(Selectors.byAttribute("translate", "SETTINGS")).click();
        $(".nav-package-percent").isDisplayed();

        $(Selectors.byXpath("/html/body/span/settings/div/div[1]/div/div/div[1]/div/div/div/div/drop-down/div[1]")).click();
        sidebarTop.$(Selectors.byAttribute("translate", "HOME")).click();
        $(".header-title").$(Selectors.byAttribute("translate", "WEB_WELCOME")).isDisplayed();

        $(Selectors.byXpath("/html/body/span/root/div/right-grid/div/div[1]/div[1]/drop-down")).click();
        sidebarTop.$(Selectors.byAttribute("ng-click", "logout()")).click();

        $(Selectors.byId("welcome")).isDisplayed();
    }
}
