import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int turns = fr.nextInt();
            long life = fr.nextLong();
            long[] nums = new long[turns];
            for(int i = 0; i < turns; i++) {
                nums[i] = fr.nextLong();
            }
            if(turns >= life) {
                out.write(1 + "\n");
            } else {
                long mink = 1;
                long maxk = life;
                long found = -1;
                while(mink < maxk) {
                    long mid = mink + ((maxk-mink)/2);
                    long left = lifeleft(nums, mid, life);
                    if(left > 0) {
                        mink = mid+1;
                    } else if (left < 0) {
                        maxk = mid-1;
                    } else {
                        found = mid;
                        break;
                    }
                }
              
                if(found > 0) {
                    out.write(found + "\n");
                } else {
                    long l = lifeleft(nums, mink, life);
                    if(l > 0) {
                        out.write((mink + 1) + "\n");
                    } else {
                        out.write(mink + "\n");
                    }
                }
            }
        }
        out.close();
    }

    static long lifeleft(long nums[], long k, long life) {
        long temp = life;
        for(int i = 1; i < nums.length; i++) {
            temp -= Math.min(k, nums[i] - nums[i-1]);
        }
        temp -= k;
        return temp;
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
