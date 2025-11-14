package tests;
import model.Group;
import org.junit.jupiter.api.Test;
public class DeleteGroupTest extends TestBase {

    @Test

    public void CanDeleteGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().CreateGroup(new Group("group name", "group header", "group footer"));
        }
        app.groups().deleteGroup();
    }


}
