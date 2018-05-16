package lifebox.home.page;

import com.codeborne.selenide.*;
import lifebox.TestCaseTemplate;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class CheckUploadFunction extends TestCaseTemplate {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CheckUploadFunction.class);

    @Test
    public void checkUpload() {

        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(2) > a")).shouldHave(Condition.text("All Files")).click();

        $(Selectors.byCssSelector("div#fileToUpload")).click(); //Upload button

        sleep(2000);

        //File-input
        WebElement upload = WebDriverRunner.getWebDriver().findElement(By.cssSelector("#dropZone > div.preloader-choose-uploading > div.preloader-modal-item.name__album > label > input"));

        upload.sendKeys("C:\\Study\\FilesForAuto\\Aaaa.jpg");
        upload.sendKeys("C:\\Study\\FilesForAuto\\Бббб.mp3");
        upload.sendKeys("C:\\Study\\FilesForAuto\\Вввв.xlsx");
        upload.sendKeys("C:\\Study\\FilesForAuto\\Дддд.mp4");

        $(Selectors.byCssSelector("#dropZone > button")).click();

        //Check toast message
        $(Selectors.byCssSelector("body > span > root > div > div.sidebar-footer")).shouldHave(Condition.text("Upload completed"));

        WebDriverRunner.getWebDriver().navigate().refresh();

        $(Selectors.byCssSelector(".filter.item.item-head > .item-right > .item-date")).shouldHave(Condition.text("Date")).click();

        //Check Added file
        $$(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div")).shouldHave(CollectionCondition.texts("Aaaa"));
        $$(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div")).shouldHave(CollectionCondition.texts("Бббб"));
        $$(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div")).shouldHave(CollectionCondition.texts("Вввв"));
        $$(Selectors.byCssSelector("body > span > root > div > div.wrapper-main > files > div")).shouldHave(CollectionCondition.texts("Дддд"));

    }
}
