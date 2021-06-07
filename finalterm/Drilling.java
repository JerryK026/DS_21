package finalterm;

import java.io.*;
import java.util.*;

public class Drilling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[] soil = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            soil[from] += val;
            soil[to] -= val;
        }

        long[] sum = new long[N + 1];
        for (int i = 1; i < N; i++) {
            sum[i] = soil[i - 1] + sum[i - 1];
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            if(result < sum[i]) result = sum[i];
        }

        System.out.println(result);
    }
}