package XmlDoc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParseDemo {
    private Document document = null;
    private String xmlFilePath = System.getProperty("user.dir")+"/src/express.xml";

    public Document getDoc(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = documentBuilder.parse(xmlFilePath);
            System.out.println(document);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return document;
    }

    //解析
    public  void parse(){
        Element rootEle =  document.getDocumentElement(); //获得根标签
        System.out.println(rootEle.getTagName());
        Element ele1=  (Element) document.getElementsByTagName("resultcode").item(0);
        String resultcode =   ele1.getTextContent();

        String reason =  ((Element)  document.getElementsByTagName("reason").item(0)).getTextContent();
        String company =  ((Element)  document.getElementsByTagName("company").item(0)).getTextContent();
        String com =  ((Element)  document.getElementsByTagName("com").item(0)).getTextContent();
        String no =  ((Element)  document.getElementsByTagName("no").item(0)).getTextContent();

        System.out.println(resultcode);
        System.out.println(reason);
        System.out.println(company);
        System.out.println(com);
        System.out.println(no);

        Element listEle =  ((Element)  document.getElementsByTagName("list").item(0));
        NodeList childNodeList = listEle.getChildNodes();
        for(int i =0;i<childNodeList.getLength();i++){
            Node child =  childNodeList.item(i); //

          /*  <item>
				<datetime>2013-06-25 10:44:05</datetime>
				<remark>已收件</remark>
				<zone>台州市</zone>
			</item>

			*/
            if(child instanceof  Element){
                Element item =   (Element)child;
                Element timeELe  = (Element)  item.getFirstChild().getNextSibling();
                String datatime = timeELe.getTextContent();
                Element remarkELe  = (Element)  timeELe.getNextSibling().getNextSibling();
                Element zoneELe  = (Element)  remarkELe.getNextSibling().getNextSibling();
                System.out.print("datetime:"+timeELe.getTextContent());
                System.out.print(",remark:"+remarkELe.getTextContent());
                System.out.println(",zone:"+remarkELe.getTextContent());
            }
        }



    }

    public static void main(String[] args) {
        DomParseDemo demo = new DomParseDemo();
        Document document = demo.getDoc();
        demo.parse();


    }


}
