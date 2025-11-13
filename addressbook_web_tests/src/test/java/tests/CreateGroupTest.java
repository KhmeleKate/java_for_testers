package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void CanCreateGroups() {
        TestBase.app.OpenGroupsPage();
        TestBase.app.CreateGroup(new Group("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupsWithEmptyName() {
        TestBase.app.OpenGroupsPage();
        TestBase.app.CreateGroup(new Group());

    }
    @Test
    public void CanCreateGroupsWithNameOnly() {
        TestBase.app.OpenGroupsPage();
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("some Name");
        TestBase.app.CreateGroup(groupWithName);

    }
}
