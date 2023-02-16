package TryingSelf.Node;

import java.util.Arrays;

public class DynamicArray {
    private Object[] data;
    int initCapasity;

    int size;

    public DynamicArray( int initCapasity){
    this.initCapasity = initCapasity;
    data = new Object[initCapasity];
    }

    public String get( int index){
        return (String) data[index];
    }

    public void set( int index, String val){
        data[index] = val;
        size++;
    }

    public String print(){
        String[] printArr = new String[size];
        for (int i = 0; i < size; i++) {
            printArr[i] = (String) data[i];
        }
        return Arrays.toString(printArr);
    }

    public void insert(int index, String val){

        if(size == initCapasity){
            Object[] newArray = new Object[initCapasity*2];
            for (int i =0; i< initCapasity; i++){
                newArray[i] = data[i];
            }
            data = newArray;
            initCapasity = initCapasity * 2;
        }

        //do the actual insert
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = val;
        size++;
    }

    public void delete(int index){
        for (int i = index; i < size -1 ; i++) {
            data[i] = data[i+1];
        }
        data[size - 1] = null;
        size--;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(String value){

        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
         DynamicArray arr = new DynamicArray(5);

        System.out.println(arr.isEmpty());
        arr.set(0, "a");
        arr.set(1, "b");
        arr.set(2, "c");
        arr.set(3, "d");
        arr.set(4, "e");

        System.out.println(arr.isEmpty());
        System.out.println(arr.contains("e"));
        arr.delete(1);
        System.out.println(arr.print());
        System.out.println(arr.contains("z"));




    }

}


