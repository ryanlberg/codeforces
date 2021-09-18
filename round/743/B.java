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
            int len = fr.nextInt();
            int[] odds = new int[len];
            int[] evens = new int[len];

            

            for(int i = 0; i < len ; i++) {
                odds[i] = fr.nextInt();
            }

            for(int i = 0; i < len; i++) {
                evens[i] = fr.nextInt();
            }

            if(len == 1) {
                out.write(0 + "\n");
            
            } else {
               
                if(odds[0] < evens[0]) {
                    out.write(0 + "\n");
                } else {
                    int minleft = -1;
                    int minright = -1;
                    for(int i = 1; i < len; i++) {
                        if(odds[i] < evens[0]) {
                            minleft = i;
                            break;
                        }
                    }
                    for(int i = 1; i < len; i++) {
                        if(evens[i] > odds[0]) {
                            minright = i;
                            break;
                        }
                    }

                    out.write(Math.min(minleft, minright) + "\n");
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
