package finalterm;

import java.util.*;
import java.io.*;

abstract class Goods implements Comparable<Goods>{
    public String name;
    public int stock;

    public Goods(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    @Override
    public int compareTo(Goods o) {
        if(this.getClass() == o.getClass()) {
            return this.compare(o);
        }else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}


public class martStockAdmin {

    static class Fruit extends Goods {
        String kind;

        Fruit (String name, String kind, int stock) {
            super(name, stock);
            this.kind = kind;
        }

        @Override
        public int compare(Object o) {
            Fruit f = (Fruit) o;
            int tmp = this.kind.compareTo(f.kind);
            if (tmp == 0) return f.stock - this.stock;
            return tmp;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.kind + ", " + this.stock;
        }
    }

    static class Electronics extends Goods {
        int serial;

        Electronics (String name, int serial, int stock)  {
            super(name, stock);
            this.serial = serial;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.serial + ", " + this.stock;
        }

        @Override
        public int compare(Object o) {
            Electronics e = (Electronics) o;
            int tmp = this.serial - e.serial;
            if(tmp == 0) return e.stock - this.stock;
            return tmp;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Goods[] arr = new Goods[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String branch = st.nextToken();
            if (branch.equals("E")) arr[i] = new Electronics(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else arr[i] = new Fruit(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            out.println(arr[i].toString());
        }
    }
}