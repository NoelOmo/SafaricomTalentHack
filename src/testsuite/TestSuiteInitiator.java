package testsuite;

import org.openqa.selenium.WebDriver;
import testsuite.utils.WebDriverUtils;

public class TestSuiteInitiator {

    private static WebDriver webDriver;


    public static void main(String[] args){
        webDriver = WebDriverUtils.getInstance();
        webDriver.get("http://masoko.com");


    }



}
