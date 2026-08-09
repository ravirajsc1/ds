package ravi.algo.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy {

    public static void main(String[] args) {

        // jump game

        int[][] nums = {
                {3, 2, 2, 0, 1, 4},
                {2, 3, 1, 1, 9},
                {3, 2, 1, 0, 4},
                {0},
                {1},
                {4, 3, 2, 1, 0},
                {1, 1, 1, 1, 1},
                {4, 0, 0, 0, 1},
                {3, 3, 3, 3, 3},
                {1, 2, 3, 4, 5, 6, 7}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(nums[i]));
            if (jumpGame(nums[i]))
                System.out.println("\tCan we reach the very last index? True");
            else
                System.out.println("\tCan we reach the very last index? False");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //     // Boats to Save People

        int[][] people = {{1,1,1,1,2}, {3, 2, 2, 1}, {3, 5, 3, 4}, {5, 5, 5, 5}, {1, 2, 3, 4}, {1, 2, 3}, {3, 4, 5}};
        int[] limit = {3, 3, 5, 5, 5, 3, 5};

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "\tWeights = " + Arrays.toString(people[i]));
            System.out.println("\tWeight Limit = " + limit[i]);
            System.out.println("\tThe minimum number of boats required to save people are "
                    + rescueBoats(people[i], limit[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // gas station

        int[][] gas = {
                {1, 2, 3, 4, 5},
                {2, 3, 4},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 10},
                {1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5}
        };
        int[][] cost = {
                {3, 4, 5, 1, 2},
                {3, 4, 5},
                {1, 2, 3, 4, 5},
                {2, 2, 1, 3, 1},
                {1, 0, 1, 2, 3},
                {1, 2, 3, 4, 5}
        };
        for (int i = 0; i < cost.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGas: " + Arrays.toString(gas[i]));
            System.out.println("\tCost: " + Arrays.toString(cost[i]));
            System.out.println("\tThe index of the gas station we can start our journey from is "+ gasStationJourney(gas[i], cost[i])+ " (If it's -1, then that means no solution exists)");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


// two city Scheduling
        int[][][] inputCosts = {{{10, 20}, {30, 200}, {400, 50}, {30,20}},
                {{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}},
                {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779},{457, 60}, {650, 359}, {631, 42}},
                {{1, 2}, {3, 4}, {5, 6}, {7,8}},
                {{1, 2}, {1, 2}, {1, 2}, {1, 2}},
                {{10, 100}, {10, 1000}, {50, 500}, {1,100}}};

        for(int i=0;i < inputCosts.length;i++){
            System.out.println((i + 1)+ "\tcosts"+ Arrays.deepToString(inputCosts[i]));
            System.out.println("\n\tThe minimum cost to send people equally into city A and B is: "+ twoCityScheduling(inputCosts[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Minimum Number of Refueling Stops

        int[] target = {120, 15, 570, 1360};
        int[] startFuel = {10, 3, 140, 380};
        int[][][] stations = {
                {{10, 60},{20, 25},{30, 30},{60, 40}},
                {{2, 5},{3, 1},{6, 3},{12,6 }},
                {{140, 200}, {160, 130}, {310, 200}, {330, 250}},
                {{310, 160}, {380, 620}, {700, 89}, {850, 190}, {990, 360}}
        };
        for(int i=0;i<target.length;i++){
            System.out.print(i+1);
            System.out.println(".\tStations: "+Arrays.deepToString(stations[i]));
            System.out.println("\tTarget fuel: "+target[i]);
            System.out.println("\tStart fuel: "+startFuel[i]);
            System.out.println("\tMinimum number of Refueling stops: "+minRefuelStops(target[i], startFuel[i],stations[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

// Largest Palindromic Number

        String[] numbers = {"1234287", "00001", "9876545367282", "000000", "146"};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i + 1) + ".\tGiven number: \"" + numbers[i] + "\"");
            String result = largestPalindrome(numbers[i]);
            System.out.println("\n\tThe largest palindromic number: \"" + result + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //
        // Assign Cookies
        int[][] greedFactors = {
                {1, 2, 3},
                {10, 20, 30, 40 ,50 ,60 ,70, 80},
                {3, 4, 5, 6, 7, 8},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                {10, 9, 8, 7},
                {1000, 996, 867, 345, 23, 12}
        };

        int[][] cookieSizes = {
                {1, 1},
                {10, 20, 30, 40 ,50 ,60 ,70, 80, 90, 100},
                {1, 2},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                {5, 6, 7, 8},
                {}
        };

        for (int i = 0; i < greedFactors.length; i++) {
            int result = findContentChildren(greedFactors[i], cookieSizes[i]);
            System.out.println((i + 1) + ".\tGreed factors: " + Arrays.toString(greedFactors[i]));
            System.out.println("\tCookie sizes: " + Arrays.toString(cookieSizes[i]));
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] basket1List = {
                {4, 2, 2, 2},
                {2, 3, 4, 1},
                {84, 80, 43, 8, 80, 88, 43, 14, 100, 88},
                {1, 2, 2, 3, 3, 4},
                {4, 4, 4, 4, 3}
        };

        int[][] basket2List = {
                {1, 4, 1, 2},
                {3, 2, 5, 1},
                {32, 32, 42, 68, 68, 100, 42, 84, 14, 8},
                {1, 1, 2, 3, 4, 4},
                {5, 5, 5, 5, 3}
        };



        for (int i = 0; i < basket1List.length; i++) {
            System.out.print((i + 1) + ".\t Basket 1 = " + Arrays.toString(basket1List[i]));
            System.out.print("\n\t Basket 2 = " + Arrays.toString(basket2List[i]));
            long result = minCostToRearrangeFruits(basket1List[i], basket2List[i]);
            System.out.println("\n\n\t Minimum cost to rearrange fruits in the two baskets is " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Number of Steps to Reduce a Binary Number to One
        List<String> strings = Arrays.asList(
                "1011",
                "111",
                "100",
                "1",
                "10"
        );

        for (int i = 0; i < strings.size(); ++i) {
            System.out.println((i + 1) + ".\tstr: " + strings.get(i));
            System.out.println();
            System.out.println("\tsteps: " + numSteps(strings.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }


        int[] numsMax = { 2736, 87654, 1643, 123, 14};

        for (int i = 0; i < numsMax.length; i++) {
            System.out.println((i + 1) + ".\tNumber: " + numsMax[i]);
            System.out.println("\n\tLargest number after swapping: " + maximumSwap(numsMax[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        int[][] flowerbeds = {
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
        };

        int[] n = {2, 1, 6, 2, 3};

        for (int i = 0; i < flowerbeds.length; i++) {
            System.out.println((i + 1) + ".\tFlower bed: " + Arrays.toString(flowerbeds[i]));
            System.out.println("\tn: " + n[i]);
            System.out.println("\n\tFlowers planted: " + canPlaceFlowers(flowerbeds[i], n[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Largest Odd Number in String
        List<String> testCases = new ArrayList<>();
        testCases.add("345679");  // Example with multiple odd digits
        testCases.add("357");     // Example with all odd digits
        testCases.add("2468");    // Example with no odd digit
        testCases.add("5");       // Example with a single odd digit
        testCases.add("74");      // Example with one odd and one even digit
        testCases.add("4597680"); // Example with even digits at the end

        for (int i = 0; i < testCases.size(); i++) {
            String testCase = testCases.get(i);
            String result = largestOddNumber(testCase);

            System.out.println((i + 1) + ".\tnum: " + testCase);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] testCaseses = {
                {1, 0, 2},
                {1, 2, 2},
                {1, 3, 4, 5, 2},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1}
        };

        for (int i = 0; i < testCaseses.length; i++) {
            System.out.println((i + 1) + "\tratings = " + Arrays.toString(testCaseses[i]));
            int result = candy(testCaseses[i]);
            System.out.println("\tMinimum candies = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Minimum Replacements to Sort the Array

        int[][] testCasesMin = {
                {3, 9, 3},
                {1, 2, 3, 4, 5},
                {5, 6, 7},
                {10, 5, 1},
                {1000000000, 1}
        };

        for (int i = 0; i < testCasesMin.length; i++) {
            int[] numsMin = testCasesMin[i];
            System.out.println("\tnums: " + java.util.Arrays.toString(numsMin));
            long result = minimumReplacement(numsMin);  // store in long
            System.out.println("\tMinimum operations: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Jump Game II



    }




    // Best Time to Buy and Sell Stock

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price<minPrice)
                minPrice=price;
            else{
                maxProfit=Math.max(maxProfit,price-minPrice);
            }
        }
        return maxProfit;
    }
    //Jump Game II



    public static int jumpGame2(int[] nums) {

        // Replace this placeholder return statement with your code
       int furthest=0;
       int end=0;
       int steps=0;
       for(int i=0;i<nums.length;i++){
           furthest=Math.max(furthest,i+nums[i]);

           if(i==end){
               steps++;
               end=furthest;
           }


       }
       return steps;
    }

    // Minimum Replacements to Sort the Array

    public static long minimumReplacement(int[] ratings) {

        int steps=0;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                int k= (ratings[i]+ratings[i+1]-1)/ratings[i+1];
                steps+=k-1;
                ratings[i]=ratings[i]/k;
            }

        }
        // Replace this placeholder return statement with your code
        return steps;
    }


    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
                }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i],candies[i+1]+1);

            }
        }


        return Arrays.stream(candies).sum();
    }




// Largest Odd Number in String
    public static String largestOddNumber (String num) {


        char[] digits=num.toCharArray();
        for(int i=digits.length-1;i>=0;i--){
            if((digits[i]-'0')%2==1) {
                 return num.substring(0,i+1);
            }
        }

        // Replace this placeholder return statement with your code
        return "";
    }



    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


            int count=0;

        for(int i=0;i<flowerbed.length;i++){

            if(flowerbed[i]==0) {
                boolean left = (i == 0 || flowerbed[i - 1] == 0);
                boolean right = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                if (left && right) {
                    flowerbed[i] = 1;
                    count++;
                    if (count == n) {
                        return true;
                    }
                }
            }
        }


        // Replace this placeholder return statement with your code
        return count>n?true:false;
    }


    public static int maximumSwap(int num) {
        String numbers=Integer.toString(num);
        char[] digits=numbers.toCharArray();

        // Replace this placeholder return statement with your code
        int localMax=-1;
        int localMin=-1;
        int maxIndex=digits.length-1;
        for(int i=digits.length-2;i>=0;i--) {
            if(digits[i]>=digits[maxIndex]){
                maxIndex=i;
            }else{
                localMax=maxIndex;
                localMin=i;
            }

        }

        if(localMin!=localMax) {
            char temp = digits[localMax];
            digits[localMax] = digits[localMin];
            digits[localMin] = temp;
        }


        String result=new String(digits);

        return Integer.valueOf(result);
    }



// Number of Steps to Reduce a Binary Number to One
/*
* The greedy solution follows the idea of minimizing operations, and it mirrors how binary addition and division work:

Dividing a binary number by 2 is like removing the last bit (shifting right).

Adding 1 may introduce a carry, which can propagate to higher bits (like in normal binary addition).

| i (index) | str.charAt(i) | c (carry before) | digit = bit + c | Action                                 | steps added | steps total | c (updated) | Binary after iteration (carry applied) |
| --------- | ------------- | ---------------- | --------------- | -------------------------------------- | ----------- | ----------- | ----------- | -------------------------------------- |
| 3         | '0'           | 0                | 0 + 0 = 0       | Even → divide by 2 (steps += 1)        | 1           | 1           | 0           | 1110 → divide by 2 → 111               |
| 2         | '1'           | 0                | 1 + 0 = 1       | Odd → add 1 + divide by 2 (steps += 2) | 2           | 3           | 1           | 111 → add 1 → 1000                     |
| 1         | '1'           | 1                | 1 + 1 = 2       | Even → divide by 2 (steps += 1)        | 1           | 4           | 1           | 1000 → divide by 2 → 100               |
| 0         | '1'           | 1                | 1 + 1 = 2       | Even → divide by 2 (steps += 1)        | 1           | 5           | 1           | 100 → divide by 2 → 10                 |

* */
    public static int numSteps (String str) {
        // Replace this placeholder return statement with your code
        char[] chars=str.toCharArray();
        int c=0;
        int step=0;
        for(int i=chars.length-1;i>0;i--){
            int digit=(chars[i]-'0')+c;
            if(digit%2==1){
                c=1;
                step+=2;
            }else{
                step+=1;
            }

        }
        return step+c;
    }


// Rearranging Fruits

    public static long minCostToRearrangeFruits(int[] basket1, int[] basket2) {

        // Replace the following return statement with your code

        int[] combined= new int[basket1.length+basket2.length];
        System.arraycopy(basket1,0,combined,0,basket1.length);
        System.arraycopy(basket2,0,combined,basket1.length,basket2.length);

        Map<Integer,Integer> comintedCounter=new HashMap<>();
        Map<Integer,Integer> counter1=new HashMap<>();
        Map<Integer,Integer> counter2=new HashMap<>();

        for(int c:combined){
            comintedCounter.put(c,comintedCounter.getOrDefault(c,0)+1);
        }

        for(int value:comintedCounter.values()){
            if(value%2==1){
                return -1;
            }
        }
        for(int c:basket1){
            counter1.put(c,counter1.getOrDefault(c,0)+1);
        }

        for(int c:basket2){
            counter2.put(c,counter2.getOrDefault(c,0)+1);
        }

        List<Integer> access1=new ArrayList<>();
        List<Integer> access2=new ArrayList<>();

        for(int key:comintedCounter.keySet()){
            int count1=counter1.getOrDefault(key,0);
            int count2=counter2.getOrDefault(key,0);
            int diff=count1-count2;
            if(diff>0){
                for(int i=0;i<diff/2;i++){
                    access1.add(key);
                }
            }else if(diff<0){
                for(int i=0;i< (-diff)/2;i++){
                    access2.add(key);
                }

            }
        }

        Collections.sort(access1);
        Collections.sort(access2,Collections.reverseOrder());

        int minFruit=Integer.MAX_VALUE;
        for(int furit:comintedCounter.keySet()){
            minFruit=Math.min(minFruit,furit);
        }

        int mincost=0;
        for(int i=0;i<access1.size();i++){
            mincost+=Math.min(2*mincost,Math.min(access1.get(i),access2.get(i)));

        }

        return mincost;
    }


    // Assign Cookies
    public static int findContentChildren(int[] greedFactors, int[] cookieSizes) {

        // Replace this placeholder return statement with your code
        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);
        int kid=0;
        int cookieSie=0;
        while(kid<greedFactors.length && cookieSie<cookieSizes.length) {
            if(cookieSizes[cookieSie]>=greedFactors[kid]) {
                 kid++;
                cookieSie++;
            }else {
                cookieSie++;
            }
        }

        return kid;
    }


    // Largest Palindromic Number

    public static String largestPalindrome(String num) {

        // Replace this placeholder return statement with your code
        Map<Character,Integer> map=new HashMap<>();
        char[] numbers=num.toCharArray();
        for(char ch:numbers){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        List<String> firsthalf=new ArrayList<>();
        String middle="";
        for(char digit='9'; digit >= '0' ; digit--){
            if(map.containsKey(digit)){


                int digitCounts=map.get(digit);


                int pairs=digitCounts/2;

                if(pairs>0) {

                    if (firsthalf.isEmpty() && digit == '0') {
                        continue;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < pairs; i++) {
                            sb.append(digit);
                        }
                        firsthalf.add(sb.toString());

                    }
                }

                if(digitCounts%2==1 && middle.isEmpty()){
                    middle=Character.toString(digit);

                }

            }
        }

        if(firsthalf.isEmpty() && middle.isEmpty()){
            return "0";
        }
        String firstString=firsthalf.stream().collect(Collectors.joining());

        StringBuilder finalresult=new StringBuilder(firstString);
        finalresult.append(middle).append(new StringBuilder(firstString).reverse());
        return finalresult.toString();
    }



    // Minimum Number of Refueling Stops
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Replace this placeholder return statement with your code
        if(target<=startFuel){
            return 0;
        }
        PriorityQueue<Integer> maxFuel=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        int stop=0;
        int n=stations.length;
        int maxDistance=startFuel;
        while(target >maxDistance){

            if( i<n && stations[i][0] <= maxDistance ){
                maxFuel.offer(stations[i][1]);
                i++;
            }else  if(maxFuel.isEmpty()){
                return -1;
            }else{
                maxDistance+=maxFuel.poll();
                stop++;
            }

        }


        return stop;
    }



// Two City Scheduling

    public static int twoCityScheduling(int[][] costs) {
        // Replace this placeholder return statement with your code

        if(costs.length==0)
            return -1;


        int minCost=0;
        Arrays.sort(costs,(a,b)-> ((a[0]-a[1])-(b[0]-b[1])));

        int left=0, right=costs.length-1;

        while(left<right){
            minCost+=costs[left][0]+costs[right][1];
            left++;
            right--;
        }

        return minCost;

    }


// Gas Station
    public static int gasStationJourney(int[] gas, int[] cost) {

        // Replace this placeholder return statement with your code

        if(Arrays.stream(cost).sum()> Arrays.stream(gas).sum()){
            return -1;
        }
        int gasSum=0;
        int startignIndex=0;

        for(int i=0;i<gas.length;i++){

            gasSum+=gas[i]-cost[i];
            if(gasSum<0){
                startignIndex=i+1;
                gasSum=0;
            }

        }


        return startignIndex;
    }
    // jump game

    public static boolean jumpGame(int[] nums) {

        int targetIndex=nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if(targetIndex <= i+nums[i]){
                targetIndex=i;
            }
        }

        if(targetIndex==0){
            return true;
        }
        // Replace this placeholder return statement with your code
        return false;
    }


    // Boats to Save People

    public static int rescueBoats(int[] people, int limit) {

        // Replace the placeholder return statement below with your code
        Arrays.sort(people);
       int boatCount=0;
       int left=0,right=people.length-1;
       while(left<=right){
           if(people[left]+people[right]<=limit){
               left++;
           }
           right--;
           boatCount++;

       }


        return boatCount;
    }


}