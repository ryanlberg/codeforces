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
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                nums.add(fr.nextInt());
            }

            Collections.sort(nums);

            int count = 1;
            int minsofar = Integer.MAX_VALUE;

            for(int i = 1; i < nums.size(); i++) {
                
                if (nums.get(i) > 0) {
                    if (nums.get(i) <= minsofar && nums.get(i-1) <= 0) {
                        count++;
                    }
                    break;
                }
                minsofar = Math.min(minsofar, Math.abs(nums.get(i-1) - nums.get(i)));
                count++;
                

            }
            out.write(count + "\n");
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
