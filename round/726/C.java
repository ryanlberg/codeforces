import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
public class C {


    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            ArrayList<Integer> nums = new ArrayList<>();
            int size = fr.nextInt();
            for(int i = 0; i < size; i++) {
                nums.add(fr.nextInt());
            }
            Collections.sort(nums);

            if(nums.size() <= 2) {
                out.write(nums.get(0) + " " + nums.get(1));
            } else {
                int[] ret = new int[size]; 
                int left = 0;
                int right = 0;
                int min = Integer.MAX_VALUE;
                
                // get min for endcaps
                for(int i = 1; i < nums.size(); i++) {
                    if(nums.get(i) - nums.get(i-1) < min) {
                        min = nums.get(i) - nums.get(i-1);
                        left = i-1;
                        right = i;
                    }
                    
                }
                int start = 0;
                for(int i = right; i < size; i++) {
                    ret[start] = nums.get(i);
                    start++;
                }
                for(int i = 0; i <= left; i++) {
                    ret[start] = nums.get(i);
                    start++;
                }

                for(int k = 0; k < ret.length; k++) {
                    out.write(ret[k] + " ");
                }
            }   
            out.write("\n");


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
