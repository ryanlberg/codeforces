import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class B {

    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int i = 0; i < cases; i++) {
            long num = fr.nextLong();
            out.write(solve(num) + "\n");
        }
        out.close();
    }

    static long solve(long num) {
        long total = 0;
        String[] nums = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < nums.length; i++) {
            String cur = nums[i];
            while(Long.parseLong(cur) <= num) {
                total++;
                cur += nums[i];
            }
        }
        return total;
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
