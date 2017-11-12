package cz.jiripinkas.main;

import cz.jiripinkas.commons.PersonUtil;
import cz.jiripinkas.commons.jaxb.Person;
import cz.jiripinkas.reflection.FieldValueAccessor;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.TimeZone;

public class Main {

    private static void performIllegalReflectiveAccess() throws Exception {
        Field defaultTimeZone = TimeZone.class.getDeclaredField("defaultTimeZone");
        defaultTimeZone.setAccessible(true);
        defaultTimeZone.get(TimeZone.getDefault());
    }

    public static void main(String[] args) throws Exception {
//        performIllegalReflectiveAccess();

        {
            FieldValueAccessor accessor = new FieldValueAccessor();
            Object fieldValue = accessor.getFieldValue(new Person("Jirka Pinkas"), "name");
            System.out.println(fieldValue);
        }


        Person person = PersonUtil.readPersonFromFile(Paths.get("person.xml"));
        System.out.println(person);
    }

}
