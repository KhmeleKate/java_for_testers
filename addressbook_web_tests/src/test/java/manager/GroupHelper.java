package manager;

import model.Group;
import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper (ApplicationManager manager) {
        this.manager = manager;
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
        manager.base.returnToTheGroupPage(By.linkText("group page"));
    }

    public boolean isGroupPresent() {
        OpenGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    public void deleteGroup() {
        OpenGroupsPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }
}
