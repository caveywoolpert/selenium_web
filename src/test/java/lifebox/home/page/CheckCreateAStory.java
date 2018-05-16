package lifebox.home.page;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.WebElementsCollection;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;
import static utils.InputPropertiesConstants.BASE_URL;
import static utils.InputPropertiesConstants.EMAIL;
import static utils.InputPropertiesConstants.PASSWORD;
import static utils.ParametersLoader.getInputDataProperty;
import static utils.ParametersLoader.getWebDriverPathProperty;
import static utils.WebDriverPathConstants.CHROME;

public class CheckCreateAStory {
    Logger logger = LoggerFactory.getLogger(CheckCreateAStory.class);
    @Before
    public void setsUp(){
        System.setProperty("webdriver.chrome.driver", getWebDriverPathProperty(CHROME));
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        Configuration.timeout = 15000;
        open(getInputDataProperty(BASE_URL));

        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]")).click();
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/input")).setValue(getInputDataProperty(EMAIL));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/input")).setValue(getInputDataProperty(PASSWORD));
        $(Selectors.byXpath("//*[@id=\"welcome\"]/div[2]/div[2]/div[2]/div[3]/div[2]/div[4]/button")).click();
        $$(".header-title").find(Condition.attribute("translate", "WEB_WELCOME")).isDisplayed();
    }

    @Test
    public void checkCreateAStoryFunction() {

        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(4) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > albums > div > div.header.breadcrums-mobile > div.header-title > div")).shouldHave(Condition.text("Albums"));

        $(Selectors.byCssSelector("body > span > root > div > right-grid > div > div > div.sidebar-list > ul > li:nth-child(1) > a")).click();

        $(Selectors.byCssSelector("#story_name")).sendKeys("Hello");

        $(Selectors.byCssSelector("#modal > div.feedback-modal-line.feedback-butons > div > button.primary-action.ng-scope")).click();

        sleep(3000);

        logger.info($(Selectors.byAttribute("ng-click", "methods.goToFolder(file)")).toString());
        $(Selectors.byAttribute("ng-click", "methods.goToFolder(file)")).click();

        $(Selectors.byCssSelector("#data > p:nth-child(1) > button")).click();
        $(Selectors.byCssSelector("#data > p:nth-child(1) > button")).click();
        $(Selectors.byCssSelector("#modal > choose-music > div.item-wrapper.choose-music > div:nth-child(1)")).click();


        $(Selectors.byCssSelector("#modal > choose-music > div.item-wrapper.choose-music > div:nth-child(1) > div.item-left > div.custom-first > label")).click();

        $(Selectors.byCssSelector("#modal > choose-music > div.feedback-modal-line.choose-music-btns > div > button.primary-action.ng-binding.ng-scope")).click();
        sleep(7000);
        $(Selectors.byCssSelector("#modal > preview-story > div.feedback-modal-line.preview-story-buttons.wrap > div > button.primary-action.ng-binding")).click();

        $(Selectors.byCssSelector("#modal > div.feedback-modal-line.final-step-but > div > button")).click();

        
    }
    }

