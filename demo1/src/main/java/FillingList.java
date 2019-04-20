package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Collections����һЩ���Ƶ�static���������а���fill(),��ʾֻ����ͬһ�������������������������
 ����ֻ��List�������á�
 */
public class FillingList {
    public static void main(String[] args) {
        List<StringAddress> stringList = new ArrayList<StringAddress>(Collections.nCopies(4,new
                StringAddress("dongxiang")));
        System.out.println(stringList);
        Collections.fill(stringList,new StringAddress("genius!"));
        System.out.println(stringList);
    }

}
class StringAddress{
    private String string;
    StringAddress(String string){
        this.string = string;
    }
    public String toString(){
        return super.toString() + " " + string;
    }
}
