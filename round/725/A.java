import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
public class A {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int min = Integer.MAX_VALUE;
            int max = 0;
            int minloc = 0;
            int maxloc = 0;
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                if (cur < min) {
                    min = cur;
                    minloc = i;
                } 
                if(cur > max) {
                    max = cur;
                    maxloc = i;
                }
            }

            if (max == min) {
                out.write(Math.min(minloc + 1, size - minloc) + "\n");
            } else {
                if(minloc < maxloc) {
                    int a = (minloc+1);
                    int b = (size - maxloc);
                    int d = (size - minloc);
                    int e = maxloc + 1;
                    out.write(Math.min(a + b, Math.min(d, e)) + "\n");
                } else {
                    int a = (maxloc+1);
                    int b = (size - minloc);
                    int d = (size - maxloc);
                    int e = minloc + 1;
                    out.write(Math.min(a + b, Math.min(d, e)) + "\n");
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
