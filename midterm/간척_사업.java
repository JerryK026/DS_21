package midterm;

import java.util.*;
import java.io.*;

public class 간척_사업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] ground = new int[N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            ground[start] += val;
            if(end != N) {
                ground[end] -= val;
            }
        }

        long[] sum = new long[N + 1];

        for(int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + ground[i - 1];
        }

        Arrays.sort(sum);
        System.out.println(sum[sum.length - 1]);
    }
}