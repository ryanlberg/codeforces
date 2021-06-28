import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
public class C {


   
    static long[] dp;
    static int[] nums;
    public static void main(String[] args) {
        

        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        dp = new long[cases];
        
        nums = new int[cases];
        for(int c = 0; c < cases; c++) {
            nums[c] = fr.nextInt();
        }
        int max = 0;
        Arrays.fill(dp, -1);
        long a = solve(0, 0);
        out.write(a + "\n");
        // for(int i = 0; i < dp.size(); i++) {
        //     System.out.println(dp.get(i)[0] + " " + dp.get(i)[1]);
        // }
        out.close();
       
    }

    static long solve(int i, long cum) {
        //System.out.println(i + " " + cum + " " + potions);
        if(i >= nums.length) {
            if(cum < 0) {
                return 0;
            }
            return 0;
        }

        if (cum < 0) {
            return 0;
        }
        if (dp[i] >= 0) {
            return dp[i];
        }
        dp[i] = Math.max(1 + solve(i+1, cum + nums[i]), solve(i+1, cum));
        return dp[i];
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
