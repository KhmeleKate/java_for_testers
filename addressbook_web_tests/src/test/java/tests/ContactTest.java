package tests;
import model.Contact;
import org.junit.jupiter.api.Test;

public class ContactTest extends TestBase {

    @Test
    public void contact() {
        app.contacts().CreateContact(new Contact());

    }

    @Test
    public void CreateContactWithAllFields() {
        app.groups().isGroupPresent();
        app.contacts().CreateContact(new Contact().contactWithAllFields("Name", "Middle", "Last", "Nickname",
                "title", "company","address","home","mobile","work","fax","1@e1.ru",
                "2@e1.ru","2@e1.ru","homepage","//option[. = '28']","//option[. = 'December']",
                "2020", "//option[. = '31']","//option[. = 'January']","2030","//option[. = 'name']"));

    }

}

