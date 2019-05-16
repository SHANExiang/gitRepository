/**
 * @author dongxiang
 * @param <E>
 * 扩容操作
 */
public class MyArrayList2<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList2(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList2(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        //什么时候扩容？
        if (size == elementData.length){
            //扩容操作
            Object[] newMyArray2 = new Object[elementData.length + (elementData.length>>1)];//10+10/2
            System.arraycopy(elementData,0,newMyArray2,0,elementData.length);
            elementData = newMyArray2;
        }
        elementData[size++] = element;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0;i< size;i++){
            stringBuffer.append(elementData[i] + ",");
        }
        stringBuffer.setCharAt(stringBuffer.length() - 1,']');
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        MyArrayList2 myArrayList2 = new MyArrayList2();
        for (int i =0;i<40;i++){
            myArrayList2.add("shane");
        }
        System.out.println(myArrayList2);
    }
}
