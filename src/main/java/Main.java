// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] strs = new String[a];
        for (int i = 0; i < a; i++) {
            strs[i] = str.substring(i* 9, (i + 1) * 9);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(get(s));
            sb.append(" ");


        }
        System.out.println(sb.toString().trim());

    }

    public static String get(String s){

        if (s.startsWith("0")){
            StringBuilder sb = new StringBuilder( s.substring(1));
            sb.reverse();
            return sb.toString();
        } else {
            return s.substring(1);
        }


    }


}



/*


public class Main {

    public static double result = Double.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(new Flower(x, y));

        }

        System.out.println("----------");
        get(list, 0,0 ,0);

        System.out.println((int)result);

    }

    public static void get(List<Flower> list, double size, int beforeX, int beforeY){

        if (list.size() == 0){

            size +=Math.sqrt(Math.pow(beforeX,2) + Math.pow(beforeY, 2));
            result = Math.min(result, size);

            return;

        }


        for (int i = 0; i < list.size(); i++) {
            Flower flower = list.remove(i);
            size += Math.sqrt( Math.pow(Math.abs(flower.x - beforeX), 2) + Math.pow(Math.abs(flower.y - beforeY), 2));
            get(list, size, flower.x, flower.y);
            list.add(i, flower);
        }


    }


}

class Flower{
    public Flower(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

}
* */