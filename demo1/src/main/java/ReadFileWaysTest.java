package main.java;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

//一行一行地读文件。
public class ReadFileWaysTest {
    public static void main(String[] args) {
        File file = new File("c:/test.txt");

        try {
            readFile1(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------");

        try {
            readFile2(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        InputStreamReader较FileReader更安全。
         */
        System.out.println("----------------------------");
        try {
            readFile3(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    InputStreamReader是字节流与字符流之间的桥梁，它读取文件，并使用特定的字符集将字节解码成字符。
    InputStreamReader可以处理文件之外的输入流，比如网络连接、类路径资源、ZIP文件等。
     */
    public static void readFile1(File file) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(file);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line = null;
        while((line = bufferedReader.readLine() )!= null){
            System.out.println(line);
        }
        bufferedReader.close();
        fileInputStream.close();
    }

    /*
    FileReader是一个便利的类，用来读取字符文件，这个类的构造方法假定默认的字符编码和默认的字节缓冲大小都是合适的。
    FileReader不允许你指定默认平台编码以外的编码。
    如果程序将在具有不同平台编码的系统上运行时，是不建议使用它的。
     */
    public static void readFile2(File file) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        while((line = bufferedReader.readLine())!= null){
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void readFile3(File file) throws Exception{
        Charset charset = Charset.forName("GBK");
        try(BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(),charset)){
            String line = null;
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
