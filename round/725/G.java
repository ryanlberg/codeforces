import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class G {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            int a = fr.nextInt();
            int b = fr.nextInt();
            int total = 0;
            if(x == y) {
                out.write(x / Math.max(a, b) + "\n");
            } else if(a == b) {
                out.write(Math.min(x, y) / a + "\n");
            } else {
                while(Math.max(x, y) >= Math.max(a, b) && Math.min(x, y) >= Math.min(a, b)) {
                    total += 1;
                    int d = Math.max(x, y) - Math.max(a, b);
                    int e = Math.min(x, y) - Math.min(a, b);
                    x = d;
                    y = e;
                }
                out.write(total + "\n");
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
