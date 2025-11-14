package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
       // manager.driver.findElement(By.cssSelector("select:nth-child(71) > option:nth-child(8)")).click();
        //manager.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        //manager.driver.findElement(By.linkText("home page")).click();
        manager.base().FillFieldsContact(contact);
    }
}
