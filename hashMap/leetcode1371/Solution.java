package hashMap.leetcode1371;
/*
In this problem, we use currentState to track the parity of each vowel. When we encounter the same currentState in the
map again, it indicates that the substring from the previous occurrence of this state up to the current index meets the
requirements. If currentState is new, we add it to the map to reference if it appears again later.
*/

class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentState = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a'){
                currentState ^= 1 << 0;
            }else if(c == 'e'){
                currentState ^= 1 << 1;
            }else if(c == 'i'){
                currentState ^= 1 << 2;
            }else if(c == 'o'){
                currentState ^= 1 << 3;
            }else if(c == 'u'){
                currentState ^= 1 << 4;
            }
            if(map.containsKey(currentState)){
                maxLength = Math.max(maxLength, i - map.get(currentState));
            }else{
                map.put(currentState, i);
            }
        }
        return maxLength;
    }
}
