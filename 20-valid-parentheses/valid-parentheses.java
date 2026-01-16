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

        return stack.isEmpty();
    }
}
/*
[      }              ]
if having opening brakce
=> push closing bracket in stack

Otherwise (Checking stakci empty and stack.pop() with current char)
*/