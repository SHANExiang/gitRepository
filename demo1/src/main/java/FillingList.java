package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Collections类有一些类似的static方法，其中包括fill(),表示只复制同一个对象引用来填充整个容器，
 并且只对List对象有用。
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
