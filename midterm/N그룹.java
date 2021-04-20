package midterm;

import java.util.*;
import java.io.*;

public class N그룹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String>[] set = new HashSet[Integer.parseInt(st.nextToken())];
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < set.length; i++) {
            set[i] = new HashSet<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            HashSet h = set[Integer.parseInt(st.nextToken())];
            h.add(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String kinds = st.nextToken();
            HashSet<String> result = new HashSet<>();
            result.addAll(set[Integer.parseInt(st.nextToken())]);

            if (kinds.equals("U")) {
                result.addAll(set[Integer.parseInt(st.nextToken())]);
                result.addAll(set[Integer.parseInt(st.nextToken())]);
            }
            else if (kinds.equals("I")) {
                result.retainAll(set[Integer.parseInt(st.nextToken())]);
                result.retainAll(set[Integer.parseInt(st.nextToken())]);
            }
            else {
                result.removeAll(set[Integer.parseInt(st.nextToken())]);
                result.removeAll(set[Integer.parseInt(st.nextToken())]);
            }

            System.out.println(result.size());
        }


    }
}
