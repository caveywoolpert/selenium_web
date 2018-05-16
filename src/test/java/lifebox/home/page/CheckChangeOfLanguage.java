package lifebox.home.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;
import lifebox.TestCaseTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.InputPropertiesConstants.BASE_URL;
import static utils.ParametersLoader.getInputDataProperty;
import static utils.ParametersLoader.getWebDriverPathProperty;
import static utils.WebDriverPathConstants.CHROME;

public class CheckChangeOfLanguage {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CheckCreateFolderFunction.class);

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", getWebDriverPathProperty(CHROME));
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 15000;
        open(getInputDataProperty(BASE_URL));
    }

    @Test
    public void checkLanguageChanging() {

        String language = Locale.getDefault().getLanguage();

        if (language == "ru") {
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Войти"));
        } else if (language == "en") {
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Login"));
        } else if (language == "uk") {
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Увійти"));
        } else if (language == "de") {
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Anmelden"));
        } else if (language == "tr") {
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Giriş"));
        }

        String dropDownLanguage = $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.disable-out-click.firstname.ng-binding")).getText();

        if (dropDownLanguage == "RU") {
            //RU
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Войти"));

        }else{
            //En
            $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.filter-btn.asc")).click();
            $(Selectors.byName("EN")).click();
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Login"));

            //Tr
            $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.filter-btn.asc")).click();
            $(Selectors.byName("TR")).click();
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Login"));

            //De
            $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.filter-btn.asc")).click();
            $(Selectors.byName("DE")).click();
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Anmelden"));

            //Ar
            $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.filter-btn.asc")).click();
            $(Selectors.byName("AR")).click();
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Login"));

            //Uk
            $(Selectors.byCssSelector("#welcome > div.container > div.login-header.flex-row.space-between > drop-down > a > span.filter-btn.asc")).click();
            $(Selectors.byName("UK")).click();
            $(Selectors.byCssSelector("#welcome > div.container > div.login-main.flex-row.space-between > div:nth-child(2) > div.login-box-title > span:nth-child(1)")).shouldHave(Condition.text("Увійти"));
        }
    }

    @After
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}