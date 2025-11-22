package manager;
import model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupHelper {
    private ApplicationManager manager;

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

    public void deleteGroup(Group group) {
        OpenGroupsPage();
        selectGroup(group);
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }

    private void selectGroup(Group group) {
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", group.id()))).click();
    }

    public int getCount() {
        OpenGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<Group> getList() {
        OpenGroupsPage();
        var groups = new ArrayList<Group>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        for (var span: spans) {
            var name = span.getText();
            System.out.println(name);
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            System.out.println(id);
            groups.add(new Group().withId(id).withName(name));
        }
        return groups;
    }

    public void modifyGroup(Group group, Group modified) {
        OpenGroupsPage();
        selectGroup(group);
        initGroupModif(By.name("edit"));
        manager.base().FillFields(modified);
        manager.driver.findElement(By.name("update")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }

    private void initGroupModif(By edit) {
        manager.driver.findElement(edit).click();
    }
    public void deleteAllGroups (){
        OpenGroupsPage();
        List<WebElement> allCheckboxes = manager.driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : allCheckboxes) {
            checkbox.click();
        }
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("group page")).click();

    }
}
