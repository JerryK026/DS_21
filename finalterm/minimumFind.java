package finalterm;

import java.util.*;
import java.io.*;

public class minimumFind {
    static class State {
        int count;
        int value;

        State(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Stack<State> minStack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int count = 1;

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input.length == 2) {
                int value = Integer.parseInt(input[1]);
                stack.push(value);
                if(minStack.size() == 0) {
                    minStack.push(new State(count, value));
                }
                else {
                    if(minStack.peek().value >= value) {
                        minStack.push(new State(count, value));
                    }
                }
                count++;
            }
            else {
                State cur = minStack.peek();
                int comp = stack.pop();
                System.out.println(cur.count + " " + cur.value);
                if(comp == minStack.peek().value) {
                    minStack.pop();
                }
            }
        }
    }
}