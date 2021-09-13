import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class D {


   

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[] nums = new int[n*m];
            int[] incoming = new int[n*m];
            HashMap<Integer, Stack<Integer>> spots = new HashMap<>();
            for(int i = 0; i < n*m; i++) {
                int cur = fr.nextInt();
                nums[i] = cur;
                incoming[i] = cur;
            }
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++) {
                if(!spots.containsKey(nums[i])) {
                    spots.put(nums[i], new Stack<Integer>());
                }
                spots.get(nums[i]).push(i);
            }

            int[] driver = new int[n*m];
            Arrays.fill(driver, -1);
            int inconv = 0;
            for(int i = 0; i < incoming.length; i++) {
                int spot = spots.get(incoming[i]).pop();
                for(int j = 0; j < spot; j++) {
                    if(driver[j] != -1) {
                        inconv++;
                    }
                } 
                driver[spot] = spot;
            }

            out.write(inconv + "\n");


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
