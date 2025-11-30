package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreateGroupTest extends TestBase {

    public static List<Group> groupProvider() throws IOException {
        var result = new ArrayList<Group>();
       /* for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new Group().withName(name).withHeader(header).withFooter(footer));
                }
            }

        var json = ""; //если файл большой, можно читать данные построчно (второй способ)
        try (var reader = new FileReader("groups.json");
        var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while (line != null) {
                json = json + line;
                line = breader.readLine();
            }
        }*/

        var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<Group>>() {});
        result.addAll(value);
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
        Assertions.assertEquals(newGroups, expectedList);
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
        var result = new ArrayList<Group>(List.of(new Group("", "group name'", "", "")));
        return result;
    }

}
