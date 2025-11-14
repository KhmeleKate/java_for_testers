package manager;

import model.Group;
import org.openqa.selenium.By;

public class HelperBase {
    private final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    void pressLogin() {
        manager.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    void FillFields(Group group) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
    }

    void returnToTheGroupPage(By group_page) {
        manager.driver.findElement(group_page).click();
    }
}
