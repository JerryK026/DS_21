package midterm;

import java.util.*;
import java.io.*;

abstract class Student3 implements Comparable<Student3> {
    public String name;

    public Student3(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student3 o) {
        if (this.getClass() == o.getClass()) {
            return this.compare(o);
        } else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }
    abstract public int compare(Object o);
}

class Android extends Student3 {
    public String model;
    public String serial;

    public Android(String name, String model, String serial) {
        super(name);
        this.model = model;
        this.serial = serial;
    }

    @Override
    public int compare(Object o) {
        int n = this.model.compareTo(((Android) o).model);
        if(n != 0) {
            return n;
        }
        else {
            return this.serial.compareTo(((Android) o).serial);
        }
    }
}

class Human extends Student3{
    public int num;

    public Human(String name, int num) {
        super(name);
        this.num = num;
    }

    @Override
    public int compare(Object o) {
        return this.num - ((Human) o).num;
    }
}

public class 학생_명단_관리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Student3[] arr = new Student3[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 3) {
                arr[i] = new Android(st.nextToken(), st.nextToken(), st.nextToken());
            }
            else {
                arr[i] = new Human(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
        }

        Arrays.sort(arr);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        for(Student3 s : arr) {
            out.println(s.name);
        }
    }
}