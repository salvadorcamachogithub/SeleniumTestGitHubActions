package org.ot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class SeleniumAOSTest
{
    // AOS site
    private static final String ADV_WEBSITE  = "http://nimbusserver.aos.com:8000/#/";
    //private static final String ADV_WEBSITE  = "http://www.advantageonlineshopping.com";

    // AOS Credentials
    private static final String ADV_LOGIN    = "Mercury"; //"insert login name here";
    private static final String ADV_PASSWORD = "Mercury"; //"insert password here";

    // Selenium Chrome Driver declaration
    private static WebDriver chromeDriver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        // Sleep before closing the browser
        Thread.sleep(3000);
        chromeDriver.quit();
    }

    @Test
    public void purchaseTablet() throws Exception {
        // Starting URL
        chromeDriver.get(ADV_WEBSITE);

        // Using WebDriverWait to wait on elements before taking action
        WebDriverWait chromeDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        // Click on Profile icon
        // Manual XPath: //*[@id='menuUser']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menuUser']")));
        chromeDriver.findElement(By.xpath("//*[@id='menuUser']")).click();

        // Type username
        // Chrome Developer Tools XPath: /html/body/login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input
        // Manual XPath: //*[@name='username']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
        chromeDriver.findElement(By.xpath("//*[@name='username']")).sendKeys(ADV_LOGIN);

        // Type Password
        // Chrome Developer Tools XPath: /html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input
        // Manual XPath: //*[@name='password']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
        chromeDriver.findElement(By.xpath("//*[@name='password']")).sendKeys(ADV_LOGIN);
        Thread.sleep(2000);

        // Click SIGN IN
        // Chrome Developer Tools XPath: //*[@id="sign_in_btnundefined"]
        // Manual XPath: //*[text() = 'SIGN IN']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'SIGN IN']")));
        chromeDriver.findElement(By.xpath("//*[text() = 'SIGN IN']")).click();

        // Click Tablets
        // Chrome Developer Tools XPath: //*[@id='tabletsTxt']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tabletsTxt']")));
        chromeDriver.findElement(By.xpath("//*[@id='tabletsTxt']")).click();

        // Click on specific tablet
        // Chrome Developer Tools XPath: /html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[3]/p[1]/a
        // Manual XPath: //*[text() = 'HP Pro Tablet 608 G1']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'HP Pro Tablet 608 G1']")));
        chromeDriver.findElement(By.xpath("//*[text() = 'HP Pro Tablet 608 G1']")).click();
        Thread.sleep(2000);

        // Add Tablet to cart
        // Chrome Developer Tools XPath: //*[@id="productProperties"]/div[4]/button
        // Manual XPath: //*[text() = 'ADD TO CART']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'ADD TO CART']")));
        chromeDriver.findElement(By.xpath("//*[text() = 'ADD TO CART']")).click();

        // Go to Checkout
        // Chrome Developer Tools XPath: //*[@id="checkOutPopUp"]
        // Manual XPath: //*[@name='check_out_btn']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='check_out_btn']")));
        chromeDriver.findElement(By.xpath("//*[@name='check_out_btn']")).click();
        Thread.sleep(2000);

        // Checkout - NEXT
        // Chrome Developer Tools XPath: //*[@id="next_btn"]
        // Manual XPath: //*[@translate = 'NEXT' and text() = 'NEXT']
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@translate = 'NEXT' and text() = 'NEXT']")));
        chromeDriver.findElement(By.xpath("//*[@translate = 'NEXT' and text() = 'NEXT']")).click();

        // Checkout - Type SafePay username
        // Chrome Developer Tools XPath: //*[@id="paymentMethod"]/div/div[2]/sec-form/sec-view[1]/div/input
        // Manual XPath: //*[@name = 'safepay_username']
        String XPath ="//*[@name = 'safepay_username']";
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
        chromeDriver.findElement(By.xpath(XPath)).clear();
        chromeDriver.findElement(By.xpath(XPath)).sendKeys(ADV_LOGIN);

        // Checkout - Type SafePay password
        // Chrome Developer Tools XPath: //*[@id="paymentMethod"]/div/div[2]/sec-form/sec-view[2]/div/input
        // Manual XPath: //*[@name = 'safepay_password']
        XPath ="//*[@name = 'safepay_password']";
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
        chromeDriver.findElement(By.xpath(XPath)).clear();
        chromeDriver.findElement(By.xpath(XPath)).sendKeys(ADV_PASSWORD + "1");
        Thread.sleep(2000);

        // Checkout - PAY NOW
        // Chrome Developer Tools XPath: //*[@id="pay_now_btn_SAFEPAY"]
        // Manual XPath: //*[text() = 'PAY NOW']
        XPath ="//*[text() = 'PAY NOW']";
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
        chromeDriver.findElement(By.xpath(XPath)).click();
        Thread.sleep(3000);

        // Sign out - Click Profile
        // Click on Profile icon
        // XPath: //*[@id="menuUser"]
        // Change to menuUsers to make it failed
        //XPath ="//*[@id='menuUsers']";
        XPath ="//*[@id='menuUser']";
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
        chromeDriver.findElement(By.xpath(XPath)).click();

        // Sign out - Click on Sign out
        // Chrome Developer Tools XPath: //*[@id="loginMiniTitle"]/label[3]
        // Manual XPath: //*[@id='loginMiniTitle']/*[text() = 'Sign out']
        XPath ="//*[@id='loginMiniTitle']/*[text() = 'Sign out']";
        chromeDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
        chromeDriver.findElement(By.xpath(XPath)).click();
    }
}
