package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElement {
    WebDriver driver;
    Logger logger;

    public ActionsWithOurElement(WebDriver driver){
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    public void enterText(String xpathLocator , String text){
        try{
            driver.findElement(By.xpath(xpathLocator)).clear();
            driver.findElement(By.xpath(xpathLocator)).sendKeys(text);
            logger.info(text + " was inputed");

        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void clickOnElement(String xpathLocator) {
        try{
            driver.findElement(By.xpath(xpathLocator)).click();
            logger.info( "Element was clecked");

        }catch (Exception e){
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }
}