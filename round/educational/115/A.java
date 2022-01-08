import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
public class A {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int n = fr.nextInt();
            int[] l = new int[n];
            String cur = fr.next();
            for(int i = 0; i < n; i++) {
                if(cur.charAt(i) == '1') {
                    l[i]++;
                }
            }
            cur = fr.next();
            for(int i = 0; i < n; i++) {
                if(cur.charAt(i) == '1') {
                    l[i]++;
                }
            }

            boolean cando = true;
            for(int x: l) {
                if(x == 2) {
                    cando = false;
                }
            }

            if(cando) {
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
