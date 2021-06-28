import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B {


   

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            ArrayList<Integer> nums = new ArrayList<Integer>();
            long total = 0;
            for(int i = 0; i < size; i++) {
                int cur = fr.nextInt();
                total += cur;
                nums.add(cur);
            }
            Collections.sort(nums);
            if (total % size != 0) {
                out.write("-1\n");
            } else {
                boolean done = false;
                int needed = (int)(total / size);
                for(int i = 0; i < size; i++) {
                    if (nums.get(i) > needed) {
                        out.write(size - i  + "\n");
                        done = true;
                        break;
                    }
                }
                if (!done) {
                    out.write(0 + "\n");
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
