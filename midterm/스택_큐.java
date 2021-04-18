package midterm;

import java.util.*;
import java.io.*;

public class 스택_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if(st.nextToken().equals("Stack")) {
            Stack<Integer> s = new Stack<>();
            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int state = Integer.parseInt(st.nextToken());
                if(state == 0) {
                    System.out.println(s.size());
                }
                else if(state == 1) {
                    System.out.println(s.peek());
                }
                else if(state == 2) {
                    s.pop();
                }
                else {
                    s.push(Integer.parseInt(st.nextToken()));
                }
            }
        }
        else {
            Queue<Integer> q = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int state = Integer.parseInt(st.nextToken());
                if(state == 0) {
                    System.out.println(q.size());
                }
                else if(state == 1) {
                    System.out.println(q.peek());
                }
                else if(state == 2) {
                    q.poll();
                }
                else {
                    q.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}