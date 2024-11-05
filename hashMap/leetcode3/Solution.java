package hashMap.leetcode3;
/*
For this problem, we basically need to use a two-pointer sliding window approach. First, we traverse from
left to right and store each character in a HashSet. Meanwhile, we check if we encounter a character that
already exists in the HashSet. If we find a duplicate, we remove characters from the left until the
duplicate is gone. It's important to use a while loop here because there may be multiple duplicate
characters that need to be removed.;
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
