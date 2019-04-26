package main.java;

public class StaticTypeCheckingTest {
    public static void main(String[] args) {
        /*
       me()����������Ϊ����AClass�������� �����ڼ䷵��AClass����
       ������ʱ������BClass��������BClass�̳���AClass��me()����������this(BClass�����Լ�)
         */
        System.out.println(new BClass().me().getClass().toString());//BClass

        AClass aClass = new BClass();
        System.out.println(aClass.getClass().toString());//BClass

        /*
        new BClass().me().BdoSomething()����δ�����벻ͨ������ʹ���ڵ��øö������BClass����
        ������������������AClass���������ڱ���ʱ��֪�����ľ������ͣ��ͽ����Ķ�����ΪAClass�Ķ���
         */

        new BClass().me().AdoSomething();

        ((BClass)(new BClass().me())).BdoSomething();//���Խ�����ת���BClass���͵�

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