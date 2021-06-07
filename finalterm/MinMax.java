package finalterm;

import java.util.*;
import java.io.*;

public class minMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> reg = new Stack<>();
        Stack<Integer> min = new Stack<>();
        Stack<Integer> max = new Stack<>();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int val;

            if(input.length == 2) {
                val = Integer.parseInt(input[1]);
                reg.push(val);
                if (min.isEmpty() || min.peek() >= val) min.push(val);
                if (max.isEmpty() || max.peek() <= val) max.push(val);
            }

            else {
                System.out.println(min.peek() + " " + max.peek());
                val = reg.pop();
                if (min.peek() == val) min.pop();
                if (max.peek() == val) max.pop();
            }
        }
    }
}
