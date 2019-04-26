package main.java;

public class AliasingProblemTest {
    public static void main(String[] args) {
        B[] bArray = new B[10];
        A[] aArray = new A[10];

        System.out.println("将bArray赋给aArray之前：");
        //getCanonicalName()返回Java语言规范定义的基础类的规范名称。
        // 如果是数组就返回数组中元素类型的规范名称。即包名+元素名+[]。
        System.out.println("\t" + aArray.getClass().getCanonicalName());
        System.out.println("\t" + bArray.getClass().getCanonicalName());

        aArray = bArray;
        System.out.println("将bArray赋给aArray之后：");
        System.out.println("\t" + aArray.getClass().getCanonicalName());
        System.out.println("\t" + bArray.getClass().getCanonicalName());
        System.out.println("\taArray中包含元素" + aArray.getClass().getComponentType().getCanonicalName());
        
    }
}
class A {
    public void methodOfParent(){
        System.out.println("This is a method of parent");
    }
}
class B extends A{
    @Override
    public void methodOfParent() {
        System.out.println("This is a overrided method of parent");
    }

    public void methodOfChild(){
        System.out.println("This is a method of child");
    }

}
