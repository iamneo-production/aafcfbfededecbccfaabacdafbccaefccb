package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class AppTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Navigate to Flipkart
        driver.get("http://www.flipkart.com");

        // Enter Email/Phone and Password
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("your_email_or_phone");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("your_password");

        // Click Login button
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        
       

        // Verify if the user is logged in
        boolean isLoggedIn = driver.findElements(By.xpath("//div[contains(text(),'My Account')]")).size() > 0;
        if (isLoggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
