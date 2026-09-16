class Solution {
    public boolean isValid(String s) {
        Deque <Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '['){
                stack.push(ch[i]);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((ch[i] == ')' && top != '(') || (ch[i] == '}' && top != '{') || (ch[i] == ']' && top != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}