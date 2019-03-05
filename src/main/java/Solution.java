
import com.song.jvm.Test;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author hadoop
 */
public class Solution {



}



class Parent implements Comparable {
    private int age = 0;

    public Parent(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("method of parent");
        Parent o1 = (Parent) o;
        return age > o1.age ? 1 : age < o1.age ? -1 : 0;
    }
}

class Child extends Parent {
    public Child() {
        super(3);
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("method of child");
        return 1;
    }
}

class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.size());
    }
}












