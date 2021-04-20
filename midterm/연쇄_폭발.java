package midterm;

import java.util.*;
import java.io.*;

class location {
    int x;
    int y;
    int hour;
    public location(int x, int y, int hour) {
        this.x = x;
        this.y = y;
        this.hour = hour;
    }
}

public class 연쇄_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<location> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int W = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dynamite = new int[M][W];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; st.hasMoreTokens(); j++) {
                dynamite[i][j] = Integer.parseInt(st.nextToken());
                if(dynamite[i][j] == 0) {
                    q.offer(new location(i, j, 0));
                }
            }
        }

        int hour = 0;

        while(!q.isEmpty()) {
            location l = q.poll();
            hour = l.hour;

            for(int i = 0; i < 4; i++) {
                int nx = l.x + dx[i];
                int ny = l.y + dy[i];
                if(nx < M && nx >= 0 && ny < W && ny >= 0) {
                    if(dynamite[nx][ny] > 0) {
                        q.offer(new location(nx, ny, hour + dynamite[nx][ny]));
                        dynamite[nx][ny] = 0;
                    }
                }
            }
        }

        boolean check = true;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < W; j++) {
                if(dynamite[i][j] > 0) {
                    check = false;
                }
            }
        }

        if(check) {
            System.out.println(hour);
        }

        else {
            System.out.println(-1);
        }
    }
}