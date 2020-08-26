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
        *获取子元素对象
            *getElementById(String id):根据id属性值获取唯一的element对象
            *getElementsByTag(String tagName):根据标签名获取元素对象集合
            *getElementsByAttribute(string key):根据属性名称获取元素对象集合
            *getElementsByAttributeValue（String key,String value):根据对应的属性名和属性值获取元素对象集合
        *获取属性值
            *String attr(String key):根据属性名称获取属性值
        *获取文本内容
            *String text():获取文本内容,获取子标签的纯文本内容
            *String html():获取标签体的所有内容（包括子标签的标签和文本）
    5.Node：节点对象*/
public class Jsoup04_Element {
    public static void main(String[] args) throws IOException {
        String path = Jsoup04_Element.class.getClassLoader().getResource("People.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //通过document对象获取name标签，获取所有的name标签，可以获取到两个
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());
        System.out.println("------");
        //通过element对象获取子标签对象
        Element ele_student = document.getElementsByTag("student").get(0);
        Elements ele_name = ele_student.getElementsByTag("name");
        System.out.println(ele_name.size());
        System.out.println("********");
        //获取student对象的属性名
        String number = ele_student.attr("number");
        System.out.println(number);
        /* *获取文本内容
                *String text():获取文本内容,获取子标签的纯文本内容
                *String html():获取标签体的所有内容（包括子标签的标签和文本）*/
        System.out.println("------------");
        String text = ele_student.text();
        System.out.println(text);
        System.out.println("~~~~~~~~~~");
        String html = ele_student.html();
        System.out.println(html);
    }
}
