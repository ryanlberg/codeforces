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
            String num = fr.next();
            int minnum = 0;

            int zeros = 0;
            int ones = 0;            
            
            int i = 0;
            while(i < num.length()) {
                boolean zerofound = false;
                while(i < num.length() && num.charAt(i) == '0') {
                    zerofound = true;
                    i++;
                }
                if(zerofound) {
                    zeros++;
                }
                boolean onefound = false;
                while(i < num.length() && num.charAt(i) == '1') {
                    onefound = true;
                    i++;
                }
                if(onefound) {
                    ones++;
                }
            }
            

            out.write(Math.min(2, zeros) + "\n");
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
