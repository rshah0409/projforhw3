package autopractice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//Open url : http://automationpractice.com/index.php
//Click on Sign In
//Enter correct Email in Email field
//Enter wrong Password in Password field
//Click on Sign In button.
//Expected Result:
//Error Message “There is 1 error”

public class HomeWork_3 {
    WebDriver driver;
    @Before

    public void setUp(){

        String url = "http://automationpractice.com/index.php";
        //selenium .jar file            //driver file path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //webdriver declaration
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //method to open browser
        driver.get(url);

    }
    @Test
    public void clickSignInField(){
       driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xyz@987.com");
       driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("unicornsky");
       driver.findElement(By.id("SubmitLogin")).click();
       String expectedErrorMessage = "There is 1 error";
        WebElement errorMessageIs = driver.findElement(By.xpath("//p[text()='There is 1 error']"));

        String actualErrorMessage = errorMessageIs.getText();
        Assert.assertEquals( "Error Message is Wrong",expectedErrorMessage,actualErrorMessage );

    }
    @After
    public  void tearDown(){

        driver.quit();
    }

}
