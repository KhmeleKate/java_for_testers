package manager;

import model.Contact;
import model.Group;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactHelper {
    private final ApplicationManager manager;

    public ContactHelper (ApplicationManager manager) {
        this.manager = manager;
    }

    public static String randomString(int n) {
        var random = new Random();
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char) ('a' + random.nextInt(26));
        }
        return result;
    }

    public void OpenContactPage() {
        manager.driver.findElement(By.linkText("add new")).click();
    }
    public void CreateContact(Contact contact) {
        OpenContactPage();
        manager.base().FillFieldsContact(contact);
    }
    public void deleteContact(Contact contact) {
        OpenHomePage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
    }

    private void OpenHomePage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

     public List<Contact> getListContact() {
        OpenHomePage();
        var contacts = new ArrayList<Contact>();
        var spans = manager.driver.findElements(By.cssSelector("span.contact"));
        for (var span: spans) {
            var firstname = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new Contact().withIdContact(id).withFirstname(firstname));
        }
        return contacts;
    }


    public int getContactCount() {
        OpenHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
