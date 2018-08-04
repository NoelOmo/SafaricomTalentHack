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

public class LoginTestSuite {

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
    public void verifyThatUserCanOpenRegistrationPage(){
        WebElement element = webDriver.findElement(By.className("authorization-link__content"));
        element.click();

        WebElement pageTitle = webDriver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']"));
        Assert.assertEquals(pageTitle.getText(), Constants.LOGIN_PAGE_TITLE);

    }
    @Test(priority = 2)
    public void fillInLoginForm(){
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("email"))));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("pass"))));

        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button[title='Sign In']"))));

        email.sendKeys(Constants.EMAIL);
        password.sendKeys(Constants.PASSWORD);

        loginButton.click();

    }
    @AfterTest
    public void cleanup()
    {
    }
}
