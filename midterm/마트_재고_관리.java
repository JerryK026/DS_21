package midterm;

import java.io.*;
import java.util.*;

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

class Electronics extends Goods{
    int model;
    Electronics(String name, int model, int stock) {
        super(name, stock);
        this.model = model;
    }

    @Override
    public int compare(Object o) {
        Electronics e = (Electronics) o;
        int result = this.model - e.model;
        if(result == 0) {
            return e.stock - this.stock;
        }
        return result;
    }
}

class Fruit extends Goods {
    String kinds;
    Fruit(String name, String kinds, int stock) {
        super(name, stock);
        this.kinds = kinds;
    }

    @Override
    public int compare(Object o) {
        Fruit f = (Fruit) o;
        int result = this.kinds.compareTo(f.kinds);
        if(result == 0) {
            return f.stock - this.stock;
        }
        return result;
    }
}

public class 마트_재고_관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Goods[] g = new Goods[N];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("F")) {
                g[i] = new Fruit(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
            }
            else {
                g[i] = new Electronics(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }

        Arrays.sort(g);

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        for(Goods goods: g) {
            // 패키지 이름이 midterm이라서
            if(goods.getClass().getName().equals("midterm.Fruit")) {
                Fruit f = (Fruit)goods;
                out.println(f.name + ", " + f.kinds + ", " + f.stock);
            }
            else {
                Electronics e = (Electronics)goods;
                out.println(e.name + ", " + e.model + ", " + e.stock);
            }
        }
    }
}