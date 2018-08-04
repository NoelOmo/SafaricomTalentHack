package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.Constants;
import testsuite.utils.WebDriverUtils;

public class ProductSearchTestSuite {

    private static WebDriver webDriver;
    WebDriverWait wait;
    @BeforeTest
    public void initWebDriver()
    {
        webDriver = WebDriverUtils.getInstance();
        webDriver.get("http://masoko.com");
        wait = new WebDriverWait(webDriver, 4000);
    }


    @Test(priority = 1)
    public void searchForAProduct(){
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("search"))));

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button[title='Search']"))));

        search.sendKeys(Constants.SEARCH_TERM);

        searchButton.click();

    }

    @Test(priority = 2)
    public void verifyThatUserCanSeeSearchResults(){
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("span[data-ui-id='page-title-wrapper']")))) ;
        Assert.assertEquals(pageTitle.getText(), Constants.SEARCH_RESULTS_TITLE);

    }
    @AfterTest
    public void cleanup()
    {
    }
}
