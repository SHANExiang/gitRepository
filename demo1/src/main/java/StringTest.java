package main.java;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class StringTest {

    public static void main(String[] args) {
        /**
         * ���´���˵��String�Ĳ�����(immutability)
         */
        //��ʼ��һ���ַ���str����ʾ����str�����ַ���String��������ã���abc������ڶ��У�����ŵ�ַ����str
        String str = "abc";

        //�����еġ�abc���Ĵ洢��ַ�ָ����ַ������ñ���str2;
        String str2 = str;

        //���ַ���"def"���ӵ�str,��ʱstr���ڴ��桰abc���Ĵ����ַ�����ǽ������´���һ��String����abcdef������str.
        str = str.concat("def");
        /*
        �ܽ᣺һ�����ڴ�(����)����һ��String����ʱ���������ڸı䣬���е�String��ķ�������ȥ�ı�String
        ���󣬶������·���һ���µĶ������������ı�String�������ʹ��StringBuffer����StringBuilder.
        ����ÿ����һ��������Ҫ�ܶ��ʱ���������������ա�
         */

        System.out.println("---------------------------------------------------------------");
        /**
         * ΪʲôString�ǲ����ࣿString����Java�еĲ����࣬�������������ʵ���ǲ��ܱ��޸ĵġ�
         * ��ʵ��������ʱ������������Ϣ������ʼ�����Ҳ��ܱ��޸ġ����óɲ������ɺܶ��ŵ㡣������ڴ桢ͬ����
         * ���ݽṹ�ĽǶ������������Եĺô���
         */
        //1. �ַ����ص���Ҫ��
        //�ַ������Ƿ��������ض��洢�ռ䡣���ַ���������ʱ��������ַ����Ѿ����ڣ����ڵ��ַ������ý������أ�
        // �������´���һ������
        String s1 = "abc";
        String s2 = "abc";
        //��������������Ȼ���������ó��������Ƕ��н���һ��String�������String���ǿɱ�ģ�ʹ��һ������
        //�ı��ַ�����ʹ�������õ�ֵ��������

        /*
        2. ����Hashcode��
        Hashcode������Java�б�ʹ�á�����HashMap��HashSet�ȡ�String�౻���óɲ���ģ�
        ���Ա�֤Hashcode��ֵ���䣬�����ܹ������棬����Ҫ����ֵ�øı䡣Ҳ����˵������Ҫ��ÿ��ʹ�õ�ʱ�򶼼���
        Hashcode��ֵ�����Ǻܸ�Ч�ġ�
         */
        //private int hash; ����String���еı�������������hash code�ġ�
        /*
        3. �ƽ����������ʹ�á�
        �磺HashSet<String> hashSet = new HashSet<String>();
            hashSet.add(new String("a"));
            hashSet.add(new String("b"));
            for(String s: hashSet)
                s.value = "a";
                ��������ֻ��չʾ�õģ���String����û��ֵ��
                ���String���ǿɱ�ģ�����ֵ�ǿ��Ըı�ģ����Υ����set����Ƴ��ԡ�
         */

        /*
        4. ��ȫ���ǡ�
        String������Java�൱���������д��ݡ�������·���ӻ��ߴ��ļ�����String����ʱ�ɱ�ģ��������Ӻ�
        �ļ������Ա��ı䣬�������ȫ�Ե���в����Ϊ�Ѿ������ϵģ�ʵ���ϲ�û�С���String�����ǿɱ��ʱ��
        Ҳ������ӳ������ɰ�ȫ��в��
         */
        //����������:
//        boolean connect(string s){
//            if (!isSecure(s)) {
//                throw new SecurityException();
//            }
        //�⽫�������⣬�����֮ǰʹ���������øı���s��
//            causeProblem(s);
//        }
        /*
        5. ���ɱ����ʱ��Ȼ�̰߳�ȫ�ġ�
        ��Ϊ���ɱ�����ܱ��ı䣬���������Ա����߳�֮�����ɹ��������������ͬ����Ҫ��
         */

        System.out.println("-----------------------------------------------------------");

        /*
        Java��String������������ַ�ʽ������һ���ǡ�������������һ���ǹ��췽����
         */
        String string1 = "xiang";
        String string2 = new String("xiang");

        String a = "abcd";
        String b = "abcd";
        System.out.println(a == b); //true���ַ��������صĴ��ڣ��ڴ�������ͬ
        System.out.println(a.equals(b)); //true�����������ֵȷʵ���

        String c = new String("abcd");
        String d = new String("abcd");
        System.out.println(c == d); //false c��dָ����е��������󣬲�ͬ�Ķ����в�ͬ���ڴ����á�
        System.out.println(a.equals(d));//true��ֵ���

        /**
         * ���ڡ�abcd"�Ѿ���String�����ˣ�ʹ�ù���������ⴴ������Ҫ�Ķ�����������������һ��String��
         * ˫���š���Ӧ�ñ�ʹ��
         * ���ȷʵ��Ҫ�ٶ��д���һ���µĶ����ˣ�������Ӧ�ñ�ʹ�á�
         */

        System.out.println("-----------------------------------------------------------");
        /**
         * public static void main(String[] args) {
         * 	String x = new String("ab");
         * 	change(x);
         * 	System.out.println(x);
         * }
         *
         * public static void change(String x) {
         * 	x = "cd";
         * }
         * �����������������ab��
         * ���ȵ��ַ�����ab��������ʱ��Java�������ڴ��е�һ���������洢String����֮����󸳸�����x��
         * �������ø�������x ��������Ǵ洢������ڴ��ַ��
         * �������x����ָ��String��������ã�����ֻ�������Լ�������һ�������洢һ�����ã��ڴ��ַ����
         * Java������ͨ��ֵ���ݡ���x���ݸ�change()����ʱ��һ��xֵ�Ŀ���(һ������)�����ݹ�ȥ��
         * ����change()��������һ������cd��,�����Ų�ͬ�����á���x�Ŀ���ָ��cd������
         * ���洢�š�cd�����������(�ڴ��ַ)��main()�����л���֮ǰ���Ǹ�����x.
         */


        //Java String�ļ������⡣
        /*
        1. ��Stringת����int
         */
        String str1 = "34";
        int value1 = Integer.parseInt(str1);
        System.out.println(value1);

        /*
        2. �ÿհ��ַ�����ַ�����
         */
        String str3 = "shane is a genius";
        String[] strArray1 = str3.split("\\s+");
        //String[] strArray1 = str3.split(" ");
        System.out.println(Arrays.toString(strArray1));

        /*
        3. �ظ��ַ�����ʹ��Apache Commons Lang package
         */
        String str4 = "abc";
        String str5 = StringUtils.repeat(str4, 2);//ָ���ǽ�str4�ظ�2��
        System.out.println(str5);

        /*
        4. ���ַ���ת��������
         */
        String str6 = "Aug 16,1992";
        try {
            Date date = new SimpleDateFormat("MMMM d,yy", Locale.ENGLISH).parse(str6);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        5. ��һ���ַ����д��ڵ��ַ���������ʹ��Apache commons lang
         */
        String str7 = "2145454445";
        int count = StringUtils.countMatches(str7, "4");
        System.out.println(count);
    }
}
