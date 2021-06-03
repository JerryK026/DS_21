package finalterm;

import java.util.*;
import java.io.*;

public class NGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String>[] ngroup;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ngroup = new HashSet[N];
        for(int i = 0; i < N; i++) {
            ngroup[i] = new HashSet<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            ngroup[idx].add(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            int tmp = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            int tmp3 = Integer.parseInt(st.nextToken());
            HashSet<String> s = new HashSet<>();

            s.addAll(ngroup[tmp]);
            if(cur.equals("U")) {
                s.addAll(ngroup[tmp2]);
                s.addAll(ngroup[tmp3]);
            }
            else if(cur.equals("I")) {
                s.retainAll(ngroup[tmp2]);
                s.retainAll(ngroup[tmp3]);
            }
            else {
                s.removeAll(ngroup[tmp2]);
                s.removeAll(ngroup[tmp3]);
            }

            System.out.println(s.size());
        }
    }
}