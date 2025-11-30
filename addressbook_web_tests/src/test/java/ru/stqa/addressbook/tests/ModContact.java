package ru.stqa.addressbook.tests;
import ru.stqa.addressbook.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ModContact extends TestBase {
    private Map<String, String> modified = new HashMap<String, String>() {{
        put("firstname", "Tom");
        put("lastname", "Bob");
        put("email", "Tom@Bob.com");
    }};
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
            var contactToModify = oldContacts.get(index);
            modified.put("id", String.valueOf(contactToModify.id()));
            var testData = new Contact().contactWithSomeNotRandomFields(modified);
            app.contacts().modifyContact(contactToModify, testData);
            var newContacts = app.contacts().getListContact();
            var expectedList = new ArrayList<>(oldContacts);
            System.out.println(expectedList);
            expectedList.set(index, testData.contactWithSomeNotRandomFields(modified));
            System.out.println(expectedList);
            System.out.println(newContacts);
            Comparator<Contact> comparedBy = Comparator.comparingInt(o -> Integer.parseInt(o.id()));
            newContacts.sort(comparedBy);
            expectedList.sort(comparedBy);
            Assertions.assertEquals(newContacts,expectedList);
        }
    }
