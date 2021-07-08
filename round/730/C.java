import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class C {


   
    static final double scale = 1e+6;
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        
        for(int c = 0; c < cases; c++) {
            int ca = (int)Math.round(fr.nextDouble() * scale);
            int m = (int)Math.round(fr.nextDouble() * scale);
            int p =(int)Math.round(fr.nextDouble() * scale);
            int v = (int)Math.round(fr.nextDouble() * scale);
            out.write(getExpected(ca, m, p, v, 1) + "\n");
        }
        out.close();
    }

    static double getExpected(int c, int m, int p, int v, int count) {
        double ans = (p*count)/scale;
        if (c > 0) {
            if(c > v) {
                if(m > 0) {
                    ans +=  c/scale * getExpected((c-v), m+v/2, p+v/2, v, count+1);
                } else {
                    ans += c/scale * getExpected(c-v, 0, p+v, v,count+1);
                }
            } else {
                if (m > 0) {
                   
                    ans += c/scale * getExpected(0, m+c/2, p+c/2, v, count+1);
                } else {
                    ans += c/scale * getExpected(0, 0, p+c, v, count+1);
                }
            }
        }
        if (m > 0) {
            if(m > v) {
                if(c > 0) {
                    
                    ans +=  m/scale * getExpected(c+v/2, (m-v), p+v/2, v, count+1);
                } else {
                    ans += m/scale * getExpected(c, m-v, p+v, v, count+1);
                }
            } else {
                if(c > 0) {
                    ans += m/scale * getExpected(c+m/2, 0, p+m/2, v, count+1);
                } else {
                    ans += m/scale * getExpected(0, 0, p+m, v, count+1);
                }
            }
        }
        return ans;
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
