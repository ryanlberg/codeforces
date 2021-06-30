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
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            long total = 0;
            int[] nums = new int[size+2];
            for(int i = 1; i < size+1; i++) {
                
                int cur = fr.nextInt();
                nums[i] = cur;
                total += Math.abs(nums[i-1] - cur);
                
            }
            
            total += nums[nums.length-2];

            for(int i = 1; i < nums.length -1; i++) {
                if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                    int sub = Math.min(nums[i] - nums[i-1], nums[i] - nums[i+1]);
                    total -= sub;
                    nums[i] -= sub;
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
