package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
类似CSS中操作的那样
    div{

    }
 */
public class Jsoup04_selector {
    public static void main(String[] args) throws IOException {
        String path = Jsoup04_selector.class.getClassLoader().getResource("People.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //查询name标签
        Elements elements = document.select("name");
      /*  div{

        }*/
        System.out.println(elements);
        System.out.println("----------");
        //根据id值去查询
        Elements select = document.select("#gallagher");
        System.out.println(select);
        System.out.println("**********");
        //获取student标签并且 number属性值为heima_00001的age子标签
        Elements select1 = document.select("student[number=\"heima_0001\"]");
        System.out.println(select1);
        Elements select2 = document.select("student[number=\"heima_0001\"] > age");
        System.out.println(select2);

    }
}
