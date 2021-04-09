package bits.wilp.devops;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Assignment2_BrowserAutomation {

    public static WebDriver driver;


    @Before
    public void Set_Up () throws IOException {

      //  Task 9 - Setup driver based on browser set by user
        Properties prop = new Properties();
        FileInputStream propfilename = null;
        String propFileName = "Common.properties";
        propfilename = new FileInputStream("src/"+propFileName);
        prop.load(propfilename);
        String browser = prop.getProperty("browser");
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

    @Test @Ignore
    public void Login_eLearning () throws IOException {

        // Task1
        String url = "https://elearn.bits-pilani.ac.in/";
        driver.navigate().to(url);

        // Task 2 - login form a different window
        WebElement launchlogin = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        launchlogin.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("2020mt93542@wilp.bits-pilani.ac.in");
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("02011985");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        loginbutton.click();







    }


    @Test @Ignore
    public void test_dynamic_static_elements () throws InterruptedException {

        // Task3 -Dynamic  Elements
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "https://register.rediff.com/register/register.php?FormName=user_details";
        driver.navigate().to(url);
        WebElement FullName = driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input"));
        FullName.sendKeys("BITS Pilani");
        WebElement password = driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[1]"));
        password.sendKeys("sufiyanansariawstest");
        WebElement Check_availabilty = driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[7]/td[3]/input[2]"));
        Check_availabilty.click();
        Thread.sleep(5000);
        WebElement message = driver.findElement(By.xpath("/html/body/center/form/div/table[2]/tbody/tr[5]/td[3]/div/font/b"));
        String response = message.getText();
        Assert.assertEquals(response,"Yippie! The ID you've chosen is available.");


        // Task 3 - Static Elements

        String url_st = "https://elearn.bits-pilani.ac.in/";
        driver.navigate().to(url_st);
        WebElement launchlogin_st = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        launchlogin_st.click();
        WebElement username_st = driver.findElement(By.xpath("//input[@id='username']"));
        username_st.sendKeys("2020mt93542@wilp.bits-pilani.ac.in");
        WebElement password_st = driver.findElement(By.xpath("//input[@id='pass']"));
        password_st.sendKeys("02011985");
        WebElement loginbutton_st = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        loginbutton_st.click();
        WebElement menu_1 = driver.findElement(By.xpath("//a[@href='/user/courses/']"));
        menu_1.click();
        WebElement page_text_st = driver.findElement(By.xpath(" /html/body/div[1]/div[4]/h3"));
        Thread.sleep(5000);
        String displayed_text = page_text_st.getText();
        Assert.assertEquals(displayed_text,"Taxila Courses");


    }

    @Test @Ignore
    public void test_list () throws InterruptedException {

        // Task4 - Extract web elements such as table or list
        String url = "https://elearn.bits-pilani.ac.in/";
        driver.navigate().to(url);
        WebElement launchlogin = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
        launchlogin.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("2020mt93542@wilp.bits-pilani.ac.in");
        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.sendKeys("02011985");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        loginbutton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dropdown= driver.findElement(By.xpath("//button[@id='nav_drpdwn']"));
        dropdown.click();
        List<WebElement> options = dropdown.findElements(By.xpath("//li[@role='presentation']"));
        for (WebElement option : options) {
            if (option.getText().equals("Edit Profile")) {
                option.click(); // click the desired option
                break;

                }
         }

    }

    @Test
    public void CSS_Xpath () throws IOException {


       // Read the Locator Selection from Properties file
        String locator = read_property("element_locator");

      //  Task 5 : Usage of locator types, whether to use CSS selector or Xpath
        if(locator.equalsIgnoreCase("cssSelector")) {
            System.out.println("Using cssSelector");
            String url = "https://elearn.bits-pilani.ac.in/";
            driver.navigate().to(url);
            WebElement launchlogin = driver.findElement(By.cssSelector("a[class='btn btn-lg btn-primary']"));
            launchlogin.click();
            WebElement username = driver.findElement(By.cssSelector("input[id='username']"));
            username.sendKeys("2020mt93542@wilp.bits-pilani.ac.in");
            WebElement password = driver.findElement(By.cssSelector("input[id='pass']"));
            password.sendKeys("02011985");
            WebElement loginbutton = driver.findElement(By.cssSelector("button[id='submitbtn']"));
            loginbutton.click();
        }else if(locator.equalsIgnoreCase("xpath")){
            System.out.println("Using XPath");
            String url = "https://elearn.bits-pilani.ac.in/";
            driver.navigate().to(url);
            WebElement launchlogin = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
            launchlogin.click();
            WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
            username.sendKeys("2020mt93542@wilp.bits-pilani.ac.in");
            WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
            password.sendKeys("02011985");
            WebElement loginbutton = driver.findElement(By.xpath("//button[@id='submitbtn']"));
            loginbutton.click();
        }else{
            driver.close();
        }

    }

    @After
    public void Close () {
     driver.quit();

    }

    public static String read_property(String lookup_str) throws IOException {

        Properties prop = new Properties();
        FileInputStream propfilename = null;
        String propFileName = "Common.properties";
        propfilename = new FileInputStream("src/"+propFileName);
        prop.load(propfilename);
        String browser_test = prop.getProperty(lookup_str);
        return browser_test;

    }





}
