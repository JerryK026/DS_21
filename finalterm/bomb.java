package finalterm;

import java.util.*;
import java.io.*;

public class bomb {
    static class loc {
        int x;
        int y;
        int sec;

        loc (int x, int y, int sec) {
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<loc> q = new LinkedList<>();

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] box = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) q.offer(new loc(i, j, 0));
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int sec = 0;
        while (!q.isEmpty()) {
            loc cur = q.poll();
            sec = cur.sec;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < H && ny < W && box[nx][ny] > 0) {
                    q.offer(new loc(nx, ny, cur.sec + box[nx][ny]));
                    box[nx][ny] = 0;
                }

            }
        }

        boolean flag = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (box[i][j] > 0) flag = false;
            }
        }

        if(!flag) sec = -1;

        System.out.println(sec);
    }
}