public class MyArrayList1<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList1(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList1(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
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
        MyArrayList1 myArrayList1 = new MyArrayList1();
        myArrayList1.add("aa");
        myArrayList1.add("bb");
        myArrayList1.add("cc");
        System.out.println(myArrayList1);
    }

}
