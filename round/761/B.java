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
            int cur = fr.nextInt();
            if(cur % 2 == 0) {
                out.write(cur/2 + " " + (cur/2 - 1) + " 1\n");
            } else {
                int a = cur/2+1;
                int b = cur/2-1;
                
                while(a + b + gcd(a, b) != cur) {
                    //System.out.println(a + " " + b + " " + gcd(a, b) + ": " + cur);
                    a++;
                    b--;
                    if( b < 0) {
                        break;
                    }
                }
                out.write(a + " " + b + " " + gcd(a, b)+ "\n");
            }

            
        }
        out.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
