package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/*对象的使用：
    1.Jsoup：工具类，可以解析html或xml文档，返回Document
        *parse:解析html或xml文档，返回Document
            *方式一：static Document	parse​(File in, String charsetName)  Parse the contents of a file as HTML.
            *方式二：static Document	parse​(String html)	Parse HTML into a Document.
            *方式三：static Document	parse​(URL url, int timeoutMillis)	Fetch a URL, and parse it as HTML.
    2.Document：文档对象。代表内存中的dom树
        *获取Element对象
            *getElementById(String id):根据id属性值获取唯一的element对象
            *getElementsByTag(String tagName):根据标签名获取元素对象集合
            *getElementsByAttribute(string key):根据属性名称获取元素对象集合
            *getElementsByAttributeValue（String key,String value):根据对应的属性名和属性值获取元素对象集合
    3.Elements：元素Element对象的集合、可以当做ArrayList<Element>来使用
    4.Element：元素对象
    5.Node：节点对象*/
public class Jsoup02_Object {
    public static void main(String[] args) throws IOException {
        String path = Jsoup02_Object.class.getClassLoader().getResource("People.xml").getPath();
        /*方式一：Document document = Jsoup.parse(new File(path), "utf-8");*/
       /* 方式二：Document document = Jsoup.parse("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                " <students>\n" +
                " \t<student number=\"heima_0001\">\n" +
                " \t\t<name>tom</name>\n" +
                " \t\t<age>18</age>\n" +
                " \t\t<sex>male</sex>\n" +
                " \t</student>\n" +
                "\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t<name>jack</name>\n" +
                "\t<age>19</age>\n" +
                "\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "</students>");
        System.out.println(document);*/
        URL url = new URL("https://www.jd.com/?cu=true&utm_source=www.infinitynewtab.com&utm_medium=tuiguang&utm_campaign=t_45363_&utm_term=2e14f9a72a884f99a4dabcb2b4cc9139");//代表网络中的一个资源路径
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);

    }
}
