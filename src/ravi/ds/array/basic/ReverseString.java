package ravi.ds.array.basic;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString=new ReverseString();
        String name="My Name is Raviraj";
        System.out.println("Reverse is "+reverseString.reverse(name));
        System.out.println("Reverse better is "+reverseString.reverseBetter(name));
        System.out.println("Reverse with bulder "+ new StringBuilder(name).reverse());


    }

    private String reverse(String name) {

        char[] reverseNamArray = null;
        if(name!=null & name.length()>1) {
            reverseNamArray = new char[name.length()];
            char[] nameArray = name.toCharArray();
            for (int i = 0; i < nameArray.length; i++) {
                System.out.println("nameArray : "+nameArray[nameArray.length - i - 1]+ " on i "+i+"And reverse i "+(nameArray.length - i - 1));
                reverseNamArray[i] = nameArray[nameArray.length - i - 1];

            }

        }else{
            return "Reverse String dont makse sense";
        }
        return Arrays.toString(reverseNamArray);
    }

    private String reverseBetter(String name) {
        char[] reverseNamArray = null;

        if(name!=null & name.length()>1) {

            reverseNamArray=new char[name.length()];
            char[] nameArray=name.toCharArray();
            int left = 0;
            int right = name.length()-1;

            while (left < right) {
                System.out.println("nameArray[right] : "+nameArray[right]+ " on i "+left +"And reverse i "+right);

                reverseNamArray[left]=nameArray[right];
                reverseNamArray[right]=nameArray[left];
                left++;
                right--;
            }

        }else{
            return "Reverse String dont makse sense";
        }
        return Arrays.toString(reverseNamArray);
    }

}
