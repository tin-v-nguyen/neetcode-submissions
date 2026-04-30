class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } 
            else if (stack.isEmpty()) return false; 
            else {
                
                switch (c) {
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                }     
            }
        }
        return stack.isEmpty();
        
    }
}
