package finalterm;

import java.util.*;
import java.io.*;

public class calcgrade {
    static class Student implements Comparable<Student> {
        String name;
        int score;
        boolean re;

        Student (String name, int score, boolean re) {
            this.name = name;
            this.score = score;
            this.re = re;
        }

        @Override
        public int compareTo(Student s) {
            int tmp = s.score - this.score;
            if (tmp == 0) return Boolean.compare(this.re, s.re);
            return tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Student[] s = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Boolean.parseBoolean(st.nextToken()));
        }

        Arrays.sort(s);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        for (int i = 0; i < N; i++) {
            out.println(s[i].name);
        }
    }
}