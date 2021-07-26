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
            int athletes = fr.nextInt();
            int[][] races = new int[athletes][5];
            
            for(int i = 0; i < athletes; i++) {
                for(int j = 0 ;j < 5; j++) {
                    races[i][j] = fr.nextInt();
                }
            }

            
           
            int winner = 0;
            for(int i = 1; i < athletes; i++) {
                winner = better(winner, i, races);
            }
            if(isWinner(winner, races)) {
                out.write(winner+1 + "\n");
            } else {
                out.write("-1\n");
            }

        }
        out.close();
    }

    static boolean isWinner(int i, int[][]races) {
        for(int j = 0; j < races.length; j++) {
            int count = 0;
            for(int k = 0; k < 5; k++) {
                if(i != j) {
                    if(races[i][k] < races[j][k]) {
                        count++;
                    }
                }
            }
            if(i != j && count < 3) {
                return false;
            }
        }
        return true;
    }

    static int better(int i, int j, int[][] races) {
        int count = 0;
        for(int k = 0; k < 5; k++) {
            if(races[i][k] < races[j][k]) {
                count++;
            }
        }
        if(count > 2) {
            return i;
        }
        return j;
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
