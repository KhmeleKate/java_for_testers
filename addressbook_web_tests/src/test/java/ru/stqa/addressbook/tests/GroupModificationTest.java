package ru.stqa.addressbook.tests;

import ru.stqa.addressbook.model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTest extends TestBase {
    @Test
    void CanModifyGroup() {
        if (app.groups().getCount() == 0)
        {
            app.groups().CreateGroup(new Group("", "n", "h", "f"));
        }
        var oldGroups = app.groups().getList();
        var random = new Random();
        var index = random.nextInt(oldGroups.size());
        var testData = new Group().withName("modified");
        app.groups().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<Group> comparedBy = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
        newGroups.sort(comparedBy);
        expectedList.sort(comparedBy);
        Assertions.assertEquals(newGroups,expectedList);
    }
    }
