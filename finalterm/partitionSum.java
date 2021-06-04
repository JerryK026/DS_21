package finalterm;

import java.util.*;
import java.io.*;

public class partitionSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        sum[0] = 0;
        for(int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(-sum[Integer.parseInt(st.nextToken()) - 1] + sum[Integer.parseInt(st.nextToken())]);
        }
    }
}