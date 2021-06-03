package finalterm;

import java.util.*;
import java.io.*;

public class SelectSniper {
    static class Sniper implements Comparable<Sniper>{
        String name;
        int score;

        Sniper(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Sniper s) {
            return s.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Sniper> snipers = new ArrayList<>();

        String input;
        while ((input = br.readLine()) != null) {
            ArrayList<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(input);
            String name = st.nextToken();
            while(st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);

            int size = arr.size();
            int score = 0;
            for(int i = 0; i < arr.size(); i++) {
                int tmp = Math.min(size - i, arr.get(i));
                score = Math.max(score, tmp);
            }

            snipers.add(new Sniper(name, score));
        }

        Collections.sort(snipers);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        out.println(snipers.get(0).name + " " + snipers.get(0).score);
    }
}