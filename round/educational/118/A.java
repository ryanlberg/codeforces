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
            long onecur = fr.nextLong();
            long onezeros = fr.nextLong();
            while(onecur % 10 == 0) {
                onezeros += 1;
                onecur/= 10;
            }
            
            long twocur = fr.nextLong();
            long twozeros = fr.nextLong();
            while(twocur % 10 == 0) {
                twozeros++;
                twocur /= 10;
            }
            if(onecur == twocur && onezeros == twozeros) {
                out.write("=\n");
            } else {
                int onelength = 0;
                long newone = onecur;
                while(newone > 0) {
                    onelength++;
                    newone /=10;
                }

                int twolength = 0;
                long newtwo = twocur;
                while(newtwo > 0) {
                    twolength++;
                    newtwo /= 10;
                }

                if(onezeros + onelength > twozeros + twolength) {
                    out.write(">\n");
                } else if(twozeros + twolength > onezeros + onelength) {
                    out.write("<\n");
                } else {
                    String ones = Long.toString(onecur);
                    String twos = Long.toString(twocur);
                    int min = Math.min(ones.length(), twos.length());
                    boolean seen = false;
                    for(int i = 0; i < min; i++) {
                        if(ones.charAt(i) > twos.charAt(i)) {
                            out.write(">\n");
                            seen = true;
                            break;
                        } 
                        if(ones.charAt(i) < twos.charAt(i)) {
                            out.write("<\n");
                            seen = true;
                            break;
                        }
                    }
                    if(!seen) {
                        if(ones.length() > twos.length()) {
                            out.write(">\n");
                        } else {
                            out.write("<\n");
                        }
                    }
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
