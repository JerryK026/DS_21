package finalterm;

import java.util.*;
import java.io.*;

public class Cellculture {

    static class Cell {
        int x;
        int y;
        int day;

        Cell(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Cell> q = new LinkedList<>();

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] arr = new int[H][W];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    q.offer(new Cell(j, i, 0));
                }
            }
        }

        int result = 0;

        while(!q.isEmpty()) {
            Cell c = q.poll();
            result = result < c.day ? c.day : result;

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for(int i = 0; i < 4; i++) {
                int x = c.x + dx[i];
                int y = c.y + dy[i];
                if(x >= 0 && x < W && y >= 0 && y < H && arr[y][x] > 0) {
                    q.offer(new Cell(x, y, c.day + arr[y][x]));
                    arr[y][x] = 0;
                }
            }
        }

        boolean flag = true;

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(arr[i][j] > 0) flag = false;
            }
        }

        if(!flag) result = -1;

        System.out.println(result);
    }
}
