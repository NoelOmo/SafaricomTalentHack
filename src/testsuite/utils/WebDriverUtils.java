package testsuite.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class WebDriverUtils {

    private static WebDriver webDriver;

    private static String exePath = "C:\\Users\\HP\\IdeaProjects\\Dependencies\\driver\\chromedriver.exe";

    private WebDriverUtils() {
    }

    public static WebDriver getInstance(){
        System.setProperty("webdriver.chrome.driver", exePath);
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim= new Dimension((int)screenSize.getWidth(),(int)screenSize.getHeight());

        if (webDriver == null){
            webDriver = new ChromeDriver();
        }

        webDriver.manage().window().setSize(dim);
        return webDriver;
    }

}
