package model;

public record Contact (String firstname, String middlename, String lastname, String nickname, String title, String company, String address,
                       String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage,
                       String bday,String bmonth,String byear,String aday,String amonth,String ayear,String new_group) {
    public Contact () {
        this("","","","","","","","","","","",
         "","","","","//option[. = '-']","//option[. = '-']",
                "","//option[. = '-']",
                "//option[. = '-']","", "//option[1]");
    }
    public Contact contactWithAllFields(String firstname, String middlename, String lastname, String nickname, String title, String company, String address,
                                        String home, String mobile, String work, String fax, String email, String email2, String email3, String homepage,
                                        String bday,String bmonth,String byear,String aday,String amonth,String ayear,String new_group) {
        return new Contact(firstname,middlename,lastname, nickname,title,company,address,
                home, mobile, work,fax,email,email2,email3,homepage,
                bday,bmonth,byear,aday,amonth,ayear,new_group);
    }
}
