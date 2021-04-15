package midterm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
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
        int n = s.score - this.score;
        if(n != 0) return n;
        else {
            return this.tries - s.tries;
        }
    }
}

public class 노력상{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> arr = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);
        for(int i = 0; i < 3; i++) {
            arr.remove(0);
        }
        Comparator<Student> scoreSort = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int n = s2.tries - s1.tries;
                if(n != 0) return n;
                else return s2.score - s1.score;
            }
        };

        Collections.sort(arr, scoreSort);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        for(Student s: arr) {
            out.println(s.name);
        }
    }
}