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
            String num = fr.next();
            
            String one = "";
            String two = "";
            for(int i = 0; i < num.length(); i++) {
                if(i % 2 == 0) {
                    one += num.charAt(i);
                } else {
                    two += num.charAt(i);
                }
            }

            long onel = 0;
            long twol = 0;
            if(one.length() > 0) {
                onel = Long.parseLong(one);
            }
            if(two.length() > 0) {
                twol = Long.parseLong(two);
            }
            out.write(((onel+1) * (twol+1) - 2) + "\n"); 
        }
        out.close();
    }

    static int waysWithCarry(int n) {
        return 0;
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
