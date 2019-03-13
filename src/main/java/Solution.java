import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author hadoop
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/hadoop/Desktop/WZ.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File("/home/hadoop/Desktop/WZ.txt")));
        FileInputStream fileInputStream = new FileInputStream(file);

        br.readLine();
        br.readLine();
        String a = br.readLine();

        System.out.println(a);

        String[] strs= a.split(" ");
        for (String s : strs){
            System.out.println(s);
        }




    }

}

class Animal {
    public void say() {
        System.out.println("animal");
    }

}

class Cat extends Animal {
    @Override
    public void say() {
        System.out.println("cat");
    }
}

class BigCat extends Cat {
    @Override
    public void say() {
        System.out.println("bigcat");
    }

    ;

}

class Dag extends Animal {
    @Override
    public void say() {
        System.out.println("dag");
    }

}


/*
*
6 3
1 1
3 5
4 8
6 4
10 3
11 2



*
* */
