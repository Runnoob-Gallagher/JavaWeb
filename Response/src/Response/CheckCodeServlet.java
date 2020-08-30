package Response;

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

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建图片对象，生成图片
        int width = 100;
        int height = 50;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR); //图片类型

        //美化图片
            //1.填充背景色
        Graphics pen = image.getGraphics();//获取画笔对象
        //pen.fillxxx();--->表示填充  pen.drawxxx();--->表示画笔
        pen.setColor(Color.magenta);//设置画笔颜色
        pen.fillRect(0,0,width,height);//填充的宽高   0,0点表示左上角
            //2.画边框
        pen.setColor(Color.BLUE);
        pen.drawRect(0,0,width-1,height-1); //因为边框还是占一个px的.你又必须把边框画在这个填充色上面才会显示，所以减1
            //3.写字
                //3.1随机获取
        String str = "ABCDEFGHIJKLMNOPKRSTUVWXYZabcdefghljkimnopkrstuvwxyz1234567890";
        Random random = new Random();
        for (int i = 0; i <=4 ; i++) {
            int index = random.nextInt(str.length());
            //3.2获取字符
            char at = str.charAt(index);
            pen.drawString(at+"",width/4*i + 10,height/2);
        }
            //4.画干扰线
            pen.setColor(Color.cyan);
                //4.1随机生成坐标点

        for (int i = 0; i <=6 ; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(width);
            int x2 = random.nextInt(height);
            int y2 = random.nextInt(height);
            pen.drawLine(x1,y1,x2,y2);//X1，Y1是确定直线的起始点，即横坐标为x1，纵坐标为y1的点。同理x2,y2确定直线的终点。
        }



        //将图片输出到页面上
        ImageIO.write(image,"jpg",response.getOutputStream());   //图片对象，后缀名，输出流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
