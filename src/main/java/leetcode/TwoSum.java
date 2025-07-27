package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){

    }
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int needed = target - nums[i];
            if (hashTable.containsKey(needed)) {
                return new int[] {hashTable.get(needed), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
