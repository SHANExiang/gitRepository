package main.java;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

//һ��һ�еض��ļ���
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
        InputStreamReader��FileReader����ȫ��
         */
        System.out.println("----------------------------");
        try {
            readFile3(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    InputStreamReader���ֽ������ַ���֮�������������ȡ�ļ�����ʹ���ض����ַ������ֽڽ�����ַ���
    InputStreamReader���Դ����ļ�֮����������������������ӡ���·����Դ��ZIP�ļ��ȡ�
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
    FileReader��һ���������࣬������ȡ�ַ��ļ��������Ĺ��췽���ٶ�Ĭ�ϵ��ַ������Ĭ�ϵ��ֽڻ����С���Ǻ��ʵġ�
    FileReader��������ָ��Ĭ��ƽ̨��������ı��롣
    ��������ھ��в�ͬƽ̨�����ϵͳ������ʱ���ǲ�����ʹ�����ġ�
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
