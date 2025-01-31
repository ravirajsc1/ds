package ravi.ds.array.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


// this function return true or false if any element in first array match with element in second array
public class ContainCommonITem {
        public static void main(String[] str){
            String[] array1= new String[]{"a","b","c","x"};
            String[] array2=new String[]{"z","m","c"};
          //  array1=null;
            System.out.println("Result1 : ="+checkCommonItem(array1,array2));
            System.out.println("Result2 : ="+checkCommonItem2(array1,array2));
            System.out.println("Result3 : ="+checkCommonItem3(array1,array2));
            System.out.println("Result3 : ="+checkCommonItem4(array1,array2));

        }

        public static boolean checkCommonItem(String[] str1, String[] str2){
            if(!isInputsValiate(str1,str2)){
                System.out.println("Please input valid parameter");
                return false;
            }
            boolean result=false;
            for(String outer:str1){
                for(String inner:str2){
                    if (outer.equals(inner)){
                        result =true;
                        return result;
                    }
                }
            }
            return result;
        }

    public static boolean isInputsValiate(String[] str1, String[] str2) {
        return str1 != null && str2 != null && str1.length > 0 && str2.length > 0;

    }

    public static boolean checkCommonItem2(String[] str1, String[] str2){
        if(!isInputsValiate(str1,str2)){
            System.out.println("Please input valid parameter");
            return false;
        }
        return Arrays.stream(str1).anyMatch(element-> Arrays.stream(str2).anyMatch(element::equals));
    }

    public static <hashmap> boolean checkCommonItem3(String[] str1, String[] str2){
        if(!isInputsValiate(str1,str2)){
            System.out.println("Please input valid parameter");
            return false;
        }
            HashMap<java.lang.String, Boolean> map=new HashMap<String, Boolean>();

            for(int i = 0; i<str1.length; i++){
                if(str1[i]!=null && (Objects.isNull(map.get(str1[i])) || !map.get(str1[i]))) {
                  map.put(str1[i],true);

                }
            }
                System.out.println(map);
            for(int i=0;i <str2.length;i++) {
                if(str2[i]!=null && Objects.nonNull(map.get(str2[i])) && map.get(str2[i])){
                    return true;
                }

            }
        return false;
        }

   public static boolean  checkCommonItem4(String[] str1, String[] str2){
       if(!isInputsValiate(str1,str2)){
           System.out.println("Please input valid parameter");
           return false;
       }
            HashMap<String, Boolean> map= new HashMap<String, Boolean>();
       Arrays.stream(str1).forEach(str-> map.put(str,true));
       System.out.println(map);
        return Arrays.stream(str1).anyMatch(element-> Arrays.stream(str2).anyMatch(element::equals));
    }
}
