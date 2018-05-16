package lifebox.home.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import lifebox.TestCaseTemplate;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static utils.InputPropertiesConstants.BASE_URL;
import static utils.InputPropertiesConstants.EMAIL;
import static utils.InputPropertiesConstants.PASSWORD;
import static utils.ParametersLoader.getInputDataProperty;

public class CheckLeftGridPagesOpen extends TestCaseTemplate {

    @Test
    public void checkAllFilesExist(){

        //Home Page
        $$(Selectors.byCssSelector("#home > div > div.header > div.header-title.ng-binding")).shouldHave(CollectionCondition.texts("Home"));

        //All Files Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(2) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div > div > div.header-title > div")).shouldHave(Condition.text("All Files"));

        //Photos & Videos Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(3) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > photosandvideos > div > div > div.header-title.ng-binding")).shouldHave(Condition.text("Photos & Videos"));

        //Albums Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(4) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > albums > div > div.header.breadcrums-mobile > div.header-title > div")).shouldHave(Condition.text("Albums"));

        //Music Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(5) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > music > div > div > div.header-title > div")).shouldHave(Condition.text("Music"));

        //Documents Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(6) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > documents > div > div > div.header-title.ng-binding")).shouldHave(Condition.text("Documents"));

        //Favorites Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(7) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > favourites > div > div > div.header-title > div")).shouldHave(Condition.text("Favorites"));

        //Contacts Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(8) > a")).click();
        $(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > contacts > div > div.header > div.header-title.ng-binding")).shouldHave(Condition.text("Contacts"));

        //Help Page
        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(9) > a")).click();
        $(Selectors.byCssSelector("body > span > settings > div > div.account-main > div > div.account-container.mobile-settings > div > info > div > div > div > h3")).shouldHave(Condition.text("Help"));


    }

}