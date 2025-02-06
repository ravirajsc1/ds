package ravi.ds.array.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private int size;

    public static void main(String[] args) {
        MyArrayList<String> myArrayList=new MyArrayList<>();
        myArrayList.add("Ravi");
        myArrayList.add("Chundawat");
        System.out.println("myArray addition "+myArrayList.size);
        myArrayList.add(1,"Singh");
        System.out.println("My addition with index "+myArrayList.size);
        System.out.println("get middelName "+myArrayList.get(1));
    }

    Object[] elements=null;


    public T get(int index){
        return (T) this.elements[index];
    }


    public MyArrayList() {
        ArrayList<String> test=new ArrayList<>();
        this.elements= new Object[]{};
        this.size=0;

    }

    public void add(T element) {
        //   this.elements[this.size] = element;
           this.elements=Arrays.copyOf(this.elements,++this.size);
           //this.size++;

    }

    public void add(int index, T elment){
        if(index==size){
            this.add(elment);
        }else{
            int newSize=0;

            Object[] newList=new Object[this.size+1];
            for( Object element:this.elements){

                         if(newSize==index){
                            newList[newSize]=elment;
                            newSize++;
                            newList[newSize]=element;
                        }else{
                             newList[newSize] = element;
                         }
                        newSize++;
            }
            this.elements=newList;
            this.size=newSize;
        }

    }

    public void remove(){

    }

}
