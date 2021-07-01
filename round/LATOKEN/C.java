import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
public class C {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] top = new int[size+1];
            int[] bottom = new int[size+1];
            int[] topt = new int[size+1];
            for(int i = 1; i <= size; i++) {
                int cur = fr.nextInt();
                top[i] = cur;
                topt[cur] = i;
            }
            for(int i = 1; i <= size; i++) {
                int cur = fr.nextInt();
                bottom[i] = cur;
            }
            boolean[] seen = new boolean[size+1];
            Arrays.fill(seen, false);
            int groups = 0;
            for(int i = 1; i <= size; i++) {
                if(seen[top[i]] == false) {
                    groups++;
                    int current = top[i];
                    while(!seen[current]) {
                        seen[current] = true;
                        current = topt[bottom[current]];
                    }
                }
            }
            long ret = 1;
            for(int i = 0; i < groups; i++) {
                ret = (ret*2) % 1_000_000_007;
            } 
            out.write(ret + "\n");
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
