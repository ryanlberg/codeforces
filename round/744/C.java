import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int k = fr.nextInt();
            char[][] board = new char[n][m];
            boolean[][] checker = new boolean[n][m];

            for(int i = 0; i < n; i++) {
                board[i] = fr.next().toCharArray();
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == '*') {
                        checker[i][j] = true;
                    }
                }
            }

            for(int i = n-1; i >= 0; i--) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == '*') {
                        fix(board, checker, i, j, k, n, m);
                    }
                }
            }

            boolean cando = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(checker[i][j]) {
                        cando = false;
                    }
                }
            }

            if(cando) {
                out.write("YES\n");
            } else{
                out.write("NO\n");
            }
            
        }
        out.close();
    }

    static void fix(char[][] board, boolean[][] checker, int i, int j, int k, int n, int m) {
        ArrayList<int[]> seen = new ArrayList<>();
        Queue<int[]> needed = new LinkedList<>();
        int size = 0;
        needed.add(new int[]{i, j});
        seen.add(new int[]{i, j});
        boolean addedtwo = true;
        while(needed.size() > 0 && addedtwo) {
            if(size == 0) {
                int[] cur = needed.poll();
                if(isValid(i-1, j-1, n, m) && board[i-1][j-1] == '*') {
                    needed.add(new int[]{i-1, j-1});

                } else {
                    addedtwo = false;
                    break;
                }
                if(isValid(i-1, j+1, n, m) && board[i-1][j+1] == '*') {
                    needed.add(new int[]{i-1, j+1});
                } else {
                    addedtwo = false;
                    break;
                }
                size++;
                seen.add(new int[]{i-1, j-1});
                seen.add(new int[]{i-1, j+1});
            } else {
                int[] left = needed.poll();
                int[] right = needed.poll();
                if(isValid(left[0]-1, left[1]-1, n, m) && board[left[0]-1][left[1]-1] == '*') {
                    needed.add(new int[]{left[0]-1, left[1]-1});
                } else {
                    addedtwo = false;
                    break;
                }
                if(isValid(right[0]-1, right[1]+1, n, m) && board[right[0]-1][right[1]+1] == '*') {
                    needed.add(new int[]{right[0]-1, right[1]+1});
                } else {
                    addedtwo = false;
                    break;
                }
                size++;
                seen.add(new int[]{left[0]-1, left[1]-1});
                seen.add(new int[]{right[0]-1, right[1]+1});

            }
        }

        if(size >= k) {
            for(int[] x : seen) {
                checker[x[0]][x[1]] = false;
            }
        }
    }

    static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
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
