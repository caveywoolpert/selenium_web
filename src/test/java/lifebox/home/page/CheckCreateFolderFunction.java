package lifebox.home.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import lifebox.TestCaseTemplate;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckCreateFolderFunction extends TestCaseTemplate {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CheckCreateFolderFunction.class);

    @Test
    public void checkCreateFolderFunction() {

        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(2) > a")).shouldHave(Condition.text("All Files")).click();

        $(Selectors.byCssSelector("#createAFolder")).shouldHave(Condition.text("Create a folder")).click();

        WebElement nameOfFolder = $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div > entity-table > div.item-container-wrapper.ng-scope > div > div:nth-child(1) > label > input"));

        nameOfFolder.sendKeys("Roman's folder");

        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div > entity-table > div.item-container-wrapper.ng-scope > div > div:nth-child(1) > label > div > span.input-name-submit")).click();

        $(Selectors.byCssSelector("body > span > root > div > div.sidebar-footer")).shouldHave(Condition.text("Folder created"));

        $$(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div")).shouldHave(CollectionCondition.texts("Roman's folder"));
    }
}