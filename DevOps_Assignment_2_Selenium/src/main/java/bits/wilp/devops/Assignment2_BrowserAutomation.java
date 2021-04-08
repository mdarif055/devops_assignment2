package bits.wilp.devops;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_BrowserAutomation {

    public static WebDriver driver;


    @Before
    public void Set_Up () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\QE636BX\\Sufiyan\\AppliTools\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void Login () {
        String url = "https://elearn.bits-pilani.ac.in/";
        driver.navigate().to(url);

    }

    @After
    public void Close () {
       driver.quit();

    }





}
