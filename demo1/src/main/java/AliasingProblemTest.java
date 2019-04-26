package main.java;

public class AliasingProblemTest {
    public static void main(String[] args) {
        B[] bArray = new B[10];
        A[] aArray = new A[10];

        System.out.println("��bArray����aArray֮ǰ��");
        //getCanonicalName()����Java���Թ淶����Ļ�����Ĺ淶���ơ�
        // ���������ͷ���������Ԫ�����͵Ĺ淶���ơ�������+Ԫ����+[]��
        System.out.println("\t" + aArray.getClass().getCanonicalName());
        System.out.println("\t" + bArray.getClass().getCanonicalName());

        aArray = bArray;
        System.out.println("��bArray����aArray֮��");
        System.out.println("\t" + aArray.getClass().getCanonicalName());
        System.out.println("\t" + bArray.getClass().getCanonicalName());
        System.out.println("\taArray�а���Ԫ��" + aArray.getClass().getComponentType().getCanonicalName());
        /*
        ��bArray���鸳��aArray��aArray�����оͲ��ڰ���A���ʵ���ˣ�
        ������ʱ��JVM����ΪaArray�е�Ԫ��ʱB���ʵ����
         */
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
