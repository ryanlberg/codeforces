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
            if(mult == 1) {
                if((to_find-1) % add == 0) {
                    out.write("Yes\n");
                } else {
                    out.write("No\n");
                }
            } else {
                long start = 1;
                boolean cando = false;
                while(start <= to_find) {
                    if(start % add == to_find % add) {
                        cando = true;
                        break;
                    }
                    start *= mult;
                }
                if(cando) {
                    out.write("Yes\n");
                } else {
                    out.write("No\n");
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
