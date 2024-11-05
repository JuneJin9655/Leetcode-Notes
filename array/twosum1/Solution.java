package array.twosum1;
/*
For this problem, we're going to use a HashMap. First of all, we need to traverse each nums[index].
Then, if the map contains the complement, which is target - nums[index],
it means there's a pair in the array that sums up to the target. If it doesn't,
we store the current number and its index in the map to match up with the corresponding complements later.
 time complex = O(n), for worst case, if hashmao doesnt find the two nums, then map need to store n Values
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
