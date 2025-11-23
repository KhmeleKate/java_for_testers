package manager;

import model.Contact;
import model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelperBase {
    private final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    void pressLogin() {
        manager.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    void FillFields(Group group) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
    }
    void FillFieldsContact(Contact contact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager.driver.findElement(By.name("title")).click();
        manager.driver.findElement(By.name("title")).sendKeys(contact.title());
        manager.driver.findElement(By.name("company")).click();
        manager.driver.findElement(By.name("company")).sendKeys(contact.company());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager.driver.findElement(By.name("work")).click();
        manager.driver.findElement(By.name("work")).sendKeys(contact.work());
        manager.driver.findElement(By.name("fax")).click();
        manager.driver.findElement(By.name("fax")).sendKeys(contact.fax());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("email2")).click();
        manager.driver.findElement(By.name("email2")).sendKeys(contact.email2());
        manager.driver.findElement(By.name("email3")).click();
        manager.driver.findElement(By.name("email3")).sendKeys(contact.email3());
        manager.driver.findElement(By.name("homepage")).click();
        manager.driver.findElement(By.name("homepage")).sendKeys(contact.homepage());
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath(contact.bday())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(61) > option:nth-child(30)")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(contact.bmonth())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(62) > option:nth-child(13)")).click();
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys(contact.byear());
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath(contact.aday())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(66) > option:nth-child(33)")).click();
        manager.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath(contact.amonth())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(67) > option:nth-child(2)")).click();
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys(contact.ayear());
        manager.driver.findElement(By.name("new_group")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("new_group"));
            dropdown.findElement(By.xpath(contact.new_group())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(71) > option:nth-child(8)")).click();
        manager.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }
    void EditFillFieldsContact(Contact contact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        manager.driver.findElement(By.name("title")).click();
        manager.driver.findElement(By.name("title")).sendKeys(contact.title());
        manager.driver.findElement(By.name("company")).click();
        manager.driver.findElement(By.name("company")).sendKeys(contact.company());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager.driver.findElement(By.name("work")).click();
        manager.driver.findElement(By.name("work")).sendKeys(contact.work());
        manager.driver.findElement(By.name("fax")).click();
        manager.driver.findElement(By.name("fax")).sendKeys(contact.fax());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("email2")).click();
        manager.driver.findElement(By.name("email2")).sendKeys(contact.email2());
        manager.driver.findElement(By.name("email3")).click();
        manager.driver.findElement(By.name("email3")).sendKeys(contact.email3());
        manager.driver.findElement(By.name("homepage")).click();
        manager.driver.findElement(By.name("homepage")).sendKeys(contact.homepage());
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath(contact.bday())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(61) > option:nth-child(30)")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(contact.bmonth())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(62) > option:nth-child(13)")).click();
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys(contact.byear());
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath(contact.aday())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(66) > option:nth-child(33)")).click();
        manager.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath(contact.amonth())).click();
        }
        //manager.driver.findElement(By.cssSelector("select:nth-child(67) > option:nth-child(2)")).click();
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys(contact.ayear());
    }

    void returnToTheGroupPage(By group_page) {
        manager.driver.findElement(group_page).click();
    }
}
