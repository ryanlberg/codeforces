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
        for (int c = 0; c < cases; c++) {
            int finalx = fr.nextInt();
            int finaly = fr.nextInt();
            int U = 0;
            int R = 0;
            int D = 0;
            int L = 0;
            String orders = fr.next();
            for (int i = 0; i < orders.length(); i++) {
                char curOrder = orders.charAt(i);
                if (curOrder == 'R') {
                    R++;
                }
                else if (curOrder == 'L') {
                   L++;
                }
                else if(curOrder == 'U') {
                    U++;
                }
                else {
                   D++;
                }
            }

            if(U >= finaly && (D*-1) <= finaly && R >= finalx && (L*-1) <= finalx) {
                out.write("YES\n");
            } else {
                out.write("NO\n");
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
