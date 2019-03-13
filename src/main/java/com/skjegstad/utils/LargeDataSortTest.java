package com.skjegstad.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * @author wangyuyuan
 *         将一个大文件中的数据排序 无法一次读入内存情况的处理方法
 *//*
public class LargeDataSortTest {
    static File file = new File("/home/hadoop/Desktop/data.txt");
    static File file1 = new File("/home/hadoop/Desktop/dataSorted.txt");

    public static void main(String[] args) throws Exception {
       createData();
        System.out.println("大文件写入成功");
        separateFile();
        System.out.println("文件拆分成功");

//        everySingleFileSort();
//        System.out.println("小文件排序完成");
//        mergeFile();
//        System.out.println("所有排序都已完成");

    }

    public static void createData() throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            bw.write(random.nextInt(Integer.MAX_VALUE) + "\r\n");
        }
        bw.close();
        fw.close();
    }

    public static void separateFile() throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = null;
        BufferedWriter bw = null;
        HashMap fwList = new HashMap();
        HashMap bwList = new HashMap();


        for(int i = 0 ; i< 20 ; i++ ){
            fw = new FileWriter("F:" + File.separator + "dataTest" + File.separator + "data" + i + ".txt");
            bw = new BufferedWriter(fw);
            fwList.put(i,fw);
            bwList.put(i,bw);
        }

        while (br.ready()) {
            Integer readNumber = Integer.valueOf(br.readLine());
            int a = readNumber.hashCode() % 20;
            BufferedWriter bufferedWriter = bwList.get(a);
            bufferedWriter.write(readNumber + "\r\n");
        }

        //遍历关闭所有子文件流
        *//*for (Iterator iterator = bwList.iterator(); iterator.hasNext(); ) {
            BufferedWriter it = (BufferedWriter) iterator.next();
            it.close();
        }*//*
        for(Map.Entry a : bwList.entrySet()){
            a.getValue().close();
        }

        *//*for (Iterator iterator = fwList.iterator(); iterator.hasNext(); ) {
            FileWriter it = (FileWriter) iterator.next();
            it.close();
        }*//*
        for(Map.Entry a : fwList.entrySet()){
            a.getValue().close();
        }

        br.close();
        fr.close();
    }

    //对每个小文件进行排序
    public static void everySingleFileSort() throws Exception {
        LinkedList numbers;
        for (int i = 0; i < 20; i++) {
            numbers = new LinkedList();
            String path = "F:" + File.separator + "dataTest" + File.separator + "data" + i + ".txt";
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                numbers.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(numbers);
            numbersWrite(numbers, path);
            br.close();
            fr.close();
        }
    }

    //将排好序的没个文件写回到小文件中
    public static void numbersWrite(LinkedList numbers, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Iterator iterator = numbers.iterator(); iterator.hasNext(); ) {
            Integer num = (Integer) iterator.next();
            bw.write(num + "\r\n");
        }
        bw.close();
        fw.close();
    }

    //再将所有小文件整合到一个大文件中
    public static void mergeFile() throws Exception {
        PriorityQueue queue = new PriorityQueue(20, new Obj());
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = new FileWriter(file1);
        BufferedWriter bw = new BufferedWriter(fw);
        List frList = new LinkedList();
        List brList = new LinkedList();
        int n;
        for (int i = 0; i < 20; i++) {
            String path = "F:" + File.separator + "dataTest" + File.separator + "data" + i + ".txt";
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            frList.add(fr);
            brList.add(br);
        }
        //把每个小文件的第一个数读入队列中
        for (int i = 0; i <= 20; i++) {
            BufferedReader buffR;
            if (i == 20) {
                while (queue.size() != 0) {
                    Obj obj = queue.poll();
                    bw.write(obj.a + "\r\n");
                    buffR = brList.get(obj.b);
                    while (buffR.ready() && queue.size() < 20) {
                        n = Integer.parseInt(buffR.readLine());
                        queue.add(new Obj(n, obj.b));
                    }
                }
                break;
            }
            buffR = brList.get(i);
            while (buffR.ready() && queue.size() < 20) {
                n = Integer.parseInt(buffR.readLine());
                Obj obj = new Obj(n, i);
                queue.add(obj);
                break;
            }
        }
        bw.close();
        fw.close();
        //遍历关闭所有子文件流
        for (Iterator iterator = brList.iterator(); iterator.hasNext(); ) {
            BufferedReader it = (BufferedReader) iterator.next();
            it.close();
        }

        for (Iterator iterator = frList.iterator(); iterator.hasNext(); ) {
            FileReader it = (FileReader) iterator.next();
            it.close();
        }
    }
}

class Obj implements Comparator {
    int a, b;

    Obj() {
    }

    Obj(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Obj oo1 = (Obj) o1;
        Obj oo2 = (Obj) o2;

        return oo1.a - oo2.a;

    }
}*/