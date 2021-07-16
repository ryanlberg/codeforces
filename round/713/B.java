import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            char[][] grid = new char[size][size];
            for(int i = 0; i < size; i++) {
                grid[i] = fr.next().toCharArray();
            }
            int[][] locs = new int[2][2];
            int loc = 0;
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(grid[i][j] == '*') {
                        locs[loc][0] = i;
                        locs[loc][1] = j;
                        loc++;
                    }
                }
            }

            if(locs[0][0] == locs[1][0]) {
                if(locs[0][0] == 0) {
                    grid[locs[0][0]+1][locs[0][1]] = '*';
                    grid[locs[1][0]+1][locs[1][1]] = '*';
                } else {
                    grid[locs[0][0]-1][locs[0][1]] = '*';
                    grid[locs[1][0]-1][locs[1][1]] = '*';
                }
            } else if(locs[0][1] == locs[1][1]) {
                if(locs[0][1] == 0) {
                    grid[locs[0][0]][locs[0][1] +1] = '*';
                    grid[locs[1][0]][locs[1][1] +1] = '*';
                } else {
                    grid[locs[0][0]][locs[0][1] -1] = '*';
                    grid[locs[1][0]][locs[1][1] -1] = '*';
                }
            } else {
                grid[locs[0][0]][locs[1][1]] = '*';
                grid[locs[1][0]][locs[0][1]] = '*';
            }  

            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    out.write(grid[i][j]);
                }
                out.write("\n");
            }
        }
        out.close();
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() { 
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
