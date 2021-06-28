import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


    static ArrayList<Integer> primes;

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        primes = new ArrayList<Integer>();
        
        for(int c = 0; c < cases; c++) {
            long num = fr.nextLong();
            int totaldivs = 0;
            if(num % 2 == 0) {
                totaldivs += num/2;
            }
            num -= 2*totaldivs;
            long divisor = 3;
            while (num > 1 && divisor < Math.sqrt(num) + 1) {
                if(num % divisor == 0) {
                    long curdivs = num/divisor;
                    num -= curdivs * divisor;
                    totaldivs += curdivs;
                }
                divisor += 2; 
            }

            if(totaldivs % 2 == 0) {
                out.write("Bob\n");
            } else {
                out.write("Alice\n");
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
