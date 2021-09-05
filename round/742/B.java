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
        int[] xors = new int[3 * (int)Math.pow(10, 5)];
        
        for(int i = 1; i < xors.length; i++) {
            xors[i] = i ^ xors[i-1]; 
        }

        for(int c = 0; c < cases; c++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int bxor = xors[a-1];
            if(b == bxor) {
                out.write(a + "\n");
            } else {
                if((bxor ^ b) == a) {
                    out.write((a+2) + "\n");
                } else {
                    out.write((a+1) + "\n");
                }
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
