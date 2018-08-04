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

public class RegisterTestSuite {


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
        WebElement element = webDriver.findElement(By.className("registration-link"));
        element.click();

        WebElement pageTitle = webDriver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']"));
        Assert.assertEquals(pageTitle.getText(), Constants.REGISTRATION_PAGE_TITLE);

    }
    @Test(priority = 2)
    public void fillInRegistrationForm(){
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("firstname"))));
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("lastname"))));
        WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("mobile"))));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("email_address"))));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("password"))));
        WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("password-confirmation"))));

        WebElement createAccountButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("button[title='Create an Account']"))));

        firstName.sendKeys(Constants.FIRSTNAME);
        lastName.sendKeys(Constants.LASTNAME);
        mobile.sendKeys(Constants.MOBILE);
        email.sendKeys(Constants.EMAIL);
        password.sendKeys(Constants.PASSWORD);
        confirmPassword.sendKeys(Constants.PASSWORD);

        createAccountButton.click();

    }
    @AfterTest
    public void cleanup()
    {
    }
}
