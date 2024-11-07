package hashMap.leetcode128;
/*
For this problem, we need to traverse each number until we find a starting number. A starting number is
one that has no consecutive number before it (i.e., num - 1 does not exist in the set). Once we find a
starting number, we continue to check the consecutive numbers after it (i.e., num + 1, num + 2, and so on)
until the sequence ends.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longestStreak = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}