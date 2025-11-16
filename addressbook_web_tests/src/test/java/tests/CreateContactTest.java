package tests;

import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class CreateContactTest extends TestBase {
    private static final String[] Fields = {
            "firstname", "middlename", "lastname",
            "nickname", "title", "company", "address",
            "home", "mobile", "work", "fax", "email",
            "email2", "email3", "homepage"
    };

    @Test
    public void contact() {
        int contactCount = app.contacts().getContactCount();
        app.contacts().CreateContact(new Contact());
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @Test
    public void CreateContactWithAllFields() {
        int contactCount = app.contacts().getContactCount();
        app.contacts().CreateContact(new Contact().contactWithAllFields("Name", "Middle", "Last", "Nickname",
                "title", "company", "address", "home", "mobile", "work", "fax", "1@e1.ru",
                "2@e1.ru", "2@e1.ru", "homepage", "//option[. = '28']", "//option[. = 'December']",
                "2020", "//option[. = '31']", "//option[. = 'January']", "2030", "//option[2]"));
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<Contact> contactProvider() {
        var result = new ArrayList<Contact>();
        for (String f_name : Fields) {
            result.add(new Contact().contactWithSomeFields(List.of(f_name), 5));
        }
        for (int i = 0; i < 3; i++) {
            result.add(new Contact().contactWithSomeFields(List.of(Fields), i * 5));
        }
        result.add(new Contact());
        result.add(new Contact().contactWithSomeFields(
                List.of("firstname", "middlename", "email", "mobile"),
                5));
        result.add(new Contact().contactWithSomeFields(
                List.of("nickname", "fax", "homepage", "firstname"),
                10));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(Contact contact) {
        int contactCount = app.contacts().getContactCount();
        app.contacts().CreateContact(contact);
        int newcontactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newcontactCount);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void CannotCreateContact(Contact contact) {
        int contactCount = app.contacts().getContactCount();
        app.contacts().CreateContact(contact);
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
    public static List<Contact> negativeContactProvider() {
        var result = new ArrayList<Contact>(List.of(
                new Contact("Contact firstname'","","","","","","","","","","",
                        "","","","","//option[1]","//option[1]",
                        "","//option[1]",
                        "//option[1]","", "//option[1]")));
        return result;
    }
}
