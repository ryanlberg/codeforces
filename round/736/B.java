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
            int n = fr.nextInt();
            char[][] board = new char[2][n];
            board[0] = fr.next().toCharArray();
            board[1] = fr.next().toCharArray();

            out.write(solve(board, n) + "\n");
        }
        out.close();
    }

    static int solve(char[][] board, int n) {
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(board[1][i] == '1') {
                if(isValid(i-1, n) && board[0][i-1] == '1') {
                    max++;
                    board[0][i-1] = 's';
                } else if(board[0][i] == '0') {
                    max++;
                    board[0][i] = 's';
                } else if(isValid(i+1, n)  && board[0][i+1] == '1') {
                    max++;
                    board[0][i+1] = 's';
                }
            }
        }
        return max;
    }

    static boolean isValid(int i, int n) {
        return i >= 0 && i < n; 
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
