class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0 ;
        int j = s.length();

        for(i = 0 ; i < j; i++){
            char s1 = s.charAt(i);

            if(s1 == '(' || s1 == '[' || s1 == '{'){
                stack.push(s1);
            }
            else if(s1 == ')' || s1 == ']' || s1 == '}'){
                if(stack.isEmpty() == true){
                    return false;
                }

                char top = stack.peek();
                if(
                    s1 == ')' && top == '('|| 
                    s1 == ']' && top == '['|| 
                    s1 == '}' && top == '{'
                   )
                {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        if(stack.isEmpty() == true){
            return true;
        }
        return false;
    }
}
