package ravi.ds.map;

import java.util.HashMap;
import java.util.HashSet;

public class CheckMap {


    public static void main(String[] args) {
        int[] firstArray= new int[]{2,3,1,3,4,3,2};
        int[] secondArray= new int[]{2,1,1,2,4,3,2};
        int[] thirdArray= new int[]{1,3,4,5};
        CheckMap checkMap=new CheckMap();

        System.out.println("repeated element in Array1 "+checkMap.checkifExisting(firstArray));
        System.out.println("repeated element in Array2 "+checkMap.checkifExisting(secondArray));
        System.out.println("repeated element in Array3 "+checkMap.checkifExisting(thirdArray));
    }

    public Integer checkifExisting(int[] input){
        HashSet<Integer> elements= new HashSet<>();
        if(input==null || input.length<1) {
            System.out.println("Wrong input");
        }else{
            for(int element:input){
                if(elements.contains(element)){
                    return element;
                }else{
                    elements.add(element);
                }

            }

        }
        return null;
    }
}
