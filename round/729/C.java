import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class C {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            long x = fr.nextLong();
            long start = 1;
            long total = 0;
            long counter = 2;
            while(start <= x) {
                long cur = lcm(start, counter);
                total += ((x/start) - (x/cur)) * counter;
                
                counter++;
                start = cur;
            }
            out.write((total) % 1_000_000_007 + "\n");
        }
        out.close();
    }

    static long lcm(long A, long B) {
        return (A * B) / gcd(A, B);
    }

    static long gcd(long A, long B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A % B);
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
