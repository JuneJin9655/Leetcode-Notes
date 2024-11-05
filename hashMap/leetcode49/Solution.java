package hashMap.leetcode49;
/*
For this problem, basically, we need to split each word and sort its characters, then put them back together
to create a new sorted word. Next, we use the computeIfAbsent function to check if this sorted word already
exists as a key in the map. If it does, we add the current word to the value associated with that key.
If it doesn’t, we create a new ArrayList, add the current word to it, and store it in the map with the
sorted word as the key.;
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedC = new String(c);

            map.computeIfAbsent(sortedC, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}