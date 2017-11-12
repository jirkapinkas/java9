module cz.jiripinkas.commons {
    requires log4j.api;
    requires log4j.core;
    requires java.xml.bind;

    exports cz.jiripinkas.commons;
    exports cz.jiripinkas.commons.jaxb;

    opens cz.jiripinkas.commons.jaxb;
}