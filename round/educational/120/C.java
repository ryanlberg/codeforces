import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class C {


   

    static long sum;
    static long min;


    static void getMin(ArrayList<Long> nums, long k) {
        int current = 0;
        long start = nums.get(0);
        if(sum <= k) {
            min = 0;
        }
        while(current < min) {
            long tempsum = sum - current;
            if(tempsum <= k) {
                min = Math.min(min, current);
            }
            for(int i = nums.size() - 1; i >= 1; i--) {
                //System.out.println(tempsum + " " + current + " " + nums.get(i));
                tempsum -= nums.get(i);
                tempsum += (start - current);
                if(tempsum <= k) {
                    min = Math.min(min, current + (nums.size() - i ));
                    break;
                }
            }
            current++; 
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int nums = fr.nextInt();
            long k = fr.nextLong();
            ArrayList<Long> tosort = new ArrayList<>();
            sum = 0;
           
            
            for(int i = 0; i < nums; i++) {
                long cur = fr.nextLong();
                tosort.add(cur);
                sum += cur;
            }

            min = Math.abs(sum - k);

            Collections.sort(tosort);
            if(tosort.size() == 1) {
                long cur = tosort.get(0);
                if(cur <= k) {
                    min = 0;
                } else {
                    min = cur - k;
                }
            } else {
                getMin(tosort, k);
            }
            out.write(min + "\n");
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
