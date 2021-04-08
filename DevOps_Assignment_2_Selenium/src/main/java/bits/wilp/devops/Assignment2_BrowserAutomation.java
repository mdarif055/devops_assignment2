package bits.wilp.devops;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Assignment2_BrowserAutomation {

    public static WebDriver driver;


    @Before
    public void Set_Up () throws IOException {

      //  Setup driver based on browser set by user
        String browser = get_browser();
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("FireFox")){
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            driver.close();
        }

    }

    @Test
    public void Login () throws IOException {

        String url = "https://elearn.bits-pilani.ac.in/";
        driver.navigate().to(url);

    }

    @After
    public void Close () {
      driver.quit();

    }

    public static String get_browser() throws IOException {

        Properties prop = new Properties();
        FileInputStream propfilename = null;
        String propFileName = "Common.properties";
        propfilename = new FileInputStream("src/"+propFileName);
        prop.load(propfilename);
        String lob_question = prop.getProperty("browser");
        return lob_question;

    }





}
