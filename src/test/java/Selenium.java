import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Selenium {
    private static WebDriver driver;

    @BeforeTest
    public static void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @Test
    public static void searchInGoogle (String [] args){


        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("automation");
        element.submit();

        WebElement element1 = driver.findElement(By.id("resultStats"));
        String text = element1.getText();
        System.out.println(text);

        String link = driver.findElement(By.tagName("a")).getText();
        if (link == null)
            System.out.println("Element is not present");
            else
            System.out.println("Element is present");
        Assert.assertEquals(link,"https://en.wikipedia.org/wiki/Automation");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
