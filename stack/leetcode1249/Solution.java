package stack.leetcode1249;
/*
For this problem, we’ll use two data structures: a stack and a HashSet. In the stack, we’ll store left
parentheses and any extra ones that might end up unused. The HashSet will mainly hold right parentheses
that don’t match and any unmatched left parentheses from the stack. Finally, as we go through the string s,
if a character is in the HashSet, we skip it; otherwise, we add it to the result.
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    indexesToRemove.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            indexesToRemove.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!indexesToRemove.contains(i)){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
