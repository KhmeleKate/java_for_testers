package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DeleteGroupTest extends TestBase {

    @Test

    public void deleteGroup() {
        try {
            ApplicationManager.driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
            ApplicationManager.driver.findElement(By.name("delete")).click();
        } catch (NoSuchElementException exception) {
        }
    }
}
