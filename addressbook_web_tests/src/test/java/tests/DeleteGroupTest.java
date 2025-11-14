package tests;

import manager.ApplicationManager;
import model.Group;
import org.junit.jupiter.api.Test;

//import static manager.ApplicationManager.DeleteIfExists;

public class DeleteGroupTest extends TestBase {

    @Test

    public void CanDeleteGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().CreateGroup(new Group("group name", "group header", "group footer"));
        }
        app.groups().deleteGroup();
    }


}
