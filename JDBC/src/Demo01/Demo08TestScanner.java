package Demo01;

import java.util.Scanner;

public class Demo08TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输出你想说的话");
        String next = sc.nextLine();
        System.out.println(next);
        /*
        总结：
        next()方法读取到空白符就结束l；杨洁你要加油！ Good Good Study,Day Day up! ---> 杨洁你要加油！
        nextLine()读取到回车结束也就是“\r”；杨洁你要加油！ Good Good Study,Day Day up! --->杨洁你要加油！ Good Good Study,Day Day up!
         */
    }
}
