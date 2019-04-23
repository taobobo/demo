package XmlDoc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHandler extends DefaultHandler {
    private Map<String,String> map;
    private List<Map<String,String>> list;
    private String currentTag;
    private String currentValue;
    private String nodeName;

    public MyHandler(String nodeName){
        super();
        this.nodeName= nodeName;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    /**
     * 当读取到xml文档准备开始解析的时候，这时会触发这个方法的执行
     */
    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<Map<String, String>>();
    }

    /**
     * 当遇到元素开始的时候，调用这个方法
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals(nodeName)) { // 是当前需要解析的节点，则创建Map对象
            map = new HashMap<String, String>();
        }
        if (attributes != null && map != null) { // map对象存在，且节点有属性，则映射属性名与属性值
            for (int i = 0; i < attributes.getLength(); i++) {
                map.put(attributes.getQName(i), attributes.getValue(i));
            }
        }
        currentTag = qName; // 当前解析的节点名称
    }

    /**
     * 这个方法是用来处理xml文本节点所读取到的内容
     */
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (currentTag != null && map != null) { // 有解析到节点，且map不为空
            currentValue = new String(ch, start, length); // 转换文本节点值
            if (currentValue != null && !"".equals(currentValue.trim())
                    && !"\n".equals(currentValue.trim())) { // 文本节点值不为空，则映射节点名称与节点文本值
                map.put(currentTag, currentValue);
            }
        }

        currentTag = null;
        currentValue = null;
    }

    /**
     * 遇到结束标记的时候会调用这个方法
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals(nodeName)) { // 需要解析的节点解析完毕，则将已解析得到的单个完整对象添加到list中保存
            list.add(map);
            map = null; // map置空
        }
    }
}


