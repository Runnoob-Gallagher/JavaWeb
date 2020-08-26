package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
Jsoup：jsoup是一款Java的HTML解析器。可直接解析某个URL地址、HTML文本内容、它提供了一套非常省力的API，可以通过DOM，CSS
        以及类似于JQuery的操作方法来提取出和操作数据。
Jsoup快速入门：
    步骤：
        1.导入jar包
        2.获取Document对象
        3.获取对应的标签Element对象
        4.获取数据
 */
public class Jsoup01 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
           //2.1 通过类加载器获取student.xml的路径
        String path = Jsoup01.class.getClassLoader().getResource("People.xml").getPath();
           //2.2 解析xml文档，加载文档进内存，获取dom树--->类比js中的document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
        Elements elements = document.getElementsByTag("name");
            //3.1获取第一个Element对象
        Element elements_1 = elements.get(0);
        //System.out.println(elements.size());
            //3.2获取数据
        String text = elements_1.text();
        System.out.println(text);
    }
}
