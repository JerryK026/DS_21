package midterm;

import java.util.*;
import java.io.*;

class Student2 implements Comparable<Student2>{
    String name;
    int score;
    boolean redo;

    Student2(String name, int score, boolean redo) {
        this.name = name;
        this.score = score;
        this.redo = redo;
    }

    @Override
    public int compareTo(Student2 s) {
        int n = s.score - this.score;
        if(n != 0) return n;
        else {
            if(this.redo != s.redo) {
                if(this.redo) return 1;
                else return -1;
            }
            return 0;
        }
    }
}

public class 학생_석차_계산{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student2> sl = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            sl.add(new Student2(input[0], Integer.parseInt(input[1]), Boolean.parseBoolean(input[2])));
        }

        Collections.sort(sl);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        for(Student2 s : sl) {
            out.println(s.name);
        }
    }
}