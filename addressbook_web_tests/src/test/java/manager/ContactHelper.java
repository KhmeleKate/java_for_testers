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
        selectContact(contact);
        manager.driver.findElement(By.name("delete")).click();
    }

    public void selectContact(Contact contact) {
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", contact.id()))).click();
    }

    private void OpenHomePage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    public List<Contact> getListContact() {
        OpenHomePage();
        var contacts = new ArrayList<Contact>();
        var rows = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var row : rows) {
            var checkbox = row.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var cells = row.findElements(By.tagName("td"));
            var lastName = cells.get(1).getText();
            var firstName = cells.get(2).getText();
            contacts.add(new Contact().withIdContact(id).withFirstname(firstName).withlastName(lastName));
        }
        return contacts;
    }

    public int getContactCount() {
        OpenHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void modifyContact(Contact contact, Contact modified) {
        OpenHomePage();
        manager.driver.findElement(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id()))).click();
    }
}
