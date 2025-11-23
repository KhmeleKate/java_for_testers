package tests;

import model.Contact;
import model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ModContact extends TestBase{
    @Test
    void CanModifyGroup() {
        int contactCount = app.contacts().getContactCount();
        if (contactCount == 0)
        {
            app.contacts().CreateContact(new Contact());
        }
        var oldContacts = app.contacts().getListContact();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        var testData = new Contact().withFirstname("Dimka");
        app.contacts().modifyContact(oldContacts.get(index), testData);

        /*var oldContacts = app.contacts().getListContact();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        var testData = new Contact().withFirstname("Dimka");
        app.contacts().modifyGroup(oldContacts.get(index), testData);
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<Group> comparedBy = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
        newGroups.sort(comparedBy);
        expectedList.sort(comparedBy);
        Assertions.assertEquals(newGroups,expectedList);*/
    }
}
