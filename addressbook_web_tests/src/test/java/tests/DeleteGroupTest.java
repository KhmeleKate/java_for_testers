package tests;
import model.Group;
import manager.GroupHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

public class DeleteGroupTest extends TestBase {

    @Test

    public void CanDeleteGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().CreateGroup(new Group("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.groups().getList();
        var random = new Random();
        var index = random.nextInt(oldGroups.size());
        app.groups().deleteGroup(oldGroups.get(index));
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups, expectedList);
    }
    @Test
    public void removeAllGroups() {
        app.groups().deleteAllGroups();
    }


}
