package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class DeleteContactTest extends TestBase {
    @Test
    public void CanDeleteContact() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().CreateContact(new Contact());
        }
        app.contacts().deleteContact(new Contact("","", "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "//option[. = '-']", "//option[. = '-']",
                "", "//option[. = '-']",
                "//option[. = '-']", "", "//option[1]"));

        var oldContacts = app.contacts().getListContact();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContact = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContact, expectedList);
    }
}