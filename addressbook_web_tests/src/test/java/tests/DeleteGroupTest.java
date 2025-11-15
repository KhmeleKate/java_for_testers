package tests;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DeleteGroupTest extends TestBase {

    @Test

    public void CanDeleteGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().CreateGroup(new Group("group name", "group header", "group footer"));
        }
        int groupCount = app.groups().getCount();
        app.groups().deleteGroup();
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount);
        System.out.println(newGroupCount);
    }


}
