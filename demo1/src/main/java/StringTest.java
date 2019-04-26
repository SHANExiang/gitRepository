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
         * 以下代码说明String的不变性(immutability)
         */
        //初始化一个字符串str，表示变量str储存字符串String对象的引用，“abc”存放在堆中，将存放地址赋给str
        String str = "abc";

        //将堆中的“abc”的存储地址又赋给字符串引用变量str2;
        String str2 = str;

        //将字符串"def"连接到str,此时str不在储存“abc”的储存地址，而是将堆中新创建一个String对象“abcdef”赋给str.
        str = str.concat("def");
        /*
        总结：一旦在内存(堆中)创建一个String对象时，它将不在改变，所有的String类的方法不是去改变String
        对象，而是重新返回一个新的对象。如果我们想改变String，你可以使用StringBuffer或者StringBuilder.
        由于每创建一个对象，需要很多的时间来进行垃圾回收。
         */

        System.out.println("---------------------------------------------------------------");
        /**
         * 为什么String是不变类？String类是Java中的不变类，不变类表明他的实例是不能被修改的。
         * 当实例被创建时，它的所有信息都被初始化并且不能被修改。设置成不变类由很多优点。下面从内存、同步和
         * 数据结构的角度来分析不变性的好处。
         */
        //1. 字符串池的需要。
        //字符串池是方法区的特定存储空间。当字符串被创建时，如果此字符串已经存在，存在的字符串引用将被返回，
        // 而不是新创建一个对象。
        String s1 = "abc";
        String s2 = "abc";
        //以上两个代码虽然有两个引用常量，但是堆中仅有一个String对象。如果String类是可变的，使用一个引用
        //改变字符串将使其他引用的值发生错误。

        /*
        2. 缓存Hashcode。
        Hashcode经常在Java中被使用。比如HashMap，HashSet等。String类被设置成不变的，
        可以保证Hashcode的值不变，并且能够被缓存，不需要担心值得改变。也就是说，不需要在每次使用的时候都计算
        Hashcode的值。这是很高效的。
         */
        //private int hash; 这是String类中的变量，用来缓存hash code的。
        /*
        3. 推进其他对象的使用。
        如：HashSet<String> hashSet = new HashSet<String>();
            hashSet.add(new String("a"));
            hashSet.add(new String("b"));
            for(String s: hashSet)
                s.value = "a";
                上述代码只是展示用的，在String类中没有值域。
                如果String类是可变的，它的值是可以改变的，这就违反了set的设计初衷。
         */

        /*
        4. 安全考虑。
        String经常被Java类当做参数进行传递。比如网路连接或者打开文件。当String对象时可变的，网络连接和
        文件都可以被改变，这回引起安全性的威胁。以为已经连接上的，实际上并没有。当String参数是可变的时候，
        也可以在映射中造成安全威胁。
         */
        //如以下例子:
//        boolean connect(string s){
//            if (!isSecure(s)) {
//                throw new SecurityException();
//            }
        //这将导致问题，如果在之前使用其他引用改变了s。
//            causeProblem(s);
//        }
        /*
        5. 不可变对象时天然线程安全的。
        因为不可变对象不能被改变，所以他可以被多线程之间自由共享。这回消除进行同步的要求。
         */

        System.out.println("-----------------------------------------------------------");

        /*
        Java中String对象可以由两种方式创建，一种是“”括起来，另一种是构造方法。
         */
        String string1 = "xiang";
        String string2 = new String("xiang");

        String a = "abcd";
        String b = "abcd";
        System.out.println(a == b); //true，字符串常量池的存在，内存引用相同
        System.out.println(a.equals(b)); //true，两个对象的值确实相等

        String c = new String("abcd");
        String d = new String("abcd");
        System.out.println(c == d); //false c和d指向堆中的两个对象，不同的对象有不同的内存引用。
        System.out.println(a.equals(d));//true，值相等

        /**
         * 由于“abcd"已经是String类型了，使用构造器会额外创建不需要的对象，因此如果仅仅创建一个String，
         * 双引号“”应该被使用
         * 如果确实需要再堆中创建一个新的对象了，构造器应该被使用。
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
         * 上述代码的输出结果是ab。
         * 首先当字符串“ab”被创建时，Java将分配内存中的一块区域来存储String对象，之后对象赋给变量x，
         * 对象引用赋给变量x 这个引用是存储对象的内存地址。
         * 这个变量x包含指向String对象的引用，它不只是引用自己，它是一个变量存储一个引用（内存地址）。
         * Java仅仅是通过值传递。当x传递给change()方法时，一个x值的拷贝(一个引用)被传递过去。
         * 方法change()创建了另一个对象“cd”,它有着不同的引用。是x的拷贝指向“cd”对象，
         * 它存储着“cd”对象的引用(内存地址)。main()方法中还是之前的那个变量x.
         */


        //Java String的几个问题。
        /*
        1. 将String转换成int
         */
        String str1 = "34";
        int value1 = Integer.parseInt(str1);
        System.out.println(value1);

        /*
        2. 用空白字符拆分字符串。
         */
        String str3 = "shane is a genius";
        String[] strArray1 = str3.split("\\s+");
        //String[] strArray1 = str3.split(" ");
        System.out.println(Arrays.toString(strArray1));

        /*
        3. 重复字符串。使用Apache Commons Lang package
         */
        String str4 = "abc";
        String str5 = StringUtils.repeat(str4, 2);//指的是将str4重复2次
        System.out.println(str5);

        /*
        4. 将字符串转换成日期
         */
        String str6 = "Aug 16,1992";
        try {
            Date date = new SimpleDateFormat("MMMM d,yy", Locale.ENGLISH).parse(str6);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        5. 数一个字符串中存在的字符的数量。使用Apache commons lang
         */
        String str7 = "2145454445";
        int count = StringUtils.countMatches(str7, "4");
        System.out.println(count);
    }
}
