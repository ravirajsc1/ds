package ravi.algo.dynamic;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class HouseRober {

    public static void main(String[] args) {
        HouseRober houseRober=new HouseRober();
        int[] housearray= new int[]{2,7,9,3,1};
        int[] housearray1= new int[]{2,7 ,9 ,3, 1, 8, 1, 10};
        int[] housearray2= new int[]{2,7,9,3,1,10};
        System.out.println("Max benift 1 = "+ houseRober.rob(housearray));
        System.out.println("Max benift 2 = "+ houseRober.robBetter(housearray1));
        System.out.println("Max benift 2 = "+ houseRober.rob(housearray2));
    }

    private int rob(int[] housearray) {
        int maxRob=0;
        for(int i=0;i<housearray.length;i++){
            int localRob=0;
            for(int j=i;j<housearray.length;j++,j++){
                localRob=localRob+housearray[j];
            }
            if(localRob>maxRob){
                maxRob=localRob;
            }
        }

        return maxRob;
    }


    public  int robBetter(int[] nums) {
        if (nums==null && nums.length==0){
            return 0;
        }else if (nums.length==1){
            return nums[0];
        }
        int prev1=0;
        int prev2=0;

        for(int num:nums){
            int temp=prev2;
            prev2=Math.max(prev1+num,prev2);
            prev1=temp;

        }
        return prev2;

    }

}
