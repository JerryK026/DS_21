package midterm;

import java.util.*;
import java.io.*;

class input{
    int index;
    int val;

    public input(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

public class 최대값_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s1 = new Stack<>();
        Stack<input> s2 = new Stack<>();
        int count = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("Push")) {
                int val = Integer.parseInt(st.nextToken());
                s1.push(val);
                if(s2.empty() || s2.peek().val <= val) {
                    s2.push(new input(count, val));
                }
                count++;
            }
            else {
                int val = s1.pop();
                input inp = s2.peek();
                if(inp.val == val) {
                    inp = s2.pop();
                }
                System.out.println(inp.index + " " + inp.val);
            }
        }
    }
}