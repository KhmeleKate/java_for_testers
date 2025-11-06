import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteGroupTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1295, 687));
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        driver.findElement(By.linkText("groups")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void deleteGroup() {
        try {
            driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
            driver.findElement(By.name("delete")).click();
        } catch (NoSuchElementException exception) {
        }
    }
}
