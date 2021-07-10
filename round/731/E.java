import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class E {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int acs = fr.nextInt();
            long[] temps = new long[size+1];
            Arrays.fill(temps, Long.MAX_VALUE);
            int[] locs = new int[acs];
            for(int i = 0; i < acs; i++) {
                locs[i]= fr.nextInt();
            }
            for(int i = 0; i < acs; i++) {
                temps[locs[i]] = fr.nextInt();
            }

            long curtemp = Long.MAX_VALUE;
            for(int i = 0; i < temps.length; i++) {
                if(temps[i] < curtemp) {
                    curtemp = temps[i];
                } 
                temps[i] = Math.min(curtemp, temps[i]);
                if(curtemp != Long.MAX_VALUE) {
                    curtemp++;
                }
            }
            curtemp = Long.MAX_VALUE;
            for(int i = temps.length-1; i >= 0; i--) {
                if(temps[i] < curtemp) {
                    curtemp = temps[i];
                } 
                temps[i] = Math.min(curtemp, temps[i]);
                if(curtemp != Long.MAX_VALUE) {
                    curtemp++;
                }
            }
            for(int i = 1; i < temps.length; i++) {
                out.write(temps[i] + " ");
            }
            out.write("\n");
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
