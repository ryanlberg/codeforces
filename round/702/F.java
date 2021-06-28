import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;
public class F {


    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
       
        for(int c = 0; c < cases; c++) {
            StringBuilder sb = new StringBuilder();
            int size = fr.nextInt();
            int[] nums = new int[size];
            long[] sums = new long[size+1];
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                int t = fr.nextInt();
                nums[i] = t;
                temp.add(t);
                
            }
            if (size == 1) {
                out.write(1 + "\n");
                out.write(1 + "\n");
            } else {
           
            Collections.sort(temp);
            for(int i = 1; i < sums.length; i++) {
                sums[i] = temp.get(i-1) + sums[i-1];
            }
            int ans = 0;

            for(int i = 0; i < temp.size()-1; i++) {
                if (sums[i+1] < temp.get(i+1)) {
                    ans = temp.get(i+1);
                    
                }
            }


           
            int total = 0;
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] >= ans) {
                    total++;
                }
            }
            out.write(total + "\n");
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] >= ans) {
                    sb.append(i+1);
                    sb.append(" ");
                }
            }
            out.write(sb.toString());
            out.write("\n");
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
