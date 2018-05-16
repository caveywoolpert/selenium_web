package lifebox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.*;
import static utils.InputPropertiesConstants.BASE_URL;
import static utils.InputPropertiesConstants.EMAIL;
import static utils.InputPropertiesConstants.PASSWORD;
import static utils.ParametersLoader.getInputDataProperty;
import static utils.ParametersLoader.getWebDriverPathProperty;
import static utils.WebDriverPathConstants.CHROME;

/**
 * Created by Dmitriy.Kruchek on 26.12.2017.
 * <p>
 * WebDrivers:
 * <p>
 * https://github.com/mozilla/geckodriver/releases
 * https://chromedriver.storage.googleapis.com/index.html
 * https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
 * https://github.com/operasoftware/operachromiumdriver/releases
 */
public class TestCaseTemplate {

    //public RemoteWebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestCaseTemplate.class);

    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", getWebDriverPathProperty(CHROME));
        //System.setProperty("webdriver.firefox.marionette", getWebDriverPathProperty(FIREFOX));
        //System.setProperty("webdriver.edge.driver", getWebDriverPathProperty(EDGE));
        //System.setProperty("webdriver.opera.driver", getWebDriverPathProperty(OPERA));
        //driver = new RemoteWebDriver(new URL(getProperty(SELENIUM_HUB_URL)), capabilities);
        WebDriverRunner.setWebDriver(new ChromeDriver());
        //WebDriverRunner.setWebDriver(new FirefoxDriver());
        //WebDriverRunner.setWebDriver(new EdgeDriver());
        //WebDriverRunner.setWebDriver(new OperaDriver());

        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        //driver.manage().window().maximize();

        //Configuration.remote = getSelenideProperty(SELENIUM_HUB_URL);
        //logger.info("Configuration.remote : " + Configuration.remote);

        Configuration.timeout = 15000;

        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/input")).setValue(getInputDataProperty(EMAIL));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();

    }

    @After
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
        //if (driver != null) {
        //    driver.quit();
        //}
    }
}
