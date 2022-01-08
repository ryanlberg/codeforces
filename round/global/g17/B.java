import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class B {


   

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
            int start = 0;
            int end = size-1;
            while(start < end) {
                if(nums[start] == nums[end]) {
                    start++;
                    end--;
                } else{
                    break;
                }
            }
            if (start >= end) {
                out.write("YES\n");
            } else {
                if(cando(start, end, nums, nums[start]) || cando(start, end , nums, nums[end])) {
                    out.write("YES\n");
                } else  {
                    out.write("NO\n");
                }
            }

        }
        out.close();
    }

    static boolean cando(int start, int end, int[] nums, int remove) {
        while(start <= end) {
            if(nums[start] == remove) {
                start++;
                continue;
            }
            if(nums[end] == remove){
                end--;
                continue;
            }
            if(nums[start] == nums[end]) {
                start++;
                end--;
                continue;
            } else {
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
