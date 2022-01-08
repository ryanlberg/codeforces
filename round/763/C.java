import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   
    static long test[][];
    static long nums[];

    static long filltest(int i, int j, int cur, long maxmin) {
        //System.out.println(i + " "  + j + " " + cur + " " + maxmin);
        if(cur >= nums.length) {
            return Math.min(maxmin, Math.min(nums[j], nums[i]));

        }
        // if(test[i][j] > 0) {
        //     return Math.min(test[i][j], maxmin);
        // }
        int l = 0;
        while(l + (2*l) <= nums[cur]) {
            nums[cur] -= l + (2*l);
            nums[j] += l;
            nums[i] += (2*l);
            test[i][j] = Math.max(test[i][j], filltest(i+1, j+1, cur+1, Math.min(maxmin, nums[i])));
            nums[cur] += l + (2*l);
            nums[j] -= l;
            nums[i] -= 2*l;
            l++;
        }
        return test[i][j];
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            test = new long[size][size];
            nums = new long[size];
            for(int i = 0 ; i < size; i++) {
                nums[i] = fr.nextLong();
                Arrays.fill(test[i], -1);
            }

            long ret = filltest(0, 1, 2, Integer.MAX_VALUE);
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
