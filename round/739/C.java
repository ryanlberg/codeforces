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
            int curnum = fr.nextInt();
            int startrow = 1;
            int outward = 1;
            int downward = 1;
            while(startrow * startrow < curnum) {
                startrow++;
                outward++;
                downward++;
            }
            boolean found = false;
            int startnum = startrow*startrow;
            for(int i = 1; i < outward; i++) {
                //System.out.println(startnum + " " + curnum + "(" + downward + ", " + i + ")");
                if(startnum == curnum) {
                    found = true;
                    out.write(downward + " " + i + "\n");
                    break;
                }
                else startnum--;
            }
            if(!found) {
                for(int i = downward; i >= 1; i--) {
                    //System.out.println(startnum + " " + curnum + "(" + downward + ", " + i + ")");
                    if(startnum == curnum) {
                        out.write(i + " " + outward + "\n");
                        break;
                    }
                    startnum--;
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
