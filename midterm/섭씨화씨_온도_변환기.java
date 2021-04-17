package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Temperature {
    public double getCelsius();

    public double getFahrenheit();

    public void setCelsius(double celsius);

    public void setFahrenheit(double fahrenheit);
}

public class 섭씨화씨_온도_변환기 implements Temperature {

    double cel = 0;
    double fah = 0;

    public double getCelsius() {
        return this.cel;
    }

    public double getFahrenheit() {
        return this.fah;
    }

    public void setCelsius(double celsius) {
        this.fah = Math.round((9 * celsius / 5 + 32) * 100) / 100.0;
    }

    public void setFahrenheit(double fahrenheit) {
        this.cel = Math.round(5 * (fahrenheit - 32) / 9 * 100) / 100.0;
    }

    public static void main(String[] args) throws IOException {
        섭씨화씨_온도_변환기 c = new 섭씨화씨_온도_변환기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if(input[1].equals("C")) {
                c.setCelsius(Double.parseDouble(input[0]));
                System.out.println(c.getFahrenheit());
            }
            else {
                c.setFahrenheit(Double.parseDouble(input[0]));
                System.out.println(c.getCelsius());
            }
        }
    }
}
