package cz.jiripinkas.commons;

import cz.jiripinkas.commons.exception.FileException;
import cz.jiripinkas.commons.jaxb.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class PersonUtil {

    private static final Logger log = LogManager.getLogger(PersonUtil.class);

    public static Person readPersonFromFile(Path path) {
        log.debug("read person from {}", path);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(path.toFile());
        } catch (JAXBException e) {
            log.error(e);
            throw new FileException("Unmarshalling of Person from " + path + " failed !!!", e);
        }
    }

}
