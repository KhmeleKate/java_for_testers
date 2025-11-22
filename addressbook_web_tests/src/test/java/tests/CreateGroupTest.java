package tests;

import manager.GroupHelper;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
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
        var oldGroups = app.groups().getList();
        app.groups().CreateGroup(group);
        var newGroups = app.groups().getList();
        Comparator<Group> comparedBy = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
        newGroups.sort(comparedBy);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));
        expectedList.sort(comparedBy);
        Assertions.assertEquals(newGroups,expectedList);
        }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void CannotCreateGroups(Group group) {

        var oldGroups = app.groups().getList();
        app.groups().CreateGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
    public static List<Group> negativeGroupProvider() {
        var result = new ArrayList<Group>(List.of(
                new Group("", "group name'", "", "")));
        return result;
    }
}
