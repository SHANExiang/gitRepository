/**
 * @author dongxiang
 * remove()方法
 */
public class MyArrayList4<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList4(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList4(int capacity){
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

    //remove()方法
    public void remove(E element){
        for (int i = 0;i < size;i++){
            if (elementData[i].equals(element)){
                remove(i);
            }
        }
    }
    public void remove(int index){
        System.arraycopy(elementData,index + 1,elementData,index,elementData.length - index - 1);
        elementData[--size] = null;
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
        MyArrayList4 myArrayList4 = new MyArrayList4();
        for (int i = 0;i < 10;i++){
            myArrayList4.add("shane" + i);
        }
        System.out.println(myArrayList4);
        myArrayList4.remove(4);
        myArrayList4.remove("shane7");
        System.out.println(myArrayList4);
    }
}
