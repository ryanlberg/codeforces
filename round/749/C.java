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
        int rows = fr.nextInt();
        int cols = fr.nextInt();
        char[][] board = new char[rows][cols];
        for(int i = 0 ; i < rows; i++) {
            board[i] = fr.next().toCharArray();
        }
        int[] checker = new int[cols];
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(board[i-1][j] == 'X' && board[i][j-1] == 'X') {
                    checker[j]++;
                }
            }
        }

        int[] outputs = new int[cols+1];
        for(int i = 1; i < outputs.length; i++) {
            outputs[i] = outputs[i-1] + checker[i-1];
        }

        int queries = fr.nextInt();
        for(int i = 0; i < queries; i++) {
            int l = fr.nextInt();
            int r = fr.nextInt();
            if(outputs[r] - outputs[l] == 0) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
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
