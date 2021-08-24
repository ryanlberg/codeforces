import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class A {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);
        int cases = fr.nextInt();
        for(int c = 0; c < cases; c++) {
            int size = fr.nextInt();
            int[] nums = new int[size];
            for(int i = 0; i < size; i++) {
                nums[i] = fr.nextInt();
            }

            out.write(solve(nums) + "\n");
            
        }
        out.close();
    }

    static int solve(int[] nums) {
        int iteration = 0;
        while(!isSorted(nums)) {
            if(iteration % 2 == 0) {
                doOdd(nums);
            } else {
                doEven(nums);
            }
            iteration++;
        }
        return iteration;
        
    }

    static void doEven(int[] nums) {
        for(int i = 1; i < nums.length-1; i+=2) {
            if(nums[i] > nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }

    static void doOdd(int[] nums) {
        for(int i = 0; i < nums.length-1; i+=2) {
            if(nums[i] > nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }

    static boolean isSorted(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
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
