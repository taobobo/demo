package XmlDoc;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ExpressSaxParse {
    public static List<Map<String,String>> readXML(InputStream in, String nodeName){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler(nodeName);
            try {
                parser.parse(in,handler);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            in.close;
            return handler.getList();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Map<String,String>> readXML(File file,String nodeName){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler(nodeName);
            try {
                parser.parse(file,handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  handler.getList();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
