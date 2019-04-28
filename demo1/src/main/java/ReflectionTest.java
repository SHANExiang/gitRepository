import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {
        /**
         * 1. 什么是反射？
         * “反射通常由程序使用，这些程序需要能够检查或修改在Java虚拟机中运行的应用程序的运行时行为。"
         * 这个概念经常与内省混合在一起。以下是他们对Wiki的定义:
         * 1. 内省是程序在运行时检查对象类型或属性的能力。
         * 2. 反射是程序在运行时检查和修改对象的结构和行为的能力。
         * 从他们的定义来看，内省是反射的一个子集。有些语言支持内省，但不支持反射，例如C ++。
         * 内省示例：instanceof运算符确定对象是否属于特定的类
         * if(object.instanceOf Dog){
         * Dog dog = (Dog)object;
         * dog.bark;
         * }
         * 反射示例：Class.forName（）方法返回与具有给定名称（字符串和完全限定名称）的类/接口关联的Class对象。
         * forName方法导致具有名称的类被初始化。
         * Class<?> c = Class.forName("classPath.and.className");
         * Object object = c.newInstance();
         * Method method = c.getDeclaredMethod("bark", new Class<?>[0]);
         * method.invoke(object);
         * 在Java中，反射更多地是关于内省，因为你无法改变一个对象的结构。
         * 有一些API可以改变方法和字段的可访问性，但不能改变结构的可访问性。
         *
         * 2. 为什么需要反射？
         * 反射能帮我们做什么：
         * 1）在运行时检查对象的类；
         * 2）在运行时为类构造一个对象；
         * 3）在运行时检查类的字段和方法；
         * 4）在运行时调用对象的任何方法；
         * 5）更改构造函数、字段和方法的可访问性标记。
         * 反射是框架的常用方法.例如:JUnit使用反射来查看使用@Test注释标记的方法，然后在运行单元测试时调用这些方法。
         * 对于Web框架，产品开发人员定义他们自己的接口和类的实现，并将其放在配置文件中。使用反射，它可以快速动态初始化所需的类。
         * 例如，Spring使用bean配置：
         * <bean id="someID" class="com.programcreek.Foo">
         *     <property name="someField" value="someValue" />
         * </bean>
         * 当Spring上下文处理这个<bean>元素时，它将使用Class.forName（String）和参数“com.programcreek.Foo”来实例化该类。
         * 然后它将再次使用反射来获取<property>元素的适当setter并将其值设置为指定值。
         * Servlet Web应用程序也使用相同的机制：
         * <servlet>
         *     <servlet-name>someServlet</servlet-name>
         *     <servlet-class>com.programcreek.WhyReflectionServlet</servlet-class>
         * <servlet>
         *
         * 3. 怎样使用反射？
         * 如何使用反射API可以通过使用一小组典型的代码示例来显示：
         * 1）根据对象获取类名
         * public class ReflectionHelloWorld {
         * 	public static void main(String[] args){
         * 		Foo f = new Foo();
         * 		System.out.println(f.getClass().getName());
         *        }
         * }
         *
         * class Foo {
         * 	public void print() {
         * 		System.out.println("abc");
         *    }
         * }
         * 2）调用不知道的对象的方法。
         * public class ReflectionHelloWorld {
         * 	public static void main(String[] args){
         * 		Foo f = new Foo();
         *
         * 		Method method;
         * 		try {
         * 			method = f.getClass().getMethod("print", new Class<?>[0]);
         * 			method.invoke(f);
         *                } catch (Exception e) {
         * 			e.printStackTrace();
         *        }* 	}
         * }
         *
         * class Foo {
         * 	public void print() {
         * 		System.out.println("abc");
         * 	}
         * }
         * 3）从Class实例创建对象
         * public class ReflectionHelloWorld {
         * 	public static void main(String[] args){
         * 		//create instance of "Class"
         * 		Class<?> c = null;
         * 		try{
         * 			c=Class.forName("myreflection.Foo");
         *                }catch(Exception e){
         * 			e.printStackTrace();
         *        }
         *
         * 		//create instance of "Foo"
         * 		Foo f = null;
         *
         * 		try {
         * 			f = (Foo) c.newInstance();
         *        } catch (Exception e) {
         * 			e.printStackTrace();
         *        }
         *
         * 		f.print();* 	}
         * }
         *
         * class Foo {
         * 	public void print() {
         * 		System.out.println("abc");
         * 	}
         * }
         * 4）获取构造函数并创建实例.同样您可以使用Class实例来获取已实现的接口，超类，声明字段等。
         * public class ReflectionHelloWorld {
         * 	public static void main(String[] args){
         * 		//create instance of "Class"
         * 		Class<?> c = null;
         * 		try{
         * 			c=Class.forName("myreflection.Foo");
         *                }catch(Exception e){
         * 			e.printStackTrace();
         *        }
         *
         * 		//create instance of "Foo"
         * 		Foo f1 = null;
         * 		Foo f2 = null;
         *
         * 		//get all constructors
         * 		Constructor<?> cons[] = c.getConstructors();
         *
         * 		try {
         * 			f1 = (Foo) cons[0].newInstance();
         * 			f2 = (Foo) cons[1].newInstance("abc");
         *        } catch (Exception e) {
         * 			e.printStackTrace();
         *        }
         *
         * 		f1.print();
         * 		f2.print();* 	}
         * }
         *
         * class Foo {
         * 	String s;
         *
         * 	public Foo(){}
         *
         * 	public Foo(String s){
         * 		this.s=s;
         * 	}
         *
         * 	public void print() {
         * 		System.out.println(s);
         * 	}
         * }
         * 5)通过反射改变数组的长度
         * public class ReflectionHelloWorld {
         * 	public static void main(String[] args) {
         * 		int[] intArray = { 1, 2, 3, 4, 5 };
         * 		int[] newIntArray = (int[]) changeArraySize(intArray, 10);
         * 		print(newIntArray);
         *
         * 		String[] atr = { "a", "b", "c", "d", "e" };
         * 		String[] str1 = (String[]) changeArraySize(atr, 10);
         * 		print(str1);
         *        }
         *
         * 	// change array size
         * 	public static Object changeArraySize(Object obj, int len) {
         * 		Class<?> arr = obj.getClass().getComponentType();
         * 		Object newArray = Array.newInstance(arr, len);
         *
         * 		//do array copy
         * 		int co = Array.getLength(obj);
         * 		System.arraycopy(obj, 0, newArray, 0, co);
         * 		return newArray;
         *    }
         *
         * 	// print
         * 	public static void print(Object obj) {
         * 		Class<?> c = obj.getClass();
         * 		if (!c.isArray()) {
         * 			return;
         *        }
         *
         * 		System.out.println("\nArray length: " + Array.getLength(obj));
         *
         * 		for (int i = 0; i < Array.getLength(obj); i++) {
         * 			System.out.print(Array.get(obj, i) + " ");
         *        }
         *    }
         * }
         */

    }

}
