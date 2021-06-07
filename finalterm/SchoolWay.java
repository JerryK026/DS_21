package finalterm;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class SchoolWay {
    static class Student implements Comparable<Student> {
        int loc;
        int spd;
        double tim;

        Student(int loc, int spd, double tim) {
            this.loc = loc;
            this.spd = spd;
            this.tim = tim;
        }

        @Override
        public int compareTo(Student s) {
            return s.loc - this.loc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Student> arr = new ArrayList<>();

        int num = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = dis - Integer.parseInt(st.nextToken());
            int spd = Integer.parseInt(st.nextToken());
            double tim = (double)loc / spd;
            arr.add(new Student(loc, spd, tim));
        }

        Collections.sort(arr);


        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if(arr.get(i).tim <= arr.get(j).tim) {
                    arr.remove(i--);
                    break;
                }
            }
        }


        System.out.println(arr.size());
    }
}