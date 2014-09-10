package arhangel.dim.reflection.di;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import arhangel.dim.reflection.Car;


public class Context {

    private static Logger log = LoggerFactory.getLogger(Context.class);

    private static final String TAG_BEAN = "bean";
    private static final String TAG_PROPERTY = "property";

    private static final String ATTR_NAME = "name";
    private static final String ATTR_VALUE = "val";
    private static final String ATTR_REF = "ref";

    private static final String ATTR_BEAN_ID = "id";
    private static final String ATTR_BEAN_CLASS = "class";


    List<Bean> beans = new ArrayList<>();
    Map<String, Object> objects = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Context context = new Context("config.xml");
        Car car = (Car) context.getBean("car");
        log.info("main:" + car.toString());
    }

    public Context(String xmlPath) throws Exception {
        Document config = readXml(xmlPath);
        Element root = config.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (TAG_BEAN.equals(n.getNodeName())) {
                parseBean(n);
            }
        }
        instantiateBeans();
    }

    public Object getBean(String beanName) {
        return objects.get(beanName);
    }

    public void instantiateBeans() throws Exception {
        log.info("beans: {}", beans);
        for (Bean bean : beans) {
            String className = bean.getClassName();
            Class clazz = Class.forName(className);
            // ищем дефолтный конструктор
            Object ob = clazz.newInstance();
            for (String name : bean.getProperties().keySet()) {
                Field field = clazz.getDeclaredField(name);
                if (field == null) {
                    throw new InvalidConfiguration("Failed to set field [" + name + "] for class " + clazz.getName());
                }
                Property prop = bean.getProperties().get(name);
                // Чтобы устанавливать приватные поля
                field.setAccessible(true);
                Type type = field.getGenericType();
                switch (prop.getType()) {
                    case VALUE:
                        field.set(ob, convert(type.getTypeName(), prop.getValue()));
                        break;
                    case REF:
                        String refName = prop.getValue();
                        if (objects.containsKey(refName)) {
                            field.set(ob, objects.get(refName));
                        } else {
                            throw new InvalidConfiguration("Failed to instantiate bean. Field " + name);
                        }
                    default:

                }
            }

            log.info("Bean instantiated: {}", bean);
            objects.put(bean.getName(), ob);

        }

    }

    @SuppressWarnings("unchecked")
    private <T> T convert(Class<T> clazz, String data) throws Exception {
        Method m = clazz.getMethod("valueOf", String.class);
        log.info("invoke: {}", m);
        T res = (T) m.invoke(clazz, data);
        return res;
    }

    private Object convert(String typeName, String data) throws Exception {
        switch (typeName) {
            case "int":
            case "Integer":
                return Integer.valueOf(data);
            case "double":
            case "Double":
                return Double.valueOf(data);
            default:
                throw new InvalidConfiguration("type name = " + typeName);
        }
    }


    void parseBean(Node bean) throws Exception {
        NamedNodeMap attr = bean.getAttributes();
        Node name = attr.getNamedItem(ATTR_BEAN_ID);
        String nameVal = name.getNodeValue();
        String classVal = attr.getNamedItem(ATTR_BEAN_CLASS).getNodeValue();
        log.info("BEAN: [name: {}, class: {}]", nameVal, classVal);

        // ищем все проперти внутри
        NodeList list = bean.getChildNodes();
        Map<String, Property> properties = new HashMap<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (TAG_PROPERTY.equals(n.getNodeName())) {
                Property property = parseProperty(n);
                log.info("\tSET {}", property);
                properties.put(property.getName(), property);
            }
        }
        //
        beans.add(new Bean(nameVal, classVal, properties));
    }

    Property parseProperty(Node node) throws Exception {
        NamedNodeMap map = node.getAttributes();
        String name = map.getNamedItem(ATTR_NAME).getNodeValue();
        Node val = map.getNamedItem(ATTR_VALUE);
        if (val != null) {
            // если значение примитивного типа
           return new Property(name, val.getNodeValue(), ValueType.VALUE);
        } else {
            // если значение ссылочного типа
            val = map.getNamedItem(ATTR_REF);
            if (val != null) {
                return new Property(name, val.getNodeValue(), ValueType.REF);
            } else {
                throw new InvalidConfiguration("Failed to parse property " + name);
            }

        }

    }

    Document readXml(String path) throws Exception {
        File file = new File(path);
        log.info("path=" + file.getAbsolutePath());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(file);
        return document;
    }

}
