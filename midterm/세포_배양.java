package midterm;

import java.util.*;
import java.io.*;

class location2 {
    int x;
    int y;
    int day;

    public location2(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class 세포_배양 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][] arr = new int[height][width];

        Queue<location2> q = new LinkedList<>();

        for(int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) {
                    q.offer(new location2(i, j, 0));
                }
            }
        }
        int day = 0;
        while(!q.isEmpty()) {
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            location2 tmp = q.poll();
            day = tmp.day;

            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < height && ny >= 0 && ny < width) {
                    if(arr[nx][ny] > 0) {
                        q.offer(new location2(nx, ny, day + arr[nx][ny]));
                        arr[nx][ny] = 0;
                    }
                }
            }

        }

        boolean check = true;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(arr[i][j] > 0) {
                    check = false;
                }
            }
        }

        if(check) {
            System.out.println(day);
        }
        else {
            System.out.println(-1);
        }
    }
}