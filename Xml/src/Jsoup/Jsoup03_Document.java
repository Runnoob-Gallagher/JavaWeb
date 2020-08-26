package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

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
public class Jsoup03_Document {
    public static void main(String[] args) throws IOException {
        String path = Jsoup03_Document.class.getClassLoader().getResource("People.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象
            //获取所有student对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);
        System.out.println("-------------");
        Element gallagher = document.getElementById("gallagher");
        String text = gallagher.text();
        System.out.println(text);
        System.out.println("-----------");
        //获取number属性名为heima_0001的元素对象
        Elements heima_0001 = document.getElementsByAttributeValue("number","heima_0001");
        System.out.println(heima_0001);
        String text1 = heima_0001.get(0).text();
    }
}
