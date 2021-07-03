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
            long answer = 0;
            long mod = 1_000_000_007;
            if(x % 2 == 0) {
                answer += (2*(x/2) % mod) % mod ;
            } else {
                answer += (2*((x/2)+1)%mod) %mod;
            }

            long sixes = (int)(x / 6);
            long evens = (x/2) - sixes;
            answer += (3*evens) % mod;
           

            if (sixes % 2 == 0) {
                answer += (4*(sixes/2)) % mod;
               
                answer += (5*(sixes/2)) % mod;
                
            } else{
                answer += (4*((sixes/2) + 1)) % mod;
               
                answer += (5*(sixes/2)) % mod;
               
            }
            out.write(answer % mod+ "\n");
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
