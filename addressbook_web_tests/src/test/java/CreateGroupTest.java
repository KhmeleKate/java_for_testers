import model.Group;
import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void CanCreateGroups() {
        OpenGroupsPage();
        CreateGroup(new Group("name", "header", "footer"));
    }

    @Test
    public void CanCreateGroupsWithEmptyName() {
        OpenGroupsPage();
        CreateGroup(new Group());

    }
    @Test
    public void CanCreateGroupsWithNameOnly() {
        OpenGroupsPage();
        var emptyGroup = new Group();
        var groupWithName = emptyGroup.withName("some Name");
        CreateGroup(groupWithName);

    }
}
