package web;

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
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
        //定义验证码图片的长宽
        int width = 80;
        int height = 30;
        //创建图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔对象
        Graphics pencil = image.getGraphics();
        //设置画笔属性-颜色
        pencil.setColor(Color.GRAY);
        //设置画笔属性-线还是填充,现在是将背景填充为灰色
        pencil.fillRect(0,0,width,height);  //得到一个矩形块
        //获得随机生成的4个验证码
        String checkcode = getcode();
        //将获取得到的验证码放在session中
        request.getSession().setAttribute("checkcode",checkcode);
        //在此设置画笔属性
        pencil.setColor(Color.YELLOW);
        pencil.setFont(new Font("楷体",Font.BOLD,20));
        //写验证码
        pencil.drawString(checkcode,15,25);

        //将验证码存在session中
        request.getSession().setAttribute("check_value",checkcode);
        //画干扰线
        //设置画笔颜色
        pencil.setColor(Color.BLACK);
        //随机生成10根线
        Random random = new Random();
        for (int i = 0; i <6 ; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            pencil.drawLine(x1,y1,x2,y2);
        }
        //见图片输出到页面
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    /**
     * 返回4位随机验证码
     * @return
     */
    private String getcode() {
        String base = "abcsefghijklmnopkrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <4 ; i++) {
            int base_index = random.nextInt(base.length());
            char basecode = base.charAt(base_index);
            stringBuilder.append(basecode);  //后面用来传值
        }
        return stringBuilder.toString();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
