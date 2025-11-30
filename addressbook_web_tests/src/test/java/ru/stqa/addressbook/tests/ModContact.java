package ru.stqa.addressbook.tests;
import ru.stqa.addressbook.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class ModContact extends TestBase {
    @Test
    void CanModifyContact() {
        int contactCount = app.contacts().getContactCount();
        if (contactCount == 0)
        {
            app.contacts().CreateContact(new Contact());
        }
        var oldContacts = app.contacts().getListContact();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        var contactToModify = oldContacts.get(index);
        var testData = new Contact().withFirstname("MODIFIED");
        app.contacts().modifyContact(contactToModify, testData);
        var newContacts = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withIdContact(contactToModify.id()).withlastName(contactToModify.lastname()));
        Comparator<Contact> comparedBy = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
        newContacts.sort(comparedBy);
        expectedList.sort(comparedBy);
        Assertions.assertEquals(newContacts,expectedList);
        }
    }
