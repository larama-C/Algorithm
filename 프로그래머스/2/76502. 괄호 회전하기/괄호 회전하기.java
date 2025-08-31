import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(i == 0)
            {
                sb.append(s);
            }
            else
            {
                char t = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(t);
            }
            
            if(isValid(sb.toString()))
            {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) 
        {
            if (c == '(' || c == '{' || c == '[') 
            {
                stack.push(c);
            } 
            else if (c == ')') 
            {
                if (stack.isEmpty() || stack.pop() != '(') 
                {
                    return false;
                }
            } 
            else if (c == '}') 
            {
                if (stack.isEmpty() || stack.pop() != '{') 
                {
                    return false;
                }
            } 
            else if (c == ']') 
            {
                if (stack.isEmpty() || stack.pop() != '[') 
                {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}