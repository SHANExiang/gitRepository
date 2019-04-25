package main.java;

import java.io.*;

public class WriteFileWaysTest {
    public static void main(String[] args) {
        try {
            writeFile1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------writeFile1() is completed...");

        try {
            writeFile2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------writeFile2() is completed...");

        try {
            writeFile3();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------writeFile3() is completed...");

        try {
            writeFile4();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------writeFile4() is completed...");
    }

    public static void writeFile1() throws Exception{
        File file = new File("c:/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
       for (int i = 0;i <10;i++){
           bufferedWriter.write("something ");
           bufferedWriter.newLine();
       }
        bufferedWriter.close();
    }

    public static void writeFile2() throws IOException{
        FileWriter fileWriter = new FileWriter("c:/test1.txt");
        for (int i = 0;i < 10;i++){
            fileWriter.write("something1");
        }
        fileWriter.close();
    }

    public static void writeFile3() throws  IOException{
        PrintWriter printWriter = new PrintWriter("c:/test2.txt");
        for (int i = 0;i < 10;i++){
            printWriter.write("something2");
        }
        printWriter.close();
    }

    public static void writeFile4() throws IOException{
        File file = new File("c:/test3.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        for (int i = 0;i < 10;i++){
            outputStreamWriter.write("something3");
        }
        outputStreamWriter.close();
    }
    /**
     * ��ͬ�㣺
     * FileWriter��һ����д�ַ��ļ��ı���ࡣ����Ĺ��췽���ٶ�Ĭ�ϵ��ַ������Ĭ���ֽڻ�������С���ǿɽ��ܵġ�
     * Ҫ�Լ�ָ����Щֵ����Ҫ��FileOutputStream�Ϲ���OutputStreamWriter��
     * PrintWriter������ĸ�ʽ����ʾ��ӡ���ı������������ʵ��PrintStream�е����д�ӡ������
     * ��������д��ԭʼ�ֽڵķ���������Ӧʹ��δ������ֽ�����
     * ��Ҫ��������PrintWriter�ṩ��һЩ������ʽ����������println��printf��
     * ���⣬���κ�I / Oʧ�ܵ�����£�FileWriter�����׳�IOException��
     * PrintWriter���������׳�IOException����������һ��������־������ʹ��checkError������á�
     * ��д��ÿ���ֽ����ݺ�PrintWriter���Զ�����flush��
     * ��FileWriter������£������߱��븺�����flush��
     */
}
