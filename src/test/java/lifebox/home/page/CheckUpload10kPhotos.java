package lifebox.home.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;
import lifebox.TestCaseTemplate;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CheckUpload10kPhotos extends TestCaseTemplate {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CheckUploadFunction.class);

    @Test
    public void checkUploads10kPhotos() {

        $(Selectors.byCssSelector("body > span > root > div > left-grid > div > ul > li:nth-child(2) > a")).shouldHave(Condition.text("All Files")).click();

        sleep(2000);

        int i = 0;
        do {
            i++;
            $(Selectors.byCssSelector("div#fileToUpload")).click();
            WebElement upload = WebDriverRunner.getWebDriver().findElement(By.cssSelector("#dropZone > div.preloader-choose-uploading > div.preloader-modal-item.name__album > label > input"));
            upload.sendKeys("C:\\Study\\FilesForAuto\\Aaaa.jpg");
            $(Selectors.byCssSelector("#dropZone > button")).click();
            $(Selectors.byCssSelector("body > span > root > div > div.sidebar-footer")).shouldHave(Condition.text("Upload completed"));
        }while (i <= 1000);

    }
}
