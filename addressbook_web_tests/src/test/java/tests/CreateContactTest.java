package tests;
import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateContactTest extends TestBase {

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
                "title", "company","address","home","mobile","work","fax","1@e1.ru",
                "2@e1.ru","2@e1.ru","homepage","//option[. = '28']","//option[. = 'December']",
                "2020", "//option[. = '31']","//option[. = 'January']","2030","//option[2]"));
        int newContactCount = app.contacts().getContactCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }

}

