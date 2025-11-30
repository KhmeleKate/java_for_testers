package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.stqa.addressbook.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ru.stqa.addressbook.manager.ContactHelper.randomFile;
import static ru.stqa.addressbook.manager.ContactHelper.randomString;

public class CreateContactTest extends TestBase {
    public static final String[] Fields = {
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
                "2020", "//option[. = '31']", "//option[. = 'January']", "2030", "//option[2]",new File("src/resources/images/avatar.png")));
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<Contact> contactProvider() throws IOException {
        var result = new ArrayList<Contact>();
        /*for (String f_name : Fields) {
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
                10));*/
    var mapper = new XmlMapper();
        var value = mapper.readValue((new File("contacts.xml")), new TypeReference<List<Contact>>() {});
        result.addAll(value);
        return result;
    }
    @Test
    void  createContact() {
        var contact = new Contact().
        withFirstname(randomString(10)).
        withlastName(randomString(10)).
        withPhoto(randomFile("src/test/resources/images/"));
        app.contacts().CreateContact(contact);
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(Contact contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().CreateContact(contact);
        var newContacts = app.contacts().getListContact();
        Comparator<Contact> comparedBy = Comparator
                .comparingInt((Contact o) -> Integer.parseInt(o.id()))
                .thenComparing(Contact::firstname)
                .thenComparing(Contact::lastname);
        newContacts.sort(comparedBy);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withFIO(newContacts.get(newContacts.size() - 1).id(),
                newContacts.get(newContacts.size() - 1).firstname(),
                newContacts.get(newContacts.size() - 1).lastname()));
        expectedList.sort(comparedBy);
        Assertions.assertEquals(newContacts, expectedList);
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
                new Contact("", "Contact firstname'", "", "", "", "", "", "", "", "", "", "",
                        "", "", "", "", "//option[1]", "//option[1]",
                        "", "//option[1]",
                        "//option[1]", "", "//option[1]",new File("src/test/resources/images/avatar.png"))));
        return result;
    }
}