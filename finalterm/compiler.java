package finalterm;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class compiler {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Stack<Character> s = new Stack<>();
        boolean flag = true;
        boolean sflag = true;

        while ((input = br.readLine()) != null) {
            for(int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if((cur == '\'' || cur == '\"')) {
                    sflag = !sflag;
                    continue;
                }

                if(!sflag) continue;

                if (cur == '(' || cur == '[' || cur == '{') s.push(cur);

                else if (cur == ')') {
                    if (s.isEmpty() || s.peek() != '(') flag = false;
                    else s.pop();
                }
                else if (cur == ']') {
                    if (s.isEmpty() || s.peek() != '[') flag = false;
                    else s.pop();
                }
                else if (cur == '}') {
                    if (s.isEmpty() || s.peek() != '{') flag = false;
                    else s.pop();
                }
            }
        }

        if(!s.isEmpty()) flag = false;

        String result;
        if (flag) result = "No Error";
        else result = "Compile Error";

        System.out.println(result);

    }
}