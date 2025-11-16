package manager;

import model.Group;
import org.openqa.selenium.By;

import java.util.Random;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public static String randomString(int n) {
        var random = new Random();
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + random.nextInt(26));
        }
        return result;
    }

    public void OpenGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("groups")).click();
        }
    }

    public void CreateGroup(Group group) {
        OpenGroupsPage();
        manager.driver.findElement(By.name("new")).click();
        manager.base().FillFields(group);
        manager.driver.findElement(By.name("submit")).click();
        manager.base().returnToTheGroupPage(By.linkText("group page"));
    }

    public void deleteGroup() {
        OpenGroupsPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }

    public int getCount() {
        OpenGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
