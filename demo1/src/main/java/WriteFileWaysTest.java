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
     * 异同点：
     * FileWriter是一个编写字符文件的便捷类。此类的构造方法假定默认的字符编码和默认字节缓冲区大小都是可接受的。
     * 要自己指定这些值，需要在FileOutputStream上构造OutputStreamWriter。
     * PrintWriter将对象的格式化表示打印到文本输出流。此类实现PrintStream中的所有打印方法。
     * 它不包含写入原始字节的方法，程序应使用未编码的字节流。
     * 主要区别在于PrintWriter提供了一些其他格式化方法，如println和printf。
     * 此外，在任何I / O失败的情况下，FileWriter都会抛出IOException。
     * PrintWriter方法不会抛出IOException，而是设置一个布尔标志，可以使用checkError（）获得。
     * 在写入每个字节数据后，PrintWriter会自动调用flush。
     * 在FileWriter的情况下，调用者必须负责调用flush。
     */
}
