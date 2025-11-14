package tests;

import model.Group;
import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void CanCreateGroups() {
        app.groups().CreateGroup(new Group("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupsWithEmptyName() {
        app.groups().CreateGroup(new Group());

    }
    @Test
    public void CanCreateGroupsWithNameOnly() {
        app.groups().CreateGroup(new Group().withName("some Name"));

    }
    @Test
    public void CanCreateGroupsWithHeaderOnly() {
        app.groups().CreateGroup(new Group().withHeader("some Header"));

    }
    @Test
    public void CanCreateGroupsWithFooterOnly() {
        app.groups().CreateGroup(new Group().withFooter("some Footer"));

    }
}
