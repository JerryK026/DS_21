package finalterm;

import java.util.*;
import java.io.*;

public class findMax {

    static class state {
        int cnt;
        int val;

        state (int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        Stack<state> ms = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        String[] input;
        for(int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int val;
            if (input.length == 2) {
                val = Integer.parseInt(input[1]);
                s.push(val);
                if(ms.isEmpty() || ms.peek().val <= val) ms.push(new state(cnt, val));
                cnt++;
            }

            else {
                System.out.println(ms.peek().cnt + " "+ ms.peek().val);
                val = s.pop();
                if(val == ms.peek().val) ms.pop();
            }
        }


    }
}