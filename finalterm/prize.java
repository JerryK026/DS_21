package finalterm;

import java.util.*;
import java.io.*;

public class prize {
    static class Student implements Comparable<Student> {
        String name;
        int score;
        int tries;

        Student(String name, int score, int tries) {
            this.name = name;
            this.score = score;
            this.tries = tries;
        }

        @Override
        public int compareTo(Student s) {
            int tmp = s.score - this.score;
            if(tmp == 0) tmp = this.score - s.score;
            return tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Student> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);

        for(int i = 0; i < 3; i++) {
            arr.remove(0);
        }

        Comparator<Student> myComp = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int tmp = s2.tries - s1.tries;
                if(tmp == 0) tmp = s2.score - s1.score;
                return tmp;
            }
        };

        Collections.sort(arr, myComp);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        for(int i = 0; i < arr.size(); i++) {
            out.println(arr.get(i).name);
        }
    }
}