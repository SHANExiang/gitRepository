package main.java;

public class StaticTypeCheckingTest {
    public static void main(String[] args) {
        /*
       me()方法被声明为返回AClass对象，所以 编译期间返回AClass对象。
       而运行时，返回BClass对象，由于BClass继承了AClass的me()方法，返回this(BClass对象自己)
         */
        System.out.println(new BClass().me().getClass().toString());//BClass

        AClass aClass = new BClass();
        System.out.println(aClass.getClass().toString());//BClass

        /*
        new BClass().me().BdoSomething()，这段代码编译不通过。即使正在调用该对象的是BClass对象，
        但是它的引用类型是AClass。编译器在编译时不知道它的具体类型，就将它的对象视为AClass的对象。
         */

        new BClass().me().AdoSomething();

        ((BClass)(new BClass().me())).BdoSomething();//可以将对象转变成BClass类型的

    }
}
class AClass{
    AClass me(){
        return this;
    }
    public void AdoSomething(){
        System.out.println("AClass do something");
    }
}
class BClass extends AClass{
    public void BdoSomething(){
        System.out.println("BClass do something.");
    }
}