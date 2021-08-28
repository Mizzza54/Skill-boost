package task15DontWork;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] tempNums = new int[nums.length - 1];
            for (int j = 0, k = 0; j < nums.length - 1; j++, k++) {
                if (i == k) {
                    k++;
                }
                tempNums[j] = nums[k];
            }
            for (List<Integer> list: twoSum(tempNums, -nums[i])) {
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                List<Integer> answer = new ArrayList<>();
                answer.add(map.get(num));
                answer.add(i);
                result.add(answer);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
