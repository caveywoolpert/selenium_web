package lifebox.home.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import lifebox.TestCaseTemplate;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class CheckSearchFieldOpens extends TestCaseTemplate {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CheckSearchFieldOpens.class);

    @Test
    public void checkSearchField() {

        WebElement searchField = $(Selectors.byCssSelector("#home > div > div.header > div.header-search > search-field > div > drop-down > input"));

        searchField.sendKeys("asd");

        $(Selectors.byCssSelector("#home > div > div.header > div.header-search > search-field > div > drop-down > div > a")).shouldHave(Condition.text("SEE ALL")).click();

        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > search > div > div > div.header-title.ng-binding")).shouldHave(Condition.text("Search Result"));

        }
    }
