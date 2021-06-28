import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
public class D {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int i = 0; i < cases; i++) {
            HashMap<Integer, Integer> seen = new HashMap<>();
            int size = fr.nextInt();
            long total = 0;
            for(int j = 0; j < size; j++) {
                int cur = fr.nextInt();
                if (seen.containsKey(cur-j)) {
                    total += seen.get(cur-j);
                    seen.put(cur-j, seen.get(cur-j) + 1);
                } else {
                    seen.put(cur-j, 1);
                }
            }
            out.write(total + "\n");

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
