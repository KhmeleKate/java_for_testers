package tests;
import model.Contact;
import org.junit.jupiter.api.Test;
public class DeleteContactTest extends TestBase {
    @Test
    public void CanDeleteContact() {
        if (app.contacts().getContactCount() == 0) {
            app.contacts().CreateContact(new Contact());
        }
        app.contacts().deleteContact();
    }
}