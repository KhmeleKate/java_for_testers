package tests;

import manager.GroupHelper;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class CreateGroupTest extends TestBase {
    public static List<Group> groupProvider() {
        var result = new ArrayList<Group>();
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new Group().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new Group()
                    .withName(GroupHelper.randomString(i * 10))
                    .withHeader(GroupHelper.randomString(i * 10))
                    .withFooter(GroupHelper.randomString(i * 10)));
        }
        return result;
    }
    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CanCreateMultipleGroups(Group group) {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
        }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CannotCreateGroups(Group group) {
        int groupCount = app.groups().getCount();
        app.groups().CreateGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
    public static List<Group> negativeGroupProvider() {
        var result = new ArrayList<Group>(List.of(
                new Group("", "group name'", "", "")));
        return result;
    }
}
