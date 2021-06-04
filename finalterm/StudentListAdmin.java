package finalterm;

import java.util.*;
import java.io.*;

public class StudentListAdmin {

    abstract static class Student implements Comparable<Student> {
        public String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            if (this.getClass() == o.getClass()) {
                return this.compare(o);
            } else {
                return this.getClass().toString().compareTo(o.getClass().toString());
            }
        }

        abstract public int compare(Object o);
    }

    static class Android extends Student implements Comparable<Student> {
        String model;
        String serial;
        Android(String name, String model, String serial) {
            super(name);
            this.model = model;
            this.serial = serial;
        }

        @Override
        public int compare(Object o) {
            Android a = (Android) o;
            int result = this.model.compareTo(a.model);

            if(result == 0) {
                result = this.serial.compareTo(a.serial);
            }

            return result;
        }
    }

    static class Human extends Student implements Comparable<Student> {
        public int num;
        Human(String name, int num) {
            super(name);
            this.num = num;
        }

        @Override
        public int compare(Object o) {
            Human h = (Human) o;
            return this.num - h.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 2) {
                arr.add(new Human(st.nextToken(), Integer.parseInt(st.nextToken())));
            }
            else {
                arr.add(new Android(st.nextToken(), st.nextToken(), st.nextToken()));
            }
        }

        Collections.sort(arr);

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