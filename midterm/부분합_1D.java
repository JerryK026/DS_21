package midterm;

import java.util.*;
import java.io.*;

public class 부분합_1D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];
        int[] sum = new int[N + 1];

        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i + 1] = sum[i] + num[i];
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(-(sum[Integer.parseInt(st.nextToken()) - 1]) + sum[Integer.parseInt(st.nextToken())]);
        }
    }
}