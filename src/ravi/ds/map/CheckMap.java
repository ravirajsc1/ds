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

        System.out.println("repeated element in Array1 "+checkMap.checkifExistiingInloop(firstArray));
        System.out.println("repeated element in Array2 "+checkMap.checkifExistiingInloop(secondArray));
        System.out.println("repeated element in Array3 "+checkMap.checkifExistiingInloop(thirdArray));


    }

    // check if a element comes second time
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

    public Integer checkifExistiingInloop(int[] input){
        if(input==null || input.length<1) {
            System.out.println("Wrong input");
        }else {
            for(int i=1;i<input.length;i++){
                for(int j=i-1;j>=0;j--){
                    if(input[i]==input[j]){
                        return input[i];
                    }
                }
            }
        }
            return null;
    }
}
