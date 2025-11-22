package model;
import manager.ContactHelper;
import java.util.List;

public record Contact (String id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address,
                       String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage,
                       String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group) {
    public Contact () {
        this("","","","","","","","","","","","",
         "","","","","//option[. = '-']","//option[. = '-']",
                "","//option[. = '-']",
                "//option[. = '-']","", "//option[1]");
    }
    public Contact contactWithAllFields(String firstname, String middlename, String lastname, String nickname, String title, String company, String address,
                                        String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage,
                                        String bday,String bmonth,String byear,String aday,String amonth,String ayear,String new_group) {
        return new Contact(id, firstname,middlename,lastname, nickname,title,company,address,
                home, mobile, work,fax,email,email2,email3,homepage,
                bday,bmonth,byear,aday,amonth,ayear,new_group);
    }
    //Метод, который принимает список, и согласно такому списку в дальнейшем определяется, какие поля будут рандомно заполнены
    public Contact contactWithSomeFields(List<String> field_name, int str_size) {
        return new Contact(field_name.contains("id") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("firstname") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("middlename") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("lastname") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("nickname") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("title") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("company") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("address") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("home") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("mobile") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("work") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("fax") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("email") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("email2") ? ContactHelper.randomString(str_size) : "",
                field_name.contains("email3") ? ContactHelper.randomString(str_size) : "" ,
                field_name.contains("homepage") ? ContactHelper.randomString(str_size) : "",
                "//option[. = '-']",
                "//option[. = '-']",
                "",
                "//option[. = '-']",
                "//option[. = '-']",
                "",
                "//option[1]");
    }

    public Contact withIdContact(String id) {
        return new Contact(id,this.firstname, this.middlename, this.lastname,this. nickname,this.title,this.company,this.address,this.
                home,this. mobile,this. work,this.fax,this.email,this.email2,this.email3,this.homepage,this.
                bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear,this.new_group);
    }
    public Contact withFirstname(String firstname) {
        return new Contact(this.id, firstname, this.middlename, this.lastname,this. nickname,this.title,this.company,this.address,this.
                home,this. mobile,this. work,this.fax,this.email,this.email2,this.email3,this.homepage,this.
                bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear,this.new_group);
    }
    public Contact withMiddlename(String middlename) {
        return new Contact(this.id,this.firstname, middlename, this.lastname,this. nickname,this.title,this.company,this.address,this.
                home,this. mobile,this. work,this.fax,this.email,this.email2,this.email3,this.homepage,this.
                bday,this.bmonth,this.byear,this.aday,this.amonth,this.ayear,this.new_group);
    }


}
