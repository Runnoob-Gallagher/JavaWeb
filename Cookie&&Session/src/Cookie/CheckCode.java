package Cookie;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义图片长宽高
        int width = 100;
        int height = 50;
        //1.创建一个验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片   填充背景色
        //2.1创建画笔对象
        Graphics pencil = image.getGraphics();
        //2.1.1设置画笔颜色
        pencil.setColor(Color.PINK);
        //2.1.2设置画画方式，填充还是单线
        pencil.fillRect(0,0,width,height);//用画笔填充图片背景
        pencil.setColor(Color.BLUE);
        pencil.drawRect(0,0,width-1,height-1);//因为画笔占一个像素，所以需要-1.不然就画到图片外面去了
        //设置验证码的随机数字
        String str = "ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghijklmnopkrstuvwxyz1234567890";
        Random random = new Random(); //因为随机只能随机数字，那么就应该想到角标
        StringBuilder sb = new StringBuilder(); //用StringBuilder来存储数据
        for (int i = 0; i <4 ; i++) {
            int index = random.nextInt(str.length());
            char code = str.charAt(index);
            sb.append(code); //添加数据
            //将验证码写到图片上
            pencil.drawString(code+"",width/5*i+10,height/2);
        }
        String check_value = sb.toString();
        //将获取的验证码存入session中
        request.getSession().setAttribute("checkcode_value",check_value);
        //画干扰线
            //设置画笔颜色
        pencil.setColor(Color.GREEN);
            //生成随机10根线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            pencil.drawLine(x1,y1,x2,y2);
        }
        //将图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
