package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.stqa.addressbook.common.Common;
import ru.stqa.addressbook.model.Contact;
import ru.stqa.addressbook.model.Group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.stqa.addressbook.tests.CreateContactTest.Fields;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException{
        var generator = new Generator();
        JCommander.newBuilder().addObject(generator).build().parse(args);
        //generator.run();
        generator.runContact();
    }

    private void run() throws IOException{
        var data = generate();
        save(data);
    }
    private void runContact() throws IOException{
        var data = generate();
        saveContact(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<Group>();
        for (int i = 0; i < count; i++) {
            result.add(new Group()
                           .withName(Common.randomString(i * 10))
                           .withHeader(Common.randomString(i * 10))
                           .withFooter(Common.randomString(i * 10)));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var write = new FileWriter(output)){ // используем try, чтобы автоматически вызвать метод close
                write.write(json);
            }
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }

    }
    private Object generateContacts() {
        var result = new ArrayList<Contact>();
        for (String f_name : Fields) {
            result.add(new Contact().contactWithSomeFields(List.of(f_name), 5));
        }
        for (int i = 0; i < 3; i++) {
            result.add(new Contact().contactWithSomeFields(List.of(Fields), i * 5));
        }
        result.add(new Contact());
        result.add(new Contact().contactWithSomeFields(
            List.of("firstname", "middlename", "email", "mobile"),
            5));
        result.add(new Contact().contactWithSomeFields(
            List.of("nickname", "fax", "homepage", "firstname"),
            10));
        return result;
    }

    private void saveContact(Object data) throws IOException {
        if ("xml".equals(format))  {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output),data);
        }
        else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }

    }

}
