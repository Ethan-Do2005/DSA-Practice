class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }

            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return (stack.isEmpty());
    }
}
/*
Stack: LIFO
()[]{}
[     ]

if condition => opening bracket
push(closing bracket with same type) in stack

else if(stack.isEmpty() || pop != char)
    false
*/