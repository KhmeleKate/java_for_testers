package manager;

import model.Contact;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManager manager;

    public ContactHelper (ApplicationManager manager) {
        this.manager = manager;
    }

    public void OpenContactPage() {
        manager.driver.findElement(By.linkText("add new")).click();
    }
    public void CreateContact(Contact contact) {
        OpenContactPage();
        manager.base().FillFieldsContact(contact);
    }
    public boolean isContactPresent() {
        OpenContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }
    public void deleteContact() {
        manager.driver.findElement(By.linkText("home")).click();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
    }
}
