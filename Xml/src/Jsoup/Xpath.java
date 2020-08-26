package Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

//先获取document对象，根据document对象获取Xpath对象，然后根绝xpath语法类似操作dom树
public class Xpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = Xpath.class.getClassLoader().getResource("People.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据document对象，创建JXdocument对象
        JXDocument jxd = new JXDocument(document);
        //结合xpath语法操作
        List<JXNode> jxNodes = jxd.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("**************");
        //查询所有student标签下的name元素
        List<JXNode> jxNodes_name = jxd.selN("//student/name");
        for (JXNode jxNode : jxNodes_name) {
            System.out.println(jxNode);
        }
        System.out.println("~~~~~~~~~~~~~");
        //查询student标签下带有id属性的name标签
        List<JXNode> jxNodes_name_id = jxd.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes_name_id) {
            System.out.println(jxNode);
        }
        System.out.println("^^^^^^^^^^^");
        //查询student标签下带有id属性的name标签.并且id属性值为itcast
        List<JXNode> jxNodes_name_id_it = jxd.selN("//student/name[@id='gallagher']");
        for (JXNode jxNode : jxNodes_name_id_it) {
            System.out.println(jxNode);
        }
        }
    }

