package sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LogSaxHandler extends DefaultHandler {

    static final Logger logger = LogManager.getLogger(LogSaxHandler.class.getName());
    private static final String CLASSNAME = "class";

    private boolean inElement = false;

    public void startDocument() throws SAXException {
        logger.info("Start document.");
    }

    public void endDocument() throws SAXException {
        logger.info("End document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        logger.info("Start element: {}", qName);
        if (!qName.equals(CLASSNAME)) {
            inElement = true;
        } else {
            logger.info("Class name: {}", attributes.getValue(0));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        inElement = false;
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (inElement) {
            System.out.println("Process : " + new String(ch, start, length));
        }
    }

    public Object getObject() {
        return null;
    }
}
