import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args) {
        /**
         * 异常的是10个问题。
         */
        /*
        1. 简而言之，受检查异常必须被显示捕获或者加在方法的throws语句中。
        未受检查异常是由出现的问题导致的，如除以0，空指针等。
        受检查异常是很重要的，因为你写的API当其他开发者看见时必须要知道怎么去处理这些异常。
        例如，IO异常是经常使用的异常，运行时异常是非检查型异常。
         */

        /*
        2. 异常管理的最佳实践。
        如果异常可以被合适地处理的时候，那么它就必须被捕获，或者抛出。
         */

        /*
        3. 为什么定义在try块里的变量在catch和finally块中不能被使用？
        try {
            File file = new File("test.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            String s1 = "inside";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(s1);
        }
        上面代码中s1放在catch中，编译不通过。
        原因是不知道try块中的哪个位置会抛出异常，很有可能在声明对象之前就抛出了异常，这个例子就说明了这点。
         */

        /*
        4. 为什么Double.parseDouble(null)和Integer.parseInt(null)抛出不同的异常？
        这是JDK的问题，它们是由不同的开发者编写的，所以不值得思考。
        Integer.parseInt(null);
        // throws java.lang.NumberFormatException: null

        Double.parseDouble(null);
        // throws java.lang.NullPointerException
         */

        /*
        5. 经常使用的运行时异常。
        IllegalArgumentException、ArrayIndexOutOfBoundsException
         */

        /*
        6. 同一catch块中可以捕获多个异常吗？
        答案是可以的。只要这些异常能够追踪到类继承机制中的同一个超类，你只能使用哪个超类。
         */

        /*
        7. 构造器可以抛出异常，构造器只是一个特殊的方法。
        class FileReader{
            public FileInputStream fis = null;

            public FileReader() throws IOException{
                File dir = new File(".");//get current directory
                File fin = new File(dir.getCanonicalPath() + File.separator + "not-existing-file.txt");
                fis = new FileInputStream(fin);
            }
         }
}
         */

        /*
        8. 在finally块中抛出异常是合法的。代码如下：
        File file1 = new File("test1.txt");
        File file2 = new File("test2.txt");
        try {
            FileInputStream fileInputStream1 = new FileInputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
         */

        /*
        9. return 可以在finally中使用。
         */

        /*
        10. 有如下许多时间代码段，如下所示。如果正确处理异常是如此重要，为什么开发人员继续这样做？
        try {
             ...
            } catch(Exception e) {
               e.printStackTrace();
            }
         }
         忽略很简单。经常发生并不意味着正确性。
         */

    }
}
