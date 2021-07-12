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
            int words = fr.nextInt();
            int len = fr.nextInt();
            int[][] lets = new int[len][26];
            for(int i = 0; i < words; i++) {
                char[] cur = fr.next().toCharArray();
                for(int j = 0; j < len; j++) {
                    lets[j][cur[j] -'a']++;
                }
            }
            for(int i = 0; i < words-1; i++) {
                char[] cur = fr.next().toCharArray();
                for(int j = 0; j < len; j++) {
                    lets[j][cur[j] -'a']--;
                }
            }

            StringBuilder outwrite = new StringBuilder();
            for(int i = 0; i < lets.length; i++) {
                for(int j = 0; j < 26; j++) {
                    if(lets[i][j] > 0) {
                        outwrite.append((char)(j + 'a'));
                        break;
                    }
                }
            }
            out.write(outwrite.toString() + "\n");

            System.out.flush();
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
