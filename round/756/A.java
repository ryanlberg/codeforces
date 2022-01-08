import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int evens = 0;
            int odds = 0;
            boolean firsteven = false;
            int n = fr.nextInt();
            if(n % 2 == 0) {
                out.write(0 + "\n");
                continue;
            } 
            while(n > 0) {
                int end = n % 10;
                if(end % 2 == 0) {
                    evens++;
                    if(n < 10){
                        firsteven = true;
                    }
                } else {
                    odds++;
                }
                n /= 10;
            }
            if(firsteven) {
                out.write(1 +"\n");
            } else if(evens > 0) {
                out.write(2 + "\n");
            } else {
                out.write(-1 + "\n");
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
