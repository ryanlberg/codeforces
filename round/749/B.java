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
            int n = fr.nextInt();
            int q = fr.nextInt();
            HashSet<Integer> rootvals = new HashSet<>();
            for(int i = 1; i <= n ; i++) {
                rootvals.add(i);
            }
            for(int i = 0; i < q; i++) {
                int a = fr.nextInt();
                int b = fr.nextInt();
                int cc = fr.nextInt();
                rootvals.remove(b);
            }
            int root = -1;
            for(int x : rootvals) {
                root = x;
                break;
            }

            for(int i = 1; i <= n; i++) {
                if(i != root) {
                    out.write(root + " " + i + "\n");
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
