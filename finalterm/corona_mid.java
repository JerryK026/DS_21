package finalterm;

import java.util.*;
import java.io.*;

public class corona_mid {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inspector = new int[st.countTokens()];
        for (int i = 0; st.hasMoreTokens(); i++) {
            inspector[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inspector);

        int right = inspector[inspector.length - 1] * M;
        int left = 1;
        int mid = 0;
        int result = right;

        while (left <= right) {
            mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < inspector.length; i++) {
                cnt += mid / inspector[i] - mid / inspector[i] / 11;
            }

            if(cnt >= M) {
                right = mid - 1;
                if(result > mid) result = mid;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}