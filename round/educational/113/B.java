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
            char[] desire = fr.next().toCharArray();
            char[][] board = new char[size][size];
            for(char[] row : board) {
                Arrays.fill(row, 'v');
            }
            boolean cando = true;
            for (int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(board[i][j] == 'v') {
                        if(i == j) {
                            board[i][j] = 'X';
                        } else if(desire[i] == '1' || desire[j] == '1') {
                            board[i][j] = '=';
                            board[j][i] = '=';
                        } else if(desire[i] == '0' && desire[j] =='2') {
                            board[i][j] = '-';
                            board[j][i] = '+';
                            desire[j] = '0';
                        } else if(desire[i] == '2' && desire[j] == '0') {
                            board[i][j] = '+';
                            board[j][i] = '-';
                            desire[i] = '0';

                        } else if(desire[i] == '2' && desire[j] == '2') {
                            board[i][j] = '+';
                            board[j][i] = '-';
                            desire[i] = '0';
                        } else if(desire[i] == '0' && desire[j] == '0' && board[i][j] == 'v') {
                            board[i][j] = '=';
                            board[j][i] = '=';
                        } else {

                        }
                    }
                }
            }

            for(int i = 0; i < size; i++) {
                if(desire[i] == '2') {
                    cando = false;
                }
            }
            if(cando) {
                out.write("YES\n");
                for(int i = 0; i < size; i++) {
                    for(int j = 0; j < size; j++) {
                        out.write(board[i][j]);
                    }
                    out.write("\n");
                }
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
