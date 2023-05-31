package Bitset.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

    /**
     * LeetCode 78
     * Medium
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < Math.pow(2,n); i++) {
            List<Integer> internal = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    internal.add(nums[j]);
                }
            }
            result.add(internal);
        }
        return result;
    }
}
