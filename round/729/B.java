import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.ArrayDeque;
public class B {

    static HashSet<Long> seen;
   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            seen = new HashSet<>();
            long to_find = fr.nextLong();
            long mult = fr.nextLong();
            long add = fr.nextLong();
            if(add == 1 || cando(to_find, mult, add)) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
            }
        }
        out.close();
    }

    static boolean cando(long to_find, long mult, long add) {
        if(to_find == 1) {
            return true;
        }
        if(to_find > 0) {
            if(to_find % mult == 0) {
                return cando(to_find/mult, mult, add);
            } else {
                return cando(to_find - add, mult, add);
            }
        }
        return false;
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
