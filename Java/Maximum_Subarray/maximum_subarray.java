//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.

//Kadane's Algorithm
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0],maxEndingHere = nums[0];
        for(int i=1;i<nums.length;++i){
	        maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
	        max = Math.max(maxEndingHere,max);
        }
        return max;
    }
}