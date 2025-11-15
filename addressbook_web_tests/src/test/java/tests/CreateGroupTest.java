package tests;

import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

public class CreateGroupTest extends TestBase {

    @ParameterizedTest
    @ValueSource(strings = {"groupName","group name'"})
    public void CanCreateGroups(String name) {
       int groupCount = app.groups().getCount();
       app.groups().CreateGroup(new Group(name, "header", "footer"));
       int newGroupCount = app.groups().getCount();
       Assertions.assertEquals(groupCount + 1, newGroupCount);
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
