package XmlDoc;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestDome {
    public static void main(String[] args) {
        File file = new File("demo.xml");
        List<Map<String, String>> list = ExpressSaxParse.readXML(file, "XmlDoc/express.xml");
        for (Map<String, String> map : list) {
            System.out.println(map);
        }
    }

}


