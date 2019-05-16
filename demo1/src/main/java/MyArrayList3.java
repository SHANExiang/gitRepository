import javax.management.RuntimeErrorException;

/**
 * @author dongxiang
 *get()和set()方法
 * 索引越界处理
 */
public class MyArrayList3<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList3(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList3(int capacity){
        if (capacity < 0){
            throw new RuntimeException("容器的容量不能为负数!");
        }else if (capacity == 0){
            elementData = new Object[DEFALT_CAPACITY];
        }else{
            elementData = new Object[capacity];
        }


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

    //get()和set()方法
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }
    public void set(int index,E element){
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){
        //10 - 1
        if (index < 0||size <= index){
            throw new RuntimeException("索引不合法：" + index);
        }
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
        MyArrayList3 myArrayList3 = new MyArrayList3();
        for (int i = 0;i < 10;i++){
            myArrayList3.add("shane");
        }
        myArrayList3.set(5,"xiang");
        System.out.println(myArrayList3);
        System.out.println(myArrayList3.get(3));
    }
}
