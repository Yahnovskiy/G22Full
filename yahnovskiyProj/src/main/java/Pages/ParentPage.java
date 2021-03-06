package Pages;


import static org.hamcrest.Matchers.is;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver driver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(driver);
        PageFactory.initElements(driver, this);
/**
 * Method for open page with url
 * @param url
 */
    }
    public void open(String url) {
        try {
            driver.get(url);
            logger.info("Page was opened with" + url);
        } catch (Exception e) {
            logger.error("Can not open" + url);
            Assert.fail("Can not open" + url);


        }
    }
    public void checkTitle(String expectedTitle){
        try {
Assert.assertThat("Title not match", driver.getTitle(),
        is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can not work with page");
            Assert.fail("Can not open");


        }
    }

    public String getTitle() {

        return driver.getTitle();
    }

    public void checkTitleH1PresentOnPageWithText(String expectedText) {
    actionsWithOurElements.checkTextInElement(".//H1", expectedText);
    }
}