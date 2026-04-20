class Solution {
    public boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> matchingParenthesis = new HashMap<>();
        matchingParenthesis.put(')', '(');
        matchingParenthesis.put('}', '{');
        matchingParenthesis.put(']', '[');
        for (char ch : expression.toCharArray()) {
            if (matchingParenthesis.containsValue(ch)) stack.push(ch);
            else if (matchingParenthesis.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != matchingParenthesis.get(ch)) return false;
            }
        }
        return stack.isEmpty();
    }
}