package midterm;

import java.util.*;
import java.io.*;

public class 계산기 {
    static int rank(String oper) {
        if(oper.equals("+") || oper.equals("-")) {
            return 2;
        }
        else if(oper.equals("*") || oper.equals("/") || oper.equals("%")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    static int calculate(String oper, int num2, int num1) {
        int result = 0;
        if(oper.equals("+")) {
            result = num1 + num2;
        }
        else if(oper.equals("-")) {
            result = num1 - num2;
        }
        else if(oper.equals("*")) {
            result = num1 * num2;
        }
        else if(oper.equals("/")) {
            result = (int) (num1 / num2);
        }
        else {
            result = (int) Math.round(Math.pow(num1, num2));
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<>();
        int result = Integer.parseInt(st.nextToken());
        int num = 0;
        sb.append(result);

        while(st.hasMoreTokens()) {
            String oper = st.nextToken();
            num = Integer.parseInt(st.nextToken());
            if(s.empty()) {
                s.push(oper);
                sb.append(" " + num);
            }
            else if(rank(oper) >= rank(s.peek())) {
                String tmp = s.pop();
                sb.append(" " + tmp + " " + num);
                s.push(oper);
            }
            else if(rank(oper) < rank(s.peek())){
                sb.append(" " + num + " " + oper );
            }
        }

        if(!s.empty()) {
            String tmp = s.pop();
            sb.append(" " + tmp);
        }

        System.out.println(sb.toString());
        st = new StringTokenizer(sb.toString());

        while(st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if(Character.isDigit(tmp.charAt(0))) {
                s.push(tmp);
            }
            else {
                result = calculate(tmp, Integer.parseInt(s.pop()), Integer.parseInt(s.pop()));
                s.push(Integer.toString(result));
            }
        }
        System.out.println(s.pop());
    }
}